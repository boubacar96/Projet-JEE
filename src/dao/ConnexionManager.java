package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
  private static final String DB_URL = "jdbc:mysql://localhost/gestionsalbums";
  private static final String DB_USER ="root";
  private static final String DB_PASSWORD = " ";
  
  public static Connection getInstance() {
	  
	  try 
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	  } 
	  catch(ClassNotFoundException e) 
	  { 
		  System.out.println("Erreur de chargement du pilote : "+ e.getMessage());
	  } catch (SQLException e) { 
		// TODO Auto-generated catch block
		  System.out.println("Erreur de connexion : "+ e.getMessage());
	}
	  return null;
  }
  
}
