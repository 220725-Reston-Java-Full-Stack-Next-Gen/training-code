package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PetStore {
	
	//instance variables
	private ArrayList<Pet> petDB = new ArrayList<>(); //Every PetStore has a DB which
	//has a bunch of pet records in it
	
	//NOTE: I will not be provide an constructor here. 
	//Therefore the default constructor
	//will be used to create new PetStore objects
	
	//we still need getters/setters!
	public ArrayList<Pet> getPetDB() {
		return petDB;
	}

	public void setPetDB(ArrayList<Pet> petDB) {
		this.petDB = petDB;
	}
	
	@Override
	public String toString() {
		return "PetStore [petDB=" + petDB + "]";
	}
	
	
	
	//What is serialization?
	//the process of converting the state of an object into a byte stream
	//this stream typically consists of data from a media source like a file for example
	
	//The serialization cycle:
	//1. Serialization = converts the object into a byte stream
	//2. De-serialization = converts byte stream into an actual Java object
	
	/*
	 * FOR THIS DEMO:
	 * When I invoke the serialize() method on a PetStore object, it
	 * will serialize the ArrayList of Pet objects to a file (aka writes data to a file)
	 * 
	 * it will transform them to a byte stream and write to a file
	 * 
	 * This stream of bits can be rehydrated (aka deserialize) at a later point in time
	 * by reading from the file
	 */
	

	//note: you can have multiple catch blocks!
	public void serialize() {
		//try with resources was introduced in Java 8 to avoid potential memory leaks from open streams
		//with this, your resources are closed automatically instead of you as the developer manually closing them
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pets.txt"))){
			//we are taking the petDB arraylist of this object(PetStore) that invokes this method
			//and writing it to a file
			oos.writeObject(this.getPetDB());
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked") //this annotation suppress the type safety warning when casting of objects here
	public void deserialize() {
		//this method is responsible for reading that byte stream and
		//creating a java object from the data inside of the file
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pets.txt"))){
			//whenever a PetStore object calls this method, it SETS its petDB arraylist
			//EQUAL to the info that is read from a file (in a form of a java object)
			this.setPetDB((ArrayList<Pet>) ois.readObject());
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
