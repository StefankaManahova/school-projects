package edu.generics;

import java.util.ArrayList;

public class TestArrays {
	;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> integerArray = new ArrayList<>();
		integerArray.add(Integer.valueOf(2));
		integerArray.add(Integer.valueOf(4));
		integerArray.add(Integer.valueOf(7));
		integerArray.add(Integer.valueOf(3));
		integerArray.add(Integer.valueOf(1));
		shuffle(integerArray);
		printList(integerArray);
		sort(integerArray);
		printList(integerArray);
		System.out.println(min(integerArray));

	}
	
	public static <E extends Comparable<E>> void shuffle(ArrayList<E> list) {
		int[] index = new int[list.size()];
		boolean random = false; 
		for(int i=0; i<list.size(); i++) {
			index[i] = (int)(Math.random()*list.size());
			do {
				random = false;
				for(int j=0; j<i; j++) {
					if(index[i] == index[j]) {
						random = true;
						break;
					}
				}
				
				if(random) {
					index[i] = (int)(Math.random()*list.size());
				}
			} while (random);
		}
		
		ArrayList<E> newArray = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			newArray.add(list.get(index[i]));
		}
		
		for(int i=0; i<list.size(); i++) {
			list.set(i, newArray.get(i));
		}
		
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for(int i=0; i<list.size()-1; i++) {
			for(int j=0; j<list.size()-i-1; j++) {
				if(list.get(j).compareTo(list.get(j+1)) > 0) {
					E swap = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, swap);	
				}
			}
		}

	}
	
	public static <E extends Comparable<E>> E min(ArrayList<E> list) {
		E minElement = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).compareTo(minElement) < 0) {
				minElement = list.get(i);
			}
		}
		return minElement;
		
	}

	public static <E> void printList(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}


}
