package edu.smg;

import java.util.Scanner;

public class Paint {

	public static void main(String[] args) {
		double height, width, length;
		
		Scanner sc = new Scanner (System.in);
		System.out.println("What is the height of the room in meters?");
		height = sc.nextDouble();
		
		System.out.println("What is the width of the room in meters?");
		width = sc.nextDouble();
		
		System.out.println("What is the length of the room in meters?");
		length = sc.nextDouble();
		
		double area = 2 * width * height + 2 * length * height + width * length;
		int number1LBuckets = 0;
		int number5LBuckets = (int)(area / 140);
		if( area % 140 <=90) {//3 cans (or less) covering 30 m2 each cost less than one can covering 140 sq. meters
			number1LBuckets = (int)((area % 140)/30);
			
			if( (number5LBuckets*140 + number1LBuckets*30) < area ) 
			{
				number1LBuckets++;
			}
		}
		else //area % 140 > 90 meaning we need at least 4 cans of 4$ but they cost more than one of 15$
		{
			number5LBuckets++;
		}
		double price = number5LBuckets * 15 + number1LBuckets * 4;
		
		System.out.println("The area you need to paint is " + area + " square meters.");
		
		if (number5LBuckets >= 2)
		{
			System.out.print("You will need to buy " + number5LBuckets + " 5-liter cans ");
		
		}
		else if(number5LBuckets == 1) 
		{
			System.out.print("You will need to buy " + number5LBuckets + " 5-liter can ");
		}
		else 
		{
			System.out.print("You will need to buy ");
		}
		
		if(number1LBuckets >= 2 && number5LBuckets != 0) 
		{
			System.out.print("and "+ number1LBuckets + " 1-liter cans4"
					+ " (" + (number5LBuckets + number1LBuckets)
			+ " cans in total). That will cost ");
		}
		else if(number1LBuckets >= 2 && number5LBuckets == 0) 
		{
			System.out.print(number1LBuckets + " 1-liter cans "
					+ " (" + (number5LBuckets + number1LBuckets)
			+ " cans in total). That will cost ");
		}
		else if(number1LBuckets ==1 && number5LBuckets!=0)
		{
			System.out.print("and "+ number1LBuckets + " 1-liter can (" + (number5LBuckets + number1LBuckets)
			+ " cans in total). That will cost ");
		}
		else if(number1LBuckets ==1 && number5LBuckets==0)
		{
			System.out.print(number1LBuckets + " 1-liter can (" + (number5LBuckets + number1LBuckets)
			+ " cans in total). That will cost ");
		}
		else 
		{
			System.out.print("(" + (number5LBuckets + number1LBuckets)
					+ " cans in total). That will cost ");
		}
		System.out.println(price + " $. Have a nice day!");
	}

}
