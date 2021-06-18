package catan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class DicePanel extends JPanel {
	protected int dice1Result;
	protected int dice2Result;
	
	protected static double topBottomRatioToHeight = 0.2;
	protected static double inBetweenRatioToSide = 0.15;
	protected static double borderRatioToSide = 0.06;
	protected static double diceMarginRatioToSide = 0.15;
	protected static double diameterRatioToSide = 0.16;
	
	protected static int side;
	
	protected static Color borderColour = new Color(0, 0, 77);
	protected static Color dotsColour = new Color(0, 0, 179);
	
	public DicePanel() {
		dice1Result = (int)(Math.random() * 6) + 1;
		dice2Result = (int)(Math.random() * 6) + 1;
		repaint();
	}
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		Graphics2D g2d = (Graphics2D) g;
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int topBottomMargin = (int)(topBottomRatioToHeight * this.getHeight());
		side = this.getHeight() - 2 * topBottomMargin;
		int inBetween =(int)(inBetweenRatioToSide * side);
		int leftRightMargin = (this.getWidth() - 2 * side - inBetween) / 2;
	
		int upLeftX1 = leftRightMargin;
		int upLeftY1 = topBottomMargin;
		
		g2d.setColor(borderColour);
		g2d.fillRect(upLeftX1, upLeftY1, side, side);
		
		int upLeftX2 = upLeftX1 + side + inBetween;
		int upLeftY2 = topBottomMargin;
		
		g2d.fillRect(upLeftX2, upLeftY2, side, side);
		
		int border = (int)(borderRatioToSide * side);
		int upLeftX1Inside = upLeftX1 + border;
		int upLeftY1Inside = upLeftY1 + border;
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(upLeftX1Inside, upLeftY1Inside, side - 2 * border, side - 2 * border);
		
		int upLeftX2Inside = upLeftX2 + border;
		int upLeftY2Inside = upLeftY2 + border;
		g2d.fillRect(upLeftX2Inside, upLeftY2Inside, side - 2 * border, side - 2 * border);
		
		if(dice1Result == 1) {
			paintOne(g2d, upLeftX1, upLeftY1);
		}
		else if(dice1Result == 2) {
			paintTwo(g2d, upLeftX1, upLeftY1);
		}
		else if(dice1Result == 3) {
			paintThree(g2d, upLeftX1, upLeftY1);
		}
		else if(dice1Result == 4) {
			paintFour(g2d, upLeftX1, upLeftY1);
		}
		else if(dice1Result == 5) {
			paintFive(g2d, upLeftX1, upLeftY1);
		}
		else if(dice1Result == 6) {
			paintSix(g2d, upLeftX1, upLeftY1);
		}
		
		if(dice2Result == 1) {
			paintOne(g2d, upLeftX2, upLeftY2);
		}
		else if(dice2Result == 2) {
			paintTwo(g2d, upLeftX2, upLeftY2);
		}
		else if(dice2Result == 3) {
			paintThree(g2d, upLeftX2, upLeftY2);
		}
		else if(dice2Result == 4) {
			paintFour(g2d, upLeftX2, upLeftY2);
		}
		else if(dice2Result == 5) {
			paintFive(g2d, upLeftX2, upLeftY2);
		}
		else if(dice2Result == 6) {
			paintSix(g2d, upLeftX2, upLeftY2);
		}
		
	}
	
	protected void paintOne(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int X = upLeftX + (this.side - diameter) / 2;
		int Y = upLeftY + (this.side - diameter) / 2;
		
		g2d.setColor(dotsColour);
		g2d.fillOval(X, Y, diameter, diameter);		
	}
	
	protected void paintTwo(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int diceMargin = (int)(this.side * diceMarginRatioToSide);
		
		int X1 = upLeftX + diceMargin;
		int Y1 = upLeftY + diceMargin;
		
		int X2 = upLeftX + side - diceMargin - diameter;
		int Y2 = upLeftY + side - diceMargin - diameter;
			
		g2d.setColor(dotsColour);
		g2d.fillOval(X1, Y1, diameter, diameter);
		g2d.fillOval(X2, Y2, diameter, diameter);
	}
	
	protected void paintThree(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int diceMargin = (int)(this.side * diceMarginRatioToSide);
		
		int X1 = upLeftX + side - diceMargin - diameter;
		int Y1 = upLeftY + diceMargin;
		
		int X2 = upLeftX + diceMargin;
		int Y2 = upLeftY + side - diceMargin - diameter;
		
		int X3 = (X1 + X2) / 2;
		int Y3 = (Y1 + Y2) / 2;
			
		g2d.setColor(dotsColour);
		g2d.fillOval(X1, Y1, diameter, diameter);
		g2d.fillOval(X2, Y2, diameter, diameter);
		g2d.fillOval(X3, Y3, diameter, diameter);
	}
	
	protected void paintFour(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int diceMargin = (int)(this.side * diceMarginRatioToSide);
		
		int X1 = upLeftX + diceMargin;
		int Y1 = upLeftY + diceMargin;
		
		int X2 = upLeftX + side - diceMargin - diameter;
		int Y2 = upLeftY + side - diceMargin - diameter;
		
		int X3 = upLeftX + side - diceMargin - diameter;
		int Y3 = upLeftY + diceMargin;
		
		int X4 = upLeftX + diceMargin;
		int Y4 = upLeftY + side - diceMargin - diameter;
			
		g2d.setColor(dotsColour);
		g2d.fillOval(X1, Y1, diameter, diameter);
		g2d.fillOval(X2, Y2, diameter, diameter);
		g2d.fillOval(X3, Y3, diameter, diameter);
		g2d.fillOval(X4, Y4, diameter, diameter);
	}
	
	protected void paintFive(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int diceMargin = (int)(this.side * diceMarginRatioToSide);
		
		int X1 = upLeftX + diceMargin;
		int Y1 = upLeftY + diceMargin;
		
		int X2 = upLeftX + side - diceMargin - diameter;
		int Y2 = upLeftY + side - diceMargin - diameter;
		
		int X3 = upLeftX + side - diceMargin - diameter;
		int Y3 = upLeftY + diceMargin;
		
		int X4 = upLeftX + diceMargin;
		int Y4 = upLeftY + side - diceMargin - diameter;
		
		int X5 = (X1 + X2) / 2;
		int Y5 = (Y1 + Y2) / 2;
		
		g2d.setColor(dotsColour);
		g2d.fillOval(X1, Y1, diameter, diameter);
		g2d.fillOval(X2, Y2, diameter, diameter);
		g2d.fillOval(X3, Y3, diameter, diameter);
		g2d.fillOval(X4, Y4, diameter, diameter);
		g2d.fillOval(X5, Y5, diameter, diameter);
	}
	
	protected void paintSix(Graphics2D g2d, int upLeftX, int upLeftY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int diameter =(int)(this.side * diameterRatioToSide);
		int diceMargin = (int)(this.side * diceMarginRatioToSide);
		
		int X1 = upLeftX + diceMargin;
		int Y1 = upLeftY + diceMargin;
		
		int X2 = upLeftX + side - diceMargin - diameter;
		int Y2 = upLeftY + side - diceMargin - diameter;
		
		int X3 = upLeftX + side - diceMargin - diameter;
		int Y3 = upLeftY + diceMargin;
		
		int X4 = upLeftX + diceMargin;
		int Y4 = upLeftY + side - diceMargin - diameter;
		
		int X5 = X1;
		int Y5 = (Y1 + Y4) / 2;
		
		int X6 = X2;
		int Y6 = (Y2 + Y3) / 2;
			
		g2d.setColor(dotsColour);
		g2d.fillOval(X1, Y1, diameter, diameter);
		g2d.fillOval(X2, Y2, diameter, diameter);
		g2d.fillOval(X3, Y3, diameter, diameter);
		g2d.fillOval(X4, Y4, diameter, diameter);
		g2d.fillOval(X5, Y5, diameter, diameter);
		g2d.fillOval(X6, Y6, diameter, diameter);
	}
	
	protected int roll() {
		dice1Result = (int)(Math.random() * 6) + 1;
		dice2Result = (int)(Math.random() * 6) + 1;
		repaint();
		return dice1Result + dice2Result;
	}
}
