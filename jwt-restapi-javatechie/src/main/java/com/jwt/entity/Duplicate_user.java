package com.jwt.entity;

import org.springframework.stereotype.Component;

@Component
public class Duplicate_user {
	
	private String username;
	
	private String password;
	
	private String email_id;

	public Duplicate_user(String username, String password, String email_id) {
		super();
		this.username = username;
		this.password = password;
		this.email_id = email_id;
	}

	public Duplicate_user() {
		super();
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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Override
	public String toString() {
		return "Duplicate_user [username=" + username + ", password=" + password + ", email_id=" + email_id + "]";
	}

	
}
