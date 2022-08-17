package com.revature.daos;

import java.sql.Connection;
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
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){
			String sql = "insert into users (name, job_title, hiredate) values(?, ?, ?, ?)";
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to execute SQL query: " + e);
		}
		return 0;
	}

}
