package edu.smg;

import javax.swing.JOptionPane;

public class MultiPlanetaryWeight {

	public static void main(String[] args) {
	  double weight = Double.parseDouble(JOptionPane.showInputDialog(null,"Please enter your weight on Earth in kg:"));
	  
	  String [] planets = {"Mercury","Venus","Mars","Jupiter","Saturn","Uranus","Neptune"};
	  String chosenPlanet = (String)JOptionPane.showInputDialog(null, "Now choose a planet:","Planet", 1, null, planets, planets[2]);
	  
	  double newWeight = weight;
	  if ( chosenPlanet.equals("Mercury")) 
	  {
		  newWeight = weight * 0.38;
	  }
	  else if (chosenPlanet.equals("Venus")) 
	  {
		  newWeight = weight * 0.91;
	  }
	  else if (chosenPlanet.equals("Mars")) 
	  {
		  newWeight = weight * 0.38;
	  }
	  else if (chosenPlanet.equals("Jupiter")) 
	  {
		  newWeight = weight * 2.36;
	  }
	  else if (chosenPlanet.equals("Saturn")) 
	  {
		  newWeight = weight * 0.92;
	  }
	  else if (chosenPlanet.equals("Uranus")) 
	  {
		  newWeight = weight * 0.89;
	  }
	  else if (chosenPlanet.equals("Neptune")) 
	  {
		  newWeight = weight * 1.13;
	  }
	  newWeight = (int)(newWeight * 100)/100.0;
	  System.out.println("Your weight on "+ chosenPlanet + " is " + newWeight + " kg.");
	}

}
