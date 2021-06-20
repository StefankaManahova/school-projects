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
	
	protected int stage;
	protected static int putFirstVillageStage = 1;
	protected static int putFirstRoadStage = 2;
	protected static int putSecondVillageStage = 3;
	protected static int putSecondRoadStage = 4;
	protected static int normalGameMoveStage = 5;
	protected static int rollDiceStage = 6;
	
	protected boolean choosingPlacesForBuilding;

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
		stage = putFirstVillageStage;
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
	

	public void setStage(int stage) {
		if(stage >= 1 && stage <= 6) {
			this.stage = stage;
		}
	}

	public int getStage() {
		return stage;
	}

	public void updateResourcesLabels() {
		for(String resource : resources.keySet()) {
			int newNumberOfResources = resources.get(resource);
			ResourcesCard card = panel.resourcesCards.get(resource);
			card.setResourceNumber(newNumberOfResources);
		}
		
	}
	public void updateScoreLabel() {
		panel.currentScore.setText("Current score: " + score);
	}
	
	public boolean isChoosingPlacesForBuilding() {
		return choosingPlacesForBuilding;
	}
	public void setChoosingPlacesForBuilding(boolean choosingPlacesForBuilding) {
		this.choosingPlacesForBuilding = choosingPlacesForBuilding;
	}

}
