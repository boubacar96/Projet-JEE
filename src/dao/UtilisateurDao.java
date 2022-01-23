package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {
	
	//private ArrayList<Utilisateur> utilisateurs;
	
	public static boolean ajouter(Utilisateur utilisateur) {
		
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				connection.setAutoCommit(false);	
				
				String nom = utilisateur.getNom();
				String prenom = utilisateur.getPrenom();
				String login = utilisateur.getLogin();
				String password = utilisateur.getPassword();
				String profil = utilisateur.getProfil();
				String requete = "insert into utilisateur(nom, prenom, login, password, profil) values(?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setString(1, nom);
				preparedStatement.setString(2, prenom);
				preparedStatement.setString(3, login);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, profil);
				int status = preparedStatement.executeUpdate();
				
				connection.commit();
				
				
				
			} catch(SQLException e) {
				try {connection.rollback();}
				catch(SQLException e1) {e1.printStackTrace();}
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
	
	public static ArrayList<Utilisateur> lister(){
		Connection connection = ConnexionManager.getInstance();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		if(connection != null) {
			try {
				
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM utilisateur");
				int id;
				String nom, prenom, login, password, profil;
				while(resultSet.next()) {
					id = resultSet.getInt("id");
					nom = resultSet.getString("nom");
					prenom = resultSet.getString("prenom");
					login = resultSet.getString("login");
					password = resultSet.getString("password");
					profil = resultSet.getString("profil");
				
					utilisateurs.add(new Utilisateur(id, nom, prenom, login, password, profil));
				
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
		return utilisateurs;
	}
	
	public static Boolean supprimer(int id) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				if(get(id) != null) {
					
					String requete = "delete from utilisateur where id=?";
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
	
	public static Boolean modifier(Utilisateur utilisateur) {
		
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		//ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				if(get(utilisateur.getId()) != null) {
					String nom = utilisateur.getNom();
					String prenom = utilisateur.getPrenom();
					String login = utilisateur.getLogin();
					String password = utilisateur.getPassword();
					String profil = utilisateur.getProfil();
					String requete = "update utilisateur set nom=?, prenom=?, login=?, password=?, profil=? where id=?";
					preparedStatement = connection.prepareStatement(requete);
					
					preparedStatement.setString(1, nom);
					preparedStatement.setString(2, prenom);
					preparedStatement.setString(3, login);
					preparedStatement.setString(4, password);
					preparedStatement.setInt(5, utilisateur.getId());
					preparedStatement.setString(6, profil);
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
	
	public static Utilisateur get(int id) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				String requete = "select * from utilisateur where id= ?";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setInt(1, id);
				
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String login = resultSet.getString("login");
					String password = resultSet.getString("password");
					String profil = resultSet.getString("profil");
					
					return new Utilisateur(nom, prenom, login, password, profil);
				} else {
					
					return null;
				}
				
				
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
		return null;
	}
	
	public static Utilisateur get(String log) {
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				String requete = "select * from utilisateur where login= ?";
				preparedStatement = connection.prepareStatement(requete);
				preparedStatement.setString(1, log);
				
				resultSet = preparedStatement.executeQuery();
				//boolean result = resultSet.next();
				if(resultSet.next()) {
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String login = resultSet.getString("login");
					String password = resultSet.getString("password");
					String profil = resultSet.getString("profil");
					
					
					return new Utilisateur(nom, prenom, login, password, profil);
				} 
				
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
		return null;
	}
	
	/*public static boolean verifierConnexion(String login, String password) {
		for(Utilisateur user : utilisateurs) {
			if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
				
				return true;
			}
			
		}
		return false;
	}*/
	


}
