package edu.smg;

import java.util.Scanner;

public class AnswerKeys {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	final int numberOfQuestions = 10;
	final int numberOfStudents = 8;
	
	String[] key = new String[numberOfQuestions];
    System.out.println("What is the answer key?");
    for(int i=0; i<numberOfQuestions; i++)
    {
    	key[i] = sc.nextLine();
    	
    }

	}

}
