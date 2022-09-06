package com.revature.model;

import lombok.Data;

@Data
public class Pokemon {
	private int pokeId;
	private String pokemonName;
	private String pokemonType;
	private int combatPower;
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int pokeId, String pokemonName, String pokemonType, int combatPower) {
		super();
		this.pokeId = pokeId;
		this.pokemonName = pokemonName;
		this.pokemonType = pokemonType;
		this.combatPower = combatPower;
	}

	public Pokemon(String pokemonName, String pokemonType, int combatPower) {
		super();
		this.pokemonName = pokemonName;
		this.pokemonType = pokemonType;
		this.combatPower = combatPower;
	}
}
