package com.revature.service;

import java.util.List;

import com.revature.model.Hero;

public interface HeroService {

	public boolean registerHero(Hero hero);
	public List<Hero> getAllHeroes();
	public Hero getHeroByName(String name);
}
