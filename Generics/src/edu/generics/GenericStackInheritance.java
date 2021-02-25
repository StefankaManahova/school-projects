package edu.generics;

import java.util.ArrayList;

public class GenericStackInheritance<E> extends ArrayList<E> {
	
   public GenericStackInheritance() {
	   super();
   }
   
   public int getSize() {
	   return super.size();
   }
   
   public E peek() {
	   return super.get(getSize()-1);
   }
   
   public E pop() {
	   E o = super.get(getSize()-1);
	   super.remove(getSize()-1);
	   return o;
   }
   
   public void push(E o) {
	   super.add(o);
   }
   
   public boolean isEmpty() {
	   return super.isEmpty();
   }
}
