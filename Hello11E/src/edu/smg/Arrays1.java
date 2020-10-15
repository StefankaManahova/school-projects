package edu.smg;

public class Arrays1 {

	public static void main(String[] args) {
		int[] array = new int[20];
		for(int i=0; i<20; i++) {
			array[i] =(int)(Math.random()*20) + 1;
		}
		for(int i=0; i<20; i++) {
			System.out.println(array[i]);
		}

	}

}
