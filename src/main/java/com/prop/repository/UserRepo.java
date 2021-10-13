package com.prop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prop.model.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
	
	AppUser findByUsername(String username);
	

}
