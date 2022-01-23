package forms;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import beans.Album;
import dao.AlbumDao;
import dao.ImageDao;

public class AddAlbumForms {
	private static final String CHAMP_THEME = "theme";
	private static final String CHAMP_MODE = "mode";
	/*private static final String CHAMP_MC = "motCles";
	private static final String CHAMP_DESC = "description";
	private static final String CHAMP_FILE = "fichiers";
	private static final String NOM_FICHIER = "/album";*/
	
	private Album album; 
	  private HttpServletRequest request;
	  private Map<String, String> erreurs;
	  private boolean status;
	  private String statusMessage;
	  
	  public AddAlbumForms(HttpServletRequest request) {
		  this.request = request;
		  this.status = false;
		  this.erreurs = new HashMap<String, String>();
	  }
	  
	  public boolean ajouter(int id) {
		String theme = getParameter(CHAMP_THEME);
		String mode = getParameter(CHAMP_MODE);  
	    /*String description = getParameter(CHAMP_DESC);
	    String motCles = getParameter(CHAMP_MC);
	    String  nomFichier= getParameter(CHAMP_FILE);
	    int hauteur, largeur ;*/

	    album = new Album(theme, mode, id);

	    validerChamps(CHAMP_THEME, CHAMP_MODE);
	    //validerFile();
	    //validerPasswords();

	    statusMessage = "Echec de l'ajout";

	    if(erreurs.isEmpty()){
	      
	      status = AlbumDao.ajouter(album);
	      //ImageDao.ajouter()

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
	  
	  public String getParameter(String parametre){
	    String valeur = request.getParameter(parametre);
		if(valeur == null || valeur.trim().isEmpty()){
		   return null;
		}
		return valeur.trim(); 
	  }
	  
	  
}
