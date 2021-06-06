package catan;

import java.util.LinkedList;

public class Player {
	protected LinkedList<Point> availablePoints = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithVillages = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithTowns = new LinkedList<Point>();
	
	protected LinkedList<Road> availableRoads = new LinkedList<Road>();
	protected LinkedList<Road> occupiedRoads = new LinkedList<Road>();
	
	protected int score;
	
	public Player() {
		
	}
	
}
