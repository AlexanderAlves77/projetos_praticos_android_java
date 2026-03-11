package br.com.fulldevstacks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.dto.Exchange;
import br.com.fulldevstacks.environment.InstanceInformationService;
import br.com.fulldevstacks.model.Book;
import br.com.fulldevstacks.proxy.ExchangeProxy;
import br.com.fulldevstacks.repository.BookRepository;

@RestController 
@RequestMapping("book-service")
public class BookController 
{
	@Autowired 
	private InstanceInformationService informationService;
	
	@Autowired 
	private BookRepository repository;
	
	@Autowired
    private ExchangeProxy proxy;
	
	// http://localhost:8100/book-service/1/BRL
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency)
	{
		String port = informationService.retrieveServerPort();		
		Book book = repository.findById(id).orElseThrow();				
		Exchange exchange = proxy.getExchange(book.getPrice(), "USD", currency);
		
		book.setEnvironment(port + " FEIGN");
		book.setPrice(exchange.getConvertedValue());
		book.setCurrency(currency);		
		return book;
	}
		
	
	/*
	 // http://localhost:8100/book-service/1/BRL
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency)
	{
		String port = informationService.retrieveServerPort();		
		Book book = repository.findById(id).orElseThrow();
		
		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		
		Exchange exchange = proxy.getExchange(book.getPrice(), "USD", currency);
		
		book.setEnvironment(port + " FEIGN");
		book.setPrice(exchange.getConvertedValue());
		book.setCurrency(currency);		
		return book;
	}
	
	// http://localhost:8100/book-service/1/BRL
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency)
	{
		String port = informationService.retrieveServerPort();
			
		Book book = repository.findById(id).orElseThrow();
		book.setEnvironment(port);
		book.setCurrency(currency);		
		return book;
	}
		
	// http://localhost:8100/book-service/1/BRL
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency)
	{
		String port = informationService.retrieveServerPort();
		
		return new Book(1L, "Nigel Poulton", "Docker Deep Dive",
			new Date(), 15.8, "BRL", port);
	}
	 */
}
