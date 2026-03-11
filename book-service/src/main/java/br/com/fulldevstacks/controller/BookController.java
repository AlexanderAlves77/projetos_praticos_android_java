package br.com.fulldevstacks.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.environment.InstanceInformationService;
import br.com.fulldevstacks.model.Book;

@RestController 
@RequestMapping("book-service")
public class BookController 
{
	@Autowired 
	private InstanceInformationService informationService;
	
	// http://localhost:8100/book-service/1/BRL
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency)
	{
		String port = informationService.retrieveServerPort();
		
		return new Book(1L, "Nigel Poulton", "Docker Deep Dive",
			new Date(), 15.8, "BRL", port);
	}

}
