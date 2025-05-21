package com.example.FureverFriends.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private String petType;
    private String job;
    private boolean ownedPets;
    private String otherPets;
    private String rentOrOwn;
    private int members;
    private boolean allergies;

    @Column(length=255)
    private String adoptreason;
    private boolean homeVisit;
    private String contact;
    private String status;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPetType() {
        return petType;
    }
    public void setPetType(String petType) {
        this.petType = petType;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public boolean isOwnedPets() {
        return ownedPets;
    }
    public void setOwnedPets(boolean ownedPets) {
        this.ownedPets = ownedPets;
    }
    public String getOtherPets() {
        return otherPets;
    }
    public void setOtherPets(String otherPets) {
        this.otherPets = otherPets;
    }
    public String getRentOrOwn() {
        return rentOrOwn;
    }
    public void setRentOrOwn(String rentOrOwn) {
        this.rentOrOwn = rentOrOwn;
    }
    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    public boolean isAllergies() {
        return allergies;
    }
    public void setAllergies(boolean allergies) {
        this.allergies = allergies;
    }
    public String getAdoptreason() {
        return adoptreason;
    }
    public void setAdoptreason(String adoptreason) {
        this.adoptreason = adoptreason;
    }
    public boolean isHomeVisit() {
        return homeVisit;
    }
    public void setHomeVisit(boolean homeVisit) {
        this.homeVisit = homeVisit;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
    

}
