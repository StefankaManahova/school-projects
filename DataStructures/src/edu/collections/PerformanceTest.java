package edu.collections;

import java.util.LinkedList;

public class PerformanceTest {

	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<>();
		for(int i=0; i< 5_000_000; i++) {
			numbers.add(i);
		}
		
		int a = 0;
		
//		for(int i=0; i< 5_000_000; i++) {
//			a = numbers.get(i);
//		}
		
		for (Integer number: numbers) {
			a = number;
		}
		System.out.println(a);
		
	}

}
