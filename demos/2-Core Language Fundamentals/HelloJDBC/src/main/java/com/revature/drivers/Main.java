package com.revature.drivers;

import java.sql.Date;
import java.time.LocalDate;

import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Employee;
import com.revature.util.JDBCConnectionUtil;

public class Main {

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
		
//		Employee tiff = new Employee("Tiff","Obi",LocalDate.now(),10_000.00,LocalDate.now(),"Teacher","teacher@email.com");
//		empDao.create(tiff);
		
		Employee tom = empDao.read(2);
		Employee ghost = empDao.read(3);
		
		
		System.out.println(tom.toString());
		System.out.println(ghost.toString());
		
	}
}
