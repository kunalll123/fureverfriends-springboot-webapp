package com.example.FureverFriends.controller;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FureverFriends.repository.AdoptionRepository;
import com.example.FureverFriends.repository.DonationRepository;
import com.example.FureverFriends.service.DashboardService;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private AdoptionRepository adoptionRequestRepository;

    

    @PostMapping("/admin")
    public String toAdminPage(
        @RequestParam String username,
        @RequestParam String password,
        Model model) {
    
    // Simple hardcoded admin credentials (in production, use database and proper security)
    if ("admin".equals(username) && "admin".equals(password)) {
        return "redirect:/dashboard"; // Redirect to admin dashboard
    } else {
        model.addAttribute("error", "Invalid admin credentials");
        return "redirect:/auth/admin/login?error";
    }

    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("contactCount", dashboardService.getCount("contact_message"));
        model.addAttribute("bookingCount", dashboardService.getCount("booking"));
        model.addAttribute("adoptionCount", dashboardService.getCount("adoption"));
        model.addAttribute("donationCount", dashboardService.getCount("donations"));
        model.addAttribute("groomingBookingCount", dashboardService.getCount("grooming_booking"));
        model.addAttribute("petAdoptionCount", dashboardService.getCount("adoption"));
        model.addAttribute("petGroomingCount", dashboardService.getCount("grooming_booking"));
        model.addAttribute("roleCount", dashboardService.getCount("roles"));
        model.addAttribute("treatmentCount", dashboardService.getCount("treatment"));
        model.addAttribute("userCount", dashboardService.getCount("users"));

        // List<Donation> donations = donationRepository.findAll();
        // List<Adoption> adoptionRequests = adoptionRequestRepository.findAll();

        //model.addAttribute("donations", donations);
        // ❌ Problem: Empty list is being passed
      
         //model.addAttribute("adoptionRequests", adoptionRequests);


        model.addAttribute("donations", Collections.emptyList());
        model.addAttribute("adoptionRequests", Collections.emptyList());



        return "dashboard"; // dashboard.html in templates
    }

    @PostMapping("/dashboard/adoption/approve/{id}")
    public String approveAdoption(@PathVariable Integer id) {
        adoptionRequestRepository.findById(id).ifPresent(req -> {
            req.setStatus("Approved");
            adoptionRequestRepository.save(req);
        });
        return "redirect:/dashboard";
    }

    @PostMapping("/dashboard/adoption/reject/{id}")
    public String rejectAdoption(@PathVariable Integer id) {
        adoptionRequestRepository.findById(id).ifPresent(req -> {
            req.setStatus("Rejected");
            adoptionRequestRepository.save(req);
        });
        return "redirect:/dashboard";
    }
}        
