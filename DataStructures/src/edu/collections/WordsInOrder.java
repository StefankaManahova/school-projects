package edu.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordsInOrder {
	public static void main(String[] args) {
		ArrayList<String> words= new ArrayList<>();
		File file = new File("src/edu/collections/song_lyrics.txt");
		
		try {
			Scanner myReader = new Scanner(file);
			while(myReader.hasNextLine()) {
				String line = myReader.nextLine();
				//System.out.println(line);
				String[] wordsInLine = line.split("[\\s.,()?]+");
				words.addAll(Arrays.asList(wordsInLine));
			}
			myReader.close();
			
		} catch(FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch(IOException e1){
				e1.printStackTrace();
			}
		}
		Collections.sort(words);
		System.out.println(words);
	}
}
