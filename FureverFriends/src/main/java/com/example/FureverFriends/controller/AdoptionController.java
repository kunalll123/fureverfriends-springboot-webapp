package com.example.FureverFriends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.FureverFriends.dto.UpdateDto;
import com.example.FureverFriends.model.Adoption;
import com.example.FureverFriends.service.AdoptionService;
import com.example.FureverFriends.service.UserService;

@Controller
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AdoptionService adoptionService;


    @PostMapping("/addAdoption")  
    public ResponseEntity<Map<String, String>>  addAdoption(@RequestBody Adoption adoption)
    {
        Adoption adoption1=userService.addAdoption(adoption);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Adoption Request Submitted Successfully!");
        return ResponseEntity.ok(response);
    } 
    
    
    @GetMapping("/getAdoption")  
    public ResponseEntity<?> getAdoption()
    {	
    	List<Adoption> response=adoptionService.getAdoption();
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/updateStatus")  
    public ResponseEntity<?> updateStatus(@RequestBody UpdateDto request)
    {	
    	Adoption response=adoptionService.updteStatus(request);
        return ResponseEntity.ok(response);
    }
}



