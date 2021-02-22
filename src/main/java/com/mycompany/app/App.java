package com.mycompany.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class App 
{
static Connection conn = null;
	private static void makeJDBCConnection() {
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log("Le driver JDBC pour MySQL est disponible.");
		} catch (ClassNotFoundException e) {
			log("Le driver JDBC pour MySQL n'est pas disponible! Verifier que vous avez bien ajouté votre dependance Maven dans le POM!");
			e.printStackTrace();
			return;
		}
 
		try {
			// Charger le JDBC driver pour MYSQL.
			conn = DriverManager.getConnection("jdbc:mysql://db/training-app", "root", "root");
			if (conn != null) {
				log("Connexion à la base de données a été établie avec succès.");
			} else {
				log("Problème de connexion à la base!");
			}
		} catch (SQLException e) {
			log("Connexion au MySQL n'est pas établie!");
			e.printStackTrace();
			return;
		}
 
	}
 
	private static void log(String string) {
		System.out.println(string);
 
	}

	public static void main(String[] argv) {
 
		try {
			log("-------- Connexion au serveur de données MYSQL ------------");
			makeJDBCConnection();
			conn.close(); // Fermer la connexion
 
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
	}
}
