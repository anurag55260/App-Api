package com.app.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Entity
public class UnitsDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "unit_no")
	private int unitNo;
	@Column(name = "floor")
	private String floor;
	@Column(name = "type")
	private String type;
	@Column(name = "block")
	private String block;
	@Column(name = "unit_history")
	private String unitHistory;
	@Column(name = "status")
	private boolean status;
	@Column(name = "unit_unique_id")
	private String unitUniqueId;// unique value

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getUnitUniqueId() {
		return unitUniqueId;
	}

	public void setUnitUniqueId(String unitUniqueId) {
		this.unitUniqueId = unitUniqueId;
	}

	// @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	// @JoinColumn(name="societyId",referencedColumnName="societyId")
	// private UnitEntity unitID;

}
