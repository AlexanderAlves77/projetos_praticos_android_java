package com.fulldevstacks.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulldevstacks.webservices.entities.Product;
import com.fulldevstacks.webservices.repositories.ProductRepository;


@Service
public class ProductService 
{
	@Autowired
	private ProductRepository repository;
	
	public List<Product> FindAll() 
	{
		return repository.findAll();		
	}
	
	public Product FindById(Long id) 
	{
		Optional<Product> product = repository.findById(id);
		return product.get();
	}
}
