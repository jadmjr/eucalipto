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
	private String fullName;
	private String userName;
	private String phoneNumber;
	private String email;
	private String documentNumber;
	private Boolean hasAtorney;
	private Boolean hasAdvisor;
	private Boolean enableSmsEmail;
	private Boolean enableWhatsapp;

	public PersonDTO(Person person) {

		id = person.getId();
		fullName = person.getFullName();
		userName = person.getUserName();
		phoneNumber = person.getPhoneNumber();
		email = person.getEmail();
		documentNumber = person.getDocumentNumber();
		hasAtorney = person.getHasAtorney();
		hasAdvisor = person.getHasAtorney();
		enableSmsEmail = person.getEnableSmsEmail();
		enableWhatsapp = person.getEnableWhatsapp();

	}

}
