package com.jwt.entity;


public class AuthReq {
	
	private String userName;
	
	private String passWord;

	public AuthReq(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public AuthReq() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "AuthReq [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	

}
