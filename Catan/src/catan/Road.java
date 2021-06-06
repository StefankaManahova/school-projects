package catan;

public class Road {
	protected double ratioX;
	protected double ratioY;//from the beginning of the game board area, not the panel
	protected int X;
	protected int Y;
	protected boolean free = true;
	protected char slope;
	
	protected boolean isFirst = false;
	
	public Road(double ratioX, double ratioY, char slope) {
		this.ratioX = ratioX;
		this.ratioY = ratioY;
		this.slope = slope;
	}
	public void setPanelSize(int panelHeight,int beginningOfBoardX){
		this.Y= (int)(ratioY * panelHeight);
		this.X = (int)((ratioX * panelHeight) + beginningOfBoardX);
	}
}
