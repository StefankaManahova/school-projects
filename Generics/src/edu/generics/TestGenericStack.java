package edu.generics;

import java.util.Scanner;

public class TestGenericStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		GenericStack<String> list = new GenericStack<>();
		
		for(int i=0; i<5; i++) {
			System.out.println("Please enter the " + (i+1) + ". element:");
			list.push(sc.nextLine());
		}
		sc.close();
		System.out.println(list.getSize());
		
	    for(int i=0; i<5; i++) {
	    	System.out.println(list.pop());
	    }
	    System.out.println(list.getSize());
	}

}
