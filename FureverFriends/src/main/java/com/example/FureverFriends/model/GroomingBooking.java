package com.example.FureverFriends.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroomingBooking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private String petName;
    private String email;
    private String petType;
    private String service;
    private String date;
    private String time;
    private String status;

    // Default Constructor
    public GroomingBooking() {}

    // Parameterized Constructor
    public GroomingBooking(String ownerName, String petName, String email, String petType, String service, String date, String time) {
        this.ownerName = ownerName;
        this.petName = petName;
        this.email = email;
        this.petType = petType;
        this.service = service;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString() Method for Debugging
    @Override
    public String toString() {
        return "GroomingBooking{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", petName='" + petName + '\'' +
                ", email='" + email + '\'' +
                ", petType='" + petType + '\'' +
                ", service='" + service + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
