package com.example.FureverFriends.controller;

import com.example.FureverFriends.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*") // Allows requests from frontend
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // ✅ Create a new order with complete donation details
    @PostMapping("/create-order")
    public String createOrder(@RequestBody Map<String, Object> requestData) {
        try {
            String fullName = (String) requestData.get("fullName");
            String email = (String) requestData.get("email");
            String phone = (String) requestData.get("phone");
            double amount = Double.parseDouble(requestData.get("amount").toString());
            String donationType = (String) requestData.get("donationType");
            String address = (String) requestData.get("address");
            String purpose = (String) requestData.get("purpose");

            return paymentService.createOrder(fullName, email, phone, amount, donationType, address, purpose);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // ✅ Update donation status after payment
    @PostMapping("/update-status")
    public String updatePaymentStatus(@RequestBody Map<String, String> requestData) {
        try {
            String transactionId = requestData.get("transactionId");
            String status = requestData.get("status");

            paymentService.updateDonationStatus(transactionId, status);
            return "Payment status updated successfully!";
        } catch (Exception e) {
            return "Error updating payment status: " + e.getMessage();
        }
    }
}
