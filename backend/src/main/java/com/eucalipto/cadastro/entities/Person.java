package com.eucalipto.cadastro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
