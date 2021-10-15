package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexionJDBC {
	
	private final String url = "jdbc:postgresql://database-etudiants:5432/opandore";
	private final String user = "opandore";
	private final String password = "d3jeq66A";
	
	 
	    public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
	    
}
