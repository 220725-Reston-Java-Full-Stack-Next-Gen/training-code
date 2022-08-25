package com.azhya.service;

import com.azhya.models.User;

public interface UserService {
	//THINK of what logic to your app need to perform as business
	public int register(User user);
	
	public boolean login(String username, String password);

	public User getUserByUsername(String username);
}
