package catan;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;

public class Player {
	protected LinkedList<Point> availablePoints = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithVillages = new LinkedList<Point>();
	protected LinkedList<Point> pointsWithTowns = new LinkedList<Point>();
	
	protected LinkedList<Road> availableRoads = new LinkedList<Road>();
	protected LinkedList<Road> occupiedRoads = new LinkedList<Road>();
	
	protected int score;
	protected PlayerPanel panel;


	protected HashMap<String, Integer> resources = new HashMap<String, Integer>(){{
		put("tree", Integer.valueOf(0));
		put("wheat", Integer.valueOf(0));
		put("wool", Integer.valueOf(0));
		put("bricks", Integer.valueOf(0));
		put("rock", Integer.valueOf(0));
		
	}};
	
	protected Color colour;
	
	public Player(Color colour, PlayerPanel panel) {
		this.setColour(colour);
		this.setPanel(panel);
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public void addResources(String resource, int numberOfAdditionalResources) {
		if(resources.containsKey(resource)) {
			int newNumberOfResources = resources.get(resource) + numberOfAdditionalResources;
			resources.put(resource, Integer.valueOf(newNumberOfResources));
			
			ResourcesCard card = panel.resourcesCards.get(resource);
			card.setResourceNumber(newNumberOfResources);
		}
	}
	public PlayerPanel getPanel() {
		return panel;
	}

	public void setPanel(PlayerPanel panel) {
		this.panel = panel;
	}
}
