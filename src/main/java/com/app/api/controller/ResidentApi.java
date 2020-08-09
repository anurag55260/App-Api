package com.app.api.controller;

import org.springframework.http.ResponseEntity;

import com.app.api.entity.Resident;
import com.app.api.model.ResidentRequestModel;

import io.swagger.annotations.Api;

@Api
public interface ResidentApi {

	ResponseEntity<?> getResidentList();

	ResponseEntity<?> getResidentByID(Long residentId);

	ResponseEntity<?> createResident(ResidentRequestModel model);

	Resident updateResidentDetails(ResidentRequestModel model, String flatID);

	String deleteResidentDetails(ResidentRequestModel model);

	ResponseEntity<?> getResidentByFlatID(String flatID);

	ResponseEntity<?> getResidentDetails(ResidentRequestModel model);

}