package edu.algorithms;

import java.util.Comparator;

public class MergeSortComparator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] list = {new Circle(2),new Circle(7),new Circle(6),new Circle(4),new Circle(3),new Circle(1)};
		mergeSort(list, new CircleComparator());
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + "  ");
		}
	}
	
	public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
		if (list.length > 1) {
			// Merge sort the first half
			E[] firstHalf = (E[]) new Object[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf, comparator);
			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[]) new Object[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf, comparator);
			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list, comparator);
		}
	}
	/** Merge two sorted lists */
	public static <E> void merge(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (comparator.compare(list1[current1],list2[current2]) < 0) {
				temp[current3++] = list1[current1++];
			}
			else {
				temp[current3++] = list2[current2++];
			}
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

}
