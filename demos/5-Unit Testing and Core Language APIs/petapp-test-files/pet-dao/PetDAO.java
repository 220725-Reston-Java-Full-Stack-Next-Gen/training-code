package com.revature.petapp.data;

import java.util.List;
import com.revature.petapp.models.Pet;
import com.revature.petapp.models.Status;

public interface PetDAO extends DataAccessObject<Pet> {
	public List<Pet> findByStatus(Status status);
}
