package com.example.FureverFriends.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ownerName;
    private String petName;
    private String petType;
    private String trainingType;
    private Date preferredDate;
    private String preferredTime;
    private String status;

    // Constructors
    public Booking() {}

    public Booking(String ownerName, String petName, String petType, String trainingType, Date preferredDate ,String  preferredTime) {
        this.ownerName = ownerName;
        this.petName = petName;
        this.petType = petType;
        this.trainingType = trainingType;
        this.preferredDate = preferredDate;
        this.preferredTime = preferredTime;

    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }

    public String getPetType() { return petType; }
    public void setPetType(String petType) { this.petType = petType; }

    public String getTrainingType() { return trainingType; }
    public void setTrainingType(String trainingType) { this.trainingType = trainingType; }

    public Date getPreferredDate() { return preferredDate; }
    public void setPreferredDate(Date preferredDate) { this.preferredDate = preferredDate; }

    public String getPreferredTime() { return preferredTime; }
    public void setPreferredTime(String preferredTime) { this.preferredTime = preferredTime; }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}

