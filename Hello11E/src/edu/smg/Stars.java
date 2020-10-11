package edu.smg;

import java.util.Scanner;

public class Stars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many stars do you want on the top row?");
	    int starsFirstRow  = sc.nextInt();
	    int n = starsFirstRow;
	    while( n > 0 )
	    {
	    	int i = 0;
	    	for(; i < starsFirstRow - n; i++)
	    	{
	    		System.out.print(" ");
	    	}
	    	for( ; i <starsFirstRow; i++)
	    	{
	    		System.out.print("*");
	    	}
	    	n--;
	    	System.out.println();
	    }
	}
}
