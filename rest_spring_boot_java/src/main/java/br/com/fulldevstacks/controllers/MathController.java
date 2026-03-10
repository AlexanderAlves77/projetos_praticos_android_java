package br.com.fulldevstacks.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fulldevstacks.exception.UnsupportedMathOperationException;
import br.com.fulldevstacks.math.SimpleMath;
import br.com.fulldevstacks.request.converters.NumberConverter;


@RestController
@RequestMapping("/math")
public class MathController 
{
	private SimpleMath math = new SimpleMath();
	
	// http://localhost:8081/math/sum/3/5
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo")String numberTwo) 
	{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// http://localhost:8081/math/sub/3/5
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo")String numberTwo) 
	{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// http://localhost:8081/math/mul/3/5
	@RequestMapping("/mul/{numberOne}/{numberTwo}")
	public Double mul(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo")String numberTwo) 
	{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// http://localhost:8081/math/div/3/5
		@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo")String numberTwo) 
	{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.divi(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
		
	// http://localhost:8081/math/median/3/5
	@RequestMapping("/median/{numberOne}/{numberTwo}")
	public Double median(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo")String numberTwo) 
	{
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// http://localhost:8081/math/square/9
	@RequestMapping("/square/{number}")
	public Double square(@PathVariable("numberOne") String numberOne) 
	{
		if (!NumberConverter.isNumeric(numberOne)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return math.sqrt(NumberConverter.convertToDouble(numberOne));
	}
}
