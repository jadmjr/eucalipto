package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eucalipto.cadastro.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
