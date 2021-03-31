package edu.collections;

import java.awt.Color;

public class Ball implements Comparable<Ball>{
	  	int x = 0;
		int y = 0; // Current ball position
		int dx = 2; // Increment on ball's x-coordinate
		int dy = 2; // Increment on ball's y-coordinate
		int radius =(int)(Math.random()*19 + 2); // Ball radius
		Color color = new Color((int)(Math.random()*256), (int)(Math.random ()*256),(int)(Math.random()*256 ));
		@Override
		public int compareTo(Ball o) {
			// TODO Auto-generated method stub
			return this.radius - o.radius;
		}

		
}

