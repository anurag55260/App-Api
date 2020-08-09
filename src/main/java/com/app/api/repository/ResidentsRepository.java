package com.app.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Resident;

@Repository
public interface ResidentsRepository extends JpaRepository<Resident, Long> {
	
	void findByResidentId(String residentId);

	Optional<Resident> findByFlatId(String residentId);

	List<Resident> findByUnitno(String residentId);

	List<Resident> findByMobileNo(String residentId);

	List<Resident> findByFirstName(String residentId);

	List<Resident> findByLastName(String residentId);
}
