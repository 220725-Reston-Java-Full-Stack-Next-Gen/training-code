package com.azhya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import com.azhya.models.Account;
import com.azhya.util.JDBCConnectionUtil;

public class AccountDaoImpl implements AccountDao {
	private static Logger logger = Logger.getLogger(AccountDaoImpl.class);

	@Override
	public int insertAccount(Account account, int userId) {
		logger.info("In AccountDaoImpl - insertAccount() started. Adding account: " + account);
		int targetId = 0;
		//1. open my JDBC connection
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//2. Prepare our SQL statement
			String sql = "INSERT INTO accounts(account_type, account_status, account_balance, account_creation_date) VALUES(?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, account.getType().getType());
			ps.setString(2, account.getStatus().getStatus());
			ps.setDouble(3, account.getBalance());
			Date date = Date.valueOf(account.getCreationDate());
			ps.setDate(4, date);
			//3. Execute that statement
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				targetId = rs.getInt("account_id");
				rs.next();
			}
			
			//another db call here
			//to update the owner of this account
			sql = "UPDATE accounts SET account_user_id = ? WHERE account_id = ?";
			
			PreparedStatement ps2 = conn.prepareStatement(sql); //the reason why I'm doing this is to not have any broken connections for this new account to its owner user
			//therefore, this action requires us to open another DB transction
			
			ps2.setInt(1, userId);
			ps2.setInt(2, targetId);
			int isSuccessfulChangeOwner = ps2.executeUpdate();
			logger.info("Successful update of owner of account" + targetId + " to DB: 1 FOR YES/0 FOR NO: " + isSuccessfulChangeOwner);
			
		}catch(SQLException e) {
			logger.warn("Unable to add new account: " + e);
		}
		
		//4. return the newly created ID number of the user
		logger.info("In UserDaoImpl - insertAccount() ended. New account id is: " + targetId);
		return targetId;
	}

}
