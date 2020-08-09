package com.app.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.UnitsDetails;
@Repository
public interface UnitDetailsRepository extends JpaRepository<UnitsDetails, Long>{

	Optional<UnitsDetails> findByUnitUniqueId(String findByUnitUniqueId);

}
