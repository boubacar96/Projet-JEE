package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AdduserForm {
	  private static final String CHAMP_NOM = "nom";
	  private static final String CHAMP_PRENOM = "prenom";
	  private static final String CHAMP_LOGIN = "login";
	  private static final String CHAMP_PASSWORD = "password";
	  private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	  private static final String CHAMP_PROFIL = "profil";


	  private Utilisateur utilisateur; 
	  private HttpServletRequest request;
	  private Map<String, String> erreurs;
	  private boolean status;
	  private String statusMessage;
	  
	  public AdduserForm(HttpServletRequest request) {
		  this.request = request;
		  this.status = false;
		  this.erreurs = new HashMap<String, String>();
	  }
	  
	  public boolean ajouter() {
		  String nom = getParameter(CHAMP_NOM);
	    String prenom = getParameter(CHAMP_PRENOM);
	    String login = getParameter(CHAMP_LOGIN);
	    String password = getParameter(CHAMP_PASSWORD);
	    String profil = getParameter(CHAMP_PROFIL);

	    utilisateur = new Utilisateur(nom, prenom, login, password, profil);

	    validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS, CHAMP_PROFIL);
	    validerLogin();
	    validerPasswords();

	    statusMessage = "Echec de l'ajout";

	    if(erreurs.isEmpty()){
	      
	      status = UtilisateurDao.ajouter(utilisateur);

	      if(status){
	          statusMessage = "Ajout effectué avec succès";
	      }
	    } 

		  return status;
	  }

	  public void validerChamps(String... champs){
	    for(String champ : champs){
	      if(getParameter(champ) == null){
	        erreurs.put(champ, "* vous devez remplir ce champs");
	      }
	    }
	  }
	  
	  public void validerLogin() {
		  String login = request.getParameter(CHAMP_LOGIN);
		  if(UtilisateurDao.get(login) != null) {
			  erreurs.put(CHAMP_LOGIN, "* ce login existe déja");
		  }
	  }

	  public String getParameter(String parametre){
	    String valeur = request.getParameter(parametre);
	    if(valeur == null || valeur.trim().isEmpty()){
	      return null;
	    }
	    return valeur.trim(); 
	  }

	  public void validerPasswords(){
	    String password = request.getParameter(CHAMP_PASSWORD);
	    String passwordBis = request.getParameter(CHAMP_PASSWORD_BIS);

	    if(password != null && !password.equals(passwordBis)){
	      erreurs.put(CHAMP_PASSWORD, "* Les mots de passe ne sont pas conformes");
	      erreurs.put(CHAMP_PASSWORD_BIS, "* Les mots de passe ne sont pas conformes");

	    }

	  }

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}
		
		public Map<String, String> getErreurs() {
			return erreurs;
		}
		
		public boolean getStatus() {
			return status;
		}
		
		public String getStatusMessage() {
			return statusMessage;
		}
	  
	  
	  
	}
