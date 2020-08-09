package com.app.api.controller;

import org.springframework.http.ResponseEntity;

import com.app.api.model.AuthenticationRequestModel;
import com.app.api.model.RegisterRequestModel;

import io.swagger.annotations.Api;
@Api
public interface LoginAPI {

	ResponseEntity<?> registration(RegisterRequestModel registerRequest) throws Exception;

	ResponseEntity<?> createAuthenticationToken(AuthenticationRequestModel authenticationRequest) throws Exception;

}