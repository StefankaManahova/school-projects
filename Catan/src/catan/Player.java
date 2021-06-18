package catan;

import java.awt.Color;
import java.util.LinkedList;

public class Player {
	protected LinkedList<Point> availablePoints = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithVillages = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithTowns = new LinkedList<Point>();
	
	protected LinkedList<Road> availableRoads = new LinkedList<Road>();
	protected LinkedList<Road> occupiedRoads = new LinkedList<Road>();
	
	protected int score;
	
	protected int availableWheatCount = 0;
	protected int availableWoolCount = 0;
	protected int availableWoodCount = 0;
	protected int availbaleBricksCount = 0;
	protected int availableRockCount = 0;
	
	protected Color colour;
	
	public Player(Color colour) {
		this.colour = colour;
	}

	/**
	 * @return the color
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * @param color the color to set
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	/**
	 * @return the availableWheatCount
	 */
	public int getAvailableWheatCount() {
		return availableWheatCount;
	}

	/**
	 * @param availableWheatCount the availableWheatCount to set
	 */
	public void setAvailableWheatCount(int availableWheatCount) {
		this.availableWheatCount = availableWheatCount;
	}

	/**
	 * @return the availableWoolCount
	 */
	public int getAvailableWoolCount() {
		return availableWoolCount;
	}

	/**
	 * @param availableWoolCount the availableWoolCount to set
	 */
	public void setAvailableWoolCount(int availableWoolCount) {
		this.availableWoolCount = availableWoolCount;
	}

	/**
	 * @return the availableWoodCount
	 */
	public int getAvailableWoodCount() {
		return availableWoodCount;
	}

	/**
	 * @param availableWoodCount the availableWoodCount to set
	 */
	public void setAvailableWoodCount(int availableWoodCount) {
		this.availableWoodCount = availableWoodCount;
	}

	/**
	 * @return the availbaleBricksCount
	 */
	public int getAvailbaleBricksCount() {
		return availbaleBricksCount;
	}

	/**
	 * @param availbaleBricksCount the availbaleBricksCount to set
	 */
	public void setAvailbaleBricksCount(int availbaleBricksCount) {
		this.availbaleBricksCount = availbaleBricksCount;
	}

	/**
	 * @return the availableRockCount
	 */
	public int getAvailableRockCount() {
		return availableRockCount;
	}

	/**
	 * @param availableRockCount the availableRockCount to set
	 */
	public void setAvailableRockCount(int availableRockCount) {
		this.availableRockCount = availableRockCount;
	}
	
}
