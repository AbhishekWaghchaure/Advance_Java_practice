package tester;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class GetAllEmpDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		List<Employee> empList  = empDao.getAllEmpDetails();
		for(Employee e : empList) {
			System.out.println(e);
		}
		empDao.cleanUp();
	}

}
