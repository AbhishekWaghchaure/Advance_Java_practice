package utils;
import java.sql.*;

public class DBUtils {
	private static Connection connection;
	//singleton pattern : ensures creation of single instance of connection through JVM.
	//add static method to return connection instance.
	
	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get fixed db connection
		String dbURL ="jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPubliKeyRetrieval=true";
		connection = DriverManager.getConnection(dbURL, "root", "Abhisw@28");
		return connection;
	}
}
