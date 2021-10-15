package connexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import DbRequete.DbRequeteFilm;

public class main {


	// Fonction d'affichage 
	private static void affiche(String message) {
		System.out.println(message);
	}

	// Fonction d'affichage des erreurs detectees et quitter l'application
	private static void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}

	// Programme principal
	public static void main(String args[]) {

		// Définition des variables 
		Connection conn = null;
		ResultSet resultats = null;
		String requete = " ";

		// String url => "jdbc:postgresql://NomServeur:PortEcoute/NomBasePostgreSQL,RoleDeConnexion,MotDePasseRoleDeConnexion";
		String ServerName = "database-etudiants";
		String PortEcoute = "5432";
		String DBName = "opandore";
		String RoleName = "opandore";
		String RolePasswd = "d3jeq66A";
		String Url = "jdbc:postgresql://database-etudiants:5432/opandore" ;
		String msg_erreur;

		// Affichage de l'URL de connexion à la base PostgreSQL
		affiche("***** Debut du programme *****");
		affiche("==> URL de connexion:" + Url);

		// Connexion a la base PostgreSQL
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Url, RoleName, RolePasswd);
		} catch (Exception e) {
			e.printStackTrace();
			msg_erreur = e.getClass().getName()+": "+e.getMessage();
			arret (msg_erreur);
			// System.err.println(e.getClass().getName()+": "+e.getMessage());
			// System.exit(0);
		} 
		affiche ("Connexion a la base "+ DBName+ " OK");
		
		//Afficher le tuple d'un film
		DbRequeteFilm requeteTupleFilm = new DbRequeteFilm();
		
		requeteTupleFilm.infoFilm("La Guerre des étoiles");
		
		
		// Parcours des donnees retournees
		affiche("==> Parcours des donnees retournees");
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			boolean encore = resultats.next();
			while (encore) {
				for (int i = 1; i <= nbCols; i++)
					System.out.print(resultats.getString(i) + " ");
				System.out.println("");
				encore = resultats.next();
			}
			//resultats.close();
		} catch (SQLException e) {
			arret(e.getMessage());
		}
		//  


		// Deconnexion de la base PostgreSQL
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) { /* ignored */}
		}
		affiche("Deconnexion a la base "+ DBName+ " OK");
		affiche("***** Fin du programme *****");
		System.exit(0);
	}
	
	
}
