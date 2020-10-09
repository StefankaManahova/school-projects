package edu.smg;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of lines you wish the pyramid would have (from 1 to 15):");
        int numberOfLines = sc.nextInt();
        if ( numberOfLines < 1 || numberOfLines > 15) {
        	System.out.println("You have entered a number outside the allowed interval. Please run the programme again and input correct data.");
        }
        else {
        	for(int i = numberOfLines; i > 0; i--) {
        		int j = i;
        		for(; j > 1; j--) {
        			System.out.print(j + " ");
        		}
        		for(;j <= i; j++)
        		{
        			System.out.print(j + " ");
        		}
        		System.out.print("\n");
        	}
        }
	}

}
