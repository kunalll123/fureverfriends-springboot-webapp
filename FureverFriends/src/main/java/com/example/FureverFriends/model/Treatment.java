package com.example.FureverFriends.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String ownerName;

   
    private String petName;

  
  
    private String email;

    private String petType;


    private String treatmentDetails;

    private LocalDate preferredDate;
    private LocalTime preferredTime;
    private String status;

    // Constructors
    public Treatment() {}

    public Treatment(String ownerName, String petName, String email, String petType, String treatmentDetails, LocalDate preferredDate, LocalTime preferredTime) {
        this.ownerName = ownerName;
        this.petName = petName;
        this.email = email;
        this.petType = petType;
        this.treatmentDetails = treatmentDetails;
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

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPetType() { return petType; }
    public void setPetType(String petType) { this.petType = petType; }

    public String getTreatmentDetails() { return treatmentDetails; }
    public void setTreatmentDetails(String treatmentDetails) { this.treatmentDetails = treatmentDetails; }

    public LocalDate getPreferredDate() { return preferredDate; }
    public void setPreferredDate(LocalDate preferredDate) { this.preferredDate = preferredDate; }

    public LocalTime getPreferredTime() { return preferredTime; }
    public void setPreferredTime(LocalTime preferredTime) { this.preferredTime = preferredTime; }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
