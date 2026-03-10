package br.com.fulldevstacks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fulldevstacks.model.Person;
import br.com.fulldevstacks.exception.ResourceNotFoundException;
import br.com.fulldevstacks.repositories.PersonRepository;


@Service
public class PersonService 
{
	@Autowired
	PersonRepository repository;
	
	private final AtomicLong counter = new AtomicLong();	
	private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());
	
	public Person FindById(Long id) 
	{
		logger.info("Finding one Person!");				
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
	}
	
	public List<Person> FindAll() 
	{
		logger.info("Finding all People!");
		List<Person> persons = new ArrayList<Person>();
		
		persons = repository.findAll();	
		return persons;
	}
	
	public Person Create(Person person) 
	{
		logger.info("Creating one Person!");

		return repository.save(person);
	}
	
	public Person Update(Person person) 
	{
		logger.info("Updating one Person!");

		Person entity = MockPerson(person);
		return repository.save(entity);
	}
	
	public void Delete(Long id) 
	{
		logger.info("Deleting one Person!");
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		repository.delete(entity);
	}
	
	private Person MockPerson(Person person) 
	{
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		entity.setFirstName(person.getAddress());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
	}
}
