package com.app.api.service.implementations;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Registration;
import com.app.api.model.RegisterRequestModel;
import com.app.api.repository.RegistrationRepository;
import com.app.api.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationRepository repository;

	@Override
	public String save(RegisterRequestModel model) {
		Registration registration = new Registration();
		BeanUtils.copyProperties(model, registration);
		registration.setRegID(model.getOrgination().substring(0, 2)+(int) (Math.random()*10000)+model.getOrgination().substring(1, 2));
		return repository.save(registration)!=null?registration.getRegID():"TRY-AGAIN";
	}

}
