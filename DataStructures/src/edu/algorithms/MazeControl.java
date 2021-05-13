package edu.algorithms;

import java.awt.BorderLayout;

import javax.swing.*;

public class MazeControl extends JPanel {
	private MazePanel mazePanel = new MazePanel("src/edu/algorithms/mazes.txt");
	
	private JButton findPath = new JButton("Find Path");
	private JButton clearPath = new JButton("Clear Path");
	
	public MazeControl() {

		setLayout(new BorderLayout());
		JPanel buttonsPanel = new JPanel();
		//int buttonLength = 70;
		buttonsPanel.add(findPath);
		buttonsPanel.add(clearPath);
		buttonsPanel.setBackground(MazePanel.background);
		
		add(mazePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

	}
}
