package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatment {

	public static void main(String[] args) {
		try (Connection cn = DBUtils.fetchDBConnection();
				Statement st = cn.createStatement();
				ResultSet rst = st.executeQuery("Select * from my_emp");) {
			while(rst.next()) {
				System.out.printf("Emp ID %d Name %s Address %s Salary %s.1f DeptId %s %n",
						rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
