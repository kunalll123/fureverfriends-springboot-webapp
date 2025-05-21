package com.example.FureverFriends.service;

import com.example.FureverFriends.model.Donation;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ReceiptService {

    public byte[] generateReceipt(Donation donation) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Donation Receipt"));
            document.add(new Paragraph("Furever Friends - Thank You for Your Donation!"));
            document.add(new Paragraph("--------------------------------------------------"));
            document.add(new Paragraph("Donor Name: " + donation.getFullName()));
            document.add(new Paragraph("Email: " + donation.getEmail()));
            document.add(new Paragraph("Phone: " + donation.getPhone()));
            document.add(new Paragraph("Amount: ₹" + donation.getAmount()));
            document.add(new Paragraph("Transaction ID: " + donation.getTransactionId()));
            document.add(new Paragraph("Donation Type: " + donation.getDonationType()));
            document.add(new Paragraph("Address: " + donation.getAddress()));
            document.add(new Paragraph("Purpose: " + donation.getPurpose()));
            document.add(new Paragraph("Donation Date: " + donation.getDonationDate()));
            document.add(new Paragraph("--------------------------------------------------"));
            document.add(new Paragraph("Thank you for supporting animal welfare!"));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
