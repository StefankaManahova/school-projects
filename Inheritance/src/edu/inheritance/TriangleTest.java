package edu.inheritance;

import java.util.Scanner;

public class TriangleTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is the lenght of the first side of the triangle?");
		double side1 = sc.nextDouble();
		
		System.out.println("What is the lenght of the second side of the triangle?");
		double side2 = sc.nextDouble();
		
		System.out.println("What is the lenght of the third side of the triangle?");
		double side3 = sc.nextDouble();
		
		System.out.println("Is the triangle filled?");
		sc.nextLine();
	    String input = sc.nextLine();
	    boolean isFilled;
	    String colour = "white";
	    if(input.equals("yes")||input.equals("Yes")) {
	       isFilled = true;
	    }
	    else {
	    	isFilled = false;
	    }
	    if(isFilled) {
	    	System.out.println("What colour is the triangle?");
	    	colour = sc.nextLine();
	    }
	    
		sc.close();
		
		if(side1+side2<=side3 ||side1+side3<=side2 ||side2+side3<=side1) {
			System.out.println("Those lengths can't be the sides of a triangle");
		}
		else {
			Triangle triangle = new Triangle(colour, isFilled,side1,side2,side3);
			System.out.println(triangle.printTriangle()+"\n"+triangle.toString());
			System.out.println("Perimeter:"+triangle.getPerimeter()+"  Area:"+triangle.getArea());
		}
		
	}
	

}
