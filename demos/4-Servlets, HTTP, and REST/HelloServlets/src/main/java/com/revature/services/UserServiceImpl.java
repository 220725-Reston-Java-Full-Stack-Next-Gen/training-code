package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	//we need to make an instance of our DAO in order to make DB calls from the DAO methods
	//why did I use both the interface and implmentation class to create a DAO instance in this class?
	//because you want to decouple your code components (aka interface & classes) from the actual project structure
	
	//Short Reason Why: makes your code less messy (organization) 
	//and you can use any part of your code in any part of your application (aka modularization)
	private static UserDAO userDao = new UserDAOImpl();

	@Override
	public int registerUser(User user) {
		//1. log this event into my log file
		LOGGER.debug("In UserServiceImpl - registerUser() started");
		
		//2. use the DAO object to make a call to the DB
		int id = userDao.create(user);
		
		//3. return the data that came from the DAO layer
		LOGGER.debug("In UserServiceImpl - registerUser() ended");
		return id;
	}

}
