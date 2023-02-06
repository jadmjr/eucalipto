package com.eucalipto.cadastro.dto;

import com.eucalipto.cadastro.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private Long id;
	private String email;
	private String name;
	private String familyName;
	private String phoneNumber;

	public PersonDTO(Person person) {

		id = person.getId();
		name = person.getName();
		familyName = person.getFamilyName();
		email = person.getEmail();
		phoneNumber = person.getPhoneNumber();

	}

}
