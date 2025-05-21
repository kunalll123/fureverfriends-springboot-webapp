package com.example.FureverFriends.service;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Treatment;
import com.example.FureverFriends.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

	public List<Treatment> getTreatments() {
		
		return treatmentRepository.findAll();
	}

	public Treatment updteStatus(UpdateDto request) {
		Treatment treatment=treatmentRepository.findById(request.getId());
		treatment.setStatus(request.getStatus());
		
		treatmentRepository.save(treatment);
		
		return treatment;
	}
}

