package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class InsertEmpDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try(Scanner sc = new Scanner(System.in);){
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("Enter employee details name,add,salary,depid,joindate(y-m-d)");
			String message = empDao.addEmployeeDetails(new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(), Date.valueOf(sc.next())));
			System.out.println("Emp insertion"+message);
			empDao.cleanUp();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
