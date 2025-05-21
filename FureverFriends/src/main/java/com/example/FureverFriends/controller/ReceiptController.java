package com.example.FureverFriends.controller;

import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FureverFriends.model.Donation;
import com.example.FureverFriends.repository.DonationRepository;
import com.example.FureverFriends.service.ReceiptService;

@RestController
@RequestMapping("/api/receipt") 
 // ✅ Ensure the base path is correct
public class ReceiptController {

    private final DonationRepository donationRepository;
    private final ReceiptService receiptService;

    public ReceiptController(DonationRepository donationRepository, ReceiptService receiptService) {
        this.donationRepository = donationRepository;
        this.receiptService = receiptService;
    }

    // ✅ Debugging Added: Confirm transaction ID is received
    @GetMapping("/download/{transactionId}")
    public ResponseEntity<byte[]> downloadReceipt(@PathVariable String transactionId) {
        System.out.println("🔍 Debug: Received request to download receipt for Transaction ID: " + transactionId);

        Optional<Donation> donationOpt = donationRepository.findByTransactionId(transactionId);

        if (donationOpt.isPresent()) {
            Donation donation = donationOpt.get();
            System.out.println("✅ Found donation record for Transaction ID: " + transactionId);

            byte[] pdfBytes = receiptService.generateReceipt(donation);
            if (pdfBytes == null || pdfBytes.length == 0) {
                System.out.println("❌ ERROR: Receipt generation failed!");
                return ResponseEntity.internalServerError().build();
            }

            System.out.println("✅ Receipt successfully generated. Sending response.");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Donation_Receipt.pdf")
                    .body(pdfBytes);
        } else {
            System.out.println("❌ ERROR: No donation record found for Transaction ID: " + transactionId);
            return ResponseEntity.notFound().build();
        }
    }
}
