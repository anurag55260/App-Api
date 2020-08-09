package com.app.api.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.UnitsDetails;
import com.app.api.exception.ResourceNotFoundException;
import com.app.api.model.UnitDetailsResponseModel;
import com.app.api.repository.UnitDetailsRepository;
import com.app.api.service.UnitDetailsServices;

@Service
public class UnitDetailsServicesImpl implements UnitDetailsServices {
	@Autowired
	private UnitDetailsRepository unitDetailsRepository;

	@Override
	public UnitsDetails save(UnitsDetails unitsDetails) {
		String unitUniqueId = unitsDetails.getBlock() + unitsDetails.getUnitNo();
		unitsDetails.setUnitUniqueId(unitUniqueId);
		return unitDetailsRepository.save(unitsDetails);
	}

	@Override
	public void deleteById(Long id) {
		unitDetailsRepository.deleteById(id);

	}

	@Override
	public UnitsDetails findById(Long id) {
		return unitDetailsRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With UnitID :" + id));
		//return unitDetailsRepository.findById(id);
	}

	@Override
	public UnitsDetails findByUnitUniqueId(String findByUnitUniqueId) {
		return unitDetailsRepository.findByUnitUniqueId(findByUnitUniqueId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With UniqueId :" + findByUnitUniqueId));
	}

	@Override
	public List<UnitDetailsResponseModel> findAll() {
		List<UnitsDetails> findAll = unitDetailsRepository.findAll();
		List<UnitDetailsResponseModel> UnitDetailsResponse = new ArrayList<UnitDetailsResponseModel>();
		UnitDetailsResponseModel unit = null;
		for (UnitsDetails unitsDetails : findAll) {
			unit = new UnitDetailsResponseModel();
			BeanUtils.copyProperties(unitsDetails, unit);
			UnitDetailsResponse.add(unit);
			unit = null;
		}
		return UnitDetailsResponse;
	}

}
