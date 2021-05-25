package edu.algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class XOPanel extends JPanel{
	private int[][] board;
	private int side = 3;
	private boolean AIsOnTurn = true;
	private boolean winner = false;
	
	public static Color background = new Color(255, 179, 255);
	public static Color XColour = new Color(128, 0, 51);
	public static Color OColour = new Color(35, 35, 144);
	
	
	public XOPanel() {
		this.board = new int[side][side];
		for (int i = 0; i < side; i++) {
			this.board[i] = new int[side];
			for (int j = 0; j < side; j++) {
				board[i][j] = 0;
			}
			
		}
		repaint();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = chosenSquareI(e.getY());
				int j = chosenSquareJ(e.getX());
				if(i != -1 && j != -1 && board[i][j] == 0 && !winner) {
					if(AIsOnTurn) {
						board[i][j] = 1;
						AIsOnTurn = false;
					}
					else {
						board[i][j] = 2;
						AIsOnTurn = true;
					}
				}
				repaint();
				String result = checkForWinner();
				if(result != "no") {
					XOControl.winner.setText(result);
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(background);
		
		int height = (this.getHeight() - 3)/side - 1;
		int width = (this.getWidth()- 3)/side - 1;
			
		for (int i = 0; i < side; i++) {
			int Y = (this.getHeight() - side*(height + 1) + 1)/2 + i*(height + 1);
			for (int j = 0; j < side; j++) {
				int X = (this.getWidth() - side*(width + 1) + 1)/2  + j*(width + 1);
				g.setColor(Color.WHITE);
				g.fillRect(X, Y, width, height);
			    if (board[i][j] == 1) {// 1 = X
				    g.setColor(XColour);
					int[] xpoints1 = {X + 10, X + 18, X + width - 10, X + width - 18};
					int [] ypoints1 = {Y + 10, Y + 10, Y + height - 10, Y + height - 10};
					Polygon firstLine = new Polygon(xpoints1, ypoints1,4);
					g.fillPolygon(firstLine);
					
					int[] xpoints2 = {X + width - 18, X + width - 10, X + 18, X + 10};
					int [] ypoints2 = {Y + 10, Y + 10, Y + height - 10, Y + height - 10};
					Polygon secondLine = new Polygon(xpoints2, ypoints2,4);
					g.fillPolygon(secondLine);
				}
			    else if(board[i][j] == 2) {//2 = O
			    	if (width < height) {
				    	g.setColor(OColour);
				    	g.fillOval(X + 10, Y + 10 + (height - width)/2, width - 20, width - 20);
				    	g.setColor(Color.WHITE);
				    	g.fillOval(X + 18, Y + 18 + (height - width)/2, width - 36, width - 36);
			    	}
			    	else {
			    		g.setColor(OColour);
				    	g.fillOval(X + 10+ (width - height)/2, Y + 10, height - 20, height - 20);
				    	g.setColor(Color.WHITE);
				    	g.fillOval(X + 18+ (width - height)/2, Y + 18, height - 36, height - 36);
			    	}
			    }
			}
		}
	}
	
	private int chosenSquareJ(int x) {
		int width = (this.getWidth()- 3)/side- 1;
		
		for (int j = 0; j < side; j++) {
			int X = (this.getWidth() - side*(width + 1) + 1)/2 + j*(width + 1);
			int nextX = X + width + 1;
			if (x >= X && x < nextX) {
				return j;
			}
		}
		return -1;
	}

	private int chosenSquareI(int y) {
		int height = (this.getHeight()- 3)/side - 1;
		
		for (int i = 0; i < side; i++) {
			int Y = (this.getHeight() - side*(height + 1) + 1)/2 + i*(height + 1);
			int nextY = Y + height + 1;
			if (y >= Y && y < nextY) {
				return i;
			}
		}
		return -1;
	}
	
	public String checkForWinner() {
		for (int i = 0; i < side; i++) {
			winner = true;
			for (int j = 0; j < side - 1; j++) {
				if(board[i][j] != board[i][j + 1] || board[i][j] == 0) {
					winner = false;
					break;
				}
			}
			if (winner) {
				if(AIsOnTurn) {
					return "The winner is player B!";
				}
				else {
					return "The winner is player A!";
				}
			}
		}
		
		for (int j = 0; j < side; j++) {
			winner = true;
			for (int i = 0; i< side - 1; i++) {
				if(board[i][j] != board[i + 1][j] || board[i][j] == 0) {
					winner = false;
					break;
				}
			}
			if (winner) {
				if(AIsOnTurn) {
					return "The winner is player B!";
				}
				else {
					return "The winner is player A!";
				}
			}
		}
		
		winner = true;
		for (int i = 0; i < side - 1; i++) {
			if(board[i][i] != board[i + 1][i + 1] || board[i][i] == 0) {
				winner = false;
				break;
			}
		}
		if (winner) {
			if(AIsOnTurn) {
				return "The winner is player B!";
			}
			else {
				return "The winner is player A!";
			}
		}
		
		winner = true;
		for (int i = 0; i < side - 1; i++) {
			if(board[i][side - i - 1] != board[i + 1][side - i - 2] || board[i][side - i - 1] == 0) {
				winner = false;
				break;
			}
		}
		if (winner) {
			if(AIsOnTurn) {
				return "The winner is player B!";
			}
			else {
				return "The winner is player A!";
			}
		}
		else if (isFull()) {
			return "It's a tie!";
		}
		else {
			return "no";
		}
		
		
	}

	private boolean isFull() {
		for (int i = 0; i < side; i++) {
			for(int j = 0; j < side; j++) {
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
