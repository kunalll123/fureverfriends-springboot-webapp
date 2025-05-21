package com.example.FureverFriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // ✅ Method to send email receipt after successful donation
    public void sendDonationReceipt(String toEmail, String name, double amount, String transactionId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Thank You for Your Donation - Furever Friends");
        message.setText("Dear " + name + ",\n\nThank you for your generous donation of ₹" + amount +
                ".\nTransaction ID: " + transactionId + "\n\nYour support helps us provide care for animals in need!\n\nBest Regards,\nFurever Friends Team");

        mailSender.send(message);
    }
}
