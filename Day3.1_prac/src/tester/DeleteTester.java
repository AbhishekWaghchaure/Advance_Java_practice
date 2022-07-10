package tester;

import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class DeleteTester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try(Scanner sc = new Scanner(System.in);){
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("Enter the employeeId which you wish to delete");
			String message = empDao.deleteEmployee(sc.nextInt());
			System.out.println(message);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
