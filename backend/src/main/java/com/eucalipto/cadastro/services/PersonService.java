package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.PersonDTO;
import com.eucalipto.cadastro.entities.Person;
import com.eucalipto.cadastro.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Transactional(readOnly = true)
	public Page<PersonDTO> findAll(Pageable pageable) {
		Page<Person> result = repository.findAll(pageable);
		Page<PersonDTO> page = result.map(x -> new PersonDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Person result = repository.findById(id).get();
		PersonDTO dto = new PersonDTO(result);
		return dto;
	}

	@Transactional
	public ResponseEntity<Person> savePerson(Person person) {
		repository.save(person);
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}

	@Transactional
	public PersonDTO updatePerson(PersonDTO dto) {

		Person person = repository.findByEmail(dto.getEmail());

		person = new Person();
		person.setEmail(dto.getEmail());
		person.setName(dto.getName());
		person.setPhoneNumber(dto.getPhoneNumber());
		person = repository.save(person);

		return new PersonDTO(person);
	}

}
