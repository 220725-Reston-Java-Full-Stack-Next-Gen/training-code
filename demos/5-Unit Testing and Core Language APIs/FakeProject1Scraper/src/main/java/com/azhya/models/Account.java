package com.azhya.models;

import java.time.LocalDate;

public class Account {
	
	private int accountId;
	private double balance;
	private AccountStatus status;
	private AccountType type;
	private LocalDate creationDate;
	//NOTE: account_user_id not needed here because we already took care of the FK relationship bask in the User class
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, double balance, AccountStatus status, AccountType type, LocalDate creationDate) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
		this.creationDate = creationDate;
	}
	public Account(double balance, AccountStatus status, AccountType type, LocalDate creationDate) {
		super();
		this.balance = balance;
		this.status = status;
		this.type = type;
		this.creationDate = creationDate;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", type=" + type
				+ ", creationDate=" + creationDate + "]";
	}
}
