package edu.smg;

import java.util.Scanner;

public class AnagramsNew {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("What is the first word?");
		String word1 = sc.nextLine();
		System.out.println("What is the second word?");
		String word2 = sc.nextLine();
		String copy2 = word2;
		boolean isAnagram = true;
	
		for(int i = 0; i < word1.length(); i++)
		{
			if(word1.charAt(i)>= 'a'&& word1.charAt(i)<= 'z' || word1.charAt(i)>= 'A'&& word1.charAt(i)<='Z')
			{  
				char charInWord1 = word1.charAt(i);
			    int indexIn2 = copy2.indexOf(charInWord1);
				if (indexIn2 == -1)
				{
					isAnagram = false;
					break;
				}
				else
				{
					copy2 = copy2.substring(0,indexIn2)+copy2.substring(indexIn2+1);
				}
				
			}
			
		}
//		System.out.println("\n"+copy2);
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
