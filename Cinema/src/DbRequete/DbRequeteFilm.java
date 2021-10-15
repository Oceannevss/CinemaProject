package DbRequete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbRequeteFilm {
	
	public Connection conn = null;
	public ResultSet resultats = null;
	public String requete = " ";
	
	
	
		public void infoFilm(String nomFilm) {
			
			requete = "SELECT * FROM film where titre = '"+ nomFilm +"' ;";
			try {
				Statement stmt = conn.createStatement();
				resultats = stmt.executeQuery(requete);
	
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
			
		}

		public void acteursUnFilm(String nomFilm) {
			
			requete = "SELECT nom_role, nom, prenom FROM artiste"
						+ "join role on artiste.id_artiste = role.id_acteur"
						+ "join film on role.id_film = film.id_film"
						+ " where titre = '"+ nomFilm +"' ;";
			try {
				Statement stmt = conn.createStatement();
				resultats = stmt.executeQuery(requete);
	
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			} 
			
		}
		
		public void insertFilm (String nom, String genre, String resume, String realisateur, int anneeRealisation, String pays) {
			
			requete = "Insert into Film ";
			try {
				Statement stmt = conn.createStatement();
				resultats = stmt.executeQuery(requete);
	
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			} 
		}
}
