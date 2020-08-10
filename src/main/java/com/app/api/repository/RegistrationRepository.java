package com.app.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	Optional<Registration> findByToken(String token);
}
