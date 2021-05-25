package edu.algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
	//8x8
	private int[][] maze;
	private Stack<Position> path = new Stack<Position>();
	private Position start;
	private int rows = 0;
	private int columns = 0;
	private boolean paintPath = false;
	
	public static Color background = new Color(159, 245, 183);
	public static Color wallColour = new Color(0, 128, 43);
	
	//позициите, маркирани с 1 и 2, са свободни
	private final static int wall = 0;
	private final static int destination = 4;
	private final static int alreadyVisited = -1;
	
	public MazePanel(){
		rows = 8;
		columns = 8;
		this.maze = new int[rows][];
		for (int i = 0; i < rows; i++) {
			 this.maze[i] = new int[columns];
	         for (int j = 0; j < columns; j++) {
	        	 if (i == 0 || i == rows - 1) {
	        		 maze[i][j] = wall;		 
	        	 }
	        	 else if ((i == 1 && j > 0 && j < columns - 1) || (i == rows - 2 && j > 0 && j < columns - 1)) {
	        		 maze[i][j] = wall;	
	        	 }
	        	 else if (j == columns - 1) {
	        		 maze[i][j] = destination;
	        	 }
	        	 else {	 
	        		 maze[i][j] = (int)(Math.random() * 4);	
	        	 }
	         }
	    }
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(background);
		
		int height = (this.getHeight() - 3)/rows - 1;
		int width = (this.getWidth()- 3)/columns - 1;
			
		for (int i = 0; i < rows; i++) {
			int Y = (this.getHeight() - rows*(height + 1) + 1)/2 + i*(height + 1);
			for(int j = 0; j < columns; j++) {
				int X = (this.getWidth() - columns*(width + 1) + 1)/2  + j*(width + 1);
				g.setColor(Color.WHITE);
				g.fillRect(X, Y, width, height);
				if (maze[i][j] == 0) {
//					g.setColor(Color.BLACK);
//					g.drawLine(X, Y, X + width, Y + height);
//					g.drawLine(X + width, Y, X, Y + height);
					g.setColor(wallColour);
					g.fillRect(X, Y, width, height);
				}
			}
		}
		if (!path.isEmpty()) {
			for (Position position : path) {
				int i = position.getY();
				int j = position.getX();
				int Y = (this.getHeight() - rows*(height + 1) + 1)/2 + i*(height + 1);
				int X = (this.getWidth() - columns*(width + 1) + 1)/2  + j*(width + 1);
				
				int diameterSmall = width/6;
				int XsmallCircle1 = X + width/4 - diameterSmall - 1;
				int YsmallCircle1 = Y + (height/3 - diameterSmall)/2;
				
				int heightBig = height/3;
				int widthBig = width/2;
				int XbigCircle1 = X + width/4;
				int YbigCircle1 = Y;
				
				int XsmallCircle2 = X + width - width/2 - diameterSmall - 1;
				int YsmallCircle2 = Y + height/3 + (height - (height/3)*2) + (width/3 - diameterSmall)/2; 
				
				int XbigCircle2 = X + width - width/2;
				int YbigCircle2 = Y + height/3 + (height - (height/3)*2);
				g.setColor(Color.YELLOW);
				g.fillOval(XsmallCircle1, YsmallCircle1, diameterSmall, diameterSmall);
				g.fillOval(XsmallCircle2, YsmallCircle2, diameterSmall, diameterSmall);
				g.fillOval(XbigCircle1, YbigCircle1, widthBig, heightBig);
				g.fillOval(XbigCircle2, YbigCircle2, widthBig, heightBig);
				
			}
		}
	}
	
	public String findPath () {
		if(path.isEmpty()) {
			int startingY = 1;
			while (maze[startingY][0] == 0) {
				startingY++;
			}
			start = new Position(startingY, 0);
			path.push(start);
			
			while (true) {
				int y = path.peek().getY();
				int x = path.peek().getX();
	
				maze[y][x] = alreadyVisited; 
				
				// надясно
				if (isValid(y, x + 1, this.maze)) {
					if (maze[y][x + 1] == destination) {
						System.out.println("Moved right");
						path.push(new Position(y, x + 1));
						break;
					} else if (maze[y][x + 1] != wall && maze[y][x + 1] != alreadyVisited) {
						System.out.println("Moved right");
						path.push(new Position(y, x + 1));
						continue;
					}
				}
	
				// надолу
				if (isValid(y + 1, x, this.maze)) {
					if (maze[y + 1][x] == destination) {
						System.out.println("Moved down");
						path.push(new Position(y + 1, x));
						break;
					} else if (maze[y + 1][x] != wall && maze[y + 1][x] != alreadyVisited) {
						System.out.println("Moved down");
						path.push(new Position(y + 1, x));
						continue;
					}
				}
	
				// нагоре
				if (isValid(y - 1, x, this.maze)) {
					if (maze[y - 1][x] == destination) {
						System.out.println("Moved up");
						path.push(new Position(y - 1, x));
						break;
					} else if (maze[y - 1][x] != wall && maze[y - 1][x] != alreadyVisited) {
						System.out.println("Moved up");
						path.push(new Position(y - 1, x));
						continue;
					}
				}
	
				// наляво
				if (isValid(y, x - 1, this.maze)) {
					if (maze[y][x - 1] == destination) {
						System.out.println("Moved left");
						path.push(new Position(y, x - 1));
						break;
					} else if (maze[y][x - 1] != wall && maze[y][x - 1] != alreadyVisited) {
						System.out.println("Moved left");
						path.push(new Position(y, x - 1));
						continue;
					}
				}
	
				path.pop(); // връщаме се, в случай че сме попаднали на задънена улица
				System.out.println("Moved back");
				if (path.size() <= 0) {
					startingY = start.getY() + 1;
					while (maze[startingY][0] == 0 && startingY < rows - 1) {
						startingY++;
					}
					if (startingY < rows - 1) {
						start = new Position(startingY, 0);
						path.push(start);
						continue;
					} else {
						break;
					}
				}
			}
	   }
		repaint();
		
		if(path.isEmpty()) {
			return "Обречени сте. :(";	
		}
		else {
			return "Ето го пътя към свободата!";
		}
	}		
	public static boolean isValid(int y, int x, int[][] maze) {
		if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
			return false;
		}
		    return true;
		}
	public void clearPath() {
		while(!path.isEmpty()) {
			path.pop();
		}
		for (int i = 0; i < rows; i++) {
			for( int j = 0; j < columns; j++) {
				if (maze[i][j] == -1) {
					maze[i][j] = 1;
				}
			}
		}
		repaint();
	}
}
