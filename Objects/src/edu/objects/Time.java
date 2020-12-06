package edu.objects;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	Time(){
		
		long milliseconds = System.currentTimeMillis();
		this.hour = (int)((milliseconds/3_600_000 + 2)%24);
		milliseconds %= 3_600_000;
		this.minute = (int)(milliseconds/60_000);
		milliseconds %= 60_000;
		this.second =(int)(milliseconds/1000);		
		
	}
	
	Time(int hour, int minute, int second){
		
		if(hour>=0 && hour<=23 && minute>=0 && minute<=59 && second>=0 && second<=59)
		{
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		else {
			System.out.println("The data is incorrect. A Time object couldn't be created.");
		}
	}
	
	Time (long milliseconds){
		this.hour = (int)((milliseconds/3_600_000 + 2)%24);
		milliseconds %= 3_600_000;
		this.minute = (int)(milliseconds/60_000);
		milliseconds %= 60_000;
		this.second =(int)(milliseconds/1000);	
	}
	

	public int getSecond() {
		return second;
	}

	public int getMinute() {
		return minute;
	}

	public int getHour() {
		return hour;
	}
	public void setTime(long milliseconds) {
		this.hour = (int)((milliseconds/3_600_000 + 2)%24);
		milliseconds %= 3_600_000;
		this.minute = (int)(milliseconds/60_000);
		milliseconds %= 60_000;
		this.second =(int)(milliseconds/1000);	
	}


}
