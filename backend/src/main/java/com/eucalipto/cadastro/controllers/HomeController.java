package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.services.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Bem vindo ao Eucalipto";
	}



}