package catan;

public class Punkt {
	protected double ratioX;
	protected double ratioY;
	protected int X;
	protected int Y;
	
	public Punkt(int ratioX, int ratioY) {
		this.ratioX = ratioX;
		this.ratioY = ratioY;
	}
	public void setPanelHeight(int panelHeight){
		this.X = (int)(ratioX * panelHeight);
		this.Y = (int)(ratioY * panelHeight);
	}
}
