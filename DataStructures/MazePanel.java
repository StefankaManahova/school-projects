package edu.projects;

import java.util.Stack;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
	//8x8
	private Location[][] maze;
	private Stack<Location> path = new Stack<Location>();
	private Location start;
	private int sideSize = 8;
	
	public MazePanel(){
		Location.setHeight(this.getHeight()/8 - 10);
		Location.setWidth(this.getWidth()/8 - 10);
		
		for(int i = 0; i < 8; i++){
			
			
		}
	}
}
