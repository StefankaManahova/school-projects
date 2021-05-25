package edu.algorithms;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class XOControl extends JPanel {
	private XOPanel gameBoard = new XOPanel();
	private JLabel players = new JLabel("X - Player A   O - Player B");;
	public static JLabel winner = new JLabel("Who will win?!");
	
	public XOControl() {
		setLayout(new BorderLayout());
		
		JPanel upperPanel = new JPanel();
		players.setFont(new Font("Calibri", Font.PLAIN, 18));
	
		upperPanel.add(players);
		upperPanel.setBackground(XOPanel.background);
		
		JPanel pnlWinner = new JPanel();
		pnlWinner.add(winner);
		winner.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		pnlWinner.setBackground(XOPanel.background);
		
		add(upperPanel, BorderLayout.NORTH);
		add(gameBoard, BorderLayout.CENTER);
		add(pnlWinner, BorderLayout.SOUTH);
		
	}
	
	
	
}
