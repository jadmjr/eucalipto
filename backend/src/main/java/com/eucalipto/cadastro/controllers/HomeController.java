package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.entities.JwtRequest;
import com.eucalipto.cadastro.entities.JwtResponse;
import com.eucalipto.cadastro.services.UserService;
import com.eucalipto.cadastro.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Welcome to Daily Code Buffer!!";
	}

	private String token = "";

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		UserDetails user = userService.loadUserByUsername(jwtRequest.getUsername());

		if (passwordEncoder.matches(jwtRequest.getPassword(), user.getPassword()) == true) {
			try {
				authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}

			final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

			token = jwtUtility.generateToken(userDetails);

		} else {			
			throw new Exception("INVALID_CREDENTIALS");			
		}

		return new JwtResponse(token);
	}
}