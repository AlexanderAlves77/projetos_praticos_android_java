package com.fulldevstacks.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulldevstacks.webservices.entities.Order;
import com.fulldevstacks.webservices.repositories.OrderRepository;


@Service
public class OrderService 
{
	@Autowired
	private OrderRepository repository;
	
	public List<Order> FindAll() 
	{
		return repository.findAll();		
	}
	
	public Order FindById(Long id) 
	{
		Optional<Order> order = repository.findById(id);
		return order.get();
	}
}
