package edu.collections;


import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class BallPanel extends JPanel{
	
		private int delay = 10;
		private ArrayList<Ball> list = new ArrayList<Ball>();
	// Create a timer with the initial delay
		protected Timer timer = new Timer(delay, new TimerListener());

		private class TimerListener implements ActionListener {
			@Override /** Handle the action event */
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}
	

		public BallPanel() {
			timer.start();
			this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i=0; i<list.size(); i++){ 
					Ball ball = (Ball)list.get(i);
					double distance = distance(e.getX(), e.getY(), ball.x, ball.y);
					if(distance <= ball.radius) {
						list.remove(ball);
						break;
					}

				}
				
			}

			
	});
		}

		public void add() {
			list.add(new Ball());
		}

		public void subtract() {
			if (list.size() > 0)
				list.remove(list.size() - 1); // Remove the last ball
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < list.size(); i++) {
				Ball ball = (Ball) list.get(i); // Get a ball
				g.setColor(ball.color); // Set ball color
				// Check boundaries
				if (ball.x < 0 || ball.x > getWidth())
					ball.dx = -ball.dx;
				if (ball.y < 0 || ball.y > getHeight())
					ball.dy = -ball.dy;
				// Adjust ball position
				ball.x += ball.dx;
				ball.y += ball.dy;
				g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
			}
			
			ArrayList<Ball> ballsToRemove = new ArrayList<>();
			for(int i=0; i<list.size(); i++) {
				Ball ball = (Ball) list.get(i);
				for(int j=i+1; j<list.size(); j++) {
					Ball nextBall = (Ball) list.get(j);
					double distance = distance(ball.x, ball.y,nextBall.x, nextBall.y);
					if(distance <= ball.radius + nextBall.radius) {
						ballsToRemove.add(nextBall);
						ball.radius += nextBall.radius;
						
					}
				}
			}
			
			list.removeAll(ballsToRemove);
		
		}
		
		public static double distance (int x1, int y1, int x2, int y2) {
			return Math.sqrt(Math.pow(x1- x2,2) + Math.pow(y1- y2,2));
		}

		public void suspend() {
			timer.stop();
		}

		public void resume() {
			timer.start();
		}

		public void setDelay(int delay) {
			this.delay = delay;
			timer.setDelay(delay);
		}
		
			
}


