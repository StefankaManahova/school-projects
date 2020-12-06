package edu.objects;

public class Course {
  private String  courseName;
  private String[] students = new String[100];
  private int numberOfStudents = 0;
  
  Course(String courseName){
	  this.courseName = courseName;
  }
  
  public String getCourseName() {
	  return this.courseName;
  }

  public String[] getStudents() {
	return students;
  }

  public int getNumberOfStudents() {
	return numberOfStudents;
  }
  
  public void addStudent(String student) {
	  if(numberOfStudents < 100) {
		  boolean takingCourse = false;
		  for(int i=0;i<numberOfStudents; i++) {
			  if(student.equals(students[i])) {
				  System.out.println("This student is already taking this course");
				  takingCourse = true;
				  break;
			  }
		  }
		  if(!takingCourse) {
		  numberOfStudents++;
		  students[numberOfStudents-1] = student;
		  }
	  }
	  else {
		  System.out.println("Sorry, but there are no more free places in this course.");
	  }
  }
  
  public void dropStudent(String student) {
	  boolean isInCourse = false;
	  for(int i=0; i<numberOfStudents; i++) {
		  if(student.equals(students[i])) {
			  isInCourse = true;
			  for(int j=i;j<numberOfStudents-1;j++) {
				  students[j] = students[j+1];
			  }
			  students[numberOfStudents-1] = null;
			  numberOfStudents--;
			  break;
		  }
	  }
	  if(!isInCourse) {
		  System.out.println("This student isn't taking this class und therefore can't drop");
	  }
  }
  
}
