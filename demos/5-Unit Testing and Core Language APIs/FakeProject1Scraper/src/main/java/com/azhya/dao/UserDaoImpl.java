package com.azhya.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.azhya.models.BankRole;
import com.azhya.models.User;
import com.azhya.util.JDBCConnectionUtil;

public class UserDaoImpl implements UserDao {
	//we are making a logger here because I want to track the events in this class as it makes SQL calls to the database
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	//connect JDBC to our servlets by providing a static initializer block that points to the Postgres driver
	//without this, you will be unable to make DB calls when Tomcat is running
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			logger.warn("Static initializer block failed: " + e);
		}
	}

	@Override
	public int insertUser(User user) {
		logger.info("In UserDaoImpl - insertUser() started. Adding user: " + user);
		int targetId = 0;
		//1. open my JDBC connection
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//2. Prepare our SQL statement
			String sql = "INSERT INTO users(username, user_password, user_first_name, user_last_name, user_email, user_role_type)"
					+ "	VALUES(?, ?, ?, ?, ?, 'CUSTOMER')";
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			
			//3. Execute that statement
			int isSuccessfulInsert = ps.executeUpdate();
			logger.info("Successful registration to DB: 1 FOR YES/0 FOR NO: " + isSuccessfulInsert);
			
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				targetId = rs.getInt("user_id");
				rs.next();
			}
			
		}catch(SQLException e) {
			logger.warn("Unable to add new user: " + e);
		}
		
		//4. return the newly created ID number of the user
		logger.info("In UserDaoImpl - insertUser() ended. New user id is: " + targetId);
		return targetId;
	}

	@Override
	public User selectUserByUsername(String username) {
		logger.info("In UserDaoImpl - selectUserByUsername() started. Searching username: " + username);
		User target = new User();
		
		//1. open my JDBC connection
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//2. Prepare our SQL statement
			String sql = "select * from users where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			//3. Execute that statement
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//here, we will be setting the resultset data to our User object called 'target'
				target.setUserId(rs.getInt("user_id"));
				target.setUsername(username);
				target.setPassword(rs.getString("user_password"));
				target.setFirstName(rs.getString("user_first_name"));
				target.setLastName(rs.getString("user_last_name"));
				target.setEmail(rs.getString("user_email"));
				target.setRole(new BankRole(rs.getString("user_role_type")));
			}
			
		}catch(SQLException e) {
			logger.warn("Unable to find user: " + e);
		}
		
		//4. return the newly created ID number of the user
		logger.info("In UserDaoImpl - selectUserByUsername() ended. Found user: " + target);
		return target;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
