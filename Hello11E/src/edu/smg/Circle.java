package edu.smg;

public class Circle {
  double radius = 1;
  
  Circle(){	  
  }
  
  Circle(double newRadius){
	  radius = newRadius;
  }
  public double getArea(){
	  return (int)(100*radius*radius*Math.PI)/100.0;
  }
  
  public double getPerimeter(){
	  return 2*radius*Math.PI;
  }
  void setRadius(double newRadius){
	  radius = newRadius;
  }
  
}
