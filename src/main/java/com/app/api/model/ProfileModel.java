package com.app.api.model;

public class ProfileModel {
private String userId;	
private String name;
private String regId;
private String address;
private String email;
private String[] role;


public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRegId() {
	return regId;
}
public void setRegId(String regId) {
	this.regId = regId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String[] getRole() {
	return role;
}
public void setRole(String[] role) {
	this.role = role;
}

}
