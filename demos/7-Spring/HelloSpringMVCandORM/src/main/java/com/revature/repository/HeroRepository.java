package com.revature.repository;

import java.util.List;

import com.revature.model.Hero;

public interface HeroRepository {
	
	public int insert(Hero hero);
	
	public List<Hero> findAll();
	
	public Hero findByName(String name);

}
