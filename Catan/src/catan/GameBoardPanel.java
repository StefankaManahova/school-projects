package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* this is the panel that regulates the painting of the board and the building 
 * of roads, villages and towns
 */

public class GameBoardPanel extends JPanel {
	protected static double spaceRatio = 0.01;
	protected static double topBottomMarginsRatio = 0.05;
	
	protected static Color forestColour = new Color(0, 204, 68); 
	protected static Color clayColour = new Color(204, 68, 0);
	protected static Color fieldColour = new Color(83, 255, 26);
	protected static Color rockColour = new Color(122, 122, 82);
	protected static Color wheatColour = new Color(255, 204, 0);
	protected static Color desertColour = new Color(255, 153, 51);
	
	protected static Color banditsColour = new Color(51, 13, 0);
	protected Field currentFieldWithBandits;
	
	protected int side;
	protected int space;
	
	protected ArrayList<Field> fields;
	protected ArrayList<Integer> numbers;
	protected ArrayDeque<Player> players;
	
	
	protected double mouseClickRadiusRatio = 0.3;
	protected boolean firstPaint = true;
	
	protected HashSet<Point> allPoints = new HashSet<Point>();
	protected HashSet<Road> allRoads = new HashSet<Road>();
	
	protected final static int noActionStage = 0;
	protected final static int putRoadStage = 1;
	protected final static int putVillageStage = 2;
	protected final static int putTownStage = 3;
	protected final static int moveBanditsStage = 4;
	
	protected int stage;
	
	protected static Font boldFont = new Font("Calibri", Font.BOLD, 17);

	public GameBoardPanel(ArrayDeque<Player> players) {
		this.stage = noActionStage;
		this.players = players;
		
		fields = new ArrayList<Field>(){{
        add(new Field("tree"));
		add(new Field("tree"));	
		add(new Field("tree"));	
		add(new Field("tree"));
		
		add(new Field("desert", true));
		
		add(new Field("bricks"));	
		add(new Field("bricks"));
		add(new Field("bricks"));
		   
		add(new Field("wheat"));	
		add(new Field("wheat"));
		add(new Field("wheat"));
		add(new  Field("wheat"));
		   
		add(new Field("rock"));
		add(new Field("rock"));
		add(new Field("rock"));
		   
		add(new Field("wool"));
		add(new Field("wool"));
		add(new Field("wool"));
		add(new Field("wool"));	
		}};
		
		Collections.shuffle(fields);
		
		Integer[] zahlen = {2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
		numbers = new ArrayList<Integer>(Arrays.asList(zahlen));
		
		Collections.shuffle(numbers);

		Collections.shuffle(fields);

		/*adding functionality to each mouseclick, because that is the way 
		the players indicate where they want to build*/
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int mouseClickRadius = (int)(mouseClickRadiusRatio * side);
				int roundingUpMistake = space * 3 / 2;
				
				/*creating HashSets with points to add and points to remove,
				so that we don't change the lists while they are being iterated*/
				HashSet<Point> pointsToRemove = new HashSet<Point>();
				HashSet<Point> pointsToAdd = new HashSet<Point>();
				HashSet<Road> roadsToAdd = new HashSet<Road>();
				HashSet<Road> roadsToRemove = new HashSet<Road>();
				Player player =  players.peek();
				
				//specifying the rules of building a village
				if(stage == putVillageStage) {
					
					/*for each point currently available for the player
					 *  we check if it's free and within the allowed 
					mouse click radius*/	
					for(Point point : player.availablePoints) {
						if(distance(point.X, point.Y, e.getX(), e.getY()) < mouseClickRadius && point.free) {
							player.pointsWithVillages.add(point);
							point.free = false;//the point is no longer free
							
							//creating a new village and updating the score
							Settlement village = new Settlement(player, "village");
							village.addPoints();
							player.updateScoreLabel();
							
							//finding the fields around the village
							for(Field field : fields) {
								for(Point p : field.vertices) {
									if(distance(point,p) <= roundingUpMistake) {
										field.settlements.add(village);
										/*if this is the second village of the player,
										some resources must be distributed*/
										if(player.availablePoints.size() == allPoints.size() - 1) {
											village.addResources(field.type);
											player.updateResourcesLabels();
										}
									}
								}
							}
							
							//in case this is the first village
							if(player.availablePoints.containsAll(allPoints)) {
								pointsToRemove.add(point);
								stage = putRoadStage;
								player.setStage(Player.putFirstRoadStage);;
							}
							//in case this is the second village
							else if(player.availablePoints.size() == allPoints.size() - 1) {
								pointsToRemove.addAll(player.availablePoints);
								stage = putRoadStage;
								player.setStage(Player.putSecondRoadStage);
							}
							//in case it's a normal move
							else {
								pointsToRemove.add(point);
								stage = noActionStage;
							}
							/*When we build a village on a certain point, we need to mark
							 * the roads coming from it as available, and the three points next to it as 
							 * unavailable (not free for anyone). There are two types of points - ones with roads
							 * looking like 'Y', and others upside down (we'll call them Z)
							 */
							if(point.type == 'Y') {
								
								//specifying the coordinates of the available 3 roads
								int road1X = (int)(point.X + Math.sqrt(3) / 4 * side + space / 4);
								int road1Y = point.Y - side / 4;
								int road2X = (int)(point.X - Math.sqrt(3) / 4 * side + space / 4);
								int road2Y = point.Y - side / 4;
								int road3X = point.X;
								int road3Y = point.Y + side / 2 + space / 2;
								
								//specifying the coordinates of the unavailable 3 points
								int point1X = (int)(point.X + Math.sqrt(3) / 2 * side + space / 2);
								int point1Y = point.Y - side / 2;
								int point2X = (int)(point.X - Math.sqrt(3) / 2 * side + space / 2);
								int point2Y = point.Y - side / 2;
								int point3X = point.X;
								int point3Y = point.Y + side + space;
								
								/*marking all roads coming from the village as 'first', 
								 * so we can't build a new village right after them
								 */
								for(Road r : allRoads) {
									if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
									else if(distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
									else if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
								}
								
								//doing the same for the points
								for(Point p : allPoints) {
									if(distance(p.X, p.Y, point1X, point1Y) <= roundingUpMistake) {
										p.free = false;
									}
									else if(distance(p.X, p.Y, point2X, point2Y) <= roundingUpMistake) {
										p.free = false;
									}
									else if(distance(p.X, p.Y, point3X, point3Y) <= roundingUpMistake) {
										p.free = false;
									}
								}
							}
							
							//doing the same things with the other points (upside down Y)
							else if(point.type == 'Z') {
								int road1X = (int)(point.X + Math.sqrt(3) / 4 * side + space / 4);
								int road1Y = point.Y + side / 4;
								int road2X = (int)(point.X - Math.sqrt(3) / 4 * side + space / 4);
								int road2Y = point.Y + side / 4;
								int road3X = point.X;
								int road3Y = point.Y - side / 2 - space / 2;
								

								int point1X = (int)(point.X + Math.sqrt(3) / 2 * side + space / 2);
								int point1Y = point.Y + side / 2;
								int point2X = (int)(point.X - Math.sqrt(3) / 2 * side + space / 2);
								int point2Y = point.Y + side / 2;
								int point3X = point.X;
								int point3Y = point.Y - side - space;
								
								
								for(Road r : allRoads) {
									if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
									else if(distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
									else if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake && r.free) {
										r.isFirst = true;
										roadsToAdd.add(r);
									}
								}
								
								for(Point p : allPoints) {
									if(distance(p.X, p.Y, point1X, point1Y) <= roundingUpMistake) {
										p.free = false;
									}
									else if(distance(p.X, p.Y, point2X, point2Y) <= roundingUpMistake) {
										p.free = false;
									}
									else if(distance(p.X, p.Y, point3X, point3Y) <= roundingUpMistake) {
										p.free = false;
									}
								}
							}
							if(player.getStage() == Player.normalGameMoveStage) {
								player.setChoosingPlacesForBuilding(false);
							}
							break;
						}
					}
					
					/*finally, we remove all necessary roads and points from the available
					 * and also add the new available roads
					*/
					player.availableRoads.removeAll(roadsToRemove);
					player.availableRoads.addAll(roadsToAdd);
					
					player.availablePoints.removeAll(pointsToRemove);
					
					//we clear the sets with points and roads
					pointsToAdd.clear();
					pointsToRemove.clear();
					
					roadsToAdd.clear();
					roadsToRemove.clear();
				} 
				
				//specifying the rules of building a road
				else if(stage == putRoadStage) {
					//checking if the player has clicked on an available road
					for(Road road : player.availableRoads) {
						if(distance(road.X, road.Y, e.getX(), e.getY()) < mouseClickRadius && road.free) {
							stage = noActionStage;
							player.occupiedRoads.add(road);
							road.free = false;
							roadsToRemove.add(road);
							
							int road1X = 0, road1Y = 0, road2X = 0, road2Y = 0, road3X = 0, road3Y = 0, road4X = 0, road4Y = 0;
							
							/* For the roads we have 3 options - they can look like '/', like
							 * '\' and like '|'. We calculate the coordinate sof the available roads
							 * and points for each case individually.
							 */
							if(road.slope == '\\') {
								//we calculate the coordinates of the 4 roads crossing the chosen one
								road1X = (int)(road.X + Math.sqrt(3) / 2 * side + space / 2);
								road1Y = road.Y;
								
								road2X = (int)(road.X + Math.sqrt(3) / 4 * side + space / 4);
								road2Y = road.Y + 3 * side / 4 + space / 4;
								
								road3X = (int)(road.X - Math.sqrt(3) / 2 * side - space / 2);
								road3Y = road.Y;
								
								road4X = (int)(road.X - Math.sqrt(3) / 4 * side - space / 4);
								road4Y = road.Y - 3 * side / 4 - space / 4;
								
								if(!road.isFirst) {
									int point12X = road2X;
									int point12Y = road2Y - side / 2 - space / 2;
									
									int point34X = road4X;
									int point34Y = road4Y + side / 2 + space / 2;
									
									boolean occupied1or2 = false;
									boolean occupied3or4 = false;
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake || distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake) {
											occupied1or2 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied1or2) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
									
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake || distance(r.X, r.Y, road4X, road4Y) <= roundingUpMistake) {
											occupied3or4 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied3or4) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
								}
									
							}
							
							else if(road.slope == '/') {
								road1X = (int)(road.X + Math.sqrt(3) / 2 * side + space / 2);
								road1Y = road.Y;
								
								road2X = (int)(road.X + Math.sqrt(3) / 4 * side + space / 4);
								road2Y = road.Y - 3 * side / 4 - space / 4;
								
								road3X = (int)(road.X - Math.sqrt(3) / 2 * side - space / 2);
								road3Y = road.Y;
								
								road4X = (int)(road.X - Math.sqrt(3) / 4 * side - space / 4);
								road4Y = road.Y + 3 * side / 4 + space / 4;

								if(!road.isFirst) {
									int point12X = road2X;
									int point12Y = road2Y + side / 2 + space / 2;
									
									int point34X = road4X;
									int point34Y = road4Y - side / 2 - space / 2;
									
									boolean occupied1or2 = false;
									boolean occupied3or4 = false;
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake || distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake) {
											occupied1or2 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied1or2) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
									
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake || distance(r.X, r.Y, road4X, road4Y) <= roundingUpMistake) {
											occupied3or4 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied3or4) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
								}
								
							}
							
							else if(road.slope == '|') {
								road1X = (int)(road.X + Math.sqrt(3) / 4 * side + space / 4); 
								road1Y = road.Y + 3 * side / 4 + 3 * space / 4;
								
								road2X = (int)(road.X - Math.sqrt(3) / 4 * side - space / 4); 
								road2Y = road.Y + 3 * side / 4 + 3 * space / 4;
								
								road3X = (int)(road.X + Math.sqrt(3) / 4 * side + space / 4); 
								road3Y = road.Y - 3 * side / 4 - 3 * space / 4;
								
								road4X = (int)(road.X - Math.sqrt(3) / 4 * side - space / 4); 
								road4Y = road.Y - 3 * side / 4 - 3 * space / 4;
								

								if(!road.isFirst) {
									int point12X = road.X;
									int point12Y = road.Y + side / 2 + space / 2;
									
									int point34X = road.X;
									int point34Y = road.Y - side / 2 - space / 2;
									
									boolean occupied1or2 = false;
									boolean occupied3or4 = false;
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake || distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake) {
											occupied1or2 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied1or2) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point12X, point12Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
									
									for(Road r : player.occupiedRoads) {
										if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake || distance(r.X, r.Y, road4X, road4Y) <= roundingUpMistake) {
											occupied3or4 = true;
											for(Point point : allPoints) {
												if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
													point.free = false;
													pointsToRemove.add(point);
												}
											}
										}
									}
									if(!occupied3or4) {
										for(Point point : allPoints) {
											if(distance(point.X, point.Y, point34X, point34Y) <= roundingUpMistake) {
												pointsToAdd.add(point);
											}
										}
									}
								}
							}
							
							for(Road r : allRoads) {
								if(distance(r.X, r.Y, road1X, road1Y) <= roundingUpMistake && r.free) {
									roadsToAdd.add(r);
								}
								else if(distance(r.X, r.Y, road2X, road2Y) <= roundingUpMistake && r.free) {
									roadsToAdd.add(r);
								}
								else if(distance(r.X, r.Y, road3X, road3Y) <= roundingUpMistake && r.free) {
									roadsToAdd.add(r);
								}
								else if(distance(r.X, r.Y, road4X, road4Y) <= roundingUpMistake && r.free) {
									roadsToAdd.add(r);
								}
							}
							if(player.getStage() == Player.normalGameMoveStage) {
								player.setChoosingPlacesForBuilding(false);
							}
							
							//setting the new stages for the players and making the next player on turn
							if(player.getStage() == Player.putFirstRoadStage){
								player.setStage(Player.putSecondVillageStage);
								players.poll();
								players.offer(player);
								Player nextPlayer = players.peek();
								nextPlayer.panel.buildVillage.setFont(boldFont);
								player.panel.buildVillage.setFont(PlayerPanel.font);
							}
							else if(player.getStage() == Player.putSecondRoadStage) {
								player.setStage(Player.normalGameMoveStage);
								Color player4Colour = new Color(77, 26, 0);
								players.poll();
								players.offer(player);
								if(player.colour.equals(player4Colour)) {
									Player nextPlayer = players.peek();
									nextPlayer.setStage(Player.rollDiceStage);
									player.panel.buildVillage.setFont(PlayerPanel.font);
								}
								else {
									Player nextPlayer = players.peek();
									nextPlayer.panel.buildVillage.setFont(boldFont);
									player.panel.buildVillage.setFont(PlayerPanel.font);
								}
							}
							stage = noActionStage;
							break;
						}
					}
					player.availableRoads.removeAll(roadsToRemove);
					player.availableRoads.addAll(roadsToAdd);
					player.availablePoints.removeAll(pointsToRemove);
					player.availablePoints.addAll(pointsToAdd);
					
					roadsToRemove.clear();
					roadsToAdd.clear();
					pointsToRemove.clear();
					pointsToAdd.clear();		

				}
				
				else if(stage == putTownStage) {
					for(Point point : player.pointsWithVillages) {
						if(distance(point.X, point.Y, e.getX(), e.getY()) < mouseClickRadius) {
							stage = noActionStage;
							player.pointsWithVillages.remove(point);
							player.pointsWithTowns.add(point);
							Settlement town = new Settlement(player, "town");
							town.addPoints();
							player.updateScoreLabel();
							
							for(Field field : fields) {
								for(Point p : field.vertices) {
									if(distance(point,p) <= roundingUpMistake) {
										field.settlements.add(town);
									}	
								}
							}
							if(player.getStage() == Player.normalGameMoveStage) {
								player.setChoosingPlacesForBuilding(false);
							}
							break;
						}
					}
				}
				else if(stage == moveBanditsStage) {
					double moveBanditsMouseclickRatioToSide = 0.7;
					int moveBanditsMouseclick = (int)(moveBanditsMouseclickRatioToSide * side);
					for(Field field : fields) {
						if(distance(field.center.X, field.center.Y,e.getX(), e.getY()) <= moveBanditsMouseclick && !field.hasBandits) {
							moveBandits(currentFieldWithBandits, field);
							stage = noActionStage;
							break;
						}
					}
				}
				repaint();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		Map<?, ?> desktopHints = 
			    (Map<?, ?>) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");

		Graphics2D g2d = (Graphics2D) g;
		if (desktopHints != null) {
			g2d.setRenderingHints(desktopHints);
		}
		space = (int)(spaceRatio * this.getHeight());
		int topBottomMargins = (int)(topBottomMarginsRatio * this.getHeight());
	
		side = (int)((this.getHeight() - 2 * topBottomMargins - 4 * space) / 8);
		Field.side = side;
		
		int leftRightMargins = (int)((this.getWidth() - 5 * Math.sqrt(3) * side) / 2);
		
		for(int i = 0; i < 3; i++) {//first row 
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + i * Math.sqrt(3) * side + i * space);
			int upperLeftY = topBottomMargins;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g2d, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).vertices) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpointsOfEdges) {
					allRoads.add(midpoint);
				}
			}
		}
		
		for(int i = 3; i < 7; i++) {//second row 
			int j = i - 3;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side +j * space);
			int upperLeftY = topBottomMargins + 3 * side / 2 + space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g2d, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).vertices) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpointsOfEdges) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 7; i < 12; i++) {//third row 
			int j = i - 7;
			int upperLeftX = (int)(leftRightMargins + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 3 * side + 2 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g2d, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).vertices) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpointsOfEdges) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 12; i < 16; i++) {//fourth row 
			int j = i - 12;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 9 * side / 2 + 3 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g2d, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).vertices) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpointsOfEdges) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 16; i < 19; i++) {//fifth row 
			int j = i - 16;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 6 * side + 4 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g2d, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).vertices) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpointsOfEdges) {
					allRoads.add(midpoint);
				}
			}
		}
		

		for(Point point : allPoints){
			point.setPanelSize(this.getHeight(), leftRightMargins);
		}
		

		for(Road road : allRoads){
			road.setPanelSize(this.getHeight(), leftRightMargins);
		}
		
		int f = 0;
		for(Field field : fields) {
			g.setFont(new Font("Times New Roman", Font.BOLD, side/2));
			g.setColor(Color.BLACK);
			
			field.center.setPanelSize(this.getHeight(), leftRightMargins);
			if(!field.hasBandits && !field.type.equals("desert")) {
				g2d.drawString(numbers.get(f).toString(), field.center.X - 2 * space, field.center.Y + space / 2);
				if(firstPaint) {
					field.number = numbers.get(f);
				}
				f++;
			}
			else if(field.hasBandits && !field.type.equals("desert")) {
				currentFieldWithBandits = field;
				paintBandits(g2d, field.center.X, field.center.Y);
				f++;
			}
			else if(field.hasBandits && field.type.equals("desert")){
				currentFieldWithBandits = field;
				paintBandits(g2d, field.center.X, field.center.Y);
			}
		}
		
		if(firstPaint) {
			HashSet<Point> pointsToAdd = new HashSet<Point>();
			HashSet<Point> pointsToRemove = new HashSet<Point>();
			for(Point point1 : allPoints) {
				for(Point point2 : allPoints) {
					if((point2.X != point1.X || point2.Y != point1.Y)  && distance(point1, point2) <= space * 3 / 2 && !pointsToRemove.contains(point1) && !pointsToRemove.contains(point2)) {
						pointsToRemove.add(point1);
						pointsToRemove.add(point2);
						Point middle = new Point((double)((point1.X + point2.X)/2 - leftRightMargins) / this.getHeight(),(double)((point1.Y + point2.Y)/2) / this.getHeight(), point1.type);
						pointsToAdd.add(middle);
						middle.setPanelSize(this.getHeight(), leftRightMargins);
						break;
					}
				}
			}
			
			allPoints.addAll(pointsToAdd);
			allPoints.removeAll(pointsToRemove);
			pointsToAdd.clear();
			pointsToRemove.clear();
			for(Point point1 : allPoints) {
				for(Point point2 : allPoints) {
					if((point2.X != point1.X || point2.Y != point1.Y)  && distance(point1, point2) <= space * 2 && !pointsToRemove.contains(point1) && !pointsToRemove.contains(point2)) {
						pointsToRemove.add(point1);
						pointsToRemove.add(point2);
						Point middle = new Point((double)((point1.X + point2.X)/2 - leftRightMargins) / this.getHeight(),(double)((point1.Y + point2.Y)/2) / this.getHeight(), point1.type);
						pointsToAdd.add(middle);
						middle.setPanelSize(this.getHeight(), leftRightMargins);
						break;
					}
				}
			}
			allPoints.addAll(pointsToAdd);
			allPoints.removeAll(pointsToRemove);
		}
		
		if(firstPaint) {
			HashSet<Road> roadsToAdd = new HashSet<Road>();
			HashSet<Road> roadsToRemove = new HashSet<Road>();
			for(Road road1 : allRoads) {
				for(Road road2 : allRoads) {
					if((road2.X != road1.X || road2.Y != road1.Y)  && distance(road1, road2) <= space * 3 / 2 && !roadsToRemove.contains(road1) && !roadsToRemove.contains(road2)) {
						roadsToRemove.add(road1);
						roadsToRemove.add(road2);
						Road middle = new Road((double)((road1.X + road2.X)/2 - leftRightMargins) / this.getHeight(),(double)((road1.Y + road2.Y)/2) / this.getHeight(), road1.slope);
						roadsToAdd.add(middle);
						middle.setPanelSize(this.getHeight(), leftRightMargins);
						break;
					}
				}
			}
			
			allRoads.addAll(roadsToAdd);
			allRoads.removeAll(roadsToRemove);
		}
		
		if(firstPaint) {
			for(Player player : players) {
				player.availablePoints.addAll(allPoints);
			}
		}
		for(Player player : players) {
			for(Road road :  player.occupiedRoads) {
				g2d.setColor(player.colour);
				paintRoad(g2d, road);
			}
			for(Point point :  player.pointsWithVillages) {
				g2d.setColor(player.colour);
				paintVillage(g2d, point);
			}
			for(Point point :  player.pointsWithTowns) {
				g2d.setColor(player.colour);
				paintTown(g2d, point);
			}
		}
		firstPaint = false;
		
   }
	private void paint(int upperLeftX, int upperLeftY, Graphics2D g2d, String fieldType) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int Ax = upperLeftX + (int)(side*Math.sqrt(3)/2);
		int Ay = upperLeftY;
		int Bx = Ax + (int)(side*Math.sqrt(3)/2);
		int By = Ay + side/2;
		int Cx = Bx;
		int Cy = By + side;
		int Dx = Ax;
		int Dy = Cy + side/2;
		int Ex = upperLeftX;
		int Ey = Cy;
		int Fx = Ex;
		int Fy = By;
		int[] pointsXs = {Ax, Bx, Cx, Dx, Ex, Fx};
		int[] pointsYs = {Ay, By, Cy, Dy, Ey, Fy};
		Polygon field = new Polygon(pointsXs, pointsYs, 6);
		if(fieldType.equals("tree")) {
			g2d.setColor(forestColour);
		}
		else if(fieldType.equals("bricks")) {
			g2d.setColor(clayColour);
		}
		else if(fieldType.equals("rock")) {
			g2d.setColor(rockColour);
		}
		else if(fieldType.equals("wheat")) {
			g2d.setColor(wheatColour);
		}
		else if(fieldType.equals("wool")) {
			g2d.setColor(fieldColour);
		}
		else if(fieldType.equals("desert")) {
			g2d.setColor(desertColour);
		}
		g2d.fillPolygon(field);
	}
	
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.X - p2.X, 2) + Math.pow(p1.Y - p2.Y, 2));
	}
	
	public static double distance(Road r1, Road r2) {
		return Math.sqrt(Math.pow(r1.X - r2.X, 2) + Math.pow(r1.Y - r2.Y, 2));
	}
	
	public void paintVillage(Graphics2D g2d, Point point) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int squareSide = side / 4;
		int houseUpLeftX = point.X - squareSide / 2;
		int houseUpLeftY = point.Y - squareSide / 2;
		g2d.fillRect(houseUpLeftX, houseUpLeftY, squareSide, squareSide);
		
		int[] triangleXPoints = {houseUpLeftX - squareSide / 2, houseUpLeftX + 3 * squareSide / 2, houseUpLeftX + squareSide / 2};
		int[] triangleYPoints = {houseUpLeftY, houseUpLeftY, houseUpLeftY -  squareSide};
		Polygon roof = new Polygon(triangleXPoints, triangleYPoints, 3);
		g2d.fillPolygon(roof);
	}
	
	public void paintRoad(Graphics2D g2d, Road midpoint) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		if(midpoint.slope == '\\' ) {
			int upLeftX = (int)(midpoint.X - Math.sqrt(3) * side / 8 + side / 32);
			int upLeftY = (int)(midpoint.Y - side / 8 - Math.sqrt(3) * side / 32);
			
			int upRightX = (int)(midpoint.X + Math.sqrt(3) * side / 8 + side / 32);
			int upRightY = (int)(midpoint.Y + side / 8 - Math.sqrt(3) * side / 32);
			
			int downLeftX = (int)(midpoint.X - Math.sqrt(3) * side / 8 - side / 32);
			int downLeftY = (int)(midpoint.Y - side / 8 + Math.sqrt(3) * side / 32);
			
			int downRightX = (int)(midpoint.X + Math.sqrt(3) * side / 8 - side / 32);
			int downRightY = (int)(midpoint.Y + side / 8 + Math.sqrt(3) * side / 32);
			
			int[] Xs  = {upLeftX, upRightX, downRightX, downLeftX};
			int[] Ys  = {upLeftY, upRightY, downRightY, downLeftY};
			
			Polygon road = new Polygon(Xs, Ys, 4);
			g2d.fillPolygon(road);
		}
		else if(midpoint.slope == '|') {
			int upLeftX = (int)(midpoint.X - side / 16);
			int upLeftY = (int)(midpoint.Y - side * 2 / 7);
			g2d.fillRect(upLeftX, upLeftY, side / 8, side * 3 / 7);
		}
		else if(midpoint.slope == '/') {
			int upRightX = (int)(midpoint.X + Math.sqrt(3) * side / 8 - side / 32);
			int upRightY = (int)(midpoint.Y - side / 8 - Math.sqrt(3) * side / 32);
			
			int upLeftX = (int)(midpoint.X - Math.sqrt(3) * side / 8 - side / 32);
			int upLeftY = (int)(midpoint.Y + side / 8 - Math.sqrt(3) * side / 32);
			
			int downRightX = (int)(midpoint.X + Math.sqrt(3) * side / 8 + side / 32);
			int downRightY = (int)(midpoint.Y - side / 8 + Math.sqrt(3) * side / 32);
			
			int downLeftX = (int)(midpoint.X - Math.sqrt(3) * side / 8 + side / 32);
			int downLeftY = (int)(midpoint.Y + side / 8 + Math.sqrt(3) * side / 32);
			
			int[] Xs  = {upLeftX, upRightX, downRightX, downLeftX};
			int[] Ys  = {upLeftY, upRightY, downRightY, downLeftY};
			
			Polygon road = new Polygon(Xs, Ys, 4);
			g2d.fillPolygon(road);
		}
	}
	
	public void paintTown(Graphics2D g2d, Point point) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		int towerWidth = side / 5;
		int upLeftBuildingX = point.X - 3 * towerWidth / 2;
		int upLeftBuildingY = point.Y - towerWidth / 2;
		int upRightBuildingX = upLeftBuildingX + 3 * towerWidth;
		g2d.fillRect(upLeftBuildingX, upLeftBuildingY, towerWidth * 3, towerWidth);
		
		int upLeftTower1X = upLeftBuildingX ;
		int upLeftTower1Y = point.Y - 5 * towerWidth / 4;
		g2d.fillRect(upLeftTower1X, upLeftTower1Y, towerWidth, upLeftBuildingY - upLeftTower1Y);
		
		int upLeftTower2X = point.X + towerWidth / 2;
		int upLeftTower2Y = point.Y - 5 * towerWidth / 4;
		g2d.fillRect(upLeftTower2X, upLeftTower2Y, upRightBuildingX - upLeftTower2X,  upLeftBuildingY - upLeftTower1Y);
		
		int[] roof1x = {upLeftTower1X, upLeftTower1X + towerWidth, upLeftTower1X + towerWidth / 2};
		int[] roof1y = {upLeftTower1Y, upLeftTower1Y, upLeftTower1Y - towerWidth / 2};
		Polygon roof1 = new Polygon(roof1x, roof1y, 3);
		g2d.fillPolygon(roof1);
		
		int[] roof2x = {upLeftTower2X, upRightBuildingX, (upLeftTower2X + upRightBuildingX) / 2};
		int[] roof2y = {upLeftTower1Y, upLeftTower1Y, upLeftTower1Y - towerWidth / 2};
		Polygon roof2 = new Polygon(roof2x, roof2y, 3);
		g2d.fillPolygon(roof2);
		
	}
	public void paintBandits(Graphics2D g2d, int centerX, int centerY) {
		Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		g2d.setRenderingHints(hints);
		
		g2d.setColor(banditsColour);
		int upLeftBellyX = centerX + side / 16;
		int upLeftBellyY = centerY - side / 4;
		g2d.fillOval(upLeftBellyX, upLeftBellyY, side / 2, side / 2);
		
		int tr1X = centerX - side / 16;
		int tr1Y = centerY + side / 4;
		
		int tr2X = centerX - side * 9 / 16;
		int tr2Y = centerY + side / 4;
		
		int tr3X = centerX - side * 5 / 16;
		int tr3Y = centerY - side * 3 / 8;
		
		int[] Xs = {tr1X, tr2X, tr3X};
		int[] Ys = {tr1Y, tr2Y, tr3Y};
		Polygon tr = new Polygon(Xs, Ys, 3);
		g2d.fillPolygon(tr);
		
		int head1X = tr3X - side / 6;
		int head1Y = tr3Y - side / 3;
		g2d.fillOval(head1X,  head1Y, side / 3, side / 3);
		
		int head2X = upLeftBellyX + side / 12;
		int head2Y = upLeftBellyY - side / 3;
		g2d.fillOval(head2X, head2Y, side / 3, side / 3);
	}
	public void moveBandits(Field fromField, Field toField) {
		fromField.hasBandits = false;
		toField.hasBandits = true;
	}
	
	public int getStage() {
		return stage;
	}
	
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public boolean freePointsAvailable(Player player) {
		for(Point point : player.availablePoints) {
			if(point.free) {
				return true;
			}
		}
		return false;
	}
	
	public boolean freeRoadsAvailable(Player player) {
		for(Road road : player.availableRoads) {
			if(road.free) {
				return true;
			}
		}
		return false;
	}
	public boolean availableVillagesToExpandIntoTowns(Player player) {
		return !player.pointsWithVillages.isEmpty();
	}
}
