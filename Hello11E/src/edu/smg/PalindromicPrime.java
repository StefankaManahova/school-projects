package edu.smg;

public class PalindromicPrime {

	public static void main(String[] args) {
		int count = 0;
		int n = 2;
		String m = Integer.toString(n);
		
		while(count < 120) {
			if(isPrime(n) && isPalindromic(m)) {
			 count++;
			 if(count % 10 == 1) {
				System.out.print("\n"); 
			 }
			 System.out.print(n+" ");
		    }
			n++;
			m = Integer.toString(n);
			
		}

	}
	
	public static boolean isPrime(int n) {
		for(int i=2; i<n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromic(String m) {
		int l = m.length();
		for(int i=0; i<l/2+1; i++) {
			if(m.charAt(i)!=m.charAt(l-i-1)) {
				return false;
			}
		}
		return true;
	}

}
