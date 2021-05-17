package edu.projects;
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
	
	public MazePanel(){
		rows = 8;
		columns = 8;
		this.maze = new Location[rows][];
		for (int i = 0; i < rows; i++) {
			 this.maze[i] = new Location[columns];
	         for (int j = 0; j < columns; j++) {
	        	 this.maze[i][j] = new Location(i,j);
	        	 if (i == 0 || i == rows - 1) {
	        		 maze[i][j].setType(Location.wall);		 
	        	 }
	        	 else if ((i == 1 && j > 0 && j < columns - 1) || (i == rows - 2 && j > 0 && j < columns - 1)) {
	        		 maze[i][j].setType(Location.wall);	
	        	 } else {	 
	        		 maze[i][j].setType((int)(Math.random() * 4));	;
	        	 }
	         }
	    }
		start = new Location(0, 0);
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
					if (maze[i][j].getType() == Location.wall) {
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
	public Stack<Location> findPath () {
		path.push(start);
		
		while (true) {
			int y = path.peek().getY();
			int x = path.peek().getX();

			maze[y][x].setType(Location.alreadyVisited); // marking the positions I have already been on with zero, so we avoid going in
								// circles

			// down
			if (isValid(y + 1, x, this.maze)) {
				if (maze[y + 1][x].getType() == Location.destination) {
					System.out.println("Moved down");
					return path;
				} else if (maze[y + 1][x].getType() != Location.destination && maze[y + 1][x].getType() != Location.wall && maze[y + 1][x].getType() == Location.alreadyVisited) {
					System.out.println("Moved down");
					path.push(new Location(y + 1, x));
					continue;
				}
			}

			// left
			if (isValid(y, x - 1, m)) {
				if (maze[y][x - 1].getType() == Location.destination) {
					System.out.println("Moved left");
					return path;
				} else if (maze[y][x - 1].getType() != Location.destination && maze[y][x - 1].getType() != Location.wall && maze[y][x - 1].getType() == Location.alreadyVisited) {
					System.out.println("Moved left");
					path.push(new Location(y + 1, x));
					continue;
				}}
			}

			// up
			if (isValid(y - 1, x, m)) {
				if (m.maze[y - 1][x] == 2) {
					System.out.println("Moved up");
					return true;
				} else if (m.maze[y - 1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y - 1, x));
					continue;
				}
			}

			// right
			if (isValid(y, x + 1, m)) {
				if (m.maze[y][x + 1] == 2) {
					System.out.println("Moved right");
					return true;
				} else if (m.maze[y][x + 1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x + 1));
					continue;
				}
			}

			m.path.pop(); // going back in case we have reached a dead end
			System.out.println("Moved back");
			if (m.path.size() <= 0 && start == maze[rows - 1][0]) { // nowhere new to go
				return ;
			}
	   }
	}		
	public static boolean isValid(int y, int x, Location[][] maze) {
		if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
			return false;
		}
		    return true;
		}
}
