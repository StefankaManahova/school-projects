package edu.smg;

public class Tuition {

	public static void main(String[] args) {
		double tuition = 10000.0;
		double sumFourYears = 0.0;
		for ( int i=0; i < 10; i++)
		{
			tuition += tuition * 6.0/100;
			tuition =(int)(tuition*100)/100.0;
		}
		System.out.println("Given that the tuition this year is $10 000, it will increase up to $" + tuition + " in ten years.");
		for ( int i=0; i < 4; i++)
		{
			tuition += tuition * 6.0/100;
			tuition =(int)(tuition*100)/100.0;
			sumFourYears += tuition;
		}
		System.out.println("If you start your education after the tenth year (starting from the 11th), it will cost $"+sumFourYears + " in total.");
	}

}
