package edu.recursion;

public class RecursionTasks2 {

	public static void main(String[] args) {
		int n = 20;
		System.out.println("The number " + n +" is " +(odd(n)?"odd.":"even."));
		System.out.println("The number " + (n+1) +" is " +(even(n+1)?"even.":"odd."));
		System.out.println("The number " + n + " equals " + dec2Bin(n) + " in binary code.");
	}
	public static boolean odd(int x) {
		if(x==1) {
			return true;
		}
		else if(x==0) {
			return false;
		}
		else {
			return odd(x-2);
		}
	}
	
	public static boolean even(int x) {
		if(x==1) {
			return false;
		}
		else if(x==0) {
			return true;
		}
		else {
			return even(x-2);
		}
	}
	
	public static String dec2Bin(int value) {
		if(value==1) {
			return  "1";
		}
		else if(value==0) {
			return "0";
		}
		else {
			return dec2Bin(value/2) + value%2;
		}
		
	}

}
