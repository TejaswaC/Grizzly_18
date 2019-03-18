package com.cts.grizzly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Login")
@Table(name="login_table")
public class Login {

	public Login() {
	}

	@Id
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;

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

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	

	

	
}
