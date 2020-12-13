package edu.inheritance;

public class Staff extends Employee {
  private String title;
  
  Staff(String name,
	    String address,
        String phoneNumber,
        String emailAddress,
        String office,
        double salary,
        String title){
	  super(name,address,phoneNumber,emailAddress,office,salary);
	  this.setTitle(title);
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }
   
  public String toString() {
	  return super.toString() +"\nTitle:"+title;
  }
  
  
}
