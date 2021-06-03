package catan;

import java.util.LinkedList;

public class Field {
	protected String type;
	protected int number;
	
	protected Point center;
	protected static int side;
	
	protected Point A;
	protected Point B;
	protected Point C;
	protected Point D;
	protected Point E;
	protected Point F;
	
	protected LinkedList<Piece> pieces = new LinkedList<Piece>();
	
	Field(String type){
		if(type.equals("tree") || type.equals("bricks") || type.equals("rock")
				|| type.equals("wool") || type.equals("wheat")){
			this.type = type;
		}
	}
	 public void setNumber(int number) {
		 if(number >= 2 && number <= 12) {
			 this.number = number;
		 }
	 }
	 
	 public void setCoordinates(int centerX, int centerY, int height, int BoardBeginningX) {
		 center = new Point((double)(centerX - BoardBeginningX) / height, (double)(centerY) / height);
		 
		 A = new Point((double)(centerX - BoardBeginningX)/ height,(double)(centerY - side) / height);
		 B = new Point((centerX + Math.sqrt(3) * side/ 2 - BoardBeginningX) / height,(double)(centerY - side / 2) / height);
		 C = new Point((centerX + Math.sqrt(3) * side / 2  - BoardBeginningX)/ height,(double) (centerY + side / 2) / height);
		 D = new Point((double)(centerX - BoardBeginningX) / height, (double) (centerY + side) / height);
		 E = new Point((centerX - Math.sqrt(3) * side / 2 - BoardBeginningX) / height, (double)(centerY - side / 2 )/ height);
		 F = new Point((centerX - Math.sqrt(3) * side / 2 - BoardBeginningX) / height,(double) (centerY + side / 2 ) /height);
	 }
}
