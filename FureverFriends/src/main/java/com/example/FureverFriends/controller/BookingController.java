package com.example.FureverFriends.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Booking;
import com.example.FureverFriends.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:9090") // Allow frontend to access backend
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/getTranings")  
    public ResponseEntity<?> getTraing()
    {	
    	List<Booking> response=bookingService.getTraings();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/updateStatus")  
    public ResponseEntity<?> updateStatus(@RequestBody UpdateDto request)
    {	
    	Booking response=bookingService.updteStatus(request);
        return ResponseEntity.ok(response);
    }
}

