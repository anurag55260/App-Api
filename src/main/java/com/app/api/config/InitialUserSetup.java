package com.app.api.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import com.app.api.entity.Authority;
import com.app.api.entity.Role;
import com.app.api.entity.User;
import com.app.api.repository.AuthorityRepository;
import com.app.api.repository.RoleRepository;
import com.app.api.repository.UserRepository;

//@Component
//@Transactional
public class InitialUserSetup {
	@Autowired
	AuthorityRepository authorityRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent event) {

		System.out.println("Application Ready Event!!");
		Authority readAuthority = createAuthority("READ_AUTHORITY");
		Authority createAuthority = createAuthority("CREATE_AUTHORITY");
		Authority deleteAuthority = createAuthority("DELETE_AUTHORITY");

		Role createRole = createRole("ROLE_USER", Arrays.asList(readAuthority, createAuthority));
		Role adminRole = createRole("ROLE_ADMIN", Arrays.asList(readAuthority, createAuthority, deleteAuthority));

		if (adminRole == null)
			return;

		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		// user.setRoles(Arrays.asList(adminRole));

		userRepository.save(user);

	}

	@Transactional
	private Authority createAuthority(String name) {
		Authority findByAuth = authorityRepository.findByAuth(name);

		if (findByAuth == null) {
			findByAuth = new Authority(name);
			authorityRepository.save(findByAuth);
		}
		return findByAuth;
	}

	@Transactional
	private Role createRole(String name, Collection<Authority> authorityList) {
		/*
		 * Role findByRole = roleRepository.findByRole(name); if (findByRole == null) {
		 * //findByRole = new Role(name); //findByRole.setAuthorities(authorityList);
		 * roleRepository.save(findByRole); }
		 */
		return null;
	}

}
