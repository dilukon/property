package com.prop.service;

import java.util.List;

import com.prop.model.Role;
import com.prop.model.AppUser;

public interface UserService{
	
	AppUser saveUser (AppUser user);
	Role saveRole (Role role);
	void addRoleToUser(String username, String rolename);
	AppUser getUser(String username);
	List<AppUser> getUsers();
	

}
