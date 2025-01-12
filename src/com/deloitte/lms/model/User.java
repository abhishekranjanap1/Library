package com.deloitte.lms.model;

public class User {
	
	public User(String userId, int age) {
		super();
		this.userId = userId;
		Age = age;
	}
	public User(String userId, String userName, int age, char gender, String userRole, String password) {
		super();
		this.userId = userId;
		UserName = userName;
		Age = age;
		Gender = gender;
		UserRole = userRole;
		Password = password;
	}
	private String userId;
	private String UserName;
	private int Age;
	private char Gender;
	private String UserRole;
	private String Password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", UserName=" + UserName + ", Age=" + Age + ", Gender=" + Gender
				+ ", UserRole=" + UserRole + ", Password=" + Password + "]";
	}
	
	
}
