package edu.smg;

import java.util.Scanner;

public class ArraysOneIndexForward {

	public static void main(String[] args) {
		
		final int arraySize = 10;
		String[] array = new String[arraySize];
		
		Scanner sc = new Scanner(System.in);
		for( int i=0; i<arraySize; i++) {
			System.out.println("Please enter the "+(i+1)+". element of the array.");
			array[i] = sc.nextLine();
		}
		sc.close();
		
		String firstElement = array[0];
		for(int i=0; i<arraySize-1; i++) {
			array[i] = array[i+1];
		}
		array[arraySize-1] = firstElement;
		
		for(String n : array) {
			System.out.print(n+" ");
		}

	}

}
