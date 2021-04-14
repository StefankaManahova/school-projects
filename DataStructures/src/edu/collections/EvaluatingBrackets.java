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
			
				for(int i=0; i<line.length(); i++) {
					char token = line.charAt(i);
					
					if(token == '{'|| token == '('|| token == '[') {
						stack.push(token);
					}
					else if(token == '}') {
						if(!stack.empty() && stack.peek().equals('{')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
					else if(token == ')') {
						if(!stack.empty() && stack.peek().equals('(')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
					else if(token == ']') {
						if(!stack.empty() && stack.peek().equals('[')) {
							stack.pop();
						}
						else {
							correctBrackets = false;
						}
					}
				}
			
			}
			
			reader.close();
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

}
