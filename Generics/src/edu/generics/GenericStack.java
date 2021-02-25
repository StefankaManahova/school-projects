package edu.generics;

public class GenericStack<E> {
	 private int elements = 0;
	 private int maximumElements = 3;
     private E[] array = (E[]) new Object[maximumElements];
     
     
     public GenericStack() {
    	 
     }
     
     public int getSize() {
    	 return elements;
     }
     
     public E peek() {
    	 return array[elements - 1];
     }
     
     public void push(E o) {
    	 if(array[maximumElements - 1] == null) {
    		 array[elements] = o;
    		 elements++;
    	 }
    	 else {
    		 int lastValueOfElements = maximumElements;
    		 maximumElements *= 2;
    		 E[] secondArray = (E[]) new Object[maximumElements];
    		 for(int i=0; i < lastValueOfElements; i++) {
    			 secondArray[i] = array[i];
    		 }
    		 array = secondArray;
    		 array[elements] = o;
    		 elements++;
    	 }
     }
     
     public E pop() {
    	 E o = array[elements - 1];
    	 array[elements - 1] = null;
    	 elements--;
    	 return o;
     }
	
     public boolean isEmpty() {
    	 return array[0] == null;
     }
     
}
