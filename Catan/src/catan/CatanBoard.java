package catan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CatanBoard extends JPanel{
	protected static double spaceRatio = 0.01;
	protected static double topBottomMarginsRatio = 0.05;
	
	protected static Color forestColour = new Color(0, 204, 68); 
	protected static Color clayColour = new Color(204, 68, 0);
	protected static Color fieldColour = new Color(83, 255, 26);
	protected static Color rockColour = new Color(122, 122, 82);
	protected static Color wheatColour = new Color(255, 204, 0);
	
	protected static int side;
	protected static int space;
	
	protected ArrayList<Field> fields;
	protected Player[] players = new Player[4];
	
	protected int playerOnTurn = 1;
	
	protected double mouseClickRadiusRatio = 0.2;
	protected double roundingUpMistakeRatio = 0.1;
	protected boolean firstPaint = true;
	
	protected HashSet<Point> allPoints = new HashSet<Point>();
	protected HashSet<Road> allRoads = new HashSet<Road>();
	
	protected int stage = 2;
	protected final static int noActionStage = 0;
	protected final static int putRoadStage = 1;
	protected final static int putVillageStage = 2;
	protected final static int putTownStage = 3;
	
	protected int stageCounter = 0;
	
	public CatanBoard() {
		for(int i = 0; i < 4; i++) {
			players[i] = new Player();
		}
		fields = new ArrayList<Field>(){{
        add(new Field("tree"));
		add(new Field("tree"));	
		add(new Field("tree"));	
		add(new Field("tree"));
		
		add(new Field("bricks"));
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

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int mouseClickRadius = (int)(mouseClickRadiusRatio * side);
				int roundingUpMistake = space * 3 / 2;
				HashSet<Point> pointsToRemove = new HashSet<Point>();
				HashSet<Point> pointsToAdd = new HashSet<Point>();
				HashSet<Road> roadsToAdd = new HashSet<Road>();
				HashSet<Road> roadsToRemove = new HashSet<Road>();
				Player player;
				
				if(playerOnTurn == 1) {
					player = players[0];
				} else if(playerOnTurn == 2) {
					player = players[1];
				} else if(playerOnTurn == 3) {
					player = players[2];
				} else if(playerOnTurn == 4) {
					player = players[3];
				}
				else {
					player = null;
				}
				
				if(stageCounter % 3 == 0) {
					for(Point point : player.availablePoints) {
						if(distance(point.X, point.Y, e.getX(), e.getY()) < mouseClickRadius && point.free) {
							stageCounter++;
							player.pointsWithVillages.add(point);
							point.free = false;
							
							for(Field field : fields) {
								for(Point p : field.points)
								if(distance(point,p) <= roundingUpMistake) {
									field.pieces.add(new Piece(player, "village"));
								}			
							}
							
							if(player.availablePoints.contains(allPoints)) {
								pointsToRemove.add(point);
							}
							else if(player.availablePoints.size() == allPoints.size() - 1) {
								pointsToRemove.addAll(player.availablePoints);
							}
							else {
								pointsToRemove.add(point);
							}
							
							if(point.type == 'Y') {
								int road1X = (int)(point.X + Math.sqrt(3) / 4 * side + space / 4);
								int road1Y = point.Y - side / 4;
								int road2X = (int)(point.X - Math.sqrt(3) / 4 * side + space / 4);
								int road2Y = point.Y - side / 4;
								int road3X = point.X;
								int road3Y = point.Y + side / 2 + space / 2;
								
								
								int point1X = (int)(point.X + Math.sqrt(3) / 2 * side + space / 2);
								int point1Y = point.Y - side / 2;
								int point2X = (int)(point.X - Math.sqrt(3) / 2 * side + space / 2);
								int point2Y = point.Y - side / 2;
								int point3X = point.X;
								int point3Y = point.Y + side + space;
								  
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
							break;
						}
					}
					
					player.availableRoads.removeAll(roadsToRemove);
					player.availableRoads.addAll(roadsToAdd);
					
					player.availablePoints.removeAll(pointsToRemove);
					
					pointsToAdd.clear();
					pointsToRemove.clear();
					
					roadsToAdd.clear();
					roadsToRemove.clear();
				} 
				
				else if(stageCounter % 3 != 0) {
					for(Road road : player.availableRoads) {
						System.out.println(road.free);
						if(distance(road.X, road.Y, e.getX(), e.getY()) < mouseClickRadius && road.free) {
							stageCounter++;
							player.occupiedRoads.add(road);
							road.free = false;
							roadsToRemove.add(road);
							
							int road1X = 0, road1Y = 0, road2X = 0, road2Y = 0, road3X = 0, road3Y = 0, road4X = 0, road4Y = 0;
							
							if(road.slope == '\\') {
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
				repaint();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		space = (int)(spaceRatio * this.getHeight());
		int topBottomMargins = (int)(topBottomMarginsRatio * this.getHeight());
	
		side = (int)((this.getHeight() - 2 * topBottomMargins - 4 * space) / 8);
		Field.side = side;
		
		int leftRightMargins = (int)((this.getWidth() - 5 * Math.sqrt(3) * side) / 2);
		
		for(int i = 0; i < 3; i++) {//first row 
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + i * Math.sqrt(3) * side + i * space);
			int upperLeftY = topBottomMargins;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).points) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpoints) {
					allRoads.add(midpoint);
				}
			}
		}
		
		for(int i = 3; i < 7; i++) {//second row 
			int j = i - 3;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side +j * space);
			int upperLeftY = topBottomMargins + 3 * side / 2 + space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).points) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpoints) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 7; i < 12; i++) {//third row 
			int j = i - 7;
			int upperLeftX = (int)(leftRightMargins + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 3 * side + 2 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).points) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpoints) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 12; i < 16; i++) {//forth row 
			int j = i - 12;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 9 * side / 2 + 3 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).points) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpoints) {
					allRoads.add(midpoint);
				}
			}
	   }
		for(int i = 16; i < 19; i++) {//fifth row 
			int j = i - 16;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 6 * side + 4 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side, this.getHeight(), leftRightMargins) ;
				for(Point point : fields.get(i).points) {
					allPoints.add(point);
				}
				for(Road midpoint : fields.get(i).midpoints) {
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
			for(int i = 0; i < 4; i++) {
				players[i].availablePoints.addAll(allPoints);
			}
		}
		
//		for(Road road :  allRoads) {
//			g.setColor(new Color(128, 0, 0));
//			paintRoad(g, road);
//		}
//		for(Road road :  players[0].availableRoads) {
//			int squareSide = 7 * space / 2;
//			g.setColor(new Color(128, 0, 0));
//			paintRoad(g, road);
//		}
		for(Road road :  players[0].occupiedRoads) {
			g.setColor(Color.BLUE);
			paintRoad(g, road);
		}
		for(Point point :  players[0].pointsWithVillages) {
			g.setColor(Color.BLUE);
			paintVillage(g, point);
		}
		
		firstPaint = false;
		
   }
	private void paint(int upperLeftX, int upperLeftY, Graphics g, String fieldType) {
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
			g.setColor(forestColour);
		}
		else if(fieldType.equals("bricks")) {
			g.setColor(clayColour);
		}
		else if(fieldType.equals("rock")) {
			g.setColor(rockColour);
		}
		else if(fieldType.equals("wheat")) {
			g.setColor(wheatColour);
		}
		else if(fieldType.equals("wool")) {
			g.setColor(fieldColour);
		}
		g.fillPolygon(field);
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
	
	public void paintVillage(Graphics g, Point point) {
		int squareSide = 7 * space / 2;
		int houseUpLeftX = point.X - squareSide / 2;
		int houseUpLeftY = point.Y - squareSide / 2;
		g.fillRect(houseUpLeftX, houseUpLeftY, squareSide, squareSide);
		
		int[] triangleXPoints = {houseUpLeftX - squareSide / 2, houseUpLeftX + 3 * squareSide / 2, houseUpLeftX + squareSide / 2};
		int[] triangleYPoints = {houseUpLeftY, houseUpLeftY, houseUpLeftY -  squareSide};
		Polygon roof = new Polygon(triangleXPoints, triangleYPoints, 3);
		g.fillPolygon(roof);
	}
	
	public void paintRoad(Graphics g, Road midpoint) {
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
			g.fillPolygon(road);
		}
		else if(midpoint.slope == '|') {
			int upLeftX = (int)(midpoint.X - side / 16);
			int upLeftY = (int)(midpoint.Y - side * 9 / 28);
			g.fillRect(upLeftX, upLeftY, side / 8, side * 3 / 7);
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
			g.fillPolygon(road);
		}
	}
}
