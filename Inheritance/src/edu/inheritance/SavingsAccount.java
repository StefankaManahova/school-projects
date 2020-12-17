package edu.inheritance;

public class SavingsAccount extends Account{
   SavingsAccount(int id,double balance){
	   super(id,balance);
   }
   
   public void withdraw(double sumToWithdraw) {
	   if(sumToWithdraw > this.getBalance()) {
		   System.out.println("You don't have this much money on your balance.");
	   }
	   else {
		   sumToWithdraw = (int)(sumToWithdraw*100)/100.0;
		   this.setBalance(this.getBalance()-sumToWithdraw);
		   System.out.println("Successful withraw of $"+sumToWithdraw);
		   
	   }
   }
   public String toString() {
	   return super.toString()+"\nAccount type: savings account";
   }
}
