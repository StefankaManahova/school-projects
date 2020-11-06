package edu.smg;

public class Emirps {

	public static void main(String[] args) {
		int n=2;
		String number = Integer.toString(n);
		String numberBackwards = new String();
		int count = 0;
		
		while(count<120) 
		{
			numberBackwards = backwards(number);
			int nBackwards = Integer.parseInt(numberBackwards);
			
			if(!numberBackwards.equals(number)&&isPrime(n)&&isPrime(nBackwards))
			{
				count++;
				if(count%10==1) {
					System.out.print("\n");
				}
				System.out.print(number+" ");
			}
			n++;
			number = Integer.toString(n);
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
	
	public static String backwards(String number) {
		String backwards ="";
		int l = number.length();
		for(int i=0; i<l; i++) {
			backwards += number.charAt(l-i-1);
		}
		return backwards;
	}

}
