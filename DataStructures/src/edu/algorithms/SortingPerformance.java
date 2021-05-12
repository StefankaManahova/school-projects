package edu.algorithms;

public class SortingPerformance {
	public static String formatHeader = "%-12s%-10s%-12s%-7s%-7s%n";
	public static String formatData = "%,-12d%,-10d%,-12d%,-7d%,-7d%n";
	
	public static void main(String[] args) {
		System.out.printf(formatHeader, "Array size","Bubble", "Selection", "Merge", "Quick");
		compareSortingTime(50000);
		compareSortingTime(100000);
		compareSortingTime(150000);
		compareSortingTime(200000);
		compareSortingTime(250000);
		compareSortingTime(300000);
	}
	
	public static void compareSortingTime(int numberOfElements) {
		int[] arrayBubble = new int[numberOfElements];
		int[] arraySelection = new int[numberOfElements];
		int[] arrayMerge = new int[numberOfElements];
	    int[] arrayQuick = new int[numberOfElements];
	    
	    for (int i = 0; i < numberOfElements; i++) {
	    	int element = (int)(Math.random() * 1000);
	    	arrayBubble[i] = element;
	    	arraySelection[i] = element;
	    	arrayMerge[i] = element;
	    	arrayQuick[i] = element;
	    	
	    }
	    
	    long timeBubble, timeSelection, timeMerge, timeQuick;
	    long currentTime = System.currentTimeMillis();
	    BubbleSort.bubbleSort(arrayBubble);
	    timeBubble = System.currentTimeMillis() - currentTime;
	    
	    currentTime = System.currentTimeMillis();
	    SelectionSort.selectionSort(arraySelection);
	    timeSelection = System.currentTimeMillis() - currentTime;
	    
	    currentTime = System.currentTimeMillis();
	    MergeSort.mergeSort(arrayMerge);
	    timeMerge = System.currentTimeMillis() - currentTime;
	    
	    currentTime = System.currentTimeMillis();
	    QuickSort.quickSort(arrayQuick);
	    timeQuick = System.currentTimeMillis() - currentTime;
      
	    System.out.printf(formatData, numberOfElements, timeBubble, timeSelection, timeMerge, timeQuick);
	}
}
