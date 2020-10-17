package edu.smg;

public class RandomCards {

	public static void main(String[] args) {
		
		String[] number = {"A","2","3","4","5","6","7","8","9","10","J","D","K"};
		String[] colour = {"♦","♠","♥","♣"};
		
		String[][] deck = new String[13][4];
		
		boolean repeat;
		
	    for(int i=0; i<13; i++) {
	    	for(int j=0; j<4; j++) {
	    		deck[i][j] = number[i] + colour[j];
	    	}
	    }
	    
	    String[] chosenCards = new String[4];
	    
	    for(int index=0; index<4; index++) {
	    	do {
	    		repeat = false;
	    		
	    		int i = (int)(Math.random()*13);
	    		int j = (int)(Math.random()*4);
	    		chosenCards[index] = deck[i][j];
	    		
	    		for(int k=0; k<index; k++) {
	    			if(chosenCards[k]==chosenCards[index]) {
	    				repeat = true;
	    				break;
	    			}
	    		}
	    	} while(repeat);
	    }
	    
	    for(int index=0; index<4; index++) {
	    	System.out.println(chosenCards[index]);
	    }
	}

}
