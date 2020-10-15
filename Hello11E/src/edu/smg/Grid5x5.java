package edu.smg;

import java.util.Scanner;

public class Grid5x5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		final int rows = 5;
		final int columns = 5;
		int[][] grid = new int [rows][columns];
		
		System.out.println("Please enter the grid:");
		for( int i=0; i<rows; i++) {
			for( int j=0; j<columns; j++ ) {
				grid[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int maxsum = 0, sum = 0; 
		int index = -1;		
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				sum += grid[i][j];
			}
			if(maxsum < sum) {
				maxsum = sum;
				index = i;
			}
			sum = 0;
		}
		System.out.println("The greatest sum is "+ maxsum+ " and it occurs on row "+(index+1)+".");

	}

}
