package com.revature.petapp.services;

import com.revature.petapp.models.Pet;

public interface AdminService {
	/**
	 * Adds the pet to the application and returns it with a newly assigned ID.
	 * 
	 * @param pet
	 * @return the pet with its new ID
	 */
	public Pet addPet(Pet pet);
	
	/**
	 * Uses the pet ID to update the pet's information in the application. Returns 
	 * null if the pet with that ID does not exist.
	 * 
	 * @param pet
	 * @return the updated pet or null if the pet did not exist in the system
	 */
	public Pet editPet(Pet pet);
}
