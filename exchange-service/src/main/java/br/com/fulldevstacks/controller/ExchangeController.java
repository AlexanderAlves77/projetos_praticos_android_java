package br.com.fulldevstacks.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.environment.InstanceInformationService;
import br.com.fulldevstacks.model.Exchange;


@RestController
@RequestMapping("exchange-service")
public class ExchangeController 
{
	@Autowired
	InstanceInformationService informationService;
	
	// http://localhost:8000/exchange-service/5/USD/BRL
	@GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchange(@PathVariable("amount") BigDecimal amount, 
			@PathVariable("from") String from, @PathVariable("to") String to) 
	{
		return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, 
				"PORT " + informationService.retrieveServerPort());
	}
}
