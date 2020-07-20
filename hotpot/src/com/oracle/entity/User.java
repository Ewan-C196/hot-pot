package com.oracle.entity;

public class User {
	private int uId;
	private String uName;
	private String uPassword;
	private String uNumber;
	 
	public int getId() {
		return uId;
	}
	public void setId(int id) {
		this.uId = id;
	}
	public String getUserName() {
		return uName;
	}
	public void setUserName(String userName) {
		this.uName = userName;
	}
	public String getPassword() {
		return uPassword;
	}
	public void setPassword(String password) {
		this.uPassword = password;
	}
	public String getuNumber() {
		return uNumber;
	}
	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPassword=" + uPassword + ", uNumber=" + uNumber + "]";
	}
}
