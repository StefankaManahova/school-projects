package edu.smg;

import java.util.Scanner;

public class AnswerKeys {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	final int numberOfQuestions = 6;
	final int numberOfStudents = 3;
	
	String[] key = new String[numberOfQuestions];
    System.out.println("What is the answer key?");
    for(int i=0; i<numberOfQuestions; i++)
    {
    	key[i] = sc.nextLine();
    	
    }
  String[][] answers = new String[numberOfStudents][numberOfQuestions];
    
    for(int j=0; j<numberOfStudents; j++) {
    	System.out.println("What are the answers of the "+(j+1)+". student?");
    	for(int i=0; i<numberOfQuestions; i++) {
    		answers[j][i] = sc.nextLine();
    	}
    }
    int[] score = new int[numberOfStudents];
    
    for(int j=0; j<numberOfStudents; j++) {
    	for(int i=0; i<numberOfQuestions; i++) {
    		score[j] += (answers[j][i].equals(key[i]))? 1 : 0;
    	}
    }
    
    for( int j=0; j<numberOfStudents; j++) {
    	System.out.println("The "+(j+1)+". student's score is "+ score[j]+ ((score[j]!=1)?" points." : " point."));
    }

	}

}
