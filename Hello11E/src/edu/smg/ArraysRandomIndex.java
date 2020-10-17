package edu.smg;

import java.util.Scanner;

public class ArraysRandomIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = new String[10];
		String[] copy = new String[10];
		int[] index = new int[10];
		boolean repeat = false;
		
		System.out.println("Please enter the 10 elements of the array:");
		for(int i=0; i<10; i++) {
			array[i] = sc.nextLine();
		}
		sc.close();
		for(int i=0; i<10; i++) {
			
			do {
			 repeat = false;
			 index[i] = (int)(Math.random()*10);
			 for(int j=0; j<i; j++) 
			 {
				if(index[i]==(index[j])) {
					repeat = true;
					break;
				}
			 }
		    } while(repeat);
			
			copy[index[i]] = array[i];
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(copy[i]);
		}

	}

}
