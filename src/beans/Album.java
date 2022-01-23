package beans;

public class Album {
	private int id;
	private String theme;
	private String mode;
	private int idUser;
	
	public Album() {}
	
	public Album(String theme, String mode, int idUser) {
		//this.id = id;
		this.theme = theme;
		this.mode = mode;
		this.idUser = idUser;
	}
	
	public Album(int id, String theme, String mode, int idUser) {
		this.id = id;
		this.theme = theme;
		this.mode = mode;
		this.idUser = idUser;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int id_user) {
		this.idUser = id_user;
	}
	
	
}
