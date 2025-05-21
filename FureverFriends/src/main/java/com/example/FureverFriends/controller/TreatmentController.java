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
import com.example.FureverFriends.model.Adoption;
import com.example.FureverFriends.model.Treatment;
import com.example.FureverFriends.service.TreatmentService;



@RestController
@RequestMapping("/api/treatments")
@CrossOrigin(origins = "http://localhost:9090") // Allow frontend to access backend
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PostMapping
    public Treatment createTreatment( @RequestBody Treatment treatment) {
        return treatmentService.saveTreatment(treatment);
    }

    
    @GetMapping("/getTreatments")  
    public ResponseEntity<?> getTreatments()
    {	
    	List<Treatment> response=treatmentService.getTreatments();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/updateStatus")  
    public ResponseEntity<?> updateStatus(@RequestBody UpdateDto request)
    {	
    	Treatment response=treatmentService.updteStatus(request);
        return ResponseEntity.ok(response);
    }
}

