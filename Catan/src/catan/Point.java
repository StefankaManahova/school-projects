package catan;

public class Point {
	protected double ratioX;
	protected double ratioY;//from the beginning of the game board area, not the panel
	protected int X;
	protected int Y;
	protected boolean free = true;
	
	protected char type;
	
	public Point(double ratioX, double ratioY, char type) {
		this.ratioX = ratioX;
		this.ratioY = ratioY;
		this.type = type;
	}
	
	public Point(double ratioX, double ratioY) {
		this.ratioX = ratioX;
		this.ratioY = ratioY;
	}
	
	public void setPanelSize(int panelHeight,int beginningOfBoardX){
		this.Y= (int)(ratioY * panelHeight);
		this.X = (int)((ratioX * panelHeight) + beginningOfBoardX);
	}
}
