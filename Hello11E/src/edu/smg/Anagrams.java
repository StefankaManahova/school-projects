package edu.smg;

import java.util.Scanner;

public class Anagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("What is the first word?");
		String word1 = sc.nextLine();
		System.out.println("What is the second word?");
		String word2 = sc.nextLine();
		String copy2 = word2;
		boolean missingFromWord2 = true;
		boolean isAnagram = true;
		
		System.out.println(copy2.length());
		System.out.println(word1.length());
		for(int i = 0; i < word1.length(); i++)
		{
			if(word1.charAt(i)>= 'a'&& word1.charAt(i)<= 'z' || word1.charAt(i)>= 'A'&& word1.charAt(i)<='Z')
			{
				for( int j=0; j < copy2.length();j++)
				{
					if(copy2.charAt(j) == word1.charAt(i)){
						copy2 = copy2.substring(0,j)+copy2.substring(j+1);
						missingFromWord2 = false;
						break;
					}
					System.out.println(copy2);
				}
				if(missingFromWord2){
					isAnagram = false;
					break;
				}
			}
			missingFromWord2 = true;
		}
		System.out.println("\n"+copy2);
		for(int i = 0; i < copy2.length(); i++)
		{
			if(copy2.charAt(i)>= 'a'&& copy2.charAt(i)<= 'z' || copy2.charAt(i)>= 'A'&& copy2.charAt(i)<= 'Z')
			{
				isAnagram = false;
			    break;
			}
		}
		
		

		if(isAnagram)
		{
			System.out.println("The second phrase is an anagram of the first.");
		}
		else
		{
			System.out.println("The second phrase is not an anagram of the first.");
		}
		sc.close();
	}
}
