package com.example.FureverFriends.service;

import com.example.FureverFriends.model.Donation;
import com.example.FureverFriends.repository.DonationRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    private final DonationRepository donationRepository;
    private final EmailService emailService;
    private final ReceiptService receiptService;

    public PaymentService(DonationRepository donationRepository, EmailService emailService, ReceiptService receiptService) {
        this.donationRepository = donationRepository;
        this.emailService = emailService;
        this.receiptService = receiptService;
    }

    // ✅ Create Razorpay Order and Save Initial Donation Record
    public String createOrder(String fullName, String email, String phone, double amount, 
                              String donationType, String address, String purpose) throws Exception {
        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int) (amount * 100)); // Convert to paise (₹1 = 100 paise)
        orderRequest.put("currency", "INR");
        orderRequest.put("payment_capture", 1);

        Order order = razorpay.orders.create(orderRequest);

        // ✅ Save donation record with all details
        Donation donation = new Donation(fullName, email, phone, amount, order.get("id"), "PENDING", 
                                         donationType, address, purpose);
        donationRepository.save(donation);

        return order.toString();
    }

    // ✅ Update Donation Status After Payment and Generate Receipt
    public void updateDonationStatus(String transactionId, String status) {
        Optional<Donation> donationOpt = donationRepository.findByTransactionId(transactionId);
        if (donationOpt.isPresent()) {
            Donation donation = donationOpt.get();
            donation.setStatus(status);
            donationRepository.save(donation);

            // ✅ Send Email Confirmation After Successful Payment
            if ("SUCCESS".equals(status)) {
                emailService.sendDonationReceipt(donation.getEmail(), donation.getFullName(), donation.getAmount(), transactionId);

                // ✅ Generate Receipt PDF
                byte[] pdfReceipt = receiptService.generateReceipt(donation);
                if (pdfReceipt != null) {
                    System.out.println("Receipt generated successfully for Transaction ID: " + transactionId);
                } else {
                    System.out.println("Failed to generate receipt for Transaction ID: " + transactionId);
                }
            }
        }
    }
}
