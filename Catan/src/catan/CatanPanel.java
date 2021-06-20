package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CatanPanel extends JPanel{
	Color player1Colour = new Color(179, 0, 0);
	Color player2Colour = new Color(0, 0, 153);
	Color player3Colour = new Color(90, 0, 90);
	Color player4Colour = new Color(77, 26, 0);
	
	PlayerPanel pnl1 = new PlayerPanel('-');
	PlayerPanel pnl2 = new PlayerPanel('|');
	PlayerPanel pnl3 = new PlayerPanel('-');
	PlayerPanel pnl4 = new PlayerPanel('|');
	
	Player player1 = new Player(player1Colour, pnl1);
	Player player2 = new Player(player2Colour, pnl2);
	Player player3 = new Player(player3Colour, pnl3);
	Player player4 = new Player(player4Colour, pnl4);
	
	ArrayDeque<Player> players = new ArrayDeque<Player>(){{
		offer(player1);
		offer(player2);
		offer(player3);
		offer(player4);
	}};
	GameBoardPanel gameBoard = new GameBoardPanel(players);
	
	DiceControl dice = new DiceControl();
	DiceControl dice2 = new DiceControl();
	
	JButton buildingInfo = new JButton("Building info");
	
	static int winningScore = 10;
	boolean hasWinner = false;
	Font boldFont = new Font("Calibri", Font.BOLD, 17);
	
	public CatanPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		pnl1.buildVillage.setFont(boldFont);
		for(Player player : players) {
			player.panel.currentScore.setForeground(player.colour);
		}
		
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
		 
		JPanel pnlInfo = new JPanel();
		//pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.X_AXIS));
		pnlInfo.add(buildingInfo);
		buildingInfo.setFont(PlayerPanel.font);
		pnlInfo.setBackground(Color.WHITE);
		
		rightPanel.add(pnlInfo, BorderLayout.NORTH);
		rightPanel.add(pnl2, BorderLayout.CENTER);
		rightPanel.add(dice, BorderLayout.SOUTH);
		dice.setPreferredSize(new Dimension(200, 140));
		pnlInfo.setPreferredSize(new Dimension(200, 40));
		
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
		
		buildingInfo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String infoRoad = "Necessary resources:\nRoad: 1 x wood & 1 x bricks" + "\nVillage: 1 x wood & 1 x bricks & 1 x wheat & 1 x wool"
						+ "\nTown: 2 x wheat && 3 x rock";
				JLabel lblInfo = new JLabel("<html>" + infoRoad.replaceAll("\n", "<br/>") + "</html>");
				lblInfo.setFont(PlayerPanel.font);
				JOptionPane.showMessageDialog(null,lblInfo, "Necessary resources for building", JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		
		dice.roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Player player = players.peek();
				if(player.getStage() == Player.rollDiceStage) {
					int result = dice.dicePanel.roll();
					for(Field field : gameBoard.fields) {
						if(result == field.number) {
							field.distributeResources();
						}
						else if(result == 7) {
							gameBoard.stage = GameBoardPanel.moveBanditsStage;
						}
					}
					player.setStage(Player.normalGameMoveStage);
					dice.roll.setFont(PlayerPanel.font);
					
					player.panel.buildRoad.setFont(boldFont);
					player.panel.buildVillage.setFont(boldFont);
					player.panel.buildTown.setFont(boldFont);
					player.panel.readyWithMove.setFont(boldFont);
				}
			}
		});
		
		for(Player player : players) {
			player.panel.buildVillage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(player.equals(players.peek()) && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false) {
						if(player.getStage() == Player.putFirstVillageStage) {
							gameBoard.setStage(GameBoardPanel.putVillageStage);
						}
						else if(player.getStage() == Player.putSecondVillageStage) {
							gameBoard.setStage(GameBoardPanel.putVillageStage);
							if(player == player4) {
								dice.roll.setFont(boldFont);
							}
						}
						else if(player.getStage() == Player.normalGameMoveStage){
							//System.out.println("normalStage");
							if(player.resources.get("tree") >= 1 && player.resources.get("bricks") >= 1 && player.resources.get("wool") >= 1
								&& player.resources.get("wheat") >= 1) {
								if(!gameBoard.freePointsAvailable(player)) {
									JLabel lblNoFreePointsAvailable = new JLabel("Sorry, there aren't any available points for you to build a village on. Maybe next time! :)");
									lblNoFreePointsAvailable.setFont(PlayerPanel.font);
									JOptionPane.showMessageDialog(null,lblNoFreePointsAvailable, "No available points",JOptionPane.INFORMATION_MESSAGE);
								} else {
									player.resources.put("tree", player.resources.get("tree") - 1);
									player.resources.put("bricks", player.resources.get("bricks") - 1);
									player.resources.put("wool", player.resources.get("wool") - 1);
									player.resources.put("wheat", player.resources.get("wheat") - 1);
									player.updateResourcesLabels();
									player.setChoosingPlacesForBuilding(true);
									
									gameBoard.setStage(GameBoardPanel.putVillageStage);
								}
							}
							else {
								JLabel lblNotEnoughResources = new JLabel("Sorry, you don't have enough resources to build a village. Maybe next time! :)");
								lblNotEnoughResources.setFont(PlayerPanel.font);
								JOptionPane.showMessageDialog(null,lblNotEnoughResources, "Not enough resources",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			});
			
			player.panel.buildRoad.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(player.equals(players.peek()) && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false){
						//first and second roads are regulated by GameBoardPanel(when the forst and second
						//villages are built
						if(player.getStage() == Player.normalGameMoveStage){
							if(player.resources.get("tree") >= 1 && player.resources.get("bricks") >= 1) {
								if(!gameBoard.freeRoadsAvailable(player)) {
									JLabel lblNoFreeRoadsAvailable = new JLabel("Sorry, there aren't any available places for you to build a road on. Maybe next time! :)");
									lblNoFreeRoadsAvailable.setFont(PlayerPanel.font);
									JOptionPane.showMessageDialog(null,lblNoFreeRoadsAvailable, "No available roads",JOptionPane.INFORMATION_MESSAGE);
								} else {
									player.resources.put("tree", player.resources.get("tree") - 1);
									player.resources.put("bricks", player.resources.get("bricks") - 1);
									player.updateResourcesLabels();
									player.setChoosingPlacesForBuilding(true);
									
									gameBoard.setStage(GameBoardPanel.putRoadStage);
								}
							}
							else {
								JLabel lblNotEnoughResources = new JLabel("Sorry, you don't have enough resources to build a road. Maybe next time! :)");
								lblNotEnoughResources.setFont(PlayerPanel.font);
								JOptionPane.showMessageDialog(null,lblNotEnoughResources, "Not enough resources",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			});
			
			player.panel.readyWithMove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(players.peek() == player && player.getStage() == Player.normalGameMoveStage && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false) {
						players.poll();
						players.offer(player);
						Player nextPlayer = players.peek();
						nextPlayer.setStage(Player.rollDiceStage);
						
						player.panel.buildRoad.setFont(PlayerPanel.font);
						player.panel.buildVillage.setFont(PlayerPanel.font);
						player.panel.buildTown.setFont(PlayerPanel.font);
						player.panel.readyWithMove.setFont(PlayerPanel.font);
						
						dice.roll.setFont(boldFont);
						
						if(player.score >= winningScore) {
							hasWinner = true;
							String winner = "";
							if(player == player1) {
								winner = "Player 1 (red) ";
							}
							else if(player == player2) {
								winner = "Player 2 (blue) ";
							}
							if(player == player3) {
								winner = "Player 3 (purple) ";
							}
							if(player == player4) {
								winner = "Player 4 (brown) ";
							}
							JLabel lblWinner = new JLabel("Congratulations!" + winner + "is the winner!");
							lblWinner.setFont(PlayerPanel.font);
							JOptionPane.showMessageDialog(null, lblWinner, "The end",JOptionPane.INFORMATION_MESSAGE);
						}
					 }
				}
		    });
	     }
	}
}
