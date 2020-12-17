package edu.inheritance;

public class TestAccounts {

	public static void main(String[] args) {
		Account account = new Account(3,20_000);
		SavingsAccount savingsAccount = new SavingsAccount(3,20_000);
		CheckingAccount checkingAccount = new CheckingAccount(3,20_000,100);
		
		account.withdraw(30_000);
		System.out.println("\n"+account.toString()+"\n");
		
		savingsAccount.withdraw(30_000);
		System.out.println("\n"+savingsAccount.toString()+"\n");
		
		checkingAccount.withdraw(30_000);
		System.out.println("\n"+checkingAccount.toString()+"\n");

	}

}
