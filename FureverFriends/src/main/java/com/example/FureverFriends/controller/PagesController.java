package com.example.FureverFriends.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import com.example.FureverFriends.model.Users;
import com.example.FureverFriends.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;




@Controller
@RequestMapping("/page")
public class PagesController {
    @Autowired
    private UserRepository userRepository;
    // /PAGES
    @GetMapping("/index")
    public String showDashboard() {
        return "index"; 
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // about.html in templates folder
    }

    @GetMapping("/service")
    public String service() {
        return "service"; // service.html in templates folder
    }

    @GetMapping("/donation")
    public String donation() {
        return "donation"; // donation.html in templates folder
    }

    
    @GetMapping("/donationform")
    public String donationform() {
        return "donationform"; // donationform.html in templates folder
    }

    @GetMapping("/adoption")
    public String adoption() {
        return "adoption"; //adoption.html in templates folder
    }

    @GetMapping("/adoptionform")
    public String adoptionform() {
        return "adoptionform"; //adoptionform.html in templates folder
    }

    @GetMapping("/birdadoption")
    public String birdadoption() {
        return "birdadoption"; //birdadoption.html in templates folder
    }

    @GetMapping("/catadoption")
    public String catadoption() {
        return "catadoption"; //catadoption.html in templates folder
    }


    
    @GetMapping("/dogadoption")
    public String dogadoption() {
        return "dogadoption"; //dogadoption.html in templates folder
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact"; //contact.html in templates folder
    }

     
    @GetMapping("/petgrooming")
    public String petgrooming() {
        return "petgrooming"; //petgrooming.html in templates folder
    }

       
    @GetMapping("/pettraining")
    public String pettraining() {
        return "pettraining"; //pettraining.html in templates folder
    }

    @GetMapping("/pettreatment")
    public String pettreatment() {
        return "pettreatment"; //pettreatment.html in templates folder
    }


    @GetMapping("/profile")
public String showProfile(Model model, Principal principal) {
    if (principal != null) {
        String username = principal.getName(); // Get logged-in user's name
        // Users user = userService.findOne(username); // Fetch user from DB
        Users user = userRepository.findByUsername(username);
        
        System.out.println("\n\n\n\n\t\tLogged-in User : " + username);
        System.out.println("\n\n\n\n\t\tLogged-in User mail : " + user.getEmail());
        if (user != null) {
            model.addAttribute("user", user);
        }
    }
    return "profile"; // Thymeleaf template name (profile.html)
}


    @GetMapping("/rescue")
    public String rescue() {
        return "rescue"; //rescue.html in templates folder
    }

    
    @GetMapping("/single")
    public String single() {
        return "single"; //single.html in templates folder
    }


    @GetMapping("/prioraction")
    public String prioraction() {
        return "prioraction"; //single.html in templates folder
    }

    @GetMapping("/cdetails1")
    public String cdetails1() {
        return "cdetails1"; //single.html in templates folder
    }
    @GetMapping("/cdetails2")
    public String cdetails2() {
        return "cdetails2"; //single.html in templates folder
    }
    @GetMapping("/cdetails3")
    public String cdetails3() {
        return "cdetails3"; //single.html in templates folder
    }
    @GetMapping("/cdetails4")
    public String cdetails4() {
        return "cdetails4"; //single.html in templates folder
    }
    @GetMapping("/cdetails5")
    public String cdetails5() {
        return "cdetails5"; //single.html in templates folder
    }
    @GetMapping("/cdetails6")
    public String cdetails6() {
        return "cdetails6"; //single.html in templates folder
    }
    @GetMapping("/cdetails7")
    public String cdetails7() {
        return "cdetails7"; //single.html in templates folder
    }
    @GetMapping("/cdetails8")
    public String cdetails8() {
        return "cdetails8"; //single.html in templates folder
    }

    //birdsdetails 
    @GetMapping("/bdetails1")
    public String bdetails1() {
        return "bdetails1"; //single.html in templates folder
    }
    @GetMapping("/bdetails2")
    public String bdetails2() {
        return "bdetails2"; //single.html in templates folder
    }
    @GetMapping("/bdetails3")
    public String bdetails3() {
        return "bdetails3"; //single.html in templates folder
    }
    @GetMapping("/bdetails4")
    public String bdetails4() {
        return "bdetails4"; //single.html in templates folder
    }
    @GetMapping("/bdetails5")
    public String bdetails5() {
        return "bdetails5"; //single.html in templates folder
    }
    @GetMapping("/bdetails6")
    public String bdetails6() {
        return "bdetails6"; //single.html in templates folder
    }
    @GetMapping("/bdetails7")
    public String bdetails7() {
        return "bdetails7"; //single.html in templates folder
    }
    @GetMapping("/bdetails8")
    public String bdetails8() {
        return "bdetails8"; //single.html in templates folder
    }

    //dogadoption
    @GetMapping("/details1")
    public String details1() {
        return "details1"; //single.html in templates folder
    }
    @GetMapping("/details2")
    public String details2() {
        return "details2"; //single.html in templates folder
    }
    @GetMapping("/details3")
    public String details3() {
        return "details3"; //single.html in templates folder
    }
    @GetMapping("/details4")
    public String details4() {
        return "details4"; //single.html in templates folder
    }
    @GetMapping("/details5")
    public String details5() {
        return "details5"; //single.html in templates folder
    }
    @GetMapping("/details6")
    public String details6() {
        return "details6"; //single.html in templates folder
    }
    @GetMapping("/details7")
    public String details7() {
        return "details7"; //single.html in templates folder
    }
    @GetMapping("/details8")
    public String details8() {
        return "details8"; //single.html in templates folder
    }

}
