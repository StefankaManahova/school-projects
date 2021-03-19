package edu.collections;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class BounceBallApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(new BallControl());
		frame.setTitle("Bouncy");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
