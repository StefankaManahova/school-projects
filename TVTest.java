package edu.smg;

public class TVTest {

	public static void main(String[] args) {
		TV homeTV = new TV();
		homeTV.channel = 45;
		homeTV.volumeLevel = 4;
		
		homeTV.turnOn();
		homeTV.channelUp();
		
		homeTV.volumeDown();
		homeTV.setChannel(2);
		homeTV.setToVolumeLevel(7);

	}

}
