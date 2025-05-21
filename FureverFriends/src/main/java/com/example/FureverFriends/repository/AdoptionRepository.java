package com.example.FureverFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FureverFriends.model.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Integer>{

	@Query(value="select * from adoption where id=:id",nativeQuery = true)
	Adoption findById(int id);
}
