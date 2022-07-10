package utils;

import java.sql.Connection;

public class TestDbConnection {

	public static void main(String[] args) {
		try(Connection cn = DBUtils.fetchDBConnection()){
			System.out.println("sucess!!!"+cn);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
