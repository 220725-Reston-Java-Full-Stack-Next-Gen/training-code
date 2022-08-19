package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class UserServiceImpl implements UserService {
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	//we need to make an instance of our DAO in order to make DB calls from the DAO methods
	//why did I use both the interface and implmentation class to create a DAO instance in this class?
	//because you want to decouple your code components (aka interface & classes) from the actual project structure
	
	//Short Reason Why: makes your code less messy (organization) 
	//and you can use any part of your code in any part of your application (aka modularization)
	private UserDAO userDao;
	
	public UserServiceImpl(UserDAOImpl dao) {
		super();
		this.userDao = dao;
	}

	@Override
	public int registerUser(User user) {
		//1. log this event into my log file
		LOGGER.info("In UserServiceImpl - registerUser() started");
		
		//2. use the DAO object to make a call to the DB
		int id = userDao.create(user);
		
		//3. return the data that came from the DAO layer
		LOGGER.info("In UserServiceImpl - registerUser() ended");
		return id;
	}

	@Override
	public boolean loginUser(int id, String name) {
		LOGGER.info("In UserServiceImpl - loginUser() started");
		
		//retrieve the user from DB
		User target = userDao.getById(id);
		
		//compare the names to see if this is a successful login match or not
		if(target.getId() == id && target.getName().equals(name)) {
			//then this is good login
			LOGGER.debug("Successful match - credentials are approved!");
			return true;
		}else {
			LOGGER.warn("Unsucessful match - credentials have been denied.");
		}
		
		LOGGER.info("In UserServiceImpl - loginUser() ended");
		return false;
	}

}
