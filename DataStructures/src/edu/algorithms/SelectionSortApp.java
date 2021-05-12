package edu.algorithms;

import javax.swing.JFrame;

public class SelectionSortApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(new SelectionSortControl());
		frame.setTitle("Sorty");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
