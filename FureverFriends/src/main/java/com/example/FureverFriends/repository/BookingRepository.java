package com.example.FureverFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FureverFriends.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query(value="select * from booking where id=:id",nativeQuery = true)
	Booking findById(long id);
}

