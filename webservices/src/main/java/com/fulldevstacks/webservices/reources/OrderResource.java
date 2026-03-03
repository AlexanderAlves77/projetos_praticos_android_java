package com.fulldevstacks.webservices.reources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulldevstacks.webservices.entities.Order;
import com.fulldevstacks.webservices.services.OrderService;


@RestController
@RequestMapping(value="/orders")
public class OrderResource 
{
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> FindAll() 
	{
		List<Order> users = service.FindAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> FindById(@PathVariable Long id) 
	{
		Order user = service.FindById(id);
		return ResponseEntity.ok().body(user);
	}
}
