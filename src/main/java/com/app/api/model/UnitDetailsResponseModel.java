package com.app.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnitDetailsResponseModel {
	//@Column(name = "unit_no")
	private int unitNo;
	//@Column(name = "floor")
	private String floor;
	//@Column(name = "type")
	private String type;
	//@Column(name = "block")
	private String block;
	//@Column(name = "unit_history")
	private String unitHistory;
	//@Column(name = "status")
	private boolean status;

	public int getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getUnitHistory() {
		return unitHistory;
	}

	public void setUnitHistory(String unitHistory) {
		this.unitHistory = unitHistory;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
