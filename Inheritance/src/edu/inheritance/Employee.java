package edu.inheritance;

public class Employee extends Person {
  private String office;
  private double salary;
  private java.util.Date dateHired;
  
  Employee(String name,
		   String address,
           String phoneNumber,
           String emailAddress,
           String office,
           double salary){
	  
	  super(name,address,phoneNumber,emailAddress);
	  dateHired = new java.util.Date();
	  this.salary = (int)(salary*100)/100.0;
	  this.office = office;
  }
  
  public String getOffice() {
	return office;
  }
  public void setOffice(String office) {
	this.office = office;
  }
  public double getSalary() {
	return salary;
  }
  public void setSalary(double salary) {
	this.salary = salary;
  }
  public java.util.Date getDateHired() {
	return dateHired;
  }
  
  public String toString() {
    return super.toString()+"\nOffice:"+office+"\nSalary:"+salary+" Euro"+"\nDate hired: "+dateHired;
  }
  
}
