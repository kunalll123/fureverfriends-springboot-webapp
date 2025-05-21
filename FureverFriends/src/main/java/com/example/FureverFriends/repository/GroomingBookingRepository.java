package com.example.FureverFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FureverFriends.model.GroomingBooking;

public interface GroomingBookingRepository extends JpaRepository<GroomingBooking, Long> {
	
	@Query(value="select * from grooming_booking where id=:id",nativeQuery = true)
	GroomingBooking findById(long id);
}
