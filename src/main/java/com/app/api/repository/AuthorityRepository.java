package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByAuth(String name);
}
