package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	private Statement st1;

	
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		cn = utils.DBUtils.getConnection();
		pst1 = cn.prepareStatement("Select empid,name,salary,join_date from my_emp where depid = ? and join_date between ? and ?"); 
		System.out.println("Employee Dao created");
		st1 = cn.createStatement();
		pst2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		pst3 = cn.prepareStatement("update my_emp set deptid=?,salary=salary+?, where empid=?");
	}
	@Override
	public List<Employee> getSelectedEmpDetails(String deptId, String beginDate, String endDate) throws SQLException {
		
		List<Employee> list = new ArrayList<>();
		//setIn params
		pst1.setString(1, deptId);
		pst1.setDate(2,Date.valueOf(beginDate));
		pst1.setDate(3,Date.valueOf(endDate));
		
		try(ResultSet rst = pst1.executeQuery();){
			while(rst.next()) {
				list.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Employee> getAllEmpDetails() throws SQLException {
		List<Employee> empList = new ArrayList<>();
		ResultSet rst = st1.executeQuery("select * from my_emp");
		while (rst.next()) {
			empList.add(new Employee (rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getDate(6)));
		}
		return empList;
		
	}

	@Override
	public String addEmployeeDetails(Employee emp) throws SQLException {
		pst2.setString(1, emp.getName());
		pst2.setString(2,emp.getAddress());
		pst2.setDouble(3, emp.getSalary());
		pst2.setString(4, emp.getDepId());
		pst2.setDate(5, emp.getJoinDate());
		int updateCount = pst2.executeUpdate();
		if(updateCount == 1) {
			return"emp details added";
		}
		return "insertion failed";
	}

	@Override
	public String updateEmpDetails(int empid, String newDept, double salIncrement) throws SQLException {
		//set InPARAMS
		pst3.setString(1, newDept);
		pst3.setDouble(2, salIncrement);
		pst3.setInt(3, empid);
		int updateCount = pst3.executeUpdate();
		if(updateCount == 1)
			return"Emp details updated";
		
		return "failed to update";
	}
	
	//add a method to close DB resources
	public void cleanUp() throws SQLException {
		if(pst1 != null && cn != null) {
			pst1.close();
			pst2.close();
			cn.close();
		}
		System.out.println("Emp dao cleaned up");
	}
	
}
