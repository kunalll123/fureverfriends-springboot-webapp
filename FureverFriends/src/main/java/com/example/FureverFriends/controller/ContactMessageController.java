package com.example.FureverFriends.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FureverFriends.model.ContactMessage;
import com.example.FureverFriends.service.ContactMessageService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactMessageController {

    @Autowired
    private ContactMessageService service;

    @PostMapping
    public ContactMessage submitContact(@RequestBody ContactMessage message) {
        return service.saveMessage(message);
    }
}

