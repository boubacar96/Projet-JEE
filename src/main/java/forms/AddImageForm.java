package forms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import beans.Album;
import beans.Image;
import dao.AlbumDao;
import dao.ImageDao;

@MultipartConfig
public class AddImageForm {
	private static final String CHAMP_MC = "motCles";
	private static final String CHAMP_DESC = "description";
	private static final String CHAMP_FILE = "fichiers";
	private String NOM_FICHIER = "/home/bousso/eclipse-workspace/gestalbum/src/main/webapp/Albums/album"; //a changer
	private static final String CHAMP_TITRE = "titre";
	
	private static final String[] exts = {"png", "jpg", "jpeg", "gif"};
	
	private Image image;
	private HttpServletRequest request;
    private Map<String, String> erreurs;
    private boolean status;
    private String statusMessage;
    
    public AddImageForm(HttpServletRequest request) {
		  this.request = request;
		  this.status = false;
		  this.erreurs = new HashMap<String, String>();
	  }
    
    public boolean ajouter(int idAlbum) throws ServletException, IOException {
    	String titre = getParameter(CHAMP_TITRE);
	    String description = getParameter(CHAMP_DESC);
	    String motCles = getParameter(CHAMP_MC);
	    Part nomFichier = getPart(CHAMP_FILE);
	    //Collection <Part>  nomFichier = request.getParts();
	    int hauteur, largeur ;

	    //image = new Image(500, 500, idAlbum, titre, motCles, description, nomFichier);

	    validerChamps(CHAMP_DESC, CHAMP_MC, CHAMP_TITRE);
	    validerFile(idAlbum, motCles, description, titre);
	    //validerPasswords();

	    statusMessage = "Echec de l'ajout";

	    /**if(erreurs.isEmpty()){
	      
	      status = ImageDao.ajouter(image);
	      //ImageDao.ajouter()

	      if(status){
	          statusMessage = "Ajout effectué avec succès";
	      }
	    } */

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
	  
	  public Part getPart(String part) throws IOException, ServletException {
		  Part valeur = request.getPart(part);
		  if(valeur == null) {
			  return null;
		  }
		  return valeur;
	  }
	  
	  public void validerFile(int id, String motCles, String description, String titre) 
			  throws ServletException, IOException{
		  String path = NOM_FICHIER+""+id;
		  File uploadDir = new File(path);
	        if ( ! uploadDir.exists() ) uploadDir.mkdirs();
	        
	        for ( Part part : request.getParts() ) {
	            String fileName = part.getSubmittedFileName();
	            //String fullPath = request.getServletContext().getRealPath(NOM_FICHIER)+"_"+id+"/"+fileName;
	            String fullPath = path+"/"+fileName;
	            if(fileName != null) {
	            String extension = fileName.substring(fileName.lastIndexOf('.')+1);
	            //part.write(fullPath);
	            InputStream is = part.getInputStream();
	            statusMessage = "Echec de l'ajout";
	            if(isImage(extension)) {
	            	boolean succes = uploadFile(is, fullPath);
	            	//System.out.println(succes); 
	            	if(succes) {
	            	if(erreurs.isEmpty()) {
	            		image = new Image(500, 500, id, titre, motCles, description, fileName);
		          	    status = ImageDao.ajouter(image);
		          	    if(status) {
		          	    	statusMessage = "ajouté avec succes";
		          	    }
	            	}
	            }else {
	            	erreurs.put(CHAMP_FILE, "ce format n'est pas autorises: listes des formats autirisées : jpg,png,jpeg, gif");
	   
	            }
	            }else {
	            	erreurs.put(CHAMP_FILE, "dossier n'a pas pu etre crée");
	            }
	          }
	        }
	  }
	        
	    	
	  
	  public boolean isImage(String e) {
			for(String ex : exts){
				if(e.equalsIgnoreCase(ex)) {
					return true;
				}
			}
			return false;
		}
	  
	  public boolean uploadFile(InputStream is, String path) {
	    	boolean test = false;
	    	FileOutputStream fops = null;
	    	try {
	    		byte[] byt = new byte[is.available()];
	    		is.read(byt);
	    		fops = new FileOutputStream(path);
	    		fops.write(byt);
	    		fops.flush();
	    		test = true;
	    	} catch(Exception e) {
	    		e.getStackTrace();
	    	}finally {
	    		if(fops != null) {
	    			try {
						fops.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    	}
	    	return test;
	    }
	  
}
