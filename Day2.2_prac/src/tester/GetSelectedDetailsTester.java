package tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class GetSelectedDetailsTester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try(Scanner sc = new Scanner(System.in)) {
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		System.out.println("Enter deptid , startdate, enddate(y-m-d)");
		List<Employee> emplist = empdao.getSelectedEmpDetails(sc.next(), sc.next(), sc.next());
		for(Employee emp : emplist){
			System.out.println(emplist);
		}
		empdao.cleanUp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
