package com.app.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Resident;
import com.app.api.model.ResidentRequestModel;
import com.app.api.model.ResidentResponseModel;
import com.app.api.model.ResponseModel;
import com.app.api.service.ResidentServices;

@RestController
@RequestMapping("/residents")
public class ResidentController implements ResidentApi {
	@Autowired
	private ResidentServices residentServices;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.api.controller.ResidentApi#getResidentList()
	 */
	@Override
	@GetMapping("/all")
	public ResponseEntity<?> getResidentList() {
		List<ResidentResponseModel> findAll = residentServices.findAll();
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, "OK", findAll));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.api.controller.ResidentApi#getResidentByID(java.lang.Long)
	 */
	@Override
	// @GetMapping("/{residentId}")
	public ResponseEntity<?> getResidentByID(@PathVariable Long residentId) {
		return ResponseEntity.ok(residentServices.findById(residentId));
	}

	@Override
	@GetMapping("/{flatID}")
	public ResponseEntity<?> getResidentByFlatID(@PathVariable String flatID) {

		Resident findByFlatID = residentServices.findByFlatID(flatID);
		ArrayList<Resident> arrayList = new ArrayList<Resident>();
		arrayList.add(findByFlatID);
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(), arrayList));
		// return ResponseEntity.ok(residentServices.findByFlatID(flatID));
	}

	@Override
	@PostMapping
	public ResponseEntity<?> getResidentDetails(@RequestBody ResidentRequestModel model) {
		return ResponseEntity.ok(residentServices.getResidentDetails(model));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.api.controller.ResidentApi#createResident(com.app.api.model.
	 * ResidentModel)
	 */
	@Override
	// @PostMapping
	public ResponseEntity<?> createResident(@RequestBody ResidentRequestModel model) {
		return ResponseEntity
				.ok(new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(), residentServices.save(model)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.app.api.controller.ResidentApi#updateResidentDetails(com.app.api.model.
	 * ResidentModel)
	 */
	@Override
	@PutMapping("/{flatID}")
	public Resident updateResidentDetails(@RequestBody ResidentRequestModel model, @PathVariable String flatID) {
		return residentServices.saveUpdate(model, flatID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.app.api.controller.ResidentApi#deleteResidentDetails(com.app.api.model.
	 * ResidentModel)
	 */
	@Override
	// @DeleteMapping
	public String deleteResidentDetails(@RequestBody ResidentRequestModel model) {
		// TODO Auto-generated method stub
		return residentServices.delete(model);
	}

}
