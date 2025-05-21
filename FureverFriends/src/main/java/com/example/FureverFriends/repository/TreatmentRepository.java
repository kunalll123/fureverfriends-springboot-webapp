package com.example.FureverFriends.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FureverFriends.model.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
	
	
	@Query(value="select * from treatment where id=:id",nativeQuery = true)
	Treatment findById(long id);
}

