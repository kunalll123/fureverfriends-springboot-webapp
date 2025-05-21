package com.example.FureverFriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FureverFriends.dto.LoginDto;
import com.example.FureverFriends.model.Role;
import com.example.FureverFriends.model.Users;
import com.example.FureverFriends.repository.RoleRepository;
import com.example.FureverFriends.repository.UserRepository;
import com.example.FureverFriends.service.UserService;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String toLoginPage() {
        return "redirect:/auth/login"; 
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "/login"; // Must have login.html in templates
    }
    @GetMapping("/admin")
    public String showAdminLoginPage(){
        return "admin"; // Must have admin.html in templates
    }


    // @PostMapping("/logon")
    // public String processLogin(@RequestParam String email, 
    //                            @RequestParam String password, 
    //                            Model model) {
    //     Users user = userRepository.findByEmail(email);

    //     if (user != null && user.getPassword().equals(password)) {
    //         return "redirect:/page/index";  
    //     } else {
    //         model.addAttribute("error", "Invalid email or password");
    //         return "login";  
    //     }
    // }

    @PostMapping("/register")
    public String processRegistration(@RequestParam String password, 
                                      @RequestParam String email, 
                                      @RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String username,
                                      Model model) {

        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("error", "Username already taken");
            return "/auth/register";  
        }

        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already registered");
            return "/auth/register";
        }

        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password)); 
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        
        Role userRole=roleRepository.findByRole("USER");
        if(userRole==null)
        {
        	userRole=new Role("USER");
        	roleRepository.save(userRole);
        }
        newUser.setRole(userRole);

        userRepository.save(newUser);

        return "redirect:/auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto login,Model model)
    {   
        service.verify(login);
        return "redirect:/page/index";
    }



    



    //  // /PAGES
    //  @GetMapping("/index")
    //  public String showDashboard() {
    //      return "index"; 
    //  }
 
    //  @GetMapping("/about")
    //  public String about() {
    //      return "about"; // about.html in templates folder
    //  }
 
    //  @GetMapping("/service")
    //  public String service() {
    //      return "service"; // service.html in templates folder
    //  }
 
    //  @GetMapping("/donation")
    //  public String donation() {
    //      return "donation"; // donation.html in templates folder
    //  }
 
     
    //  @GetMapping("/donationform")
    //  public String donationform() {
    //      return "donationform"; // donationform.html in templates folder
    //  }
 
    //  @GetMapping("/adoption")
    //  public String adoption() {
    //      return "adoption"; //adoption.html in templates folder
    //  }
 
    //  @GetMapping("/adoptionform")
    //  public String adoptionform() {
    //      return "adoptionform"; //adoptionform.html in templates folder
    //  }
 
    //  @GetMapping("/birdadoption")
    //  public String birdadoption() {
    //      return "birdadoption"; //birdadoption.html in templates folder
    //  }
 
    //  @GetMapping("/catadoption")
    //  public String catadoption() {
    //      return "catadoption"; //catadoption.html in templates folder
    //  }
 
 
     
    //  @GetMapping("/dogadoption")
    //  public String dogadoption() {
    //      return "dogadoption"; //dogadoption.html in templates folder
    //  }
     
    //  @GetMapping("/contact")
    //  public String contact() {
    //      return "contact"; //contact.html in templates folder
    //  }
 
      
    //  @GetMapping("/petgrooming")
    //  public String petgrooming() {
    //      return "petgrooming"; //petgrooming.html in templates folder
    //  }
 
        
    //  @GetMapping("/pettraining")
    //  public String pettraining() {
    //      return "pettraining"; //pettraining.html in templates folder
    //  }
 
    //  @GetMapping("/pettreatment")
    //  public String pettreatment() {
    //      return "pettreatment"; //pettreatment.html in templates folder
    //  }
 
    // @Autowired
    // private UserService userService;

    // @GetMapping("/profile")
    // public String showProfilePage(Model model, Principal principal) {

        
    //     // Get the currently logged-in user's email
    //     String email = principal.getName();

    //     // Fetch user details from DB
    //     Users user = userService.findOne(email);

    //     System.out.println("Logged-in User Email: " + email);


    //     // Add user details to the model
    //     model.addAttribute("user", user);

    //     return "profile"; // This will render profile.html
    // }
 
    //  @GetMapping("/rescue")
    //  public String rescue() {
    //      return "rescue"; //rescue.html in templates folder
    //  }
 
     
    //  @GetMapping("/single")
    //  public String single() {
    //      return "single"; //single.html in templates folder
    //  }
 
 
    //  @GetMapping("/prioraction")
    //  public String prioraction() {
    //      return "prioraction"; //single.html in templates folder
    //  }
 
    //  @GetMapping("/details")
    //  public String details() {
    //      return "details"; //single.html in templates folder
    //  }
     






    

}
