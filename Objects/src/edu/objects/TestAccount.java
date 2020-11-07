package edu.objects;

import java.text.*;

public class TestAccount {

	public static void main(String[] args) {
		Account account = new Account(1122, 20_000);
		Account.setYearInterestRate(4.5);//4,5%
		
		account.withdraw(2500);
		account.deposit(3000);
		
		SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
		
		System.out.println("The current balance of this account is $"+account.getBalance()+", the monthly interest rate is $"+ 
		                   +account.getMonthlyInterest()+", and the date the account was created was " + ft.format(account.getDateCreated()));

	}

}
