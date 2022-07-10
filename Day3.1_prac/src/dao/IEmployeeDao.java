package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
	  //add a method declaration for getting employee details
	List<Employee> getSelectedEmpDetails(String deptId, String beginDate, String endDate)throws SQLException;
	
	//add method declaration to add employee details
	String addEmployeeDetails(Employee emp)throws SQLException;

	//add method declaration to update emp details
	String updateEmpDetails(int empid,String newDept,double salIncrement) throws SQLException;
	
	//add method declaration to delete an employee
	String deleteEmployee(int empid)throws SQLException;
}
