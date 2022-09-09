package com.revature.services;

import java.util.List;

import com.revature.models.Candy;

public interface CandyService {
	//create a new candy
	public boolean createCandy(Candy candy);
	
	//get candy by id
	public Candy getCandyById(int id);
	
	//get all candies
	public List<Candy> getAllCandies();
	
	//update candy
	public boolean updateCandy(Candy candy);
	
	//delete candy
	public boolean deleteCandy(Candy candy);
}
