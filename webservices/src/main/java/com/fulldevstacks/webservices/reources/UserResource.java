package com.fulldevstacks.webservices.reources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulldevstacks.webservices.entities.User;
import com.fulldevstacks.webservices.services.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource 
{
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> FindAll() 
	{
		List<User> users = service.FindAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> FindById(@PathVariable Long id) 
	{
		User user = service.FindById(id);
		return ResponseEntity.ok().body(user);
	}
}
