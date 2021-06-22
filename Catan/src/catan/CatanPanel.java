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
//this is the main panel that contains all the components
public class CatanPanel extends JPanel{
	Color player1Colour = new Color(179, 0, 0);
	Color player2Colour = new Color(0, 0, 153);
	Color player3Colour = new Color(90, 0, 90);
	Color player4Colour = new Color(77, 26, 0);
	
	PlayerPanel pnl1 = new PlayerPanel('-');
	PlayerPanel pnl2 = new PlayerPanel('|');
	PlayerPanel pnl3 = new PlayerPanel('-');
	PlayerPanel pnl4 = new PlayerPanel('|');
	
	//each player has a reference to its panel that is given in the constructor
	Player player1 = new Player(player1Colour, pnl1);
	Player player2 = new Player(player2Colour, pnl2);
	Player player3 = new Player(player3Colour, pnl3);
	Player player4 = new Player(player4Colour, pnl4);
	
	//creating a queue for the players so we can keep track of who is on turn
	ArrayDeque<Player> players = new ArrayDeque<Player>(){{
		offer(player1);
		offer(player2);
		offer(player3);
		offer(player4);
	}};
	//creating a panel containing the game board
	GameBoardPanel gameBoard = new GameBoardPanel(players);
	
	DiceControl dice = new DiceControl();
	ExchangePanel exchange = new ExchangePanel();
	
	JButton buildingInfo = new JButton("Building info");
	
	static int winningScore = 10;
	
	//indicating whether there is already a winner or not
	boolean hasWinner = false;
	Font boldFont = new Font("Calibri", Font.BOLD, 17);
	
	public CatanPanel() {
		//creating the desired layout
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		pnl1.buildVillage.setFont(boldFont);
		for(Player player : players) {
			player.panel.currentScore.setForeground(player.colour);
		}
		//the left and right panels contain buttons and info about two of the players
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setPreferredSize(new Dimension(200, 590));
		
		leftPanel.add(pnl4, BorderLayout.CENTER);
		exchange.setPreferredSize(new Dimension(200, 140));
		leftPanel.add(exchange, BorderLayout.NORTH);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setPreferredSize(new Dimension(200, 590));
		 
		//adding a button for more information about building
		JPanel pnlInfo = new JPanel();
		pnlInfo.add(buildingInfo);
		buildingInfo.setFont(PlayerPanel.font);
		pnlInfo.setBackground(Color.WHITE);
		
		rightPanel.add(pnlInfo, BorderLayout.NORTH);
		rightPanel.add(pnl2, BorderLayout.CENTER);
		rightPanel.add(dice, BorderLayout.SOUTH);
		dice.setPreferredSize(new Dimension(200, 140));
		pnlInfo.setPreferredSize(new Dimension(200, 40));
		
		/*the center panel contains the board 
		with the panels of the other two players above and below*/
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
		
		//adding functionality to the buildingInfo button
		buildingInfo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String infoRoad = "Necessary resources:\nRoad: 1 x wood & 1 x bricks" + "\nVillage: 1 x wood & 1 x bricks & 1 x wheat & 1 x wool"
						+ "\nTown: 2 x wheat & 3 x rock";
				JLabel lblInfo = new JLabel("<html>" + infoRoad.replaceAll("\n", "<br/>") + "</html>");
				lblInfo.setFont(PlayerPanel.font);
				JOptionPane.showMessageDialog(null,lblInfo, "Necessary resources for building", JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		
		//adding functionality to the exchange button
		exchange.btnExchange.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Player player = players.peek();
				//adding some conditions in which the button won't be active
				if(player.getStage() == Player.normalGameMoveStage && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false)
					try {
						exchange.exchange3for1(players.peek());
					} catch (InvalidExchangeException e) {
						JLabel lblInvalidExchange = new JLabel(e.toString());
						lblInvalidExchange.setFont(PlayerPanel.font);
						JOptionPane.showMessageDialog(null,lblInvalidExchange, "Invalid exchange", JOptionPane.ERROR_MESSAGE);
					}		
			}
		});
		
		//adding functionality to the dice
		dice.roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Player player = players.peek();
				if(player.getStage() == Player.rollDiceStage) {
					int result = dice.dicePanel.roll();
					
					/*finding all fields with this number and adding the new resources to the players 
					that have built settlements there*/
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
					
					//changing the fonts of the buttons so only those of the player in turn are bold
					player.panel.buildRoad.setFont(boldFont);
					player.panel.buildVillage.setFont(boldFont);
					player.panel.buildTown.setFont(boldFont);
					player.panel.readyWithMove.setFont(boldFont);
				}
			}
		});
		
		//adding functionality to the buttons of each player's panel
		for(Player player : players) {
			player.panel.buildVillage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					/*it is necessary that the button is active only when the player is on turn along
					with some other requirements about the current stage of the game*/
					if(player.equals(players.peek()) && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false) {
						
						//in case this is the player's first village
						if(player.getStage() == Player.putFirstVillageStage) {
							gameBoard.setStage(GameBoardPanel.putVillageStage);
						}
						//in case this is the player's second village
						else if(player.getStage() == Player.putSecondVillageStage) {
							gameBoard.setStage(GameBoardPanel.putVillageStage);
							if(player == player4) {
								dice.roll.setFont(boldFont);
							}
						}
						//in case it is a normal game move for the player
						else if(player.getStage() == Player.normalGameMoveStage){
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
			
			//adding functionality to the buildRoad button
			player.panel.buildRoad.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(player.equals(players.peek()) && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false){
						//first and second roads are regulated by GameBoardPanel(when the forst and second
						//villages are built
						if(player.getStage() == Player.normalGameMoveStage){
							if(player.resources.get("tree") >= 1 && player.resources.get("bricks") >= 1) {
								/*even if the player has the necessary resources, we still have to check
								if there are any available places to put a road on*/
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
			
			//adding functionality to the buildTown button
			player.panel.buildTown.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(player.equals(players.peek()) && player.getStage() == Player.normalGameMoveStage && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false){
						//checking if the player has the necessary resources
						if(player.resources.get("wheat") >= 2 && player.resources.get("rock") >= 3) {
							//checking if there are any avalable villages to be expanded into towns
							if(!gameBoard.availableVillagesToExpandIntoTowns(player)) {
								JLabel lblNoAvailableVillages = new JLabel("Sorry, there aren't any available villages for you to expand into towns. Maybe next time! :)");
								lblNoAvailableVillages.setFont(PlayerPanel.font);
								JOptionPane.showMessageDialog(null,lblNoAvailableVillages, "No available villages",JOptionPane.INFORMATION_MESSAGE);
							} else {
								player.resources.put("wheat", player.resources.get("wheat") - 2);
								player.resources.put("rock", player.resources.get("rock") - 3);
								player.updateResourcesLabels();
								player.setChoosingPlacesForBuilding(true);
								
								gameBoard.setStage(GameBoardPanel.putTownStage);
							}
						}
						else {
							JLabel lblNotEnoughResources = new JLabel("Sorry, you don't have enough resources to build a town. Maybe next time! :)");
							lblNotEnoughResources.setFont(PlayerPanel.font);
							JOptionPane.showMessageDialog(null,lblNotEnoughResources, "Not enough resources",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			
			//adding functionality to the readyWithMove button
			player.panel.readyWithMove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(players.peek() == player && player.getStage() == Player.normalGameMoveStage && gameBoard.stage != GameBoardPanel.moveBanditsStage && !hasWinner && player.isChoosingPlacesForBuilding() == false) {
						//if a player has reached the winning score, they become the winner
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
							JLabel lblWinner = new JLabel("Congratulations! " + winner + "is the winner!");
							lblWinner.setFont(PlayerPanel.font);
							JOptionPane.showMessageDialog(null, lblWinner, "The end",JOptionPane.INFORMATION_MESSAGE);
						}
						//if there is no winner yet, add the current player at the end of the queue 
						//the next player in the queue is now on turn
						else {
							players.poll();
							players.offer(player);
							Player nextPlayer = players.peek();
							nextPlayer.setStage(Player.rollDiceStage);
							
							/*indicating that the player is no longer on turn by
							making the font plain again*/
							player.panel.buildRoad.setFont(PlayerPanel.font);
							player.panel.buildVillage.setFont(PlayerPanel.font);
							player.panel.buildTown.setFont(PlayerPanel.font);
							player.panel.readyWithMove.setFont(PlayerPanel.font);
							
							dice.roll.setFont(boldFont);
						}
					 }
				}
		    });
	     }
	}
}
