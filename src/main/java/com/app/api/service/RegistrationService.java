package com.app.api.service;

import com.app.api.model.RegisterRequestModel;

public interface RegistrationService {
	String save(RegisterRequestModel model);
	Boolean verifying(String trim);
}
