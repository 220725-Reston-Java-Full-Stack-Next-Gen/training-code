package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Pokemon;

public class PokemonDaoImpl implements PokemonDao {

	@Override
	public List<Pokemon> getAllPokemon() {
		// here I will be doing a fake database simulation by providing
		//some hard-coded Pokemon objects and returning them inside of my list
		List<Pokemon> dbPokemon = new  ArrayList<>();
		
		//here are our pokemon
		dbPokemon.add(new Pokemon(1, "pikachu", "electric", 1500));
		dbPokemon.add(new Pokemon(2, "seel", "water", 900));
		dbPokemon.add(new Pokemon(3, "weedle", "bug", 100));
		dbPokemon.add(new Pokemon(4, "mewtwo", "psychic", 12000));
		dbPokemon.add(new Pokemon(5, "eevee", "normal", 1000));
		dbPokemon.add(new Pokemon(6, "gastly", "ghost", 1100));
		
		return dbPokemon;
	}

}
