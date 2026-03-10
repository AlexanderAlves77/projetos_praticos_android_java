package br.com.fulldevstacks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.model.Person;
import br.com.fulldevstacks.services.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController 
{
	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person FindById(@PathVariable("id") Long id) 
	{
		return service.FindById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> FindAll() 
	{
		return service.FindAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Create(@RequestBody Person person) 
	{
		return service.Create(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Update(@RequestBody Person person) 
	{
		return service.Update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> Delete(@PathVariable("id") Long id) 
	{
		service.Delete(id);
		return ResponseEntity.noContent().build();
	}
}
