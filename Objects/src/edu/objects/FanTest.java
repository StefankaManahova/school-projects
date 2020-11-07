package edu.objects;

public class FanTest {

	public static void main(String[] args) {
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10);
		fan1.setColour("yellow");
	    fan1.setSwitchedOn(true);
		
		fan2.setSpeed(Fan.MEDIUM);
		fan2.setColour("blue");
		fan2.setRadius(5);
	    fan2.setSwitchedOn(false);
		
		
//		System.out.println(fan1.isSwitchedOn());
//		System.out.println(fan2.isSwitchedOn());
		
		System.out.println("First fan:"+fan1.toString());
		System.out.println("Second fan:"+fan2.toString());
		
		

	}

}
