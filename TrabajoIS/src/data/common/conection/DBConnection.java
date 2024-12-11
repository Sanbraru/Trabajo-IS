package data.common.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import data.common.config.*;
/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class DBConnection {

    String ClaveURL = Configuracion.getClave("url");
	String ClaveUSER = Configuracion.getClave("user");
	String ClavePASSWORD = Configuracion.getClave("password");
    
	protected Connection connection = null;

	// Important: This configuration is hard-coded here for illustrative purposes only
	
	protected String url = ClaveURL;

	protected String user = ClaveUSER;

	protected String password = ClavePASSWORD;

	public Connection getConnection(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	// We can include here other methods to encapsulate CRUD commands...

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}