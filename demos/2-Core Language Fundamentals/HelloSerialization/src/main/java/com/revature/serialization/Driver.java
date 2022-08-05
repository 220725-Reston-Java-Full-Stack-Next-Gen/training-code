package com.revature.serialization;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// call our writeFile method here
		//writeToFile();

		//call our readFile method here
		readFromFile();
	}
	
	public static void writeToFile() {
		//here we will be serialize some Pet objects and putting their info into a text file
		//1. instantiate some Pet Objects
		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
		Pet p2 = new Pet("Spot", 2203, "Dog", "Jerry", 1, Color.BROWN);
		
		//2. instantiate a PetStore Object
		PetStore petco = new PetStore();
		//we want to capture the arraylist that is the petDB and add some pets to it
		ArrayList<Pet> petcoDB = petco.getPetDB();
		
		//3. add some pets to PetStoreDB
		petcoDB.add(p1);
		petcoDB.add(p2);
		
		//4. for validation, print out each pet in the store
		for(Pet p : petcoDB) {
			System.out.println(p);
		}
		
		//5. write our arraylist to the file
		petco.serialize();
	}
	
	public static void readFromFile() {
		//here we will be converting the binary data inside of our text file
		//and creating java object with it
		
		//1. instantiate a new PetStore object that will deserialize the object and 
		//adopt that collection as its own
		PetStore petsMart = new PetStore();
		petsMart.deserialize(); //this will read from the file and deserialize (aka hydrate) those objects in java
		
		//2. print out our objects to the console
		System.out.println(petsMart.getPetDB());
	}

}
