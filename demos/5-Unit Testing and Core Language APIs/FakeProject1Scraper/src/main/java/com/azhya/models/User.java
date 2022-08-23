package com.azhya.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private BankRole role; //this is a FK
	private List<Account> accounts = new ArrayList<Account>(); //I did this FK like this because there is a M:M relationship
	//between users and accounts
	
	//no-args constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all-args constructor
	public User(int userId, String username, String password, String firstName, String lastName, String email,
			BankRole role, List<Account> accounts) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.accounts = accounts;
	}

	//constructor for creating objects in database
	public User(String username, String password, String firstName, String lastName, String email, BankRole role,
			List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.accounts = accounts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BankRole getRole() {
		return role;
	}

	public void setRole(BankRole role) {
		this.role = role;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + ", accounts="
				+ accounts + "]";
	}
}
