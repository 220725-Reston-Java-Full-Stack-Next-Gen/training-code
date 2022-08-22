package com.revature.petapp.services;

import java.util.List;
import com.revature.petapp.exceptions.AlreadyAdoptedException;
import com.revature.petapp.exceptions.UsernameAlreadyExistsException;
import com.revature.petapp.models.Pet;
import com.revature.petapp.models.User;

public interface UserService {
	/**
	 * Creates a new user in the application and returns the newly 
	 * created user. If a user with that username already exists, it 
	 * will throw an exception.
	 * 
	 * @param user the new user to be created
	 * @return the created user
	 * @throws UsernameAlreadyExistsException
	 */
	public User registerUser(User user) throws UsernameAlreadyExistsException;
	
	/**
	 * Retrieves a user with the specified username in the application, 
	 * returning that user only if the specified password matches the password 
	 * of the retrieved user.
	 * 
	 * @param username the username of the desired user
	 * @param password the password of the desired user
	 * @return the user matching the username if the password matches or null if there is 
	 * no user with that username or the password does not match
	 */
	public User logIn(String username, String password);
	
	/**
	 * Retrieves all of the currently available pets in the application.
	 * 
	 * @return a List of the available pets
	 */
	public List<Pet> viewAllPets();

	/**
	 * Adopts a pet by updating the pet's status and adding the pet 
	 * to the user's list of pets. If the pet is already adopted and
	 * therefore cannot be adopted by this user, an exception is thrown.
	 * 
	 * @param pet the pet to be adopted
	 * @param user the user who is adopting the pet
	 * @return the user with their newly adopted pet in their pets list
	 * @throws AlreadyAdoptedException
	 */
	public User adoptPet(Pet pet, User user) throws AlreadyAdoptedException;
	
	/**
	 * Retrieves the pet that has the specified ID.
	 * 
	 * @param id
	 * @return the pet with the ID, or null if the pet doesn't exist
	 */
	public Pet getPet(int id);

	/**
	 * Retrieves the user that has the specified ID.
	 * 
	 * @param id
	 * @return the user with the ID, or null if the user doesn't exist
	 */
	public User getUser(int id);
}
