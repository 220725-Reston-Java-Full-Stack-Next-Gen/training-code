package com.revature.petapp.services;

import com.revature.petapp.data.DAOFactory;
import com.revature.petapp.data.PetDAO;
import com.revature.petapp.data.StatusDAO;
import com.revature.petapp.data.UserDAO;

import java.sql.SQLException;
import java.util.List;
import com.revature.petapp.exceptions.AlreadyAdoptedException;
import com.revature.petapp.exceptions.UsernameAlreadyExistsException;
import com.revature.petapp.models.Pet;
import com.revature.petapp.models.Status;
import com.revature.petapp.models.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = DAOFactory.getUserDAO();
	private PetDAO petDao = DAOFactory.getPetDAO();
	private StatusDAO statusDao = DAOFactory.getStatusDAO();

	@Override
	public User registerUser(User user) throws UsernameAlreadyExistsException {
		try {
			user = userDao.create(user);
		} catch (SQLException e) {
			throw new UsernameAlreadyExistsException();
		}
		return user;
	}

	@Override
	public User logIn(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null && (password!=null && password.equals(user.getPassword()))) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public List<Pet> viewAllPets() {
		Status availableStatus = statusDao.findByName("Available");
		return petDao.findByStatus(availableStatus);
	}

	@Override
	public User adoptPet(Pet pet, User user) throws AlreadyAdoptedException {
		if (user == null || pet == null) {
			return null;
		}
		if ("Adopted".equals(pet.getStatus().getName())) {
			throw new AlreadyAdoptedException();
		}
		
		Status adoptedStatus = statusDao.findByName("Adopted");
		pet.setStatus(adoptedStatus);
		List<Pet> pets = user.getPets();
		pets.add(pet);
		user.setPets(pets);

		// TODO this should really be a transaction, but this would require some
		// refactoring of my DAO code in order to do so, so we will leave that
		// for later.
		petDao.update(pet);
		userDao.update(user);
		
		return user;
	}

	@Override
	public Pet getPet(int id) {
		return petDao.findById(id);
	}

	@Override
	public User getUser(int id) {
		return userDao.findById(id);
	}
}
