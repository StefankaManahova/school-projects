package catan;

import java.util.LinkedList;

public class catanField {
	protected String type;
	protected static int side;
	
	protected int centerX;
	protected int centerY;
	
	protected Point A;
	protected Point B;
	protected Point C;
	protected Point D;
	protected Point E;
	protected Point F;
	
	protected LinkedList<Piece> pieces = new LinkedList<Piece>();
	
	public catanField(String type){
		this.type= type;
	}
	public void setCoordinates(int X, int Y, int height) {
		centerX = X;
		centerY = Y;
		
		A = new Point(centerX / height, (centerY - side / 2) / height);
		B = new Point((int)(centerX + Math.sqrt(3) * side /2)/ height, (centerY - side / 4)/ height);
		C = new Point((int)(centerX + Math.sqrt(3) * side /2) / height, (centerY + side / 4) / height);
		D = new Point(centerX / height, (centerY + side / 2) / height);
		E = new Point((int)(centerX - Math.sqrt(3) * side /2) / height, (centerY + side / 4) / height);
		F = new Point((int)(centerX - Math.sqrt(3) * side /2) / height, (centerY - side / 4) / height);
		
	}
}
