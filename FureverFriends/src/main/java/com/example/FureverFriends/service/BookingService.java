package com.example.FureverFriends.service;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Booking;
import com.example.FureverFriends.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

	public List<Booking> getTraings() {
		return bookingRepository.findAll();
	}

	public Booking updteStatus(UpdateDto request) {
		Booking booking=bookingRepository.findById(request.getId());
		booking.setStatus(request.getStatus());
		bookingRepository.save(booking);
		return booking;
	}
}

