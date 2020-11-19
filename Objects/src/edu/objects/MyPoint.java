package edu.objects;

public class MyPoint {
	
	private double x;
	private double y;
	
	MyPoint(){
		this.x = 0;
		this.y = 0;
	}
	
	MyPoint(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}
	
	public double distance( MyPoint point2 ) {
		
		double distance = Math.pow(point2.x - this.x,2) + Math.pow(point2.y - this.y,2);
		distance = Math.pow(distance, 0.5);
		return (int)(distance*100)/100.0;
		
	}
	
	public double distance(double x2, double y2) {

		double distance = Math.pow(x2 - this.x,2) + Math.pow(y2 - this.y,2);
		distance = Math.pow(distance, 0.5);
		return (int)(distance*100)/100.0;
	}
	
	public static double distance(MyPoint point1, MyPoint point2) {
		double distance = Math.pow(point2.x - point1.x,2) + Math.pow(point2.y - point1.y,2);
		distance = Math.pow(distance, 0.5);
		return (int)(distance*100)/100.0;
	}

}
