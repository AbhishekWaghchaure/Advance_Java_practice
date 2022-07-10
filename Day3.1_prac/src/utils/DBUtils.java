package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPublicKeyRetrieval=true", "root", "Abhisw@28");   
		}
		return connection;
	}
}
