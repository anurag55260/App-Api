package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	//Role findByRole(String name);
}