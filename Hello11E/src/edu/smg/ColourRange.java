package edu.smg;

import java.util.Scanner;

public class ColourRange {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner (System.in);
    System.out.println("Please enter the wavelenth in nanometers:");
	double wavelength = sc.nextDouble();
	
	if ( wavelength < 380 || wavelength >= 750 ) 
		{
		  System.out.println("The entered wavelength is not a part of the visible spectrum.");
		}
	else 
		{
		  System.out.print("The colour is ");
		  if ( wavelength >= 380 && wavelength < 450)
		  	{
			  System.out.println("Violet.");
		  	}
		  else if( wavelength >= 450 && wavelength < 499)
		  	{
			 System.out.println("Blue.");
		  	}
		  else if( wavelength >= 499 && wavelength < 570)
		  	{
			 System.out.println("Green.");
		  	}
		  else if( wavelength >= 570 && wavelength < 590)
		  	{
			 System.out.println("Yellow.");
		  	}
		  else if( wavelength >= 590 && wavelength < 620)
		  	{
			 System.out.println("Orange.");
		  	}
		  else if( wavelength >= 620 && wavelength < 750)
		  	{
			 System.out.println("Red.");
		  	}
	}
	sc.close();
  }
}
