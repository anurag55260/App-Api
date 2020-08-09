package com.app.api.controller;

import org.springframework.http.ResponseEntity;

import com.app.api.entity.UnitsDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface UserDetails {

	@ApiOperation(value = "Get list of unitdetails in the System ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!") })
	ResponseEntity<?> getUnitsDetailsList();

	@ApiOperation(value = "Get unit by unit ID", response = UnitsDetails.class)
	ResponseEntity<?> getUnitsDetails(Long unitId);

	@ApiOperation(value = "Create unit", response = String.class)
	ResponseEntity<?> createUnitsDetails(UnitsDetails unitsDetails);

	@ApiOperation(value = "Update Unit by unit ID", response = String.class)
	String updateUnitsDetails(Long unitId, UnitsDetails unitsDetails);

	@ApiOperation(value = "Delete/Inactivate unit by unit ID", response = String.class)
	String deleteUnitsDetails(String consumerKey);

	// ResponseModelList<UnitsDetails> getUnitsDetails1(Long unitId);

	// ResponseEntity<?> getUnitsDetails2(Long unitId) throws Exception;

}