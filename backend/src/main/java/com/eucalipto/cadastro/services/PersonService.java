package com.eucalipto.cadastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eucalipto.cadastro.dto.MovieDTO;
import com.eucalipto.cadastro.dto.PersonDTO;
import com.eucalipto.cadastro.dto.ScoreDTO;
import com.eucalipto.cadastro.entities.Movie;
import com.eucalipto.cadastro.entities.Person;
import com.eucalipto.cadastro.entities.Score;
import com.eucalipto.cadastro.entities.User;
import com.eucalipto.cadastro.repositories.MovieRepository;
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
	public PersonDTO savePerson(PersonDTO dto) {
		//Person person = repository.findByEmail(dto.getEmail());
		 
		Person person = new Person();
		person.setEmail(dto.getEmail());
		person.setDocumentNumber(dto.getDocumentNumber());
		person.setEnableSmsEmail(dto.getEnableSmsEmail());
		person.setEnableWhatsapp(dto.getEnableWhatsapp());
		person.setFullName(dto.getFullName());
		person.setHasAdvisor(dto.getHasAdvisor());
		person.setHasAtorney(dto.getHasAtorney());
		person.setPhoneNumber(dto.getPhoneNumber());
		person.setUserName(dto.getUserName());
		person = repository.save(person);

		return new PersonDTO(person);
	}
	
	@Transactional
	public PersonDTO updatePerson(PersonDTO dto) {
		
		Person person = repository.findByEmail(dto.getEmail());
		 
		person = new Person();
		person.setEmail(dto.getEmail());
		person.setDocumentNumber(dto.getDocumentNumber());
		person.setEnableSmsEmail(dto.getEnableSmsEmail());
		person.setEnableWhatsapp(dto.getEnableWhatsapp());
		person.setFullName(dto.getFullName());
		person.setHasAdvisor(dto.getHasAdvisor());
		person.setHasAtorney(dto.getHasAtorney());
		person.setPhoneNumber(dto.getPhoneNumber());
		person.setUserName(dto.getUserName());
		person = repository.save(person);

		return new PersonDTO(person);
	}

}
