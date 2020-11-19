package edu.objects;

public class TestMyInteger {

	public static void main(String[] args) {
		MyInteger number = new MyInteger(67);
		
		System.out.println("The number "+ number.getValue()+" is "+ (number.isOdd()?"odd.":"even."));
		System.out.println("The number " + number.getValue() + (number.isPrime()?" is ":" isn't ")+"prime.");
		System.out.println();
		
		int n = 34;
		
		System.out.println("The number " + n +" is "+ (MyInteger.isOdd(n)?"odd.":"even."));
		System.out.println("The number " + n + (MyInteger.isPrime(n)?" is ":" isn't ")+"prime.");
		System.out.println();
		
		MyInteger score  = new MyInteger(67);
		
		System.out.println("The number " + score.getValue()+(score.equals(n)?" equals ":" doesn't equal ") + n+".");
		System.out.println("The number " + score.getValue()+(score.equals(number)?" equals ":" doesn't equal ") + number.getValue()+".");
		System.out.println();
	
	String str1 = "123467";
	
	if(MyInteger.parseInt(str1)==-1) {
		System.out.println("This can't be converted into an int data type.");
	}
	else {
	int str1Value = MyInteger.parseInt(str1);
	System.out.println(str1Value+1);
	}
	
	char[] str2 = {'4','0','9'};
	
	if(MyInteger.parseInt(str2)==-1) {
		System.out.println("This can't be converted into an int data type.");
	}
	else {
	int str2Value = MyInteger.parseInt(str2);
	System.out.println(str2Value+1);
	}
	
 }
}
