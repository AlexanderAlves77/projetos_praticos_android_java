package com.fulldevstacks.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulldevstacks.webservices.entities.User;
import com.fulldevstacks.webservices.repositories.UserRepository;


@Service
public class UserService 
{
	@Autowired
	private UserRepository repository;
	
	public List<User> FindAll() 
	{
		return repository.findAll();		
	}
	
	public User FindById(Long id) 
	{
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User Insert(User user) 
	{
		return repository.save(user);
	}
}
 