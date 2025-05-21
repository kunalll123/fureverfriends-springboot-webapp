package com.example.FureverFriends.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private double amount;
    private String transactionId;
    private String status;
    private String donationType; // ✅ Added Field
    private String address; // ✅ Added Field
    private String purpose; // ✅ Added Field

    @Column(nullable = false, updatable = false)
    private LocalDateTime donationDate = LocalDateTime.now();

    // ✅ Default Constructor
    public Donation() {}

    // ✅ Parameterized Constructor (For New Donations)
    public Donation(String fullName, String email, String phone, double amount, String transactionId, String status,
                    String donationType, String address, String purpose) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.transactionId = transactionId;
        this.status = status;
        this.donationType = donationType;
        this.address = address;
        this.purpose = purpose;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }
}
