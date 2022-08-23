package com.azhya.models;

public class BankRole {

	private int roleId;
	private String roleType;
	
	public BankRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankRole(int roleId, String roleType) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
	}

	public BankRole(String roleType) {
		super();
		this.roleType = roleType;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "BankRole [roleId=" + roleId + ", roleType=" + roleType + "]";
	}
}
