package edu.algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class SelectionSortPanel extends JPanel {
	private ArrayList<Integer> numbers = new ArrayList(Arrays.asList(5, 4, 3, 2, 1));

	private static int noSortingStage = -1;
	private static int incrementIStage = 0; 
	private static int incrementJStage = 1;
	private static int swapForNewMinStage = 2;
	private static int compareStage = 3;
	private static int putInPlaceStage = 4; 
	private static int isSortedStage = 5;

	private int stage = noSortingStage;

	int currentI = -1;
	int currentJ = 0;
	int currentMinIndex = -1;
	
	//private Color blue = new Color(24, 222, 209);
	private Color purpleLighter = new Color(219, 77, 255);
	
	private Color pinkLight = new Color(255, 153, 221);
	private Color pinkDarker = new Color(255, 102, 204);
	private Color purple = new Color(204, 0, 255);
	

	public SelectionSortPanel() {

	}

	public void nextStepInSorting() {
		if (stage == isSortedStage) {
			return;
		}

		if (stage == noSortingStage) {
			stage = incrementIStage; // Initializing stage, continue directly to next stage
		}

		if (stage == incrementIStage) {
			currentI++;
			currentJ = currentI;
			currentMinIndex = currentI;
		}

		if (stage == incrementJStage) {
			currentJ++;
		} 
		
		else if (stage == compareStage) {
			currentJ = -1;
		}
		else if (stage == putInPlaceStage) {
			Integer numberI = numbers.get(currentI);
			Integer currentMin = numbers.get(currentMinIndex);
			if (currentMinIndex != currentI) {
				numbers.set(currentI, currentMin);
				numbers.set(currentMinIndex, numberI);
			}
			currentMinIndex = -1;
		} 
		else if (stage == swapForNewMinStage) {
			currentMinIndex = currentJ;
		}

		repaint();

	}

	private void nextStage() {
		if (stage == incrementIStage) {
			stage = incrementJStage;
		}
		else if (stage == incrementJStage) {
			if (numbers.get(currentMinIndex) > numbers.get(currentJ)) {
				stage = swapForNewMinStage;
			}
			else {
				if (currentJ < numbers.size() - 1){
					stage = incrementJStage;
				}
				else {
					stage = compareStage;
				}
			
			} 
		} else if (stage == swapForNewMinStage) {
			if (currentJ < numbers.size() - 1) { 
				stage = incrementJStage;
			} else {
				currentJ = -1;
				stage = compareStage; 
			}
		}
		else if (stage == compareStage) {
			stage = putInPlaceStage;
		}
		else if (stage == putInPlaceStage) {
			if(currentI < numbers.size() - 2) {
				stage = incrementIStage;
			}
			else {
				currentI = -1;
				stage = isSortedStage;
				repaint();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int towerWidth = ((getWidth() - 20) / numbers.size()) - 2;
		int towerHeightIndex = (getHeight() - 20) / maxElement(numbers);
		int downY = getHeight() - 5;
		for (int j = 0; j < numbers.size(); j++) {

			// establish color
			if (stage == noSortingStage) {
				g.setColor(pinkLight);
			} else if (j == currentMinIndex) {
				g.setColor(purpleLighter);
			}
			else if (j == currentI && stage == compareStage) {
				g.setColor(pinkDarker);
			}
			else if (j == currentI && stage == putInPlaceStage) {
				g.setColor(purple);
			} else if (j == currentJ && stage != incrementIStage) {
				g.setColor(pinkDarker);
			} else if (j < currentI){
				g.setColor(purple);
			} else if (stage == isSortedStage) {
				g.setColor(purple);
			} else {
				g.setColor(pinkLight);
			}

			int leftX = j * towerWidth + 5 * (j + 1);
			int rightX = leftX + towerWidth;
			int upperY = downY - numbers.get(j) * towerHeightIndex;
//			g.drawLine(leftX, downY, leftX, upperY); // left side line
//			g.drawLine(leftX, upperY, rightX, upperY); // top line
//			g.drawLine(rightX, downY, rightX, upperY); // right line
			int towerHeight = numbers.get(j) * towerHeightIndex;

			g.fillRect(leftX, upperY, towerWidth, towerHeight);
			g.drawString(numbers.get(j).toString(), leftX + towerWidth / 2, downY - 5);
		}

		if (stage != noSortingStage) {
			nextStage();
		}
	}

	public static Integer maxElement(ArrayList<Integer> numbers) {
		Integer max = numbers.get(0);
		for (Integer a : numbers) {
			if (a > max) {
				max = a;
			}
		}

		return max;
	}
}
