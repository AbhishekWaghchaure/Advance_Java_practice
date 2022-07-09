package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static Connection connection;

	// add static method to return singleton connection instance
	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
		// Load jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish connection with db
		String dbURL = "jdbc:mysql://localhost:3360/test?useSSL=false&allowPubliKeyRetrival=true";
		connection =DriverManager.getConnection(dbURL, "root", "Abhisw@28"); 	
	}
		return connection;
	}
}
