package com.cts.grizzly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Profile")
@Table(name="profile_table")
public class Profile {

	@Id
	@Column(name="userId")
	private String userId;
	private String password;
	private long contactNumber;
	private String userType;
	private String address;
	
	private String designation;
	private String name;
	private int id;
	private int userStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	public Profile() {
		super();
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "Profile [userId=" + userId + ", password=" + password + ", contactNumber=" + contactNumber
				+ ", userType=" + userType + ", address=" + address + ", designation=" + designation + ", name=" + name
				+ ", id=" + id + ", userStatus=" + userStatus + "]";
	}
	

}
