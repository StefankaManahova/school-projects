package programmes;

public abstract class GeometricObject implements Colourable {
	
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

	  public java.util.Date getDateCreated() {
		return dateCreated;
	  }
	  
	  public abstract double getArea();
	  
	  public String toString() {
	  return "Created on "+ dateCreated +"\ncolour:" + colour +" and filled:" + filled; 
	  }
}
