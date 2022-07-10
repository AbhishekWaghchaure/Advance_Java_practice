package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPST {

	public static void main(String[] args) {
		try (Connection cn = DBUtils.fetchDBConnection();
				Scanner sc = new Scanner(System.in);
				PreparedStatement pst = cn.prepareStatement("Select empid,name,salary,join_date from my_emp where depid = ? and join_date between ? and ?");
				
				) {
			System.out.println("Enter deptid ,begin and end dates to fetch employee details");
			//Set InPARAMS
			pst.setString(1, sc.next());
			pst.setDate(2, Date.valueOf(sc.next()));
			pst.setDate(3, Date.valueOf(sc.next()));
			try(ResultSet rst = pst.executeQuery();){
				while(rst.next()) {
					System.out.printf("Empid %d Name %s Salary %.1f Join Date %s %n",rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
