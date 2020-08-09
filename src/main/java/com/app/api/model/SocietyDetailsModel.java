package com.app.api.model;

public class SocietyDetailsModel {
	private String name;//XYZ  --- these two information will be from 
	private String societyId;//XYZ123
	private String noOfUnit;// NoOfUnit| 100
	private boolean status;
	private UnitsDetailsRequestModel[] units;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSocietyId() {
		return societyId;
	}
	public void setSocietyId(String societyId) {
		this.societyId = societyId;
	}
	public String getNoOfUnit() {
		return noOfUnit;
	}
	public void setNoOfUnit(String noOfUnit) {
		this.noOfUnit = noOfUnit;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public UnitsDetailsRequestModel[] getUnits() {
		return units;
	}
	public void setUnits(UnitsDetailsRequestModel[] units) {
		this.units = units;
	}
	

}
