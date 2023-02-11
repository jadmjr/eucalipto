package com.eucalipto.cadastro.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eucalipto.cadastro.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		// Logic to get the user form the Database
		String username = userRepository.findByUsername(userName).getUsername();
		String password = userRepository.findByUsername(userName).getPassword();
		
		//return (UserDetails) userRepository.findByUsername(username);

		return new User(username, password, new ArrayList<>());
	}
}