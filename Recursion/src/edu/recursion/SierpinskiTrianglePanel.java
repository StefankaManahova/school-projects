package edu.recursion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

public class SierpinskiTrianglePanel extends JPanel {
	private int order = 0;
	private static int red = 245;
	private static int green = 7;
	private static int blue = 7;
	private static int times = 0;

	/** Set a new order */
	public int getOrder() {
		return this.order;
	}
	
	public void setOrder(int order) {
		this.order = order;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Select three points in proportion to the panel size
		Point p1 = new Point(getWidth() / 2, 10);
		Point p2 = new Point(10, getHeight() - 10);
		Point p3 = new Point(getWidth() - 10, getHeight() - 10);
		displayTriangles(g, order, p1, p2, p3);
	}

	private static void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
		if (order == 0) {
			// Draw a triangle to connect three points
			int xpoints[] = {p1.x, p2.x, p3.x};
			int ypoints[] = {p1.y,p2.y, p3.y};
			Polygon triangle = new Polygon(xpoints,ypoints,3);
			
			changeColour(times);
			g.setColor(new Color(red,green,blue));
			times++;
			g.fillPolygon(triangle);

		} else {
			// Get the midpoint on each edge of the triangle
			Point p12 = midpoint(p1, p2);
			Point p23 = midpoint(p2, p3);
			Point p31 = midpoint(p3, p1);
			// Recursively display three triangles
			displayTriangles(g, order - 1, p1, p12, p31);
			displayTriangles(g, order - 1, p12, p2, p23);
			displayTriangles(g, order - 1, p31, p23, p3);
		}
	}

	private static Point midpoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
	private static void changeColour(int iterations) {
		while(iterations>0) {
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(blue<215) {
	    		blue += 30;
	    	}
	    	else {
	    		blue = 245;
	    	}
	    	iterations--;
	    }
	
	    
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(red>37) {
	    		red -=30;
	    	}
	    	else {
	    		red = 7;
	    	}
	    	iterations--;
	    }
	    
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(green<215) {
	    		green += 30;
	    	}
	    	else {
	    		green = 245;
	    	}
	    	iterations--;	
		}
	    
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(blue>37) {
	    		blue -=30;
	    	}
	    	else {
	    		blue = 7;
	    	}
	    	iterations--;
	    }
	    
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(red<215) {
	    		red += 30;
	    	}
	    	else {
	    		red = 245;
	    	}
	    	iterations--;	
		}
	    
	    for(int i=0; i<7 && iterations>0; i++) {
	    	if(green>37) {
	    		green -=30;
	    	}
	    	else {
	    		green = 7;
	    	}
	    	iterations--;
	    }
	  }  
	}
}
