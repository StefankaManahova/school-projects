package edu.objects;

public class Students {
	private String name;
	private double averageScore;
	
	Students(){
		
	}
	
	Students (String name, double averageScore){
		this.name = name;
		this.averageScore = averageScore;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverageScore() {
		return this.averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
}
