package com.azhya.models;

public class AccountStatus {
	private int statusId;
	private String status;
	public AccountStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public AccountStatus(String status) {
		super();
		this.status = status;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountStatus [statusId=" + statusId + ", status=" + status + "]";
	}
}
