package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.exception.CredentialsException;
import com.app.api.model.AuthenticationRequestModel;
import com.app.api.model.RegisterRequestModel;
import com.app.api.model.ResponseModel;
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

	// ResponseModel<?> responseModel = null;

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
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new CredentialsException("Incorrect username or password");
		}
		final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(), jwt);
		// responseModel = new ResponseModelList<>(HttpStatus.OK, "Success", new
		// AuthenticationResponse(jwt).getJwtToken());
		// return responseModel;
	}

	@Override
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestModel authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// return new ResponseEntity<>("Incorrect username or password",HttpStatus.OK);
			throw new CredentialsException("Incorrect username or password");
		}
		final org.springframework.security.core.userdetails.UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		// Collection<? extends GrantedAuthority> authorities =
		// userDetails.getAuthorities();
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK, HttpStatus.OK.toString(), jwt));// (new
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

	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ResponseEntity<?> setting(@RequestBody RegisterRequestModel registerRequest) throws Exception {
		String registrationId = registration.save(registerRequest);
		return ResponseEntity.ok(new ResponseModel<String>(HttpStatus.OK,
				"Registration Succesfull with ID :" + registrationId + ", Please check mail and verify the link"));

	}

}
