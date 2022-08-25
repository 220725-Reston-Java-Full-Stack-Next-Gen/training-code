package com.azhya.service;

import org.apache.log4j.Logger;

import com.azhya.dao.AccountDao;
import com.azhya.dao.AccountDaoImpl;
import com.azhya.models.Account;
import com.azhya.models.User;

public class AccountServiceImpl implements AccountService {
	private static Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	private AccountDao accountDao;

	public AccountServiceImpl(AccountDaoImpl accountDao) {
		super();
		this.accountDao = accountDao;
	}



	@Override
	public int createNewAccount(Account account, int userId) {
		//1. log event start
		logger.info("In AccountServiceImpl - createNewAccount() started. Account info for user id# " + userId +": " + account);
		
		//2. make my DB call
		int id = accountDao.insertAccount(account, userId);
		
		//3. log event end
		logger.info("In UserServiceImpl - createNewAccount() ended. New account id is: " + id);
		
		//4. return data in return statement
		return id;
	}

}
