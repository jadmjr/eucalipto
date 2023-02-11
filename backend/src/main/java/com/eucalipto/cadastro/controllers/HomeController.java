package com.eucalipto.cadastro.controllers;

import javax.swing.tree.ExpandVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.entities.JWTRequest;
import com.eucalipto.cadastro.entities.JWTResponse;
import com.eucalipto.cadastro.services.UserService;
import com.eucalipto.cadastro.utility.JWTUtility;

@RestController
//@RequestMapping(value = "home")
public class HomeController {
		
	@Autowired
	private JWTUtility jwtUtility;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService; 
	
	@GetMapping("/")
	public String home() {
		return "welcome to eucalipto";
	}

	@PostMapping("/authenticate")
	public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
							)
					);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTILS",e);
		}
		final UserDetails userDetails 
			= userService.loadUserByUsername(jwtRequest.getUsername() );
		
		final String token = jwtUtility.generateToken(userDetails);
		
		return new JWTResponse(token);
	}

}
