package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.RoleDTO;
import com.eucalipto.cadastro.entities.Role;
import com.eucalipto.cadastro.repositories.RoleRepository;

@Service
public class RoleService  {

	@Autowired
	RoleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RoleDTO> findAll(Pageable pageable) {
		Page<Role> result = repository.findAll(pageable);
		Page<RoleDTO> page = result.map(x -> new RoleDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public RoleDTO findById(Long id) {
		Role result = repository.findById(id).get();
		RoleDTO dto = new RoleDTO(result);
		return dto;
	}

	@Transactional
	public ResponseEntity<Role> saveRole(Role role) {
		repository.save(role);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}

	
}