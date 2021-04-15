package edu.collections;

import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Capitals {
	public static void main(String[] args){
		Map<String,String> countriesAndCapitals = new HashMap<String,String>(){{
			put("Bulgaria","Sofia");
			put("France","Paris");
			put("Spain","Madrid");
			put("China","Beijing");
			put("Belgium","Brussels");
			put("India","New Delhi");
			put("New Zealand","Wellington");
			put("Argentina","Buenos Aires");
			put("Switzerland","Bern");
			put("Germany","Berlin");	
		}};
		
		System.out.println("Hello there:)\nWe are going to play a fun game of guessing the capitals of different countries. Are you ready?");
		int score = 0;
		Scanner sc = new Scanner(System.in);
		
		List<String> countries = new ArrayList<String>(countriesAndCapitals.keySet());
		Collections.shuffle(countries);
		for (String country : countries) {
			System.out.println("What is the capital of " + country + "?");
			String capital = sc.nextLine();
			if (capital.equals(countriesAndCapitals.get(country))) {
				score++;
			}
		}
		System.out.println("You made it! Your score is " + score +" :)");
	}
}
