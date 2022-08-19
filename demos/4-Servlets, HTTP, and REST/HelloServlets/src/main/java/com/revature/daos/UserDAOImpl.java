package com.revature.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		try {
			Class.forName("org.postgresql.Driver"); //here we are telling Tomcat that we are using Postgres
		} catch (ClassNotFoundException e) {
			System.out.println("Static initializer block failed: unable to get DB connection -- " + e);
		}
	}

	@Override
	public int create(User user) {
		System.out.println("In UserDAOImpl - adding user: " + user);
		int targetId = 0;
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){
			String sql = "insert into users (name, job_title, hiredate) values(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getName());
			ps.setString(2, user.getJobTitle());
			ps.setDate(3, Date.valueOf(user.getHireDate()));
			
			int isSuccessfulInsert = ps.executeUpdate(); 
			System.out.println("Successful registration [1 for yes/0 for no]: " + isSuccessfulInsert);
			
			//this will return the new ID number that was created by the DB
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				targetId = rs.getInt("id");
				rs.next();
			}
			
		}catch(SQLException e) {
			System.out.println("Unable to execute SQL query: " + e);
		}
		
		System.out.println("In UserDAOImpl - create was successfully. New user ID: " + targetId);
		return targetId;
	}

}
