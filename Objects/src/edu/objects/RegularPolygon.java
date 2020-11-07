package edu.objects;

public class RegularPolygon {
	private int n = 3;
	private double sideLength = 1;
	private double x = 0;//x coordinate of the center
	private double y = 0;//y coordinate of the center
	
	RegularPolygon(){
		
	}
	
	RegularPolygon(int n, double sideLength){
		this.setN(n);
		this.setSideLength(sideLength);	
	}
	
	RegularPolygon(int n, double sideLength, double x, double y){
		this.setN(n);
		this.setSideLength(sideLength);
		this.setX(x);
		this.setY(y);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getPerimeter() {
		return n*sideLength;
	}
	public double getArea(){
		double angle = 2*Math.PI/n;
		double area = n*sideLength*sideLength/(4*Math.tan(angle/2));
		area = (int)(area*100)/100.0;
		return area;
	}
}
