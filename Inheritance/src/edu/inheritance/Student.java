package edu.inheritance;

public class Student extends Person {
   public static final int  FRESHMAN = 9;
   public static final int SOPHOMORE = 10;
   public static final int JUNIOR = 11;
   public static final int SENIOR = 12;
   
   private String classStatus = "fresh-man";
    
   Student(String name,
		   String address,
           String phoneNumber,
           String emailAddress){
	   
	   super(name,address,phoneNumber,emailAddress);
   }

  public String getClassStatus() {
	return classStatus;
  }

  public void setClassStatus(int classStatus) {
   switch(classStatus) {
   case 9 :this.classStatus = "fresh-man";
             break;
   case 10:this.classStatus = "sophomore";
           break;
   case 11: this.classStatus = "junior";
           break;
   
   case 12: this.classStatus = "senior";
     break;
   default:System.out.println("That can't be resolved into a class status.");
   }
   }
   
   public String toString() {
	   return super.toString() + "\nClass status:"+ classStatus;
   }
}
