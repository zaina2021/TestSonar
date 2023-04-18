package com.openclassroom.testing.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}


	public void longCalculation() {

		try {
			//Attendre 2 secondes
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public Set<Integer> digitsSet(int number) {
		Set<Integer> integers = new HashSet<Integer>();
		String numberString = String.valueOf(number);
		for(int i =0; i < numberString.length(); i++ ) {
			if(numberString.charAt(i)!='-') {
				integers.add(Integer.parseInt(numberString, i, i + 1, 10));
				
			}
			
			
		}
		
		return  integers;
	}

	public Double celsiusToFahrenheit(double d) {
		// TODO Auto-generated method stub
		return (1.8 * d + 32.0);
	}

	public Double litresToGallons(double d) {
		// TODO Auto-generated method stub
		return (double)Math.round(d * 0.264172 * 1000d) / 1000d ;
		
	}

	public Double radiusToAreaOfCircle(double d) {
		// TODO Auto-generated method stub
		 return Math.PI * d * Math.pow(d, 2);
	}

	public Double fahrenheitToCelsius(double d) {
		// TODO Auto-generated method stub
	
		  return (d - 32) * 5 / 9;
	}

}
