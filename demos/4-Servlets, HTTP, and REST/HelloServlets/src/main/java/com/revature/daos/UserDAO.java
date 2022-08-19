package com.revature.daos;

import com.revature.models.User;

public interface UserDAO {
	
	int create(User user);
	
	//here, since I am logging in with an existing user, I should be able to retrieve that user by id or name
	//we then use the user info found and compare that info with the user input that our client entered for this request
	User getById(int id);
	
	User getByName(String name);

}
