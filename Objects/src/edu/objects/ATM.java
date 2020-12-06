package edu.objects;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Account[] people = new Account[10];
		for(int i=0; i<10; i++) 
		{
			people[i] = new Account(i, 100);
		}
		
		Scanner sc = new Scanner(System.in);
		boolean stopProgramme = false;
		int choice = 0;
		
		
        while(!stopProgramme) {
        	
        boolean exit = false;	
        	
		System.out.println("Enter an id:");
		String input = sc.nextLine();
		while(!input.equals("0")&&!input.equals("1")&&!input.equals("2")&&!input.equals("3")&&!input.equals("4")&&!input.equals("5")&&!input.equals("6")&&!input.equals("7")&&!input.equals("8")&&!input.equals("9")) {
			System.out.println("Please enter a correct id:");
			input = sc.nextLine();
		}
		int currentID = Integer.parseInt(input);
		
		while(!exit) {
		System.out.println("Main menu: \n1.check balance \n2.withdraw \n3.deposit \n4.exit");
		System.out.println("Enter a choice:");
		input = sc.nextLine();
		if(!input.equals("1") && !input.equals("2") && !input.equals("3")&&!input.equals("4")) {
			System.out.println("Please choose one of the available options:");
			input = sc.nextLine();
		}
		if(!input.equals("1") && !input.equals("2") && !input.equals("3")&&!input.equals("4")) {
			System.out.println("You had to choose one of the available options.");
			exit = true;
			break;
		}
		choice = Integer.parseInt(input);
		if(choice==1) 
		{
			System.out.println("The balance is $"+people[currentID].getBalance());
		}
		else if(choice==2)
		{
			System.out.println("Enter an amount to withdraw (written with \".\" instead of \",\"):");
			input= sc.nextLine();
			int l = input.length();
			boolean floatingPointFound = false;
			
			for(int i=0; i<l; i++) {
				
				if(!(Character.isDigit(input.charAt(i))) && input.charAt(i)!='.') {
					System.out.println("You had to enter a number.");
					exit = true;
					break;
				}
				else if(input.charAt(i)=='.') {
					if(!floatingPointFound) {
				     floatingPointFound = true;
				   }
					else {
						System.out.println("You had to enter a number.");
						exit = true;
						break;
					}
			    }
				
						
		     }
			if(exit) break;
	

			double amountToWithdraw = Double.parseDouble(input);
			if(amountToWithdraw > people[currentID].getBalance()) {
				System.out.println("You don't have this much money on your balance.");
			}
			else {
			 people[currentID].withdraw(amountToWithdraw);
			}
        }
		else if(choice==3) {
			
			System.out.println("Enter an amount to deposit (written with \".\" instead of \",\"):");
			input= sc.nextLine();
			int l = input.length();
			boolean floatingPointFound = false;
			
			for(int i=0; i<l; i++) {

				if(!(Character.isDigit(input.charAt(i))) && input.charAt(i)!='.') {
					System.out.println("You had to enter a number.");
					exit = true;
					break;
				}
				else if(input.charAt(i)=='.') {
					if(!floatingPointFound) {
				     floatingPointFound = true;
				   }
					else {
						System.out.println("You had to enter a number.");
						exit = true;
						break;
					}
			    }
				
						
		     }
			if(exit) break;
			
			double amountToDeposit = Double.parseDouble(input);
			people[currentID].deposit(amountToDeposit);

		}
		
		else if(choice==4) {
			exit = true;
			break;
		}
		
		
        }
		
	  }
        
        
	}
}
