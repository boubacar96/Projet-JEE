package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AuthentificationForm {
	
	  private static String CHAMP_LOGIN = "login";
	  private static String CHAMP_PASSWORD = "password";
	  private static String CHAMP_PROFIL = "profil";

	  private Utilisateur utilisateur;
	  private String login;
	  private HttpServletRequest request;
	  
	  public AuthentificationForm(HttpServletRequest request) {
		  this.request = request;
	  }
	  
	  public boolean authentifier() {
		  login = getParameter(CHAMP_LOGIN);
		  String password = getParameter(CHAMP_PASSWORD);
		  String profil = getParameter(CHAMP_PROFIL);
		  
		  if("admin1".equals(login) && "passer".equals(password) && "admin".equals(profil)) {
			  utilisateur = new Utilisateur(2,"bousso", "yawa", "admin1", "passer", "admin");
			  
		  } else {
			  utilisateur = UtilisateurDao.get(login);
			  if(utilisateur != null && !utilisateur.getPassword().equals(password)) {
				  utilisateur = null;
			  }
		  }
		  
		  if(utilisateur != null && profil.equals(utilisateur.getProfil())) {
		  	if("admin".equals(utilisateur.getProfil())){
		  		HttpSession session = request.getSession();
			  session.setAttribute("admin",  utilisateur);
		  	}else{
		  		HttpSession session = request.getSession();
			  session.setAttribute("simple",  utilisateur);
		  	}
			  return true;
		  }
		  return false;
	  }
	  
	  private String getParameter(String parametre) {
		  String param = request.getParameter(parametre);
		  if(param == null || param.trim().isEmpty()){
			  return null;
		  }
		  return param.trim();
	  }

	public String getLogin() {
		return login;
	}
	  
	  
	  
	}
