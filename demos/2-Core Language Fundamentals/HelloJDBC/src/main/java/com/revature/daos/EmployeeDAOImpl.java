package com.revature.daos;

import java.sql.Statement;
import java.time.LocalDate;
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
	public Employee update(int empId, String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(int empId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
