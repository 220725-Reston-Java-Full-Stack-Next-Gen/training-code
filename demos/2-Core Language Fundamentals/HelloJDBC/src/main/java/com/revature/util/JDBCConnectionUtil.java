package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


public class JDBCConnectionUtil {
	//this utility class will establish a database connection between this Java program
	//and our SQL database
	
	//static means that i can call a method or variable on the class itself
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
			System.out.println(String.format("Making a database connection with the following credentials: \nURL: %s \nUsername: %s \nPassword: %s",
					System.getenv("DB_URL"),
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD"))
					);
			
			conn = DriverManager.getConnection(
					System.getenv("DB_URL"),
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD")
					
					);
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return conn;
		
	}

}
