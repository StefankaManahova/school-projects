package edu.collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LongestIncreasingSequence {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			System.out.println(longestAscendingRow(str));
		}
		public static String longestAscendingRow(String s) {
			//T(n) = O(n^3) ili T(n) = O(n^2)?
			ArrayList<String> strings = new ArrayList<String>();
			strings.add("" + s.charAt(0));
			//T(n) = n^2
			//Идея: Hачалото на търсения стринг е символ, преди който няма по-малки символи
			// Създаваме стрингове, които започват с потенциален първи символ, 
			// а остатъка от стринга са всички символи в редицата след първия в низа ни, които са по-големи от него
			for(int i=1; i<s.length(); i++) {
				int numberOfFirstElement;
				for(numberOfFirstElement = 0; numberOfFirstElement<strings.size(); numberOfFirstElement++ ) {
					if(strings.get(numberOfFirstElement).charAt(0)<s.charAt(i))
						strings.set(numberOfFirstElement, strings.get(numberOfFirstElement) + s.charAt(i));
					else if(strings.get(numberOfFirstElement).charAt(0)>s.charAt(i))
						strings.add("" + s.charAt(i));
				}
			}
			//T(n) = O(n) + O(n^3)?
			// Прилагаме рекурсивна стъпка за всеки един от получените низове
			for(int i = 0; i < strings.size(); i++) {
				if(strings.get(i).length()>1)
					strings.set(i, strings.get(i).charAt(0) + longestAscendingRow(strings.get(i).substring(1)));
			}
			//T(n) = n
			// сравняваме новите низове по дължина и извеждаме най-дългия от тях
			while(strings.size()>1){
				if(strings.get(0).length()<strings.get(1).length())
					strings.remove(0);
				else
					strings.remove(1);
			}
			return strings.get(0);
			//Пример: welcome
			//Стрингове преди рекурсията: 
			//w
			//elom
			//come
			//Стрингове след рекурсията:
			//w
			//elo
			//co
			//Отговор: elo
		}
	
}
