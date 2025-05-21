package com.example.FureverFriends.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Adoption;
import com.example.FureverFriends.model.GroomingBooking;
import com.example.FureverFriends.service.GroomingBookingService;

@RestController
@RequestMapping("/api/grooming-bookings")
@CrossOrigin(origins = "http://localhost:9090") // Allow frontend access
public class GroomingBookingController {

    @Autowired
    private GroomingBookingService groomingBookingService;

    @PostMapping
    public GroomingBooking createBooking(@RequestBody GroomingBooking booking) {
        return groomingBookingService.saveBooking(booking);
    }

    @GetMapping("/getGroommings")  
    public ResponseEntity<?> getAdoption()
    {	
    	List<GroomingBooking> response=groomingBookingService.getGroomings();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/updateStatus")  
    public ResponseEntity<?> updateStatus(@RequestBody UpdateDto request)
    {	
    	GroomingBooking response=groomingBookingService.updteStatus(request);
        return ResponseEntity.ok(response);
    }
}
