package edu.smg;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int[][] grid = new int [9][9];
		boolean isSudoku = true;
		int index = 0;
		
		System.out.println("Please enter the sudoku grid:");
		for( int i=0; i<9; i++ ) {
			for( int j=0; j<9; j++ ) {
				grid[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		sc.close();
		
		for( int i=0; i<9; i++ ) {
			for( int j=0; j<9; j++ ) {
				if(grid[i][j]!=1 && grid[i][j]!=2 && grid[i][j]!=3 && grid[i][j]!=4 && grid[i][j]!=5 && grid[i][j]!=6 && grid[i][j]!=7 &&grid[i][j]!=8 && grid[i][j]!=9)
				{
					isSudoku = false;
					break;
				}
			}
		}
		
		if(!isSudoku) {
			System.out.println("It's not a sudoku grid :(");
		}
		else 
		{
			int [] digitsPerSection = new int[9];
			
			for( int i=0; i<9; i++ ) {
				for( int j=0; j<9; j++ ) {
					index = grid[i][j] - 1;
					digitsPerSection[index] = 1;
				}
				for(int n : digitsPerSection) {
					if(n!=1)
					{
						isSudoku = false;
						break;
					}
				}
				if(!isSudoku) {
					break;
				}
				for( index=0; index<9; index++ ) {
					digitsPerSection[index] = 0;
				}
			}//обхожда по редове
			
			
			
			for( int j=0; j<9; j++ ) {
				for( int i=0; i<9; i++ ) {
					index = grid[i][j] - 1;
					digitsPerSection[index] = 1;
				}
				for(int n : digitsPerSection) {
					if(n!=1)
					{
						isSudoku = false;
						break;
					}
				}
				if(!isSudoku) {
					break;
				}
				for( index=0; index<9; index++ ) {
					digitsPerSection[index] = 0;
				}
			}//обхожда по колони
			
			
			for( int k=0; k<9; k+=3 ) {
				for( int p =0; p<9; p+=3 ) {
					for(int i=k; i<k+3; i++) {
						for(int j=p; j<p+3;j++) {
							index = grid[i][j] - 1;
							digitsPerSection[index] = 1;
						}
					}
					for( int n : digitsPerSection)
					{
						if(n!=1) {
							isSudoku = false;
							break;
						}
					}
					if(!isSudoku) break;
					for( index=0; index<9; index++) {
						digitsPerSection[index]=0;
					}
				}//close the for with p
			 if(!isSudoku) {
				 break;
			 }
			}//close the for with k
			
			if(isSudoku) {
				System.out.println("Congratulations! Your grid is a sudoku! ;)");
			}
			else {
				System.out.println("It's not a sudoku grid :(");
			}
				
		}//close the else after checking if all the numbers are from 1 to 9

	}//close the main

}//close the class
