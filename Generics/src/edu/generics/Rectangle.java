package edu.generics;

public class Rectangle extends GeometricObject{
	private double length;
	private double width;
	
	Rectangle(double length,double width){
		super();
		this.setLength(length);
		this.setWidth(width);
	}
	
	Rectangle(double length, double width,String colour, boolean filled) {
		  super(colour, filled);
		  this.setLength(length);
		  this.setWidth(width);
	  }

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}
	@Override
	public String toString() {
		return "\nRectangle length:" + length + " width:" + width + " area:" + this.getArea();
	}
}
