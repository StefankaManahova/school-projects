package edu.smg;

import java.util.Scanner;

public class TransposedMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many rows does the matrix have?");
		int rows = sc.nextInt();
		System.out.println("How many columns does the matrix have?");
		int columns = sc.nextInt();
		
		int[][] matrix = new int[rows][columns];
		
		for(int i=0; i<rows; i++) {
			
			System.out.println("Input the elements on the "+ (i+1)+". row:");
			for(int j=0; j<columns; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int[][] transpose = new int[columns][rows];
		
		for(int i=0; i<rows; i++) {
			for(int j=0;j<columns;j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
		for(int j=0; j<columns; j++) {
			for(int i=0;i<rows;i++) {
				System.out.print(transpose[j][i]+" ");
			}
			System.out.print("\n");
		}
		
	}

}
