package com.revature.util;

import java.sql.Connection;

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
	}

}
