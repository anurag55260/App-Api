package com.app.api.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.xml.txw2.annotation.XmlElement;
@XmlElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> {
	private HttpStatus status;
	private String message;
	private List<T> items;//= new ArrayList<>();
	private T item;
	private Integer noOfPage[];
	private String action;
	private String token;
	private ProfileModel profile;
	private Services[] services;
	
	public ResponseModel(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	

	public ResponseModel(HttpStatus status, String message, String action, String token) {
		super();
		this.status = status;
		this.message = message;
		this.action = action;
		this.token = token;
	}

	public ResponseModel(HttpStatus status, String message, List<T> items) {
		super();
		this.status = status;
		this.message = message;
		this.items = items;
	}
	public ResponseModel(HttpStatus status, String message, T item) {
		super();
		this.status = status;
		this.message = message;
		this.item = item;
	}


	public ResponseModel(HttpStatus status, String message, String token) {
		super();
		this.status = status;
		this.message = message;
		this.token = token;
	}
	
	public ResponseModel(HttpStatus status, String message, String token, ProfileModel profile) {
		super();
		this.status = status;
		this.message = message;
		this.token = token;
		this.profile=profile;
	}


	public ResponseModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseModel(HttpStatus status, String message, List<T> items, Integer[] noOfPage, String action,
			String token) {
		super();
		this.status = status;
		this.message = message;
		this.items = items;
		this.noOfPage = noOfPage;
		this.action = action;
		this.token = token;
	}



	public HttpStatus getStatus() {
		return status;
	}



	public void setStatus(HttpStatus status) {
		this.status = status;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public List<T> getItems() {
		return items;
	}



	public void setItems(List<T> items) {
		this.items = items;
	}



	public T getItem() {
		return item;
	}



	public void setItem(T item) {
		this.item = item;
	}



	public Integer[] getNoOfPage() {
		return noOfPage;
	}



	public void setNoOfPage(Integer[] noOfPage) {
		this.noOfPage = noOfPage;
	}



	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public ProfileModel getProfile() {
		return profile;
	}



	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}



	public Services[] getServices() {
		return services;
	}



	public void setServices(Services[] services) {
		this.services = services;
	}
	
	
	
}
