package com.eucalipto.cadastro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.UserDTO;
import com.eucalipto.cadastro.entities.Role;
import com.eucalipto.cadastro.entities.UserModel;
import com.eucalipto.cadastro.enums.Rolename;
import com.eucalipto.cadastro.repositories.RoleRepository;
import com.eucalipto.cadastro.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	RoleRepository roleRepository;

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

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		Role role = roleRepository.findByrolename(Rolename.ROLE_USER);

		List<Role> roles = new ArrayList<>();
		roles.add(role);

		user.setPassword(bcrypt.encode(user.getPassword()));
		user.setRoles(roles);

		repository.save(user);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}