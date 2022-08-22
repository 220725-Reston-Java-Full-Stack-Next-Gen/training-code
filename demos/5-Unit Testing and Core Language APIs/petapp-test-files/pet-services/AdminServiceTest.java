package com.revature.petapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.petapp.data.PetDAO;
import com.revature.petapp.models.Pet;

// tell JUnit to use Mockito
@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	// tell Mockito the objects that should be mocked
	@Mock // has Mockito create the mock version of this object
	private PetDAO petDao;
	
	// tell Mockito to insert our mock versions into the class we're testing
	@InjectMocks
	private AdminService adminServ = new AdminServiceImpl();
	
	@Test
	public void addPetSuccessfully() throws SQLException {
		// setup
		Pet testPet = new Pet();
		
		Pet mockReturnedPet = new Pet();
		mockReturnedPet.setId(10);
		
		// the method we're testing (addPet) calls a DAO method.
		// in order for this to be a unit test and not an integration test,
		// we need to mock the DAO method that is called
		
		// when (the mocked method is called) then (the thing it should do)
		Mockito.when(petDao.create(testPet)).thenReturn(mockReturnedPet);
		
		// call the method
		Pet actualPet = adminServ.addPet(testPet);
		
		// assertion
		assertEquals(mockReturnedPet, actualPet);
	}
	
	@Test
	public void addPetSomethingWrong() throws SQLException {
		Pet testPet = new Pet();
		Mockito.when(petDao.create(testPet)).thenThrow(SQLException.class);
		
		Pet actualPet = adminServ.addPet(testPet);
		
		assertNull(actualPet);
	}
	
	@Test
	public void editPetSuccessfully() {
		Pet testPet = new Pet();
		// if a method that you're mocking is called more than once, and you need it to do
		// something different each time, you can just put multiple "then" calls.
		// if it's doing the same thing, you only need one "then" call
		Mockito.when(petDao.findById(testPet.getId())).thenReturn(testPet).thenReturn(testPet);
		// when mocking void methods, you usually will use the Mockito doNothing method
		Mockito.doNothing().when(petDao).update(testPet);
		
		Pet actualPet = adminServ.editPet(testPet);
		
		assertEquals(testPet, actualPet);
	}
	
	@Test
	public void editPetDoesNotExistInDatabase() {
		Pet testPet = new Pet();
		Mockito.when(petDao.findById(testPet.getId())).thenReturn(null);
		
		Pet actualPet = adminServ.editPet(testPet);
		
		assertNull(actualPet);
		
		// Mockito can make sure that certain methods were not called
		Mockito.verify(petDao, Mockito.never()).update(testPet); // asserts that petDao.update(testPet) was never called
		Mockito.verify(petDao, Mockito.times(1)).findById(testPet.getId());
	}
}
