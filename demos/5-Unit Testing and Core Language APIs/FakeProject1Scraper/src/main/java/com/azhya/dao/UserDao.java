package com.azhya.dao;

import com.azhya.models.User;

public interface UserDao {
	
	//THINK CRUD!
	//CREATE
	public int insertUser(User user);
	
	//READ
	public User selectUserByUsername(String username);
	
	//UPDATE
	public void updateUser (User user);
	
	//DELETE
}
