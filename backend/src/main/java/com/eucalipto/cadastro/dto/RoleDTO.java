package com.eucalipto.cadastro.dto;

import com.eucalipto.cadastro.entities.Role;
import com.eucalipto.cadastro.enums.Rolename;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

	private Long id;
	private Rolename rolename;

	public RoleDTO(Role role) {

		id = role.getId();
		rolename = role.getRolename();

	}

}
