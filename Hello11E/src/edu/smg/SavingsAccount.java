package edu.smg;

public class SavingsAccount {
   public String name;
   public double balance;
   public double interestRate = 0.01;
   
   public void deposit(double sumToDeposit){
	   balance += sumToDeposit;
   }
   
   public void withdraw(double sumToWithdraw){
	   if(sumToWithdraw<0 || sumToWithdraw > balance){
		   System.out.println("Error");
		   return;
	   }
	   balance -= sumToWithdraw;
	   System.out.println("Successful withraw of "+ sumToWithdraw +", " + balance + " left.");
   }
}
