package edu.smg;

public class TV {
  public int channel = 1;
  public int volumeLevel = 1;
  public boolean on = false;
  
  TV(){
	  
  }
  public void turnOn(){
	  on = true;
	  System.out.println("The TV is on.");
  }
  public void turnOff(){
	  on = false;;
	  System.out.println("The TV is off.");
  }
  public void setChannel(int newChannel){
	  if(newChannel < 1 || newChannel > 120){
		  System.out.println("This channel doesn't exist");
		  return;
	  }
	  channel = newChannel;
	  System.out.println("You are currently watching channel "+ channel);
  }
  public void setToVolumeLevel(int newVolumeLevel){
	  if(newVolumeLevel<1 || newVolumeLevel>7){
		  System.out.println("The volume level isn't accesible");
		  return;
	  }
	  volumeLevel = newVolumeLevel;
	  System.out.println("You are currently at volume level "+ volumeLevel);
  }

public void channelUp(){
	channel++;
	if(channel>120){
		 System.out.println("This channel doesn't exist");
		 return;
	}
	System.out.println("You are currently watching channel "+ channel);
  }
public void channelDown(){
	channel--;
	if(channel<1){
		 System.out.println("This channel doesn't exist");
		 return;
	}
	System.out.println("You are currently watching channel "+ channel);
  }
public void volumeUp(){
	volumeLevel++;
	if(volumeLevel>7){
		 System.out.println("This volume level doesn't exist");
		 return;
	}
	System.out.println("You are currently at volume level "+ volumeLevel);
  }
public void volumeDown(){
	volumeLevel--;
	if(volumeLevel<1){
		 System.out.println("This volume level doesn't exist");
		 return;
	}
	System.out.println("You are currently at volume Level  "+ volumeLevel);
  }

}
