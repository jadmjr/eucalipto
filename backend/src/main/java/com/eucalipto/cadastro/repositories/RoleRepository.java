package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eucalipto.cadastro.entities.Role;
import com.eucalipto.cadastro.enums.Rolename;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByrolename(Rolename rolename);
}
