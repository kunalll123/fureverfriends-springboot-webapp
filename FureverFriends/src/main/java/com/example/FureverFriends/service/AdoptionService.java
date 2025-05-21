package com.example.FureverFriends.service;

import java.util.List;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Adoption;

public interface AdoptionService {

	List<Adoption> getAdoption();

	Adoption updteStatus(UpdateDto request);

}
