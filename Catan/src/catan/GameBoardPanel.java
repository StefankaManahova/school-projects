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
	
	protected ArrayList<Field> fields;
	protected Player player1 = new Player();
	protected Player player2 = new Player();
	protected Player player3 = new Player();
	protected Player player4 = new Player();
	
	protected int playerOnTurn = 1;
	protected HashMap<Point,Player> pointsWithVillages = new HashMap<Point,Player>();
	
	protected double mouseClickRadiusRatio = 0.1;
	protected double roundingUpMistakeRatio= 0.04;
	protected boolean firstPaint = true;
	
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
						pointsWithVillages.put(point, player1);
						System.out.println("89");
						
						for(Field field : fields) {
							if(distance(point.X, point.Y, field.A.X, field.A.Y) < roundingUpMistake || 
							   distance(point.X, point.Y, field.B.X, field.B.Y) < roundingUpMistake ||
							   distance(point.X, point.Y, field.C.X, field.C.Y) < roundingUpMistake ||
							   distance(point.X, point.Y, field.D.X, field.D.Y) < roundingUpMistake ||
							   distance(point.X, point.Y, field.E.X, field.E.Y) < roundingUpMistake ||
							   distance(point.X, point.Y, field.F.X, field.F.Y) < roundingUpMistake) {
								field.pieces.add(new Piece(player1, "village"));
							}			
						}
						player1.availablePoints.addLast(new Point((int)(point.X + Math.sqrt(3) / 2 * side), point.Y - side / 2));
						player1.availablePoints.addLast(new Point((int)(point.X - Math.sqrt(3) / 2 * side), point.Y -  side / 2));
						player1.availablePoints.addLast(new Point(point.X, point.Y + side / 2));
					}
				}
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		int space = (int)(spaceRatio * this.getHeight());
		int topBottomMargins = (int)(topBottomMarginsRatio * this.getHeight());
	
		side = (int)((this.getHeight() - 2 * topBottomMargins - 4 * space) / 8);
		Field.side = side;
		
		int leftRightMargins = (int)((this.getWidth() - 5 * Math.sqrt(3) * side) / 2);
		
		if(firstPaint) {
			player1.availablePoints.add(new Point((int)(leftRightMargins + 3 * Math.sqrt(3)* side + 2 * space + space / 2), topBottomMargins + 3 * side + side / 2 + 2 * space));
		}
		System.out.println("Point " + player1.availablePoints.getLast().X + " " + player1.availablePoints.getLast().Y);
		
		for(int i = 0; i < 3; i++) {//first row 
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + i * Math.sqrt(3) * side + i * space);
			int upperLeftY = topBottomMargins;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side) ;
			}
		}
		
		for(int i = 3; i < 7; i++) {//second row 
			int j = i - 3;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side +j * space);
			int upperLeftY = topBottomMargins + 3 * side / 2 + space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side) ;
			}
	   }
		for(int i = 7; i < 12; i++) {//third row 
			int j = i - 7;
			int upperLeftX = (int)(leftRightMargins + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 3 * side + 2 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side) ;
			}
	   }
		for(int i = 12; i < 16; i++) {//forth row 
			int j = i - 12;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side / 2 + space / 2 + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 9 * side / 2 + 3 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side) ;
			}
	   }
		for(int i = 16; i < 19; i++) {//fiftht row 
			int j = i - 16;
			int upperLeftX = (int)(leftRightMargins + Math.sqrt(3) * side + space + j * Math.sqrt(3) * side + j * space);
			int upperLeftY = topBottomMargins + 6 * side + 4 * space;
			String fieldType = fields.get(i).type;
			paint(upperLeftX, upperLeftY, g, fieldType);
			if(firstPaint) {
				fields.get(i).setCoordinates((int)(upperLeftX + Math.sqrt(3) * side / 2), upperLeftY + side) ;
			}
		}
		
		firstPaint = false;
		
		for(Point point : player1.availablePoints) {
			int squareSide = 4 * space ;
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
}
