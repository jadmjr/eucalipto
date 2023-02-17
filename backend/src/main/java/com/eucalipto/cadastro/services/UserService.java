package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.UserDTO;
import com.eucalipto.cadastro.entities.UserModel;
import com.eucalipto.cadastro.repositories.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<UserModel> result = repository.findAll(pageable);
		Page<UserDTO> page = result.map(x -> new UserDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		UserModel result = repository.findById(id).get();
		UserDTO dto = new UserDTO(result);
		return dto;
	}

	@Transactional
	public ResponseEntity<UserModel> saveUser(UserModel user) {
		repository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	
}