package com.eucalipto.cadastro.dto;

import com.eucalipto.cadastro.entities.UserModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long id;
	private String username;
	private String password;
	//private String roles;

	public UserDTO(UserModel user) {

		id = user.getId();
		username = user.getUsername();
		password = user.getPassword();
		//roles = user.getRoles();

	}

}
