package com.revature.petapp.services;

import java.sql.SQLException;

import com.revature.petapp.data.DAOFactory;
import com.revature.petapp.data.PetDAO;
import com.revature.petapp.models.Pet;

public class AdminServiceImpl implements AdminService {
	private PetDAO petDao = DAOFactory.getPetDAO();

	@Override
	public Pet addPet(Pet pet) {
		try {
			return petDao.create(pet);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public Pet editPet(Pet pet) {
		if (petDao.findById(pet.getId())!=null) {
			petDao.update(pet);
			return petDao.findById(pet.getId());
		}
		return null;
	}

}
