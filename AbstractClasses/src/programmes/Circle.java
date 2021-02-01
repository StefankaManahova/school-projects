package programmes;

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
	  
	  public double getArea(){
		  return (int)(100*radius*radius*Math.PI)/100.0;
	  }
	  
	  public double getPerimeter(){
		  return 2*radius*Math.PI;
	  }
	  
	  void setRadius(double newRadius){
		  radius = newRadius;
	  }
	  
	  public double getRadius() {
		  return radius;
	  }
	  @Override
	  public void howToColour() {
		  if(this.isFilled()) {
			  System.out.println("Paint the whole area within the circle "+this.getColour()+".");
		  }
		  else {
			  if("white".equals(this.getColour())) {
				  System.out.println("Paint the border of the circle black.");
			  }
			  else {
				  System.out.println("Paint the border of the circle "+this.getColour()+".");
			  }
		  }
	  }
}
