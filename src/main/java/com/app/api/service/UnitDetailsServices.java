package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.entity.UnitsDetails;
import com.app.api.model.UnitDetailsResponseModel;

@Service
public interface UnitDetailsServices {

	UnitsDetails save(UnitsDetails product);

	void deleteById(Long id);

	UnitsDetails findById(Long id);

	List<UnitDetailsResponseModel> findAll();

	UnitsDetails findByUnitUniqueId(String uniqueId);

}
