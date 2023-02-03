package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eucalipto.cadastro.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	Person findByEmail(String email);
}
