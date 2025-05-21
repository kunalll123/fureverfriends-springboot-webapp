package com.example.FureverFriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.FureverFriends.dto.LoginDto;
import com.example.FureverFriends.dto.LoginResponseDto;
import com.example.FureverFriends.model.Adoption;
import com.example.FureverFriends.model.Users;
import com.example.FureverFriends.repository.AdoptionRepository;
import com.example.FureverFriends.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

	@Autowired
	private AdoptionRepository adoptionRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    public boolean authenticate(String email, String password) {
        Users user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

	public Users findOne(String email) {
        return userRepository.findByEmail(email);
    }

    public LoginResponseDto verify(LoginDto login) {
		try {
		    Authentication authentication = authManager
		        .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		    if (authentication.isAuthenticated()) {
		      

		        Users user = userRepository.findByUsername(login.getUsername());
		        if (user == null) {
		            throw new UsernameNotFoundException("User not found with username: " + login.getUsername());
		        }

		        String token = jwtService.generateToken(login.getUsername());
		        user.setToken(token);
		        userRepository.save(user);
		        
		        LoginResponseDto dto = new LoginResponseDto();
		        dto.setToken(token);
		        dto.setId(user.getId());

		        return dto;
		    }
		} catch (AuthenticationException e) {
		    throw new BadCredentialsException("Invalid username or password");
		}
	
		return null;


	}

    public Adoption addAdoption(Adoption adoption) {
        Adoption adoption1=new Adoption();

		adoption1.setAdoptreason(adoption.getAdoptreason());
		adoption1.setAllergies(adoption.isAllergies());
		adoption1.setContact(adoption.getContact());
		adoption1.setHomeVisit(adoption.isHomeVisit());
		adoption1.setJob(adoption.getJob());
		adoption1.setMembers(adoption.getMembers());
		adoption1.setOtherPets(adoption.getOtherPets());
		adoption1.setOwnedPets(adoption.isOwnedPets());
		adoption1.setPetType(adoption.getPetType());
		adoption1.setRentOrOwn(adoption.getRentOrOwn());
		adoption1.setStatus("PENDING");

		adoptionRepository.save(adoption1);
		return adoption1;
    }
}
