package edu.objects;

public class TestCircle {//with added getter and setter, as requested in 12th task

	public static void main(String[] args) {
		Circle circle1 = new Circle();
		System.out.println("The area of a circle with radius " + circle1.getRadius() + " is "+ circle1.getArea());
		
		Circle circle2 = new Circle(25);
		System.out.println("The area of a circle with radius " + circle2.getRadius() + " is "+ circle2.getArea());
		
		Circle circle3 = new Circle(125);
		System.out.println("The area of a circle with radius " + circle3.getRadius() + " is "+ circle3.getArea());
	}

}
