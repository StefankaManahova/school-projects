package catan;

import java.util.LinkedList;

import javax.swing.JLabel;

public class Field {
	protected String type;
	protected int number;
	protected boolean hasBandits = false;
	
	protected Point center;
	protected static int side;
	
	protected LinkedList<Point> points = new LinkedList<Point>();
	protected LinkedList<Road> midpoints = new LinkedList<Road>();
	
	protected LinkedList<Piece> pieces = new LinkedList<Piece>();
	
	Field(String type){
		if(type.equals("tree") || type.equals("bricks") || type.equals("rock")
				|| type.equals("wool") || type.equals("wheat") || type.equals("desert")){
			this.type = type;
		}
	}
	
	Field(String type, boolean hasBandits){
		if(type.equals("tree") || type.equals("bricks") || type.equals("rock")
				|| type.equals("wool") || type.equals("wheat") || type.equals("desert")){
			this.type = type;
			this.hasBandits = hasBandits;
		}
	}
	 public void setNumber(int number) {
		 if(number >= 2 && number <= 12) {
			 this.number = number;
		 }
	 }
	 
	 public void setCoordinates(int centerX, int centerY, int height, int BoardBeginningX) {
		 points.clear();
		 center = new Point((double)(centerX - BoardBeginningX) / height, (double)(centerY) / height);
		 
		 Point A = new Point((double)(centerX - BoardBeginningX)/ height,(double)(centerY - side) / height, 'Z');
		 Point B = new Point((centerX + Math.sqrt(3) * side/ 2 - BoardBeginningX) / height,(double)(centerY - side / 2) / height, 'Y');
		 Point C = new Point((centerX + Math.sqrt(3) * side / 2  - BoardBeginningX)/ height,(double) (centerY + side / 2) / height, 'Z');
		 Point D = new Point((double)(centerX - BoardBeginningX) / height, (double) (centerY + side) / height, 'Y');
		 Point E = new Point((centerX - Math.sqrt(3) * side / 2 - BoardBeginningX) / height, (double)(centerY + side / 2 )/ height, 'Z');
		 Point F = new Point((centerX - Math.sqrt(3) * side / 2 - BoardBeginningX) / height,(double) (centerY - side / 2 ) /height, 'Y');
		 
		 Road AB = new Road((A.ratioX + B.ratioX) / 2, (A.ratioY + B.ratioY)/ 2, '\\');
		 Road BC = new Road((B.ratioX + C.ratioX) / 2, (B.ratioY + C.ratioY)/ 2, '|');
		 Road CD = new Road((C.ratioX + D.ratioX) / 2, (C.ratioY + D.ratioY)/ 2, '/');
		 Road DE = new Road((D.ratioX + E.ratioX) / 2, (D.ratioY + E.ratioY)/ 2, '\\');
		 Road EF = new Road((E.ratioX + F.ratioX) / 2, (E.ratioY + F.ratioY)/ 2, '|');
		 Road FA = new Road((F.ratioX + A.ratioX) / 2, (F.ratioY + A.ratioY)/ 2, '/');
		 
		 points.add(A);
		 points.add(B);
		 points.add(C);
		 points.add(D);
		 points.add(E);
		 points.add(F);
		 
		 midpoints.add(AB);
		 midpoints.add(BC);
		 midpoints.add(CD);
		 midpoints.add(DE);
		 midpoints.add(EF);
		 midpoints.add(FA);
	 }
}
