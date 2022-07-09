package utils;

import java.sql.Connection;

public class TestDBConnecction {

	public static void main(String[] args) {
	try(Connection cn = DBUtils.fetchDBConnection()){
		System.out.println("COnnected to DB"+ cn);
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

}
