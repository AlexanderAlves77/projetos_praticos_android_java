package br.com.fulldevstacks.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.model.Greeting;


@RestController
public class GreetingController 
{
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello, %s!";
		
	// http://localhost:8081/greeting?name=Alexander
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) 
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
