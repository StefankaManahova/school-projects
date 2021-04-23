package edu.smg;

import java.util.Scanner;

public class ArraysTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = 10;
		int[] array = new int[arraySize];
		int numberOfIncreasingMax = 0;
		int startingIndex = 0, j=0, i=0;
		for(int k=0; k<arraySize; k++)
	      {
	    	  System.out.println("Input a number on position " + k);
	    	  array[k]=sc.nextInt();
	      }
		while( i < arraySize-2)
		{
			j = 1;
			while(array[i+j-1]<array[i+j])
			{
				j++;
			}
			if(j > numberOfIncreasingMax)
			{
				numberOfIncreasingMax = j;
				startingIndex = i;
			}
			i = i+j;
		}
		System.out.println( numberOfIncreasingMax+" , staring from inex "+startingIndex);

	}
}
