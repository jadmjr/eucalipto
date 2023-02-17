package com.eucalipto.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eucalipto.cadastro.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	//Optional<Role> findByRoleName(String rolename);
}
