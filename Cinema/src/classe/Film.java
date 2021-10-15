package classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Film {
	
	private int id;
	private String nom;
	private String genre ;
	private String resume;
	private String realisateur;
	private int anneeRealisation;
	private String pays;
	
	Connection conn = null;
	ResultSet resultats = null;
	String requete = " ";
	
	public Film(int id,String nom, String genre, String resume, String realisateur, int anneeRealisation, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.genre = genre;
		this.resume = resume;
		this.realisateur = realisateur;
		this.anneeRealisation = anneeRealisation;
		this.pays = pays;
	}
	

}
