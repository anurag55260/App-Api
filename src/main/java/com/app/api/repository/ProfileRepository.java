package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.entity.Profiles;

public interface ProfileRepository extends JpaRepository<Profiles, Integer> {

	Profiles findByEmail(String email);
}
