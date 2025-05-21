package com.example.FureverFriends.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.FureverFriends.model.Users;
import com.example.FureverFriends.repository.UserRepository;


@Service
@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userR;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user =userR.findByUsername(username);
		
        System.out.println("I am in the custome userservice");
			
		if(user!=null) {
			return User.builder()
					.username(user.getUsername())
					.password(user.getPassword())
					.build();
		}
		throw new UsernameNotFoundException("User not found");
	}
	
}
