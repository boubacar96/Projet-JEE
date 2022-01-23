package beans;

public class Image {
	private int id, hauteur, largeur, idAlbum;
	private String titre, motCles, dateCreation, dateModification, description, nomFichier;
	
	public Image() {}
	
	public Image(int hauteur, int largeur, int idAlbum, String titre, String motCles, String description, String nomFichier) {
		
		//this.id = id;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.motCles = motCles;
		//this.dateCreation = dateCreation;
		//this.dateModification = dateModification;
		this.description = description;
		this.nomFichier = nomFichier;
	}
	
	public Image(int id, int hauteur, int largeur, int idAlbum, String titre, String motCles, String dateCreation,
			String dateModification, String description, String nomFichier) {
		//super();
		this.id = id;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.idAlbum = idAlbum;
		this.titre = titre;
		this.motCles = motCles;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.description = description;
		this.nomFichier = nomFichier;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMotCles() {
		return motCles;
	}
	public void setMotCles(String motCles) {
		this.motCles = motCles;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDateModification() {
		return dateModification;
	}
	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNomFichier() {
		return nomFichier;
	}
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	
}
