package stacks;

import java.util.LinkedList;

abstract class Animal{
	int timestamp;

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
}
 
  class Dog extends Animal{
		
 }
 
  class Cat extends Animal{
		
 }






public class AnimalShelter {

	/*
	 * Animal Shelter of dogs and cats
	 * Firstin first out
	 * customer must get first in Animal
	 * They can choose only animal Type not the specific animal because animal which came first must out first
	 */
	
  LinkedList<Animal> dogList = new LinkedList<Animal>();
  LinkedList<Animal> catList = new LinkedList<Animal>();  
  int top = -1;
  
  private void enQueue(Animal animal) {
	  
	  animal.setTimestamp(++top);
	  
	  if (animal instanceof Dog) {
		 
		  dogList.addLast(animal);
		  
	  }else {
		 
		  catList.addLast(animal);
	  }
		  
	 
	 	  
  }
  
  private Animal deQueueAny() {
	  
	 if(catList.isEmpty())  return deQueueDog();
	 else  if(dogList.isEmpty())  return deQueueCat();
	
	 else {
		 
	 
	    if(  catList.peekFirst().getTimestamp() > dogList.peekFirst().getTimestamp()) {
			return deQueueDog();
		}
		 else
			 return deQueueCat() ;
	  }
	 
  }
  
  private Animal deQueueDog() {
	  return dogList.pollFirst();
	  
  }
  
  private Animal deQueueCat() {
	  
	  return catList.pollFirst();
  }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
