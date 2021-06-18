package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JPanel;

public class CatanPanel extends JPanel{
	Color player1Colour = new Color(179, 0, 0);
	Color player2Colour = new Color(0, 0, 153);
	Color player3Colour = new Color(90, 0, 90);
	Color player4Colour = new Color(77, 26, 0);
	
	Player player1 = new Player(player1Colour);
	Player player2 = new Player(player2Colour);
	Player player3 = new Player(player3Colour);
	Player player4 = new Player(player4Colour);
	
	Queue<Player> players = new ArrayDeque<Player>(){{
		offer(player1);
		offer(player2);
		offer(player3);
		offer(player4);
	}};
	GameBoardPanel gameBoard = new GameBoardPanel();
	
	PlayerPanel pnl1 = new PlayerPanel(player1,'-');
	PlayerPanel pnl2 = new PlayerPanel(player2,'|');
	PlayerPanel pnl3 = new PlayerPanel(player3,'-');
	PlayerPanel pnl4 = new PlayerPanel(player4,'|');
	
	DiceControl dice = new DiceControl();
	DiceControl dice2 = new DiceControl();
	
	public CatanPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setPreferredSize(new Dimension(200, 590));
		
		leftPanel.add(pnl4, BorderLayout.CENTER);
		dice2.setPreferredSize(new Dimension(200, 140));
		leftPanel.add(dice2, BorderLayout.NORTH);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setPreferredSize(new Dimension(200, 590));
		 
		rightPanel.add(pnl2, BorderLayout.CENTER);
		rightPanel.add(dice, BorderLayout.SOUTH);
		dice.setPreferredSize(new Dimension(200, 140));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new BorderLayout());
		pnl1.setPreferredSize(new Dimension(500,110));
		pnl3.setPreferredSize(new Dimension(500,110));
		centerPanel.add(pnl1, BorderLayout.SOUTH);
		centerPanel.add(pnl3, BorderLayout.NORTH);
		centerPanel.add(gameBoard, BorderLayout.CENTER);
		
		add(rightPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);
		
	}
}
