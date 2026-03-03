package com.fulldevstacks.webservices.reources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fulldevstacks.webservices.entities.Category;
import com.fulldevstacks.webservices.services.CategoryService;


@RestController
@RequestMapping(value="/categories")
public class CategoryResource 
{
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> FindAll() 
	{
		List<Category> categories = service.FindAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> FindById(@PathVariable Long id) 
	{
		Category category = service.FindById(id);
		return ResponseEntity.ok().body(category);
	}
}
