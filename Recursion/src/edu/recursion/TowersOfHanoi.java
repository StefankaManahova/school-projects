package edu.recursion;

public class TowersOfHanoi {

	static int numberOfMovesTotal = 0;
	public static void main(String[] args) {
		
		int diskCount = 6;
		Bar A = new Bar("A");
		Bar B = new Bar("B");
		Bar C = new Bar("C");
		
		System.out.println("We are going to play a very interesting game called "
							+ "\"The Towers Of Hanoi\".\nThe rules are simple"
							+ " - you have to move all " + diskCount + " disks from bar A to bar C,but\n"
							+ "at no point in the game could there be a larger disk on top of a smaller one."
							+ "\nHere are the instructions:\n");
		
		recursiveSolution(diskCount, A, C, B);
		System.out.println("\nNumber of moves total:" + numberOfMovesTotal);

	}
	
    public static void recursiveSolution(int n, Bar currentBar, Bar wantedBar, Bar leftoverBar) {
    	if(n==1){
    		move(n,currentBar, wantedBar);
    	}
    	else{
    		recursiveSolution( n-1, currentBar, leftoverBar, wantedBar);
    		move(n, currentBar, wantedBar);
    		recursiveSolution( n-1, leftoverBar, wantedBar, currentBar);
    	}
    }
                                                                           
	public static void move(int  a, Bar currentBar, Bar wantedBar) {
		System.out.println("Move the " + a + ". disk to bar " + wantedBar.getName() + ".");
		currentBar.setNumberOfDisks(currentBar.getNumberOfDisks()-1);
		wantedBar.setNumberOfDisks(wantedBar.getNumberOfDisks()+1);
		numberOfMovesTotal++;
		
	}
	

}
