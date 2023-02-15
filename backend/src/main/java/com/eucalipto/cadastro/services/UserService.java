package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eucalipto.cadastro.repositories.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository userRepository;

	
}