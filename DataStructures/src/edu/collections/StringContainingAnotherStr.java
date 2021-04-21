package edu.collections;

import java.util.Scanner;

public class StringContainingAnotherStr {

	public static void main(String[] args) {
		System.out.println("Enter the main string:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Enter the string that you want to search for in the main string:");
		String key = sc.nextLine();
		int index = contains(str,key);
		if (index == -1) {
			System.out.println("The main string doesn't contain the key string.");
		}
		else {
			System.out.println("The main string contains the key string at index " + index);
		}

	}
	
	public static int contains(String str, String key) {
		//O(n)
		int keyLength = key.length();
		int strLength = str.length();
		for (int i=0; i<strLength-keyLength+1; i++) {
			String substr = str.substring(i, i+keyLength);
			if (substr.equals(key)) {
				return i;
			}
		}
		return -1;
	}

}
