package edu.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GoogleInterview {

	public static void main(String[] args) {
		final int capacity = 5;
		System.out.println("Enter a sorted array of " + capacity + " integers:");
		Scanner sc = new Scanner(System.in);
	
		int sum = 8;
		int[] array = new int[capacity];
		for(int i=0; i<capacity; i++) {
			array[i] = sc.nextInt();
		}
		
		int[] indexes = findUsingBinarySearch(array,sum);
		if(indexes[0] == -1) {
			System.out.println("There isn't a pair of numbers in the array that add up to " + sum + ".");
		}
		else {
			System.out.println("The numbers " + array[indexes[0]] + " and " + array[indexes[1]] + 
					" on indexes " + indexes[0] + " and " + indexes[1] + " add up to " + sum + " :)");
		}
	}
	
	public static int[] findUsingTwoLoops(int[] array, int sum) {
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length;j++) {
				if(array[i] + array[j] == sum) {
					int[] indexes = {i,j};
					return indexes;
				}
			}
		}
		int[] indexes = {-1,-1};
		return indexes;
	}//T(n) = O(n^2)

	public static int[] findUsingBinarySearch(int[] array, int sum) {//the array must be sorted
		for(int i=0; i<array.length; i++) {
			int low = 0;
			int high = array.length - 1;
			while(high >= low) {
				int mid = (low + high)/2;
				if(array[mid] > sum - array[i]) {
					high = mid - 1;
				}
				else if(array[mid] == sum - array[i]) {
					int[] indexes = {i,mid};
					return indexes;
				}
				else { //array[mid] < sum - array[i]
					low = mid + 1;
				}
			}
		}
		int[] indexes = {-1,-1};
		return indexes;
	}//T(n) = O(nlogn)
	
	public static int[] findUsingTwoPoints(int[] array, int sum) {//the array must be sorted
		int low = 0;
		int high = array.length - 1;
		while(high > low) {
			int currentSum = array[high] + array[low];
			if(currentSum == sum) {
				int[] indexes =  {low,high};
				return indexes;
			}
			else if(currentSum > sum) {
				high--;
			}
			else {//currentSum < sum
				low++;
			}				
		}
		int[] indexes = {-1,-1};
		return indexes;	
	}//T(n) = O(n)
	
	public static int[] findUsingHashMap(int[] array, int sum) {//the array doesn't have be sorted
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//elements - keys, indexes - values
		for(int i=0; i<array.length; i++) {
			if(map.containsKey(array[i])) {
				int[] indexes = {map.get(array[i]),i};
				return indexes;
			}
			if(!map.containsKey(sum - array[i])){
				map.put(sum - array[i],i);
			}
		}
		int[] indexes = {-1,-1};
		return indexes;
	}//T(n) = O(n)
}
