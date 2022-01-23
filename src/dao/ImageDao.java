package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Image;


public class ImageDao {
	
	public static ArrayList<Image> listerImageAlbum(int album){
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Image> images = new ArrayList<Image>();
		if(connection != null) {
			try {
				//connection.setAutoCommit(false);
				String requete = "select * from image where idAlbum = ?";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setInt(1, album);
				resultSet = preparedStatement.executeQuery();
				int id, hauteur, largeur, idAlbum;
				String titre, motCles, description, nomFichier, dateCreation, dateModification;
				//images = "{ \"images\": [";
				while(resultSet.next()) {
					//images += "{ ";
					id = resultSet.getInt("id");
					hauteur = resultSet.getInt("hauteur");
					largeur = resultSet.getInt("largeur");
					idAlbum = resultSet.getInt("idAlbum");
					titre = resultSet.getString("titre");
					motCles = resultSet.getString("motCles");
					description = resultSet.getString("description");
					nomFichier = resultSet.getString("nomFichier");
				    dateCreation = resultSet.getString("dateCreation");
					dateModification = resultSet.getString("dateModification");
					/*images += "\"id\":\" "+id+"\", "
						   +"\"hauteur\" : \" "+hauteur+"\","
						   +"\"largeur\" : \" "+largeur+"\","
						   +"\"idAlbum\" : \" "+idAlbum+"\","
						   +"\"titre\" : \" "+titre+"\","
						   +"\"motCles\" : \" "+motCles+"\","
						   +"\"description\" : \" "+description+"\","
						   +"\"nomFichier\" : \" "+nomFichier+"\","
						   +"\"dateCreation\" : \" "+dateCreation+"\","
						   +"\"dateModification\" : \" "+dateModification+"\""
						   +"},"
							;*/
					
					images.add(new Image(id, hauteur, largeur, idAlbum, titre, motCles, dateCreation, dateModification, description, nomFichier));
				
				}
				//images = "}";
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(resultSet != null) {
						resultSet.close();
					}
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
		return images;
	}
	
public static boolean ajouter(Image image) {
		
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		
		if(connection != null) {
			try {
				connection.setAutoCommit(false);	
				
				String description = image.getDescription();
				String nomFichier = image.getNomFichier();
				String motCles = image.getMotCles();
				String titre = image.getTitre();
				int idAlbum = image.getIdAlbum();
				int hauteur = image.getHauteur();
				int largeur = image.getLargeur();
				String requete = "insert into image"
						+ "(description, nomFichier, motCles, titre, idAlbum, "
						+ "dateCreation, dateModification, hauteur, largeur) "
						+ "values(?, ?, ?, ?, ?, now(), now(), ?, ?)";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setString(1, description);
				preparedStatement.setString(2, nomFichier);
				preparedStatement.setString(3, motCles);
				preparedStatement.setString(4, titre);
				preparedStatement.setInt(5, idAlbum);
				preparedStatement.setInt(6, hauteur);
				preparedStatement.setInt(7, largeur);
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

	public static boolean modifier(Image image) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				if(getImage(image.getId()) != null) {
					String description = image.getDescription();
					String nomFichier = image.getNomFichier();
					String motCles = image.getMotCles();
					String titre = image.getTitre();
					int idAlbum = image.getIdAlbum();
					int hauteur = image.getHauteur();
					int largeur = image.getLargeur();
					String requete = "update image set description=?, "
							+ "nomFichier=?, motCles=?, titre=?, "
							+ "idAlbum=?, hauteur=?, largeur=?, dateModification=?"
							+ "where id=?";
					preparedStatement = connection.prepareStatement(requete);
			
					preparedStatement.setString(1, description);
					preparedStatement.setString(2, nomFichier);
					preparedStatement.setString(3, motCles);
					preparedStatement.setString(4, titre);
					preparedStatement.setInt(5, idAlbum);
					preparedStatement.setInt(6, hauteur);
					preparedStatement.setInt(7, largeur);
					preparedStatement.setInt(8, image.getId());
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
				
				if(getImage(id) != null) {
					
					String requete = "delete from image where id=?";
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

	public static Image getImage(int idImage) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		if(connection != null) {
			try {
				connection.setAutoCommit(false);	
				
				String requete = "select * from image where id = ?";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setInt(1, idImage);

				result = preparedStatement.executeQuery();
				
				if(result.next()) {
					int id = result.getInt("id");
					int hauteur = result.getInt("hauteur");
					int largeur = result.getInt("largeur");
					int idAlbum = result.getInt("idAlbum");
					String titre = result.getString("titre");
					String motCles = result.getString("motCles");
					String description = result.getString("description");
					String nomFichier = result.getString("nomFichier");
					String dateCreation = result.getString("dateCreation");
					String dateModification = result.getString("dateModification");
					
					connection.commit();
					
		
					
					return new Image(id, hauteur, largeur, idAlbum, titre, motCles, dateCreation, dateModification, description, nomFichier);
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
