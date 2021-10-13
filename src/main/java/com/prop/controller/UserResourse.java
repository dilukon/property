package com.prop.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prop.model.AppUser;
import com.prop.model.Role;
import com.prop.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResourse {
	
	private final UserService userService;
	
	
	//get all users
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUser() {
		return ResponseEntity.ok().body(userService.getUsers());
				
	}
	
	//save a user
	@PostMapping("/user/save")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
				
	}
	
	//save a user
	@GetMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role ) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
				
	}
	
	//add role to user
	@GetMapping("/user/addRole")
	public ResponseEntity<?> addRole(@RequestBody AddRoleToUserForm form) {
		userService.addRoleToUser(form.getUsername(), form.getRolename());
		return ResponseEntity.ok().build();
				
	}
	

}

@Data
class AddRoleToUserForm {
	private String username;
	private String rolename;
}
 