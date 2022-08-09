package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
	//this utility class will establish a database connection between this Java program
	//and our SQL database
	
	public static Connection getConnection() {
		//1. establish/declare our DB credentials (URL for the host, username, & password)
		//2 ways to share creds:
		//a. environment variables (recommended)
		//b. hardcoded (bad, bad, VERY BAD -- don't do this)
		
		//the credentials:
		//URL: jdbc:postgresql://[host URL]:[port number]/[database name - optional]
		//USERNAME: same as the one that you set when installing PostgreSQL
		//PASSWORD: same as above
		
		//2. establish our Connection's Driver Manager to make a new connection based on provided creds
		Connection conn = null;
		
		
		try {
			
			// here we will use our environment variables to 
			System.out.println(String.format("Making a database connection with the following credebtials: \nURL: %s \nUsername: %s \nPassword: %s",
					System.getenv("db_url"),
					System.getenv("db_username"),
					System.getenv("db-password")));
			
			conn = DriverManager.getConnection(
					System.getenv("db_url"),
					System.getenv("db-username"),
					System.getenv("db_password")
					
					);
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return conn;
		
	}

}
