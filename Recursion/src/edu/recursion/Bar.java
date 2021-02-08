package edu.recursion;

public class Bar {
	
	private String name;
	private int numberOfDisks;
   
   	Bar(String name){ 
   		this.name = name;
   	}
	
   	public int getNumberOfDisks() {
		return numberOfDisks;
	}
	
	public void setNumberOfDisks(int numberOfDisks) {
		this.numberOfDisks = numberOfDisks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
