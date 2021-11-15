package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.AuthReq;
import com.jwt.entity.User;
import com.jwt.repository.UserRepository;
import com.jwt.service.CustomUserDetailsService;
import com.jwt.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String welcomeController() {
		
		return "jason-web-token";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userRepository.findAll();
		
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody User user) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
				);
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(user.getUsername());
		return jwtUtil.generateToken(userDetails);
		}
		catch(Exception ex){
			throw new Exception("invalid credentials");
		}
		
		
	}
	
	@PostMapping("/register")
	public User createUser(@RequestBody User user) {	
		User updatedUser = new User();
		updatedUser.setId(user.getId());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(updatedUser);
		
	}

}
