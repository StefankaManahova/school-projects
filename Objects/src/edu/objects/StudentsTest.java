package edu.objects;

import java.util.Scanner;

public class StudentsTest {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		  Students[]  klasse = new Students[5];
		  
		  for(int i=0; i<5; i++) {
			  System.out.println("What is the name of the "+(i+1)+". student?");
			  String name = sc.nextLine();
			  System.out.println("What is the average score of the "+(i+1)+". student?");
			  double averageScore = sc.nextDouble();
			  sc.nextLine();
			  
			  klasse[i] = new Students(name,averageScore);
		  }
		  sc.close();
		  scholars(klasse);
		  

		}
		
		public static boolean worthyForScholarship(Students A) {
			if(A.getAverageScore() >= 5.80 && A.getAverageScore() <= 6.0) {
				return true;
			}
			return false;
		}
		
		public static void scholars(Students[] klasse) {
			for(int i=0; i<klasse.length; i++) {
				if(worthyForScholarship(klasse[i])) {
					System.out.println(klasse[i].getName() +"   " + klasse[i].getAverageScore());
				}
			}

	}

}
