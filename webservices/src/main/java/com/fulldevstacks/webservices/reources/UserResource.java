package com.fulldevstacks.webservices.reources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulldevstacks.webservices.entities.User;


@RestController
@RequestMapping(value="/users")
public class UserResource 
{
	@GetMapping
	public ResponseEntity<User> FindAll() 
	{
		User user = new User(1L, "Rita", "rita@gmail.com", "99999999999", "12345");
		return ResponseEntity.ok().body(user);
	}
}
