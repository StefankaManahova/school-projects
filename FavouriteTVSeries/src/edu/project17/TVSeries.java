package edu.project17;

import java.util.ArrayList;

public class TVSeries {
	String name;
	int numberOfSeasons = 0;
	
	ArrayList<Character> characters;
	ArrayList<Season> seasons;
	
	TVSeries(int numberOfSeasons){
		seasons = new ArrayList<Season>();
		
		for(int i=0; i<numberOfSeasons; i++) {
			seasons.add(new Season(i+1));
			this.numberOfSeasons++;
		}
		characters = new ArrayList<Character>();
			
	}
    
	public String toString() {
		String result = this.name + ", "+ this.numberOfSeasons +((this.numberOfSeasons==1)?" season":" seasons") + "\nFavourite characters:";
		for(Character character : this.characters) {
			result += character.toString();
		}
		result+="\n\n";
		return result;
	}
}