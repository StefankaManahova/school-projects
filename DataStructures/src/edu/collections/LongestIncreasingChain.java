package edu.collections;

import java.util.LinkedList;
import java.util.Scanner;

/*This programme finds the longest increasing sequence of chars (compared by their ASCII codes)
in a given string. Note that the chars don't need to be consecutive, but can only be separated by chars that 
are smaller than the left one. For example, in the string "azbcd" we don't consider "abcd" as the longest sequence since 'z' is 
bigger than 'a' and comes between 'a' and 'b'*/

public class LongestIncreasingChain {
	//T(n) = ((n-1) + (n-2) + ... + 1)*c = c*n*(n-1)/2 = c*n*n/2 - c*n/2 = O(n^2)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String string = sc.nextLine();
		
		LinkedList<Character> max = new LinkedList<>();
		LinkedList<Character> list = new LinkedList<Character>();
		
		for(int i=0; i<string.length(); i++) {
			list.add(string.charAt(i));
			for(int j=i+1; j<string.length(); j++) {
				if(string.charAt(j) > list.getLast()) {
					list.add(string.charAt(j));
				}
			}
			if(max.size() < list.size()) {
				max.clear();
				max.addAll(list);
			}
			list.clear();
		}
		
		System.out.println(max.toString());

	}

}
