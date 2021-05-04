package edu.recursion;

public class Dress {
	private String colour;
	private double price;
	private static double profit;
	
	Dress(double price, String colour){
		this.price = price;
		this.colour = colour;
	}
	
	public static void buy(Dress dress) {
		profit += dress.price;
	}
}

