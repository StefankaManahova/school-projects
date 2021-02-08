package edu.recursion;

public class Sum {
	public static void main(String[] args) {
	   	 System.out.println("Sum is " + sumNaturalNumbersUpTo(3));
	   	 printBackwards(1234567);
	   	 System.out.println();
	   	 System.out.println(powerOfTwo(3));
	   	 System.out.println(powerOfTwoRecursive(5));
	   	 System.out.println(powerOfX(2.5, 2));
	     System.out.println(powerOfXRecursive(2.5, 2));
	}

	public static int sumNaturalNumbersUpTo(int n) {
		int res = 0;
		for(int i=1; i<=n; i++) {
			res += i;
		}
		return res;
	}
	
	public static void printBackwards(int n) {
		while(n>0) {
			System.out.print(n%10);
			n /= 10;
		}
	}
	
	public static long powerOfTwo(int n) {
		long res = 1;
		for(int i=1; i<=n; i++) {
			res *= 2;
		}
		return res;
	}
	
	public static long powerOfTwoRecursive(int n) {
		if(n==0){
		  return 1;
		}
		else {
			return 2*powerOfTwoRecursive(n-1);
		}
	}
	
	public static double powerOfX(double x, int n) {
		double res = 1;
		for(int i=1; i<=n; i++) {
			res *= x;
		}
		return res;
	}
	
	public static double powerOfXRecursive(double x, int n) {
		if(n==0) {
			return x;
		}
		else {
			return x*powerOfX(x,n-1);
		}
	}
}
