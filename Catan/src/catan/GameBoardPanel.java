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


public class GameBoardPanel extends JPanel {
	protected static double spaceRatio = 0.01;
	protected static double topBottomMarginsRatio = 0.0125;
	
	protected static Color forestColour = new Color(0, 204, 68); 
	protected static Color clayColour = new Color(204, 68, 0);
	protected static Color fieldColour = new Color(83, 255, 26);
	protected static Color rockColour = new Color(122, 122, 82);
	protected static Color wheatColour = new Color(255, 204, 0);
	
	protected static int side;
	protected static int space;
	
	protected ArrayList<Field> fields;
	protected Player player1 = new Player();
	protected Player player2 = new Player();
	protected Player player3 = new Player();
	protected Player player4 = new Player();
	
	protected int playerOnTurn = 1;
	
	protected double mouseClickRadiusRatio = 0.1;
	protected double roundingUpMistakeRatio= 0.4;
	protected boolean firstPaint = true;
	
	protected HashSet<Point> allPoints = new HashSet<Point>();
	
	public GameBoardPanel() {
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
				int roundingUpMistake = (int)(roundingUpMistakeRatio * side);
				
				for(Point point : player1.availablePoints) {
					if(distance(point.X, point.Y, e.getX(), e.getY()) < mouseClickRadius) {
						player1.pointsWithVillages.add(point);
						
						if(player1.availablePoints.containsAll(allPoints)) {
							player1.availablePoints.clear();
						}
						else {
							player1.availablePoints.remove(point);
						}
						System.out.println(roundingUpMistake);
						
						int point1X = (int)(point.X + Math.sqrt(3) / 2 * side + space / 2);
						int point1Y = point.Y - side / 2;
						int point2X = (int)(point.X - Math.sqrt(3) / 2 * side + space / 2);
						int point2Y = point.Y - side / 2;
						int point3X = point.X;
						int point3Y = point.Y + side + space;
						
						for(Point p : allPoints) {
							if(distance(p.X, p.Y, point1X, point1Y) <= roundingUpMistake) {
								player1.availablePoints.add(p);
							}
							else if(distance(p.X, p.Y, point2X, point2Y) <= roundingUpMistake) {
								player1.availablePoints.add(p);
							}
							else if(distance(p.X, p.Y, point3X, point3Y) <= roundingUpMistake) {
								player1.availablePoints.add(p);
							}
						}
						
						for(Field field : fields) {
							if(distance(point, field.A) <= roundingUpMistake || 
							   distance(point, field.B) <= roundingUpMistake ||
							   distance(point, field.C) <= roundingUpMistake ||
							   distance(point, field.D) <= roundingUpMistake ||
							   distance(point, field.E) <= roundingUpMistake ||
							   distance(point, field.F) <= roundingUpMistake) {
								field.pieces.add(new Piece(player1, "village"));
							}			
						}
					}
				}
				repaint();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
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
				allPoints.add(fields.get(i).A);
				allPoints.add(fields.get(i).B);
				allPoints.add(fields.get(i).C);
				allPoints.add(fields.get(i).D);
				allPoints.add(fields.get(i).E);
				allPoints.add(fields.get(i).F);
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
				allPoints.add(fields.get(i).A);
				allPoints.add(fields.get(i).B);
				allPoints.add(fields.get(i).C);
				allPoints.add(fields.get(i).D);
				allPoints.add(fields.get(i).E);
				allPoints.add(fields.get(i).F);
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
				allPoints.add(fields.get(i).A);
				allPoints.add(fields.get(i).B);
				allPoints.add(fields.get(i).C);
				allPoints.add(fields.get(i).D);
				allPoints.add(fields.get(i).E);
				allPoints.add(fields.get(i).F);
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
				allPoints.add(fields.get(i).A);
				allPoints.add(fields.get(i).B);
				allPoints.add(fields.get(i).C);
				allPoints.add(fields.get(i).D);
				allPoints.add(fields.get(i).E);
				allPoints.add(fields.get(i).F);
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
				allPoints.add(fields.get(i).A);
				allPoints.add(fields.get(i).B);
				allPoints.add(fields.get(i).C);
				allPoints.add(fields.get(i).D);
				allPoints.add(fields.get(i).E);
				allPoints.add(fields.get(i).F);
			}
		}
		
		for(Point point : allPoints){
			point.setPanelSize(this.getHeight(), this.getWidth());
		}
		
		if(firstPaint) {
			HashSet<Point> pointsToAdd = new HashSet<Point>();
			HashSet<Point> pointsToRemove = new HashSet<Point>();
			for(Point point1 : allPoints) {
				for(Point point2 : allPoints) {
					if((point2.X != point1.X || point2.Y != point1.Y)  && distance(point1, point2) <= space * 3 / 2 && !pointsToRemove.contains(point1) && !pointsToRemove.contains(point2)) {
						pointsToRemove.add(point1);
						pointsToRemove.add(point2);
						Point middle = new Point((double)((point1.X + point2.X)/2 - leftRightMargins) / this.getHeight(),(double)((point1.Y + point2.Y)/2) / this.getHeight());
						pointsToAdd.add(middle);
						middle.setPanelSize(this.getHeight(), this.getWidth());
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
					if((point2.X != point1.X || point2.Y != point1.Y)  && distance(point1, point2) <= space * 3 / 2 && !pointsToRemove.contains(point1) && !pointsToRemove.contains(point2)) {
						pointsToRemove.add(point1);
						pointsToRemove.add(point2);
						Point middle = new Point((double)((point1.X + point2.X)/2 - leftRightMargins) / this.getHeight(),(double)((point1.Y + point2.Y)/2) / this.getHeight());
						pointsToAdd.add(middle);
						middle.setPanelSize(this.getHeight(), this.getWidth());
						break;
					}
				}
			}
			allPoints.addAll(pointsToAdd);
			allPoints.removeAll(pointsToRemove);
		}
		
		if(firstPaint) {
			player1.availablePoints.addAll(allPoints);
		}
		for(Point point : player1.pointsWithVillages) {
			int squareSide = 7 * space / 2;
			paintVillage(g, point, squareSide);
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
	
	public void paintVillage(Graphics g, Point point, int squareSide) {
		int houseUpLeftX = point.X - squareSide / 2;
		int houseUpLeftY = point.Y - squareSide / 2;
		g.setColor(new Color(128, 0, 0));
		g.fillRect(houseUpLeftX, houseUpLeftY, squareSide, squareSide);
		
		int[] triangleXPoints = {houseUpLeftX - squareSide / 2, houseUpLeftX + 3 * squareSide / 2, houseUpLeftX + squareSide / 2};
		int[] triangleYPoints = {houseUpLeftY, houseUpLeftY, houseUpLeftY -  squareSide};
		Polygon roof = new Polygon(triangleXPoints, triangleYPoints, 3);
		g.fillPolygon(roof);
	}
}
