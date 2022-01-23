package beans;

public class Utilisateur {
	private int id;
	private String nom, prenom, login, password, profil;
	
	public Utilisateur() { }
	

	public Utilisateur(int id, String nom, String prenom, String login, String password, String profil) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.profil = profil;
		
	}
	
	public Utilisateur(String nom, String prenom, String login, String password, String profil) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.profil = profil;
		
	}
	
	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
