package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.UnitsDetails;
import com.app.api.entity.User;
import com.app.api.model.ResponseModel;
import com.app.api.repository.UserRepository;
import com.app.api.service.UnitDetailsServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/units")
public class UnitController implements UserDetails {

	@Autowired
	private UnitDetailsServices unitDetailsServices;
	@Autowired
	private UserRepository userRepository;
	ResponseModel<UnitsDetails> responseModel = new ResponseModel<>();

	@RequestMapping(value = "/addUSer", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		User save = userRepository.save(user);
		System.out.println("User created!!" + save);
	}

	@Override
	@GetMapping("/all")
	public ResponseEntity<?> getUnitsDetailsList() {
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, "OK", unitDetailsServices.findAll()));
	}

	@Override
	@GetMapping("/{unitId}")
	public ResponseEntity<?> getUnitsDetails(@PathVariable Long unitId) {
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, "OK", unitDetailsServices.findById(unitId)));
	}

	@Override
	@PostMapping
	public ResponseEntity<?> createUnitsDetails(@RequestBody UnitsDetails unitsDetails) {
		UnitsDetails save = unitDetailsServices.save(unitsDetails);
		return new ResponseEntity<UnitsDetails>(unitsDetails, HttpStatus.CREATED);// unitsDetails.unitDetailsServices.save(unitsDetails);
	}

	@Override
	@PutMapping("/{unitId}")
	public String updateUnitsDetails(@PathVariable("unitId") Long unitId, @RequestBody UnitsDetails unitsDetails) {

		return "Product updated";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.api.controller.UserDetails#deleteUnitsDetails(java.lang.String)
	 */
	@Override
	@DeleteMapping("/{unitId}")
	public String deleteUnitsDetails(@RequestParam String consumerKey) {
		/*
		 * return productService.findById(productId).map(p -> {
		 * productService.deleteById(productId); return "Product deleted";
		 * }).orElseThrow(() -> new ResourceNotFoundException("productId " + productId +
		 * " not found"));
		 */
		return "Product deleted";
	}

}
