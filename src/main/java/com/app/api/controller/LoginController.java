package com.app.api.controller;
/**
 * Anurag
 */
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Profiles;
import com.app.api.entity.User;
import com.app.api.exception.CredentialsException;
import com.app.api.model.AuthenticationRequestModel;
import com.app.api.model.ProfileModel;
import com.app.api.model.RegisterRequestModel;
import com.app.api.model.ResponseModel;
import com.app.api.repository.ProfileRepository;
import com.app.api.service.RegistrationService;
import com.app.api.util.Jwt;

@RequestMapping(value = "/")
@RestController
public class LoginController implements LoginAPI {

	@Autowired
	private Jwt jwtTokenUtil;

	@Autowired(required = true)
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private RegistrationService registration;
	@Autowired
	ProfileRepository profileRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.app.api.controller.LoginAPI#createAuthenticationToken(com.app.api.model.
	 * AuthenticationRequest)
	 */// ResponseModelList<UnitsDetails>
	@RequestMapping(value = "/authent", method = RequestMethod.POST)
	public ResponseModel<?> createAuthenticationToken11(@RequestBody AuthenticationRequestModel authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new CredentialsException("Incorrect username or password");
		}
		final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(), jwt);
	}

	@Override
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestModel authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// return new ResponseEntity<>("Incorrect username or password",HttpStatus.OK);
			throw new CredentialsException("Incorrect username or password");
		}
		final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		Profiles profiles = profileRepository.findByEmail(authenticationRequest.getUsername());
		ProfileModel profileModel = new ProfileModel();
		BeanUtils.copyProperties(profiles, profileModel);
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(),jwt, profileModel));// (new
																									// ResponseModel<>(HttpStatus.OK,"OK",Arrays.asList(jwt)),
																									// HttpStatus.OK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.api.controller.LoginAPI#registration(com.app.api.model.
	 * RegisterRequest)
	 */
	@Override
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registration(@RequestBody RegisterRequestModel registerRequest) throws Exception {
		String registrationId = registration.save(registerRequest);
		return ResponseEntity.ok(new ResponseModel<String>(HttpStatus.OK,
				"Registration Succesfull with ID :" + registrationId + ", Please check mail and verify the link"));

	}
	
	@RequestMapping(value = "/verify/{token}", method = RequestMethod.GET)
	public ResponseEntity<?> verifying(@PathVariable() String token) throws Exception {
		Boolean registrationId = registration.verifying(token.trim());
		return ResponseEntity.ok(new ResponseModel<String>(HttpStatus.OK,
				"Registration Succesfull with ID :" + registrationId + ", Please check mail and verify the link"));

	}


	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ResponseEntity<?> setting(@RequestBody RegisterRequestModel registerRequest) throws Exception {
		String registrationId = registration.save(registerRequest);
		return ResponseEntity.ok(new ResponseModel<String>(HttpStatus.OK,
				"Registration Succesfull with ID :" + registrationId + ", Please check mail and verify the link"));

	}

}
