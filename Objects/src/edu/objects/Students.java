package edu.objects;

public class Students {
   public String name;
   public int klasse;
   public int number;
   
   public Students(String newName, int newKlasse, int newNumber){
		  name = newName;
		  klasse = newKlasse;
		  number = newNumber;
	  }
	  public String toString(){
		  String res ="";
		  res = "Student: faculty number, name " + name;
		  return res;
	  }
}
