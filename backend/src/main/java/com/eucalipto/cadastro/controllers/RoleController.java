package com.eucalipto.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eucalipto.cadastro.dto.RoleDTO;
import com.eucalipto.cadastro.dto.UserDTO;
import com.eucalipto.cadastro.entities.Role;
import com.eucalipto.cadastro.entities.UserModel;
import com.eucalipto.cadastro.services.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	@Autowired
	private RoleService service;

	@GetMapping
	public Page<RoleDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public RoleDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<Role> create(@RequestBody Role role) {
		return service.saveRole(role);
	}

}
