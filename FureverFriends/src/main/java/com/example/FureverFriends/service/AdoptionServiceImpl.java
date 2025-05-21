package com.example.FureverFriends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Adoption;
import com.example.FureverFriends.repository.AdoptionRepository;

@Service
public class AdoptionServiceImpl implements AdoptionService{

	@Autowired
	private AdoptionRepository adoptionRepository;
	
	@Override
	public List<Adoption> getAdoption() {
		List<Adoption> adoptionList=adoptionRepository.findAll();
		return adoptionList;
	}

	@Override
	public Adoption updteStatus(UpdateDto request) {
		
		Adoption adoption=adoptionRepository.findById(request.getId());
		
		adoption.setStatus(request.getStatus());
		
		adoptionRepository.save(adoption);
		
		return adoption;
	}

}
