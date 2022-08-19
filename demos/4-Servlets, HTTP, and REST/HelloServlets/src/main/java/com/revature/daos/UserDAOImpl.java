package com.revature.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.JDBCConnectionUtil;

public class UserDAOImpl implements UserDAO {
	private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	//now we need to connect JDBC to servlets
	//because of this, we must use a initializer block to connect our DriverManager 
	//to Postgres
	
	//this block is commonly used to declare & initialize the components of an object
	//when it is created
	static {
		try {
			Class.forName("org.postgresql.Driver"); //here we are telling Tomcat that we are using Postgres
		} catch (ClassNotFoundException e) {
			LOGGER.warn("Static initializer block failed: unable to get DB connection -- " + e);
		}
	}

	@Override
	public int create(User user) {
		LOGGER.info("In UserDAOImpl - adding user: " + user);
		int targetId = 0;
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){
			String sql = "insert into users (name, job_title, hiredate) values(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getName());
			ps.setString(2, user.getJobTitle());
			ps.setDate(3, Date.valueOf(user.getHireDate()));
			
			int isSuccessfulInsert = ps.executeUpdate(); 
			LOGGER.info("Successful registration [1 for yes/0 for no]: " + isSuccessfulInsert);
			
			//this will return the new ID number that was created by the DB
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				targetId = rs.getInt("id");
				rs.next();
			}
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to execute SQL query: " + e);
		}
		
		LOGGER.info("In UserDAOImpl - create was successfully. New user ID: " + targetId);
		return targetId;
	}

	@Override
	public User getById(int id) {
		LOGGER.info("In UserDAOImpl - retrieving user by id: " + id);
		
		User user = new User();
		
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//prepare our statement for SQL query
			String sql = "select * from users where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//execute my query and get the results from the result set
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//set all data into my user object here
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setJobTitle(rs.getString("job_title"));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate hiredate = LocalDate.parse(rs.getDate("hiredate").toString(), formatter);
				user.setHireDate(hiredate);
			}
		}catch(SQLException e) {
			LOGGER.warn("Unable to execute SQL statement: " + e.getMessage());
		}
		
		LOGGER.info("Found user - " + user);
		return user;
	}

	@Override
	public User getByName(String name) {
		// if I have time, I will come back to this
		return null;
	}

}
