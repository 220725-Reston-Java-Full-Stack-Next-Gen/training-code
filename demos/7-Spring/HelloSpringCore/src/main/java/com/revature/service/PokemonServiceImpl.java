package com.revature.service;

import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.model.Pokemon;

public class PokemonServiceImpl implements PokemonService {
	//since the service class DEPENDS on the dao implementation class, we must use constructor injection to 
	//inject our dependency (aka daoImpl class) into our service's constructor
	private PokemonDao pokeDao;
	
//	public PokemonServiceImpl(PokemonDao pokeDao) {
//		this.pokeDao = pokeDao;
//	}
	
	//this is how we will be doing setter injection so the IoC container can manage this spring bean properly
	//1. do need to provide an default constructor so the config file can work as expected
	public PokemonServiceImpl() {}
	
	//2. make a setter that will be performing the injection
	public void setPokeDao(PokemonDao pokeDao) {
		this.pokeDao = pokeDao; //so implicitly, Spring is doing the decoupling on your Dao object for you.
		//remember our usual decoupling would look like this:
		//private static PokemonDao pokeDao = new PokemonDaoImpl();
	}

	@Override
	public List<Pokemon> retrieveAll() {
		return pokeDao.getAllPokemon();
	}

}
