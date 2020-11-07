package edu.objects;

public class PolygonTest {

	public static void main(String[] args) {
		RegularPolygon triangle = new RegularPolygon();
		RegularPolygon hexagon = new RegularPolygon(6,4);
		RegularPolygon decagon = new RegularPolygon(10,4, 5.6, 7.8);//x = 5.6 y = 7.8
		
		System.out.println("The perimeter of the triangle is "+triangle.getPerimeter()+", and its area is "+triangle.getArea());
		System.out.println("The perimeter of the hexagon is "+hexagon.getPerimeter()+", and its area is "+hexagon.getArea());
		System.out.println("The perimeter of the decagon is "+decagon.getPerimeter()+", and its area is "+decagon.getArea());
	}

}
