package com.revature.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.util.JDBCConnectionUtil;

public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
	//now we need to connect JDBC to servlets
	//because of this, we must use a initializer block to connect our DriverManager 
	//to Postgres
	
	//this block is commonly used to declare & initialize the components of an object
	//when it is created
	static {
		//code here
		try {
			Class.forName("org.postgresql.Driver"); //here we are telling Tomcat that we are using Postgres
		}catch(ClassNotFoundException e) {
			LOGGER.warn("Static initializer block failed: unable to get DB connection -- " + e);
		}
	}

	@Override
	public int create(User user) {
		LOGGER.info("In UserDAOImpl - adding user: " + user);
		int targetId = 0;
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){
			String sql = "insert into users (name, job_title, hiredate) values(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getJobTitle());
			ps.setDate(3, Date.valueOf(user.getHireDate()));
			
			ps.executeUpdate(); 
			
			//this will return the new ID number that was created by the DB
			ResultSet rs = ps.getGeneratedKeys();
			
			rs.next();
			targetId = rs.getInt("id");
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to execute SQL query: " + e);
		}
		
		LOGGER.debug("In UserDAOImpl - create was successfully. New user ID: " + targetId);
		return targetId;
	}

}
