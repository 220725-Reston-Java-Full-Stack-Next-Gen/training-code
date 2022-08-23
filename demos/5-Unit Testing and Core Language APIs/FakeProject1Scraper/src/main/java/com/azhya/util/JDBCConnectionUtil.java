package com.azhya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JDBCConnectionUtil {
	private static Logger LOGGER = Logger.getLogger(JDBCConnectionUtil.class);

	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			LOGGER.info("JDBCConnectionUtil - using DB creds for connection: URL="+ System.getenv("DB_URL") + 
					", Username=" + System.getenv("DB_USERNAME") + 
					", Password=" + System.getenv("DB_PASSWORD"));
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
