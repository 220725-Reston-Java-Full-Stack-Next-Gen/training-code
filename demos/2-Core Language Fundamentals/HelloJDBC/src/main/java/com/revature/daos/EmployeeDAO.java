package com.revature.daos;

import com.revature.models.Employee;

public interface EmployeeDAO {
	
	//here we are making our CRUD  methods
	// Create
	// Read
	// Update
	// Delete
	
	// please note that the return types can be whatever you think you need for your project
	
	Integer create(Employee emp);
	
	Employee read(int empId);
	
	Employee update(int empId, String email);
	
	boolean delete(int empId);
	
	
	

}
