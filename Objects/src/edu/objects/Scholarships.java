package edu.objects;

import java.util.Scanner; 

public class Scholarships {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  Student[]  klasse = new Student[5];
		  
		  for(int i=0; i<5; i++) {
			  System.out.println("What is the name of the "+(i+1)+". student?");
			  String name = sc.nextLine();
			  System.out.println("What is the average score of the "+(i+1)+". student?");
			  double averageScore = sc.nextDouble();
			  sc.nextLine();
			  
			  klasse[i] = new Student(name,averageScore);
		  }
		  scholars(klasse);
		  

		}
		
		public static boolean worthyForScholarship(Student A) {
			if(A.averageScore >= 5.80 && A.averageScore <= 6.0) {
				return true;
			}
			return false;
		}
		
		public static void scholars(Student[] klasse) {
			for(int i=0; i<klasse.length; i++) {
				if(worthyForScholarship(klasse[i])) {
					System.out.println(klasse[i].name +"   " + klasse[i].averageScore);
				}
			}
			
		}

}
