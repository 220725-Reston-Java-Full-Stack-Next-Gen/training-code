package com.revature.drivers;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Employee;
import com.revature.util.JDBCConnectionUtil;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	
	
	public static void main(String[] args) {
		
	
		
//		System.out.println(JDBCConnectionUtil.getConnection());
		
//		Employee tim = new Employee();
//		Employee tom = new Employee(2,"tom","hanks",LocalDate.now(),5000.00,LocalDate.now(),"trainer","trainer@email.com");
//		
//		System.out.println(tim.getEmail());
//		System.out.println(tom.getEmail());
//		
//		tim.setEmail(("timsemailisnolongernull@aol.com"));
//		System.out.println(tim.getEmail());
//		
//		System.out.println(tim.toString());
		
		EmployeeDAOImpl empDao = new EmployeeDAOImpl();
		
//		Integer empId = empDao.create(tom);
//		System.out.println((empId));
		
		Employee tiff = new Employee("Tiff","Obi",LocalDate.of(1990, 3, 14),10_000.00,LocalDate.of(2020,4,20),"Teacher","trainer@email.com");
		empDao.create(tiff);
////		
//		Employee tom = empDao.read(2);
//		Employee ghost = empDao.read(3);
//		
//		//here we are able to see the user that exists in the db
//		System.out.println(tom.toString());
//		//here we are reading a user that does not exist
//		System.out.println(ghost.toString());
		
		// Here we are demoing all 4 of the CRUD functionalities with our new employee
		//C = Create
//		Employee bruce = new Employee("Bruce","Jones",LocalDate.now(),
//				50_000.00,LocalDate.now(),"Full Stack Developer","bruceJones@aol.com");
//		Integer bruceId = empDao.create(bruce);
//		System.out.println(bruceId);
		
		
		//R = Read
//		Employee bruceFromDb = empDao.read(8);
//		System.out.println(bruceFromDb.toString());
		
		
		//U = Update
//		System.out.println(empDao.update(5, "brucespruce@yahoo.com"));
		
		//D = Delete
//		System.out.println(empDao.delete(7));
		
		//bonus method = logging in a user or checking login credentials
//		Employee loggedInBruce = empDao.logInEmployee("brucespruce@yahoo.com", "Jones");
//		System.out.println(loggedInBruce.toString());
		
//		System.out.println(empDao.getAllEmployees().toString());
		
		LOGGER.info(empDao.getAllEmployees().toString());
		
	}
}
