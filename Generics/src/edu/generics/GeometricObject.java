package edu.generics;

public abstract class GeometricObject implements Comparable<GeometricObject>{
	  private String colour = "white";
	  private boolean filled = false;
	  private java.util.Date dateCreated;
	  
	  public GeometricObject() {
		  dateCreated = new java.util.Date();
	  }
	  
	  public GeometricObject(String colour, boolean filled) {
		  dateCreated = new java.util.Date();
		  this.setColour(colour);
		  this.setFilled(filled);
	  }

	  public String getColour() {
		return colour;
	  }

	  public void setColour(String colour) {
		this.colour = colour;
	  }

	  public boolean isFilled() {
		return filled;
	  }

	  public void setFilled(boolean filled) {
		this.filled = filled;
	  }
	  
	  public abstract double getArea();
	  

	  public java.util.Date getDateCreated() {
		return dateCreated;
	  }
	  
	  public String toString() {
	  return "";
	  }

	@Override
	public int compareTo(GeometricObject o) {
		// TODO Auto-generated method stub
		if(this.getArea() > o.getArea()) {
			return 1;
		}
		else if(this.getArea() == o.getArea()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	  
		  
}
