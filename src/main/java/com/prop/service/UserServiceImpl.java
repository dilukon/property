package com.prop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prop.model.AppUser;
import com.prop.model.Role;
import com.prop.repository.RoleRepo;
import com.prop.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService{
	

	private final UserRepo userrepo;
	private final RoleRepo rolerepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user= userrepo.findByUsername(username);
		
		if (user==null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
			
		}else 
		{
			log.info("User {} found in the database ", username);
				
		}
			
			
		Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRolename())));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}


	@Override
	public AppUser saveUser(AppUser user) {
		return userrepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return rolerepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppUser user = userrepo.findByUsername(username);
		Role role = rolerepo.findByRolename(rolename);
		user.getRoles().add(role);
		
	}

	@Override
	public AppUser getUser(String username) {
		return userrepo.findByUsername(username);
	}

	@Override
	public List<AppUser> getUsers() {
		return userrepo.findAll();
	}

}
