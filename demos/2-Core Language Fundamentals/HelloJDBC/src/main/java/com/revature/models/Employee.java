package com.revature.models;
import java.time.*;

public class Employee {
	
	//here we are creating our fields
	// variables are considered the state of an object
	// where the object is the class
	
	//note: it is conventional and encouraged that you
	//your data types
	
	
	private Integer employeeId;
	private String employeeFirstname;
	private String employeeLastname;
	private LocalDate employeeBirthday;
	private Double monthlyIncome;
	private LocalDate employeeStartdate;
	private String jobTitle;
	private String email;
	
	
	// here we are going to create out constructors
	//  constructors are used to make new instance of a class
	//however using constructors we can change the state of the class
	
	public Employee() {
		super();
		// here is a no args constructor. 
		//creating a class like this would give us an object with all null values
	}


	// this is our all args constructor
	//when we are reading from our database we will use this constructor to build our object
	
	public Employee(int employeeId, String employeeFirstname, String employeeLastname, LocalDate employeeBirthday,
			Double monthlyIncome, LocalDate employeeStartdate, String jobTitle, String email) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.employeeBirthday = employeeBirthday;
		this.monthlyIncome = monthlyIncome;
		this.employeeStartdate = employeeStartdate;
		this.jobTitle = jobTitle;
		this.email = email;
	}


	// here we have our some args constructor because  we do not need the employee id when we are 
	//creating an employee - aka inserting into the employee table
	public Employee(String employeeFirstname, String employeeLastname, LocalDate employeeBirthday, Double monthlyIncome,
			LocalDate employeeStartdate, String jobTitle, String email) {
		super();
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.employeeBirthday = employeeBirthday;
		this.monthlyIncome = monthlyIncome;
		this.employeeStartdate = employeeStartdate;
		this.jobTitle = jobTitle;
		this.email = email;
	}


	//there getters and setter are the method we have so far
	// they will be used when we want to get and set our state (variables)
	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeFirstname() {
		return employeeFirstname;
	}


	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}


	public String getEmployeeLastname() {
		return employeeLastname;
	}


	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}


	public LocalDate getEmployeeBirthday() {
		return employeeBirthday;
	}


	public void setEmployeeBirthday(LocalDate employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}


	public double getMonthlyIncome() {
		return monthlyIncome;
	}


	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}


	public LocalDate getEmployeeStartdate() {
		return employeeStartdate;
	}


	public void setEmployeeStartdate(LocalDate employeeStartdate) {
		this.employeeStartdate = employeeStartdate;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstname=" + employeeFirstname + ", employeeLastname="
				+ employeeLastname + ", employeeBirthday=" + employeeBirthday + ", monthlyIncome=" + monthlyIncome
				+ ", employeeStartdate=" + employeeStartdate + ", jobTitle=" + jobTitle + ", email=" + email + "]";
	}
	
	
	
	

}
