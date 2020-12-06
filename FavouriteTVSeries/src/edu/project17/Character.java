package edu.project17;

import java.util.ArrayList;

public class Character {
   String name;
   String description;
   ArrayList<Actor> actor;
   
   Character(){
	   actor = new ArrayList<Actor>();
   }
   
   public String toString() {
	   String result =  "\n"+this.name+", "+this.description;
	   for(Actor actor : this.actor) {
		   result += " (" + actor.name +") ";
	   }
	   return result;
   }
}
