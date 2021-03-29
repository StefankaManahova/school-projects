package edu.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class EvaluatingBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File javaFile = new File("src/edu/collections/DLL.java");
		Stack<Character> stack = new Stack<Character>();
		boolean correctBrackets = true;
		
		try {
			Scanner reader = new Scanner(javaFile);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				line = insertBlanks(line);
				String[] words = line.split("[\\s]");
				for(String word : words) {
					if(word.length()==0) {
						continue;
					}
					else if( word.charAt(0) == '{'|| word.charAt(0) == '('|| word.charAt(0) == '[') {
						stack.push(word.charAt(0));
					}
					else if(word.charAt(0) == '}') {
						if(!stack.empty() && stack.peek().equals('{')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
					else if(word.charAt(0) == ')') {
						if(!stack.empty() && stack.peek().equals('(')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
					else if(word.charAt(0) == ']') {
						if(!stack.empty() && stack.peek().equals('[')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
				}
			
			}
			
			if(correctBrackets && stack.empty()) {
				System.out.println("The brackets are correctly distributed.");
			}
			else {
				System.out.println("The brackets aren't distributed correctly.");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String insertBlanks(String s) {
		String result = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(' ||s.charAt(i) == ')' || s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == '[' ||s.charAt(i) == ']') {
				result += " " + s.charAt(i) + " ";
			}
			else {
				result += s.charAt(i);
			}
		}
		return result;
	}

}
