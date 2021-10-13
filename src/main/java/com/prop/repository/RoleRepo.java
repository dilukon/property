package com.prop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prop.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByRolename(String rolename);

}
