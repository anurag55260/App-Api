package com.app.api.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name ="Unit")
public class Units  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aptName;
	private String societyId;
	private String noOfUnit;
	
//	@OneToMany(targetEntity=UnitDetailsEntity.class,cascade= CascadeType.ALL,mappedBy="unitID")
	//private List<UnitDetailsEntity> unitDetails = new ArrayList<>();
	
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
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
	
}
