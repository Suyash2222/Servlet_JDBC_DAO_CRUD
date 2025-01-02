package com.user.model;

import java.io.Serializable;

public class UserRegister implements Serializable
{
	
	private String name,username,password,mail;
	private long phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public UserRegister(String name, String username, String password, String mail, long phone) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
	}
	
	public UserRegister(){}

}
