package edu.objects;

public class MyInteger {
	private int value;
	
	
	MyInteger(int value){
		this.value = value;
	}


	public int getValue() {
		return value;
	}
	
	
	public boolean isEven() {
		if(this.value % 2==0) {
			return true;
	    }
		else {
			return false;
		}
	}  
	public boolean isOdd() {
		if(this.value % 2==1) {
			return true;
	    }
		else {
			return false;
		}
	}
	public boolean isPrime() {
		for(int i=2; i<this.value; i++) {
			if(this.value % i==0) {
				return false;
			}
		}
		if(this.value==0 || this.value==1) {
			return false;
		}
		return true;
	}
	
	
	public static boolean isEven(int number) {
		if(number % 2==0) {
			return true;
	    }
		else {
			return false;
		}
		
	}
	public static boolean isOdd(int number) {
		if(number % 2==1) {
			return true;
	    }
		else {
			return false;
		}
		
	}
	public static boolean isPrime(int number) {
		for(int i=2; i<number; i++) {
			if(number%i==0) {
				return false;
			}
		}
		if(number==0 || number==1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean isEven(MyInteger myInteger) {
		if(myInteger.value % 2==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isOdd(MyInteger myInteger) {
		if(myInteger.value % 2==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isPrime(MyInteger myInteger) {
		for(int i=2; i<myInteger.value; i++) {
			if(myInteger.value % i==0) {
				return false;
			}
		}
		if(myInteger.value==1 || myInteger.value==0) {
			return false;
		}
		return true;
	}
	public boolean equals(int number) {
		if(this.value == number)
		{
			return true;
		}
		return false;
	}
	public boolean equals(MyInteger myInteger) {
		if(this.value == myInteger.value)
		{
			return true;
		}
		return false;
	}
	
	public static int parseInt(char[] array) {
		int length = array.length;
		int result = 0;
		int power = 0;
		boolean notInteger = false;
		
		for(int i=length-1; i>=0; i--) {
			switch(array[i]) {
			case '1':result += 1*Math.pow(10, power);
			 break;
			case '2':result += 2*Math.pow(10, power);
			 break;
			case '3':result += 3*Math.pow(10, power);
			 break;
			case '4':result += 4*Math.pow(10, power);
			 break;
			case '5':result += 5*Math.pow(10, power);
			 break;
			case '6':result += 6*Math.pow(10, power);
			 break;
			case '7':result += 7*Math.pow(10, power);
			 break;
			case '8':result += 8*Math.pow(10, power);
			 break;
			case '9':result += 9*Math.pow(10, power);
			 break;
			case '0':result += 0*Math.pow(10, power);
			 break;
			default: notInteger= true;
			 break;
			}
			power++;
		}
		
		if(notInteger) {
			return -1;
		}
		else {
			return result;
		}
	}
	
	public static int parseInt(String number) {
		int length = number.length();
		int result = 0;
		int power = 0;
		boolean notInteger = false;
		
		for(int i=length-1; i>=0; i--) {
			switch(number.charAt(i)) {
			case '1':result += 1*Math.pow(10, power);
			 break;
			case '2':result += 2*Math.pow(10, power);
			 break;
			case '3':result += 3*Math.pow(10, power);
			 break;
			case '4':result += 4*Math.pow(10, power);
			 break;
			case '5':result += 5*Math.pow(10, power);
			 break;
			case '6':result += 6*Math.pow(10, power);
			 break;
			case '7':result += 7*Math.pow(10, power);
			 break;
			case '8':result += 8*Math.pow(10, power);
			 break;
			case '9':result += 9*Math.pow(10, power);
			 break;
			case '0':result += 0*Math.pow(10, power);
			 break;
			default: notInteger= true;
			 break;
			}
			power++;
		}
		
		if(notInteger) {
			return -1;
		}
		else {
			return result;
		}
		
	}

}
