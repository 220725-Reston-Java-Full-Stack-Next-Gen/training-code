package com.revature.drivers;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.models.Saiyan;

public class Main {
	
	//Azhya forgot the logger becuase she is very sick--my bad
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		//here I will be showing how we can access our getters/setters using Lombok
		//1. make a Saiyan object
		Saiyan goku = new Saiyan(1, "Son Goku", "Earth", 9001);
		Saiyan vegeta = new Saiyan(2, "Vegeta", "Planet Vegeta", 8999);
		Saiyan broly = new Saiyan(3, "Broly", "Unknown", 100000000);
		
		//goku.setName("Son Goku"); //related to Lombok
		//System.out.println(goku.getName()); //related to Lombok
		
		//now we will start adding our saiyans to our HashSet 
		Set<Saiyan> saiyans = new HashSet<>();
		
		//add a saiyan to the set
		saiyans.add(goku);
		saiyans.add(vegeta);
		saiyans.add(broly);
		
		//add more than one object to a set
		Set<Saiyan> team7 = new HashSet<>();
		team7.addAll(saiyans);
		
		//the contains() method allows us to know if an object is contained in the set and will return either T/F
		if(team7.contains(goku)) {
			System.out.println("Hi, I'm' Goku!");
		}
		
		//the remove() = removes elements from the set
		team7.remove(broly);
		
		//to see what is inside of our set, we must iterate thru the set using a conditional statement
		for(Saiyan dude: team7) {
			log.info("Team 7 member info: " + dude);
		}
		
		//DISCLAIMER: this is using the Collections parent toString() to show these contents
		System.out.println("BEFORE: " + team7); 
		
		//the clear() method will empty all content inside of the data structure
		team7.clear(); 
		
		System.out.println("AFTER: " + team7); 
		

	}

}
