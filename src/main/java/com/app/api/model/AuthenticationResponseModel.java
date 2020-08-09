package com.app.api.model;

public class AuthenticationResponseModel {
	private String jwtToken;

	public AuthenticationResponseModel() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponseModel(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
