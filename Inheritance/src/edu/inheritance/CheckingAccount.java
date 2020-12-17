package edu.inheritance;

public class CheckingAccount extends Account{
	 private double overdraftLimit;
	 
     CheckingAccount(int id, double balance, double overdraftLimit){
    	 super(id,balance);
    	 this.overdraftLimit = overdraftLimit;
     }
     
    public void withdraw(double sumToWithdraw) {
    	if(sumToWithdraw > this.getBalance() + overdraftLimit) {
    		System.out.println("This sum exceeds your overdraft limit.");
    	}
    	else {
    		sumToWithdraw = (int)(sumToWithdraw*100)/100.0;
    		this.setBalance(this.getBalance()-sumToWithdraw);
    		System.out.println("Successful withraw of $"+sumToWithdraw);	
    	}
    }

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	public String toString() {
		return super.toString()+"\nAccount type: checking account"+"\nOverdraft limit:"+overdraftLimit;
	}
}
