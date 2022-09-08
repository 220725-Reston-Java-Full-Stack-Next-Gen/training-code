package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

//here I am just providing the Spring IoC a suggested name for my service component
@Service("heroServiceImpl")
public class HeroServiceImpl implements HeroService{
	//since this service layers relys on the repository layer, we must provided the @Autowired annotation on that dependency
	@Autowired
	private HeroRepository heroRepo;
	
	//because this dependency is autowired, we don't have to set up any constructor/setter injection areas

	@Override
	public boolean registerHero(Hero hero) {
		int pk = heroRepo.insert(hero);
		//here I will use a teriary operation to check if the primary key returned from the repo layer is either zero or non-zero
		return (pk > 0) ? true : false;
	}

	@Override
	public List<Hero> getAllHeroes() {
		return heroRepo.findAll();
	}

	@Override
	public Hero getHeroByName(String name) {
		return (Hero) heroRepo.findByName(name);
	}

}
