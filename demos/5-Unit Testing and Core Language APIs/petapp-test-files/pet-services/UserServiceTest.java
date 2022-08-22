package com.revature.petapp.services;

// import all of the static methods of the Assertions class
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.petapp.data.PetDAO;
import com.revature.petapp.data.StatusDAO;
import com.revature.petapp.data.UserDAO;
import com.revature.petapp.exceptions.AlreadyAdoptedException;
import com.revature.petapp.exceptions.UsernameAlreadyExistsException;
import com.revature.petapp.models.Pet;
import com.revature.petapp.models.Status;
import com.revature.petapp.models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	// object that we're testing
	@InjectMocks
	private UserService userServ = new UserServiceImpl();

	// UserService dependencies that we need to mock
	@Mock
	private UserDAO userDao;
	@Mock
	private PetDAO petDao;
	@Mock
	private StatusDAO statusDao;

	@BeforeAll
	public static void setUp() {
		// set up some mock values, etc.
	}

	// @BeforeEach, @AfterEach, @AfterAll

	@Test
	public void registerSuccessfully() throws UsernameAlreadyExistsException, SQLException {
		// setup
		User mockUser = new User();
		Mockito.when(userDao.create(mockUser)).thenReturn(mockUser);

		// call method
		User returnedUser = userServ.registerUser(mockUser);

		// assertion
		assertNotNull(returnedUser);
	}

	@Test
	public void registerUsernameAlreadyExists() throws SQLException {
		User mockUser = new User();
		Mockito.when(userDao.create(mockUser)).thenThrow(SQLException.class);

		// when asserting an exception was thrown, the structure is a little
		// different - you set up a lambda function that JUnit will call and
		// check for an exception
		assertThrows(UsernameAlreadyExistsException.class, () -> {
			userServ.registerUser(mockUser);
		});
	}

	@Test
	public void logInSuccessfully() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = "test";

		User mockUser = new User(username, password);
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertEquals(username, returnedUser.getUsername());
	}

	@Test
	public void logInUsernameDoesntExist() {
		// setup (inputs, mocks, etc.)
		String username = "wrong";
		String password = "test";

		Mockito.when(userDao.findByUsername(username)).thenReturn(null);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

	@Test
	public void logInWrongPassword() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = "wrong";

		User mockUser = new User(username, "test");
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

	@Test
	public void logInNullPassword() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = null;

		User mockUser = new User(username, "test");
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

	@Test
	public void viewAvailablePets() {
		// setup
		Mockito.when(statusDao.findByName("Available")).thenReturn(new Status());
		Mockito.when(petDao.findByStatus(new Status())).thenReturn(new ArrayList<>());

		// call method
		List<Pet> returnedPets = userServ.viewAllPets();

		// assertion
		assertNotNull(returnedPets);
	}

	@Test
	public void adoptPetSuccessfully() throws AlreadyAdoptedException {
		// setup
		Pet mockPet = new Pet();
		User mockUser = new User();

		// mocking methods with the void return type uses a different structure:
		// (i don't know why it's so different... questionable design choice)
		Mockito.doNothing().when(petDao).update(mockPet);
		Mockito.doNothing().when(userDao).update(mockUser);
		
		Mockito.when(statusDao.findByName("Adopted")).thenReturn(new Status(2, "Adopted"));

		// call method
		User returnedUser = userServ.adoptPet(mockPet, mockUser);

		// assertion
		List<Pet> userPets = returnedUser.getPets();
		assertTrue(userPets.size() > 0 && "Adopted".equals(userPets.get(0).getStatus().getName()));
	}

	@Test
	public void adoptPetAlreadyAdopted() {
		Pet mockPet = new Pet();
		User mockUser = new User();

		mockPet.setStatus(new Status(2, "Adopted"));

		assertThrows(AlreadyAdoptedException.class, () -> {
			userServ.adoptPet(mockPet, mockUser);
		});
	}

	@Test
	public void adoptPetNullPet() throws AlreadyAdoptedException {
		// setup
		Pet mockPet = null;
		User mockUser = new User();

		// call method
		User returnedUser = userServ.adoptPet(mockPet, mockUser);
		
		// assertion
		assertNull(returnedUser);
	}

	@Test
	public void adoptPetNullUser() throws AlreadyAdoptedException {
		// setup
		Pet mockPet = new Pet();
		User mockUser = null;

		// call method
		User returnedUser = userServ.adoptPet(mockPet, mockUser);
		
		// assertion
		assertNull(returnedUser);
	}
}
