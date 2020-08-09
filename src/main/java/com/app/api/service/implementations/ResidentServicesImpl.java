package com.app.api.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Resident;
import com.app.api.exception.ResourceNotFoundException;
import com.app.api.model.ResidentRequestModel;
import com.app.api.model.ResidentResponseModel;
import com.app.api.repository.ResidentsRepository;
import com.app.api.service.ResidentServices;

@Service
public class ResidentServicesImpl implements ResidentServices {

	@Autowired
	private ResidentsRepository repository;

	@Override
	public List<ResidentResponseModel> findAll() {
		List<Resident> findAll = repository.findAll();
		List<ResidentResponseModel> residentResponse = new ArrayList<ResidentResponseModel>();
		ResidentResponseModel residentmodel = null;
		for (Resident resident : findAll) {
			residentmodel = new ResidentResponseModel();
			BeanUtils.copyProperties(resident, residentmodel);
			residentResponse.add(residentmodel);
			residentmodel = null;
		}

		return residentResponse;
	}

	@Override
	public Resident saveUpdate(ResidentRequestModel model, String flatID) {
		Resident findByFlatID = findByFlatID(flatID);
		
		Resident resident = new Resident();
		BeanUtils.copyProperties(model, resident);
		// find single record with request data;
		resident.setFlatId(findByFlatID.getFlatId());
		return repository.save(resident);
	}

	@Override
	public Resident save(ResidentRequestModel model) {
		Resident resident = new Resident();
		BeanUtils.copyProperties(model, resident);
		return repository.save(resident);
	}

	@Override
	public void deleteById(ResidentRequestModel model) {
		Resident resident = new Resident();
		BeanUtils.copyProperties(model, resident);
		repository.save(resident);
	}

	@Override
	public String delete(ResidentRequestModel model) {
		Resident resident = new Resident();
		BeanUtils.copyProperties(model, resident);
		repository.delete(resident);
		return "deleted";
	}

	@Override
	public Optional<Resident> findByFlatNo(Long flatNo, String block, String floor) {
		return null;
	}

	@Override
	public Resident findByFlatID(String residentId) {
		return repository.findByFlatId(residentId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With FlatID :" + residentId));
	}

	@Override
	public Resident findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With Id :" + id));
	}

	@Override
	public List<Resident> getResidentDetails(ResidentRequestModel model) {
		if (model.getFirstName() != null) {
			return repository.findByFirstName(model.getFirstName());			
					//.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With Name :"));
		}
		if (model.getUnitno() != null) {
			return repository.findByUnitno(model.getUnitno());
					//.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With UnitNo :"));
		}
		if (model.getMobileNo() != null) {
			return repository.findByMobileNo(model.getMobileNo());
					//.orElseThrow(() -> new ResourceNotFoundException("Resource Not Found With MobileNo :"));
		}
		return null;
	}

}
