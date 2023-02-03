package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.dto.PersonDTO;
import com.eucalipto.cadastro.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	private PersonService service;

	@GetMapping
	public Page<PersonDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public PersonDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping
	public PersonDTO saveScore(@RequestBody PersonDTO dto) {
		PersonDTO personDTO = service.savePerson(dto);
		return personDTO;
	}

}
