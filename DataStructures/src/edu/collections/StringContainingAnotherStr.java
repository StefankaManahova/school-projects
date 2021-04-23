package edu.collections;

import java.util.Scanner;

public class StringContainingAnotherStr {

	public static void main(String[] args) {
		System.out.println("Enter the main string:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Enter the string that you want to search for in the main string:");
		String key = sc.nextLine();
		int index = contains_2(str,key);
		if (index == -1) {
			System.out.println("The main string doesn't contain the key string.");
		}
		else {
			System.out.println("The main string contains the key string at index " + index);
		}

	}
	
	public static int contains(String str, String key) {
		//T(n,k) = ((n-k+1)*c)*(k*c) = (n-k+1)*k*c*c = c*c*n*k - c*c*k*k + k*c*c = O(n*k) - O(k*k) + O(k)
		//T(n,k) = O(n*k)
		int keyLength = key.length();
		int strLength = str.length();
		for (int i=0; i<strLength-keyLength+1; i++) {//O(n-k+1) = O(n)
			String substr = str.substring(i, i+keyLength);
			if (substr.equals(key)) {// O(k)
				return i;
			}
		}
		return -1;
	}
	
	public static int contains_2(String str, String key) {
		//O(n*k)
		int index = -1;
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == key.charAt(0) && count == 0) {
				count++;
				index = i;
			}
			else if(count != 0) {
				if(str.charAt(i) == key.charAt(count)) {
					count++;
				}
				else {
					index = -1;
					i -= count;
					count = 0;
				}
			}
			
			if(count == key.length()) {
				break;
			}
		}
		
		if(count != key.length()) {//we need to make sure that there isn't a part of the key right at the end of the main str
			index = -1;
			count = 0;
		}
		return index;
	}
}
