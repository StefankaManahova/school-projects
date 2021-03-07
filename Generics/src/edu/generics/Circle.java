package edu.generics;

public class Circle extends GeometricObject{
	 private double radius;
	  
	  public Circle(){	 
		  super();
		  this.radius = 1;
	  }
	  
	  public Circle(double radius){
		  super();
		  this.setRadius(radius);
	  }
	  
	  public Circle(double radius,String colour, boolean filled) {
		  super(colour, filled);
		  this.setRadius(radius);
	  }
	  @Override
	  public double getArea(){
		  return (int)(100*radius*radius*Math.PI)/100.0;
	  }
	  
	  public double getPerimeter(){
		  return 2*radius*Math.PI;
	  }
	  
	  public void setRadius(double newRadius){
		  radius = newRadius;
	  }
	  
	  public double getRadius() {
		  return radius;
	  }
	  @Override
	  public String toString() {
		  return "\nCircle  radius:" + radius +" area:" + this.getArea();
	  }
	
	  
}
