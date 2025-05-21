package com.example.FureverFriends.service;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.GroomingBooking;
import com.example.FureverFriends.repository.GroomingBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroomingBookingService {

    @Autowired
    private GroomingBookingRepository groomingBookingRepository;

    public GroomingBooking saveBooking(GroomingBooking booking) {
        return groomingBookingRepository.save(booking);
    }

    public List<GroomingBooking> getAllBookings() {
        return groomingBookingRepository.findAll();
    }

	public List<GroomingBooking> getGroomings() {
		
		return groomingBookingRepository.findAll();
	}

	public GroomingBooking updteStatus(UpdateDto request) {
		GroomingBooking grooming=groomingBookingRepository.findById(request.getId());
		grooming.setStatus(request.getStatus());
		groomingBookingRepository.save(grooming);
		return grooming;
	}
}
