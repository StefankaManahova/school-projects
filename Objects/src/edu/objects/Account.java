package edu.objects;

import java.util.*;

public class Account {
  private int id = 0;
  private double balance = 0;
  private static double yearInterestRate = 0;//in %
  private Date dateCreated = new Date(1514764800000L);
  
  Account(){
	  
  }
  Account(int id, double balance){
	  this.setId(id);
	  this.setBalance(balance);
  }
  public Date getDateCreated() {
	return dateCreated;
  }
  public static double getYearInterestRate() {
	return yearInterestRate;
  }
  public static void setYearInterestRate(double yearInterestRate) {
	Account.yearInterestRate = yearInterestRate;
  }
  public double getBalance() {
	return balance;
  }
  public void setBalance(double balance) {
	this.balance = balance;
  }
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  
  public static double getMonthlyInterestRate() {
	  return yearInterestRate/12;// in %
  }
  public double getMonthlyInterest() {
	  return (int)(balance*getMonthlyInterestRate())/100.0;
	  
  }
  public void withdraw(double sumToWithdraw) {
	  sumToWithdraw = (int)(sumToWithdraw*100)/100.0;
	  balance -= sumToWithdraw;
	  System.out.println("Successful withdraw of $"+sumToWithdraw);
  }
  public void deposit(double sumToDeposit) {
	  sumToDeposit = (int)(sumToDeposit*100)/100.0;
	  balance += sumToDeposit;
	  System.out.println("Successful deposit of $"+sumToDeposit);
  }
  
}
