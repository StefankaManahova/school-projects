package edu.recursion;

import java.util.Scanner;

public class RecursionProblems4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   System.out.println("Enter the two numbers:");
	   Scanner sc = new Scanner(System.in);
	   int x = sc.nextInt();
	   int y = sc.nextInt();
       System.out.println("The least common divisor of " + x + " and " + y + " is: " + leastCommonDivisor(x,y));
	
       System.out.println("Enter the number that you wish to find the sum up to:");
       int n = sc.nextInt();
       System.out.println("The sum of the numbers from 1 to "+ n+" is: " + sum(n));
       
	   System.out.println("2 up to the 4th power is: " + powRecursive(2,4));
	   
	   int[] list = {1,4,5,9};
	   System.out.println("The average of the numbers 1,4,5,9 is: " + average(list,4));
       sc.close();
	}
	
	public static int leastCommonDivisor(int x, int y){
		if (y == 0) {
			return x;
		}
		else {
     	    return leastCommonDivisor(y, x % y);
    	}
	}
	
	public static int leastCommonDivisorIterative(int x, int y) {
		while(y>0) {
			int z = y;
			y = x % y;
			x = z;
		}
		return x;
	}
	
	public static int sum(int n) {
		return sum(n,1);//recursive call
	}
	
	private static int sum(int n, int result) {
	   	 if (n == 1)
	   		 return result;//base case
	   	 else
	   		 return sum(n - 1, result + n);//recursive call
	}
	
	public static int powRecursive(int x, int n) {
		return powRecursive(x,n,1);
	}
	
	private static int powRecursive( int x, int n, int result ) {
		if (n == 0) {
			return result;
	    }
		else{
			return  powRecursive(x, n - 1, result*x );
		}
	}
	
	public static double average(int[] numbers, int n) {
		return sum(numbers,n,0)/n;
	}
	
	private static double sum(int[] numbers, int n, int result) {
		if(n==0) {
			return result;//base case
		}
		else {
			return sum(numbers, n-1, result+numbers[n-1]);//recursive call
		}
	}


}
