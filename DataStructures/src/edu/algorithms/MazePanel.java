package edu.algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
	//8x8
	private Location[][] maze;
	private Stack<Location> path = new Stack<Location>();
	private Location start;
	private int rows = 0;
	private int columns = 0;
	private boolean exists = true;
	
	public static Color background = new Color(159, 245, 183);
	
	public MazePanel(String filePath){
//		try {
//			exists = true;
//			Scanner sc = new Scanner(new File(filePath));
//			while (sc.hasNextLine()) {
//				rows++;
//			}
//			
//			this.setRows(rows);
//			if(rows ==0) {
//				exists  = false;
//			}
//			else {
//				this.maze = new Location[rows][];
//				
//				Scanner in = new Scanner(filePath);
//				sc = in;
//				for(int i = 0; i < rows; i++){
//					String line = sc.nextLine();
//					String[] numbers = line.split(", ");
//					this.setColumns(numbers.length);
//					if (columns == 0) {
//						exists = false;
//						break;
//					}
//					else {
//						this.maze[i] = new Location[columns];
//						for(int j = 0; j < columns; j++) {
//							maze[i][j].setType(Integer.parseInt(numbers[j]));
//						}
//
//					}
//				}
//				repaint();
//			}
//			
//		} catch(Exception e) {
//			exists = false;
//			e.printStackTrace();
//		}
		
		rows = 8;
		columns = 8;
		this.maze = new Location[rows][];
		for (int i = 0; i < rows; i++) {
			 this.maze[i] = new Location[columns];
	         for (int j = 0; j < columns; j++) {
	        	 maze[i][j] = new Location(i,j);
	        	 maze[i][j].setType((int)(Math.random() * 2));
	         }
	    }
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(background);
		
		if(exists) {
			int height = (this.getHeight() - 3)/rows - 1;
			int width = (this.getWidth()- 3)/columns - 1;
			
			for (int i = 0; i < rows; i++) {
				int Y = (this.getHeight() - rows*(height + 1) + 1)/2 + i*(height + 1);
				for(int j = 0; j < columns; j++) {
					int X = (this.getWidth() - columns*(width + 1) + 1)/2  + j*(width + 1);
					g.setColor(Color.WHITE);
					g.fillRect(X, Y, width, height);
					if (maze[i][j].getType() == 0) {
						g.setColor(Color.BLACK);
						g.drawLine(X, Y, X + width, Y + height);
						g.drawLine(X + width, Y, X, Y + height);
					}
				}
			}
		}
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		if(rows > 0 && rows < 12) {
			this.rows = rows;
		}
	}
	
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		if(columns > 0 && columns < 15) {
			this.columns = columns;
		}
	}
}
