package com.todo.main.domain;

public class UserDetails {
	private int userId;
	private String name;
	private String countryCode;
	private String phoneNo;
	private String email;
	private String password;
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	public UserDetails(int userId, String name, String countryCode, String phoneNo, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.countryCode = countryCode;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", countryCode=" + countryCode + ", phoneNo="
				+ phoneNo + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
