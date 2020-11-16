package edu.objects;

public class TestTime {

	public static void main(String[] args) {
		Time timeCurrent = new Time();
		Time time1 = new Time(555550000);
		Time time2 = new Time(5,23,55);
		
		System.out.println("The current time is "+((timeCurrent.getHour()<10)?"0":"")+timeCurrent.getHour()
		                   +":"+((timeCurrent.getMinute()<10)?"0":"")+timeCurrent.getMinute()
		                   +":"+((timeCurrent.getSecond()<10)?"0":"")+timeCurrent.getSecond());
		
		System.out.println("The first set time is "+((time1.getHour()<10)?"0":"")+time1.getHour()
        +":"+((time1.getMinute()<10)?"0":"")+time1.getMinute()
        +":"+((time1.getSecond()<10)?"0":"")+time1.getSecond());
		
		System.out.println("The second set time is "+((time2.getHour()<10)?"0":"")+time2.getHour()
        +":"+((time2.getMinute()<10)?"0":"")+time2.getMinute()
        +":"+((time2.getSecond()<10)?"0":"")+time2.getSecond());
	}

}
