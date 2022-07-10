package pojos;

import java.sql.Date;

// empid | name | addr| salary| depid 
public class Employee {
	private int empId;
	private String name;
	private String address;
	private double salary;
	private String depId;
	private Date joinDate;
	
	public Employee() {
		
	}
	
	

	public Employee(String name, String address, double salary, String depId, Date joinDate) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.depId = depId;
		this.joinDate = joinDate;
	}



	public Employee(int empId, String name, String address, double salary, String depId, Date joinDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.depId = depId;
		this.joinDate = joinDate;
	}
	

	public Employee(int empId, String name, double salary, Date joinDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", depId=" + depId + ", joinDate=" + joinDate + "]";
	}
	
	
}
