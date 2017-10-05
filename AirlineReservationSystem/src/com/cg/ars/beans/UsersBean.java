package com.cg.ars.beans;

public class UsersBean {

	String userName;
	String password;
	String role;
	
		
	//getters-setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	//parameterized constructor
	public UsersBean(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	//default constructor
	public UsersBean() {
		super();
	}
	
	//To string method
	@Override
	public String toString() {
		return "UsersBean [userName=" + userName + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
	
}
