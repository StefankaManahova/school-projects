package edu.smg;

public class Circle {
  double radius = 1;
  
  Circle(){	  
  }
  
  Circle(double newRadius){
	  radius = newRadius;
  }
  public double getArea(){
	  return radius*radius*Math.PI;
  }
  
  public double getPerimeter(){
	  return 2*radius*Math.PI;
  }
  void setRadius(double newRadius){
	  radius = newRadius;
  }
  
}
