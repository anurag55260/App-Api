package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Resident;
import com.app.api.model.ResidentRequestModel;
import com.app.api.model.ResidentResponseModel;

public interface ResidentServices {

	Resident save(ResidentRequestModel model);

	void deleteById(ResidentRequestModel model);

	Resident findById(Long id);
	
	Resident findByFlatID(String flatID);
	
	Optional<Resident> findByFlatNo(Long flatNo, String block, String floor);

	List<ResidentResponseModel> findAll();

	String delete(ResidentRequestModel model);

	Resident saveUpdate(ResidentRequestModel model, String flatID);

	List<Resident> getResidentDetails(ResidentRequestModel model);
}
