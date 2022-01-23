package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Album;
import beans.Image;


public class AlbumDao {
 	//liste des albums avec leurs images
	public static ArrayList<Object> listeAlbum(){
		Connection connection = ConnexionManager.getInstance();
		Statement statement = null;
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		
		ArrayList<Object> albums = new ArrayList<Object>();
		ArrayList<Image> images = new ArrayList<Image>();
		if(connection != null) {
			try {
				//connection.setAutoCommit(false);
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM album");
				int id, idUser;
				String theme, mode;
				while(resultSet.next()) {
					
					id = resultSet.getInt("id");
					theme = resultSet.getString("theme");
					mode = resultSet.getString("mode");
					idUser = resultSet.getInt("idUser");
				
					preparedStatement = connection.prepareStatement("select * from image where idAlbum = ?");
					
					preparedStatement.setInt(1, id);
					resultSet2 = preparedStatement.executeQuery();
					int idImage, hauteur, largeur, idAlbum;
					String titre, motCles, description, nomFichier, dateCreation, dateModification;
					while(resultSet2.next()) {
					//images += "{ ";
					idImage = resultSet2.getInt("id");
					hauteur = resultSet2.getInt("hauteur");
					largeur = resultSet2.getInt("largeur");
					idAlbum = resultSet2.getInt("idAlbum");
					titre = resultSet2.getString("titre");
					motCles = resultSet2.getString("motCles");
					description = resultSet2.getString("description");
					nomFichier = resultSet2.getString("nomFichier");
				    dateCreation = resultSet2.getString("dateCreation");
					dateModification = resultSet2.getString("dateModification");
					
					try {
						if(resultSet2 != null) {
							resultSet.close();
						}
						if(preparedStatement != null) {
							statement.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					images.add(new Image(idImage, hauteur, largeur, idAlbum, titre, motCles, dateCreation, dateModification, description, nomFichier));
				}
					Object[] obj = 	new Object[5];
					obj[0] = id;
					obj[1] = theme;
					obj[2] = mode;
					obj[3] = idUser;
					obj[4] = images;
					albums.add(obj);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(resultSet != null) {
						resultSet.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return albums;
	}


	
	public static ArrayList<Album> listerAlbum(){
		Connection connection = ConnexionManager.getInstance();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Album> albums = new ArrayList<Album>();
		if(connection != null) {
			try {
				//connection.setAutoCommit(false);
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM album");
				int id, idUser;
				String theme, mode;
				while(resultSet.next()) {
					
					id = resultSet.getInt("id");
					theme = resultSet.getString("theme");
					mode = resultSet.getString("mode");
					idUser = resultSet.getInt("idUser");
				
					albums.add(new Album(id, theme, mode, idUser));
				
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(resultSet != null) {
						resultSet.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return albums;
	}
	
	public static ArrayList<Album> listAlbum(int idU){
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Album> albums = new ArrayList<Album>();
		if(connection != null) {
			try {
				//connection.setAutoCommit(false);
				statement = connection.prepareStatement("SELECT * FROM album where idUser= ?");
				statement.setInt(1, idU);
				resultSet = statement.executeQuery();
				int id, idUser;
				String theme, mode;
				while(resultSet.next()) {
					
					id = resultSet.getInt("id");
					theme = resultSet.getString("theme");
					mode = resultSet.getString("mode");
					idUser = resultSet.getInt("idUser");
				
					albums.add(new Album(id, theme, mode, idUser));
				
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(resultSet != null) {
						resultSet.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return albums;
	}
	
	
public static boolean ajouter(Album album) {
		
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		
		if(connection != null) {
			try {
				connection.setAutoCommit(false);	
				
				String nom = album.getTheme();
				String mode = album.getMode();
				int idUser = album.getIdUser();
				String requete = "insert into album(theme, mode,idUser) values(?, ?, ?)";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setString(1, nom);
				preparedStatement.setString(2, mode);
				preparedStatement.setInt(3, idUser);
				int status = preparedStatement.executeUpdate();
				
				connection.commit();
				
				
			} catch(SQLException e) {
		
				e.printStackTrace();
			}finally {
				
				try {
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	public static boolean modifier(Album album) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				if(getAlbum(album.getId()) != null) {
					String theme = album.getTheme();
					String mode = album.getMode();
					//int idUser = album.getIdUser();
					String requete = "update album set theme=?, mode=? where id=?";
					preparedStatement = connection.prepareStatement(requete);
			
					preparedStatement.setString(1, theme);
					preparedStatement.setString(2, mode);
					preparedStatement.setInt(5, album.getId());
					int status = preparedStatement.executeUpdate();
					
  				    
					return true;
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	
	public static Boolean supprimer(int id) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				if(getAlbum(id) != null) {
					
					String requete = "delete from album where id=?";
					preparedStatement = connection.prepareStatement(requete);
					
					preparedStatement.setInt(1, id);
					int status = preparedStatement.executeUpdate();
					
					return true;
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {

					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static Album getAlbum(int idAlbum) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		if(connection != null) {
			try {
				connection.setAutoCommit(false);	
				
				String requete = "select * from album where id = ?";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setInt(1, idAlbum);

				result = preparedStatement.executeQuery();
				
				if(result.next()) {
					int id = result.getInt("id");
					String theme = result.getString("theme");
					String mode = result.getString("mode");
					int idUser = result.getInt("idUser");
					
					connection.commit();

					
					return new Album(id, theme, mode, idUser);
				}else {
					return null;
				}
				
			} catch(SQLException e) {
			
				e.printStackTrace();
			}finally {
				
				try {
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}
}
