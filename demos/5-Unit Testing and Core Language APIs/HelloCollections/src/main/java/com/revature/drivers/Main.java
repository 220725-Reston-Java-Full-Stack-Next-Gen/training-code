package com.revature.drivers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.models.Saiyan;

public class Main {
	
	//Azhya forgot the logger becuase she is very sick--my bad
	private static Logger log = Logger.getLogger(Main.class);

	//private UserDao userDao = new UserDaoImpl(); //decoupling = use the methods within the implementation class instead of interface 
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
		

		//Now  we will take a look at LinkedLists
		LinkedList<Saiyan> otherSaiyans = new LinkedList<>();
		
		//add some elements to the list
		otherSaiyans.add(new Saiyan(4, "Gohan", "Earth", 9000));
		otherSaiyans.add(new Saiyan(5, "Trunks", "Earth", 100000));
		otherSaiyans.add(new Saiyan(6, "Pan", "Earth", 1000));
		
		otherSaiyans.addFirst(vegeta); //addFirst will insert the element at the head of our linkedlist (aka the beginning)
		otherSaiyans.addLast(goku); //insert at the tail (or end)
		
		log.debug("BEFORE: " + otherSaiyans);
		
		//just remove the head element from the linkedlist, you must use the removeFirst() method
		otherSaiyans.removeFirst();
		
		//you can do the same with removing the tail element
		otherSaiyans.removeLast();
		
		//how to remove the elements in the middle? by index
		otherSaiyans.remove(1); //same with arrays, all collections indices start at 0
		
		//another way to remove elements in linkedlists
		for(Saiyan s : otherSaiyans) {
			if(s.equals(new Saiyan(4, "Gohan", "Earth", 9000))) {
				//remove him
				otherSaiyans.remove(new Saiyan(4, "Gohan", "Earth", 9000));
			}
		}
		
		//Overall, you can remove other elements in a linkedlist by index or by object comparsion
		//you use linkedlist if you need to keep your elements organized (if order of elements is needed)
		
		//do linkedlists allow for duplicates (multiple elements of the same object)? Yes!
		
		log.debug("AFTER: " + otherSaiyans);
	}

}
