package edu.smg;

public class Student {
	
  public String name;
  public int facno;
  
  public Student(String aName, int aFacno){
	  name = aName;
	  facno = aFacno;
  }
  public String toString(){
	  String res ="";
	  res = "Student: faculty number " + facno + ", name " + name;
	  return res;
  }
}
