package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JDBCConnectionUtil.class);

	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			LOGGER.debug("JDBCConnectionUtil - using DB creds for connection: URL=%s, Username=%s, Password=%s", System.getenv("DB_URL"), 
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD"));
			conn = DriverManager.getConnection(
					System.getenv("DB_URL"), 
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD"));
			
		}catch(SQLException e) {
			LOGGER.warn(e.getMessage());
		}
		
		return conn;
	}
}
