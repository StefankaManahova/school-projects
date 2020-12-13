package edu.inheritance;

public class Faculty extends Employee{
   private String officeHours;
   private String rank;
   
   Faculty( String name,
		    String address,
	        String phoneNumber,
	        String emailAddress,
	        String office,
	        double salary,
	        String officeHours,
	        String rank){
	   
	   super(name,address,phoneNumber,emailAddress,office,salary);
	   this.officeHours = officeHours;
	   this.rank = rank;
   }
   public String getOfficeHours() {
	return officeHours;
   }
   public void setOfficeHours(String officeHours) {
	this.officeHours = officeHours;
   }
   public String getRank() {
	return rank;
   }
   public void setRank(String rank) {
	this.rank = rank;
   }
   
   public String toString() {
	   return super.toString()+"\nOffice hours:"+officeHours+"\nRank:"+rank;
   }
   
}
