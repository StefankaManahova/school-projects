package edu.collections;

import java.io.*;
import java.util.*;

public class VowelsAndConsonants {
	public static void main(String[] args){
		File text = new File("src/edu/collections/song_lyrics.txt");
		try {
			System.out.println("The text contains " + numberOfVowels(text) + " vowels and " + numberOfConsonants(text) + " consonants.");
		} 
		catch (Exception e) {
			System.out.println("Sadly, the file doesn't exist :(");
		}
	}

	public static int numberOfVowels(File text) throws Exception {
		Character[] vowels = {'A', 'O', 'E', 'U', 'I', 'a', 'o', 'e', 'u', 'i'};
		Set<Character> vowelsSet = new HashSet<Character>(Arrays.asList(vowels));
		int count = 0;
		
		Scanner reader = new Scanner(text);
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
		    for (int i=0; i<line.length(); i++) {
		    	if(vowelsSet.contains(line.charAt(i))) {
		    		count++;
		    	}
		    }
		}
		return count;		
	}
	
	public static int numberOfConsonants(File text) throws Exception {
		Character[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		Set<Character> consonantsSet = new HashSet<Character>(Arrays.asList(consonants));
		int count = 0;
		
		Scanner reader = new Scanner(text);
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
		    for (int i=0; i<line.length(); i++) {
		    	if(consonantsSet.contains(line.charAt(i))) {
		    		count++;
		    	}
		    }
		}
		return count;		
	}
}
