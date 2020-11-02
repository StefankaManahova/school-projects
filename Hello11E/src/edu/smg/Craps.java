package edu.smg;

public class Craps {

	public static void main(String[] args) {
		int die1 = roll();
		int die2 = roll();
		int sum = die1+die2;
	    int previousSum=sum;
	    
	    System.out.println(die1+"+"+die2+"="+sum);
	    
	    if(sum==2 || sum==3 || sum==12) {
	    	System.out.println("Oh no, you just lost!");
	    }
	    else if(sum==7 || sum==11) {
	    	System.out.println("Yay!You win!");
	    }
	    else {
	    	do {
	    		die1 = roll();
	    		die2 = roll();
	    		sum = die1+die2;
	    		System.out.println(die1+"+"+die2+"="+sum);
	    	} while(previousSum!=sum && sum!=7);
	    	
	    	if(previousSum==sum) {
	    		System.out.println("Yay!You win!");
	    	}
	    	else {
	    		System.out.println("Oh no, you just lost!");
	    	}
	    }

	}
	public static int roll() {
		return (int)(Math.random()*6) + 1;
	}

}
