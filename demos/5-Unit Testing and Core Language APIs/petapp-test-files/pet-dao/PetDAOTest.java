// package name should match the package of the class we're testing
package com.revature.petapp.data;

// static import: allows you to call static methods without using the class name
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;

import com.revature.petapp.data.jdbc.PetPostgres;
import com.revature.petapp.models.Pet;

public class PetDAOTest {
	// we need an object of the class we're testing
	private PetDAO petDao = new PetPostgres();
	
	// JUnit test methods are public and void with no parameters
	@Test // this annotation says that this method is a test
	public void exampleTest() {
		// setup (set up your test inputs, mocking, etc.)
		
		// call the method that you're testing
		
		// assertion: checking for the expected behavior
		// Assertions.assertTrue(true) // if you don't do the static import on line 5
		assertTrue(true);
	}
	
	// testing petDao findById with a valid ID
	@Test
	public void findByIdSuccessful() {
		// setup
		int testId = 1;
		
		// call the method, getting the return value
		Pet actualPet = petDao.findById(testId);
		
		// assertion
		// what do we expect?
		// a pet object with the matching ID
		// we could assert: the pet is not null, the pet has ID of 1, the pet's name
		assertEquals(testId, actualPet.getId());
	}
	
	@Test
	// @Disabled
	public void findByIdDoesNotExist() {
		int testId = 0;
		Pet actualPet = petDao.findById(testId);
		assertNull(actualPet);
	}
	
	@Test
	public void createPetSuccessfully() throws SQLException {
		// setup
		Pet testPet = new Pet();
		testPet.setName("Test");
		
		// call the method
		Pet actualPet = petDao.create(testPet);
		// this method can throw an exception. i am "handling" it
		// using the "throws" keyword because i want the test to fail
		// if the exception is thrown. if i handled it using a try-catch,
		// it could fly under the radar
		
		// assertion
		// some options: make sure the pet is not null, make sure the ID is not the default
		assertNotEquals(testPet.getId(), actualPet.getId());
	}
	
	@Test
	// this test fails right now because the exception is being caught in the method
	public void createPetSQLException() {
		// setup
		Pet testPet = new Pet();
		testPet.setName(null);
		
		// when we are expecting an exception, the structure is a little different
		assertThrows(SQLException.class, () -> {
			// the code that should throw the exception goes here.
			// if the exception is not thrown, the test fails
			petDao.create(testPet);
		});
	}
}
