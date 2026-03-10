package br.com.fulldevstacks.math;


public class SimpleMath 
{	
	// http://localhost:8081/math/sum/3/5
	public Double sum(Double numberOne, Double numberTwo) 
	{		
		return numberOne + numberTwo;
	}
	
	public Double sub(Double numberOne, Double numberTwo) 
	{		
		return numberOne - numberTwo;
	}
	
	public Double mult(Double numberOne, Double numberTwo) 
	{		
		return numberOne * numberTwo;
	}
	
	public Double divi(Double numberOne, Double numberTwo) 
	{		
		return numberOne / numberTwo;
	}
	
	public Double mean(Double numberOne, Double numberTwo) 
	{		
		return (numberOne + numberTwo) / 2;
	}
	
	public Double sqrt(Double numberOne) 
	{		
		return Math.sqrt(numberOne);
	}
}
