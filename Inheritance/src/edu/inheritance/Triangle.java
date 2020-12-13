package edu.inheritance;

public class Triangle extends GeometricObject {
   private double side1 = 1;
   private double side2 = 1;
   private double side3 = 1;
   
   public Triangle() {
	   super();
   }
   public Triangle(String colour,boolean filled,double side1,double side2, double side3) {
	   super(colour,filled);
	   if(side1+side2>side3 & side2+side3>side1 & side1+side3>side2) {
		   this.side1 = (int)(side1*100)/100.0;
		   this.side2 = (int)(side2*100)/100.0;
		   this.side3 = (int)(side3*100)/100.0;
		   
	   }
	   else {
		   System.out.println("Those lengths can't be the sides of a triangle");

	   }
	   
   }
   public double getSide1() {
	return side1;
   }
   public double getSide2() {
	return side2;
   }
   public double getSide3() {
	return side3;
   }
   
   public double getPerimeter() {
	   return side1+side2+side3;
   }
   public double getArea() {
	   double a = side1;
	   double b = side2;
	   double c = side3;
	   
	   double cosB = (a*a + c*c - b*b)/(2*a*c);
	   double sinB = Math.sqrt(1 - cosB*cosB);
	   
	   double area = (a*c*sinB)/2;
	   return area;
   }
   
   public String printTriangle() {
	   return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
   }
   
   
}
