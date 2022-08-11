package com.revature.daos;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.util.JDBCConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection conn;
	
	
	
	
	public EmployeeDAOImpl() {
		conn = JDBCConnectionUtil.getConnection();
	}


	@Override
	public Integer create(Employee emp){
		// note this is our 'create' method however we
		//will be inserting into our ready made tables
		
		//we are using ? wild card as a placeholder for the values we will set on our prepared statement;
		try {
		String sql = "INSERT INTO employees (id,first_name, last_name, birthdate, monthly_income, "
				+ "hire_date, job_title, email) VALUES (default,?,?,?,?,?,?,?)";
		
		// note: prepareStatement() throws an SQLException so we must wrap the code
		//we are trying to execute in a try catch
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, emp.getEmployeeFirstname());
		pstmt.setString(2, emp.getEmployeeLastname());
		pstmt.setDate(3, Date.valueOf(emp.getEmployeeBirthday()));
		pstmt.setDouble(4, emp.getMonthlyIncome());
		pstmt.setDate(5, Date.valueOf(emp.getEmployeeStartdate()));
		pstmt.setString(6, emp.getJobTitle());
		pstmt.setString(7, emp.getEmail());
		
		
		// note that when we are inserting, or updating we will be using 
		//executeUpdate();
		// when we are querying the database we will be using 
		//executeQuery()
		// when we are deleting we use execute()
		pstmt.executeUpdate();
		
		ResultSet rs = pstmt.getGeneratedKeys();		
		
		
		// the cursor is initially placed right before the first element of the result set
		//in order for us to advance into the next item we must use the command rs.next()
		rs.next();
		
		System.out.println("Im in the DAO impl class: " + rs.getInt(1));
		return rs.getInt("id");

		
		} catch(SQLException sqlEx) {
			System.out.println("This is the EmployeeDAOImpl create() " + sqlEx.getMessage());
		}
		return null;
	}


	@Override
	public Employee read(int empId) {
		
		try {
			String sql = "SELECT * FROM employees WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empId);
			
			// by using executeQuery() we get a result set back
			ResultSet rs = pstmt.executeQuery();
			
			//we are creating an instance of our Employee b/c we will
			// have to return an Employee
			
			Employee emp = new Employee();
			
			// this resultset that we get back from our query is what were
			//iterating through in order to make out Employee
			while(rs.next()) {
				emp.setEmployeeId(rs.getInt("id"));
				emp.setEmployeeFirstname(rs.getString("first_name"));
				emp.setEmployeeLastname(rs.getString("last_name"));
				emp.setEmployeeBirthday(LocalDate.now());
				emp.setMonthlyIncome(rs.getDouble("monthly_income"));
				emp.setEmployeeStartdate(LocalDate.now());
				emp.setJobTitle(rs.getString("job_title"));
				emp.setEmail(rs.getString("email"));
				
			}
			
			
			return emp;
			
		}catch(SQLException sqlEx) {
			System.out.println(" This is the employee Doa impl - read()" + sqlEx.getMessage());
		}
		return null;
	}


	@Override
	public Boolean update(int empId, String email) {
		// here we are going to update the database for a user
		//in this example we are just updating the email
		
		try {
			
			String sql = "UPDATE employees SET email=? WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,email);
			pstmt.setInt(2, empId);
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			};
			
			
		
		} catch (SQLException sqlEx){
			System.out.println("This is the employee Doa impl - update() " 
					+sqlEx.getMessage());
		}
		
		return false;
	}
	
	//example of method overloading  -> same name , different params /different return type
//	public Employee update(String name) {
//		return null;
//	}


	//Java can downcast and upcast Reference Types (aka in our models) itself
	//Java will not allow automatic upcasting/downcasting for Return types.
	@Override
	public Boolean delete(int empId) {
		try {
			
			
			String sql = "DELETE FROM employees WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			
			// it will return true if the first result is  resultSet
			return pstmt.execute();
			
			// we can use Exception even though these methods specifically throw SQLExceptions 
			//because Exception is the parent class of all Exceptions
		}catch(Exception e) {
			System.out.println("This is the employee Doa impl - delete() " + e.getMessage());
		}
		return true;
	}
	
	public Employee logInEmployee(String email, String password) {
		
		// Note: we do not have a password field on our table at the moment
		// So, i will use the employees last name to act as the password
		
		try {
			
			String sql = "SELECT * FROM employees WHERE email=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			//Note: as we are getting further in developing our apps we will had to ensure
			//that email is set to be unique . why ? multiple users should not have the same email
			
			ResultSet rs = pstmt.executeQuery();
			
//			private Integer employeeId;
//			private String employeeFirstname;
//			private String employeeLastname;
//			private LocalDate employeeBirthday;
//			private Double monthlyIncome;
//			private LocalDate employeeStartdate;
//			private String jobTitle;
//			private String email;
			
			if(rs.next() && rs.getString("last_name").equals(password)) {
				// note the && operator checks to see if BOTH conditions are true because coming into the
				// body to execute the code inside ; aka login a user (return that user)
				
				return new Employee(rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						LocalDate.now(),
						rs.getDouble("monthly_income"),
						LocalDate.now(),
						rs.getString("job_title"),
						rs.getString("email"));
						
			}
			
			
			
		}catch(Exception e) {
			
			System.out.println("This is the employee Doa impl - logInEmployee() " + e.getLocalizedMessage());
		}
		
		return null;
	}
	
	//"homework" 
	public List<Employee> getAllEmployees(){
		
		
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "SELECT * FROM employees";
		
		//if we are selecting we ill be executing a query be a query
		//then we want to continuously go through the result set and addd each employee to our 
		// employee list above then return the list
		
		
		return employees;
	}
	
	

}
