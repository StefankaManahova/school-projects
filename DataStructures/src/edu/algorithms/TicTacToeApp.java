package edu.algorithms;

import javax.swing.JFrame;

public class TicTacToeApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(360, 420);
		frame.add(new XOControl());
		frame.setTitle("Tic-Tac-Toe");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
