package com.fulldevstacks.webservices.reources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulldevstacks.webservices.entities.Product;
import com.fulldevstacks.webservices.services.ProductService;


@RestController
@RequestMapping(value="/products")
public class ProductResource 
{
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> FindAll() 
	{
		List<Product> products = service.FindAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> FindById(@PathVariable Long id) 
	{
		Product product = service.FindById(id);
		return ResponseEntity.ok().body(product);
	}
}
