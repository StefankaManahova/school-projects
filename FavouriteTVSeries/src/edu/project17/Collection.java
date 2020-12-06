package edu.project17;

import java.util.ArrayList;

public class Collection {
	String name;
	
	ArrayList<TVSeries> tvSeries;

	Collection(){
		tvSeries = new ArrayList<TVSeries>();
	}
	
	public String toString() {
		String result = "";
		for(TVSeries series : tvSeries) {
			result += series.toString();
		}
		return result;
	}
}
