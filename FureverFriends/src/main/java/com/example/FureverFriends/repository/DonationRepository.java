package com.example.FureverFriends.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FureverFriends.model.Donation;



@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    Optional<Donation> findByTransactionId(String transactionId);
}

