package com.app.api.service.implementations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Profiles;
import com.app.api.entity.Registration;
import com.app.api.entity.Role;
import com.app.api.entity.User;
import com.app.api.model.RegisterRequestModel;
import com.app.api.repository.ProfileRepository;
import com.app.api.repository.RegistrationRepository;
import com.app.api.repository.UnitDetailsRepository;
import com.app.api.repository.UserRepository;
import com.app.api.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationRepository repository;
	
	@Autowired
	UnitDetailsRepository unitDetailsRepository;
	@Autowired
	ProfileRepository profileRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public String save(RegisterRequestModel model) {
		Registration registration = new Registration();
		BeanUtils.copyProperties(model, registration);
		registration.setToken(UUID.randomUUID().toString());
		registration.setVerifed(false);
		registration.setRegId(model.getName().substring(0, 2)+(int) (Math.random()*10000)+model.getName().substring(1, 2));
		return repository.save(registration)!=null?registration.getRegId():"TRY-AGAIN";
	}

	@Override
	public Boolean verifying(String token) {
		Optional<Registration> registrationObj = repository.findByToken(token);
		if(!registrationObj.isPresent()) {
			//
		}
		Registration registration = registrationObj.get();
		registration.setToken(null);
		registration.setVerifed(true);
		repository.save(registration);
		Profiles profiles = new Profiles();
		BeanUtils.copyProperties(registrationObj.get(), profiles);
		profileRepository.save(profiles);
		userRepository.save(new User(profiles.getEmail(), "ADMIN", false, new Role("ADMIN")));
		
		
		return true;
	}

}
