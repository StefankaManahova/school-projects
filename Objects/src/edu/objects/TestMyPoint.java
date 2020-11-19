package edu.objects;

public class TestMyPoint {

	public static void main(String[] args) {
		MyPoint center = new MyPoint();
		
		MyPoint A = new MyPoint(1,1);
		MyPoint B = new MyPoint(-2,-3);
		
		System.out.println(center.distance(A));
		System.out.println(A.distance(center));
		System.out.println(MyPoint.distance(A, center));
		System.out.println(A.distance(B));
		System.out.println(A.distance(-2,-3));
		

	}

}
