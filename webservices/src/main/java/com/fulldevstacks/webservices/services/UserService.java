package com.fulldevstacks.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulldevstacks.webservices.entities.User;
import com.fulldevstacks.webservices.repositories.UserRepository;
import com.fulldevstacks.webservices.services.exceptions.ResourceNotFoundException;


@Service
public class UserService 
{
	@Autowired
	private UserRepository repository;
	
	private void updateData(User entity, User user) 
	{
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
	public List<User> FindAll() 
	{
		return repository.findAll();		
	}
	
	public User FindById(Long id) 
	{
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User Insert(User user) 
	{
		return repository.save(user);
	}
	
	public void Delete(Long id) 
	{
		repository.deleteById(id);
	}
	
	public User Update(Long id, User user) 
	{
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
	}
}
 