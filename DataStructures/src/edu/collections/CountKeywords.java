package edu.collections;

import java.util.*;
import java.io.*;

public class CountKeywords {
	public static void main(String[] args) throws Exception {
		File file = new File("src/edu/collections/PostfixNotation.java");
		if (file.exists()) {
			System.out.println("The number of keywords is " + countKeywords(file));
		} else {
			System.out.println("File does not exist");
		}

	}

	public static int countKeywords(File file) throws Exception {
    // Array of all Java keywords + true, false and null
		String[] keywordString = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
				"const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
				"float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
				"true", "false", "null" };
		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
		int count = 0;

		Scanner input = new Scanner(file);
		Stack<Character> quotesStack = new Stack<Character>();
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] wordsInLine = line.split("[\\s.,().]+");
			for (String word : wordsInLine) {
				if (word.length() == 0) {
					continue;
				}
				else if (word.length() > 1 && word.charAt(0) == '/' && word.charAt(1) == '/') {
					break;
				}
				else if (word.charAt(0) == '"') {
					/*We don't have to check 
					if after " follows a key word since we shouldn't count key words inside quotes anyway*/
					if (quotesStack.empty()) {
						quotesStack.push('"');
					}
					else {
						quotesStack.pop();
					}
				}
				else if (keywordSet.contains(word)) {
					if (quotesStack.empty()) {
						count++;
					}
				}
		
			}
		}
		return count;
	}
}
