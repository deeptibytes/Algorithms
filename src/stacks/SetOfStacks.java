package stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	
	private ArrayList<Stack<Integer>> stackList;
	private int capacity;//maxSize of eacj stack in the SetOfStacks
	//private int size;
	
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		stackList = new ArrayList<Stack<Integer>>();
	}
	
	private int pop() {
		
			Stack<Integer> lastStack = getLastStack();
			if(lastStack == null) {
				System.out.println("Stack does not have any emenet");
			}
			
			int element =  lastStack.pop();
			if(lastStack.isEmpty()) {//lastStack.size() == 0, stack gets empty after popping
				stackList.remove(lastStack);
			}
			
			System.out.println("stackList size after pop is "+ stackList.size() +"*** "+"stack size is "+getLastStack().size());
			
			return element;
		
		

	
	}
	private void push(int element) {
		
		Stack<Integer> lastStack = getLastStack();
		
		if(lastStack ==null || lastStack.size() == capacity) { //this limits the stack capacity
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(element);
			stackList.add(newStack);
		}else {
			lastStack.push(element);
		}
				
		System.out.println("stackList size after push is "+ stackList.size() +"*** "+"stack size is "+getLastStack().size());
			
	}
	
	
	private Stack<Integer> getLastStack() {
				
		if( stackList.size() > 0) {
			return  stackList.get(stackList.size() - 1);
			
		}
		
		return null;
	}
	
	
	private int popAt(int index) {
		
		int removedItem;
		if(index == stackList.size() - 1) {//element was removed from the last stack
			removedItem = pop();
			
		}else {//element is removed form the middle stack and rollover is required
			Stack<Integer> stack = stackList.get(index);
			removedItem = stack.pop();
			leftShift(index);
		}
		

		return removedItem;
		
	}
	
	private void leftShift(int index) {
		
		while (index < stackList.size() - 1) {
			
			Stack<Integer> currentStack = stackList.get(index);
			Stack<Integer> nextStack = stackList.get(++index);//get the following stack
			int nextStackTop = nextStack.pop();//pop element from following stack
			
			if(index == stackList.size() - 1) {//following stack is the last stack
				if(nextStack.isEmpty()) {//if it gets empty after removing item, remove that stack from list
					stackList.remove(nextStack);
				}
			}			
			currentStack.push(nextStackTop);//push that element from the following stack into the previous stack to make that full again
			
	}
	}
	
	private void printStackList() {
		System.out.println("size of stackList is "+stackList.size());
		for(int i = 0; i < stackList.size(); i++) {
			System.out.println("stack at "+i+ " index is "+ stackList.get(i).size());
		}
		
	}
	
	
	public static void main(String args[]) {
		SetOfStacks obj = new SetOfStacks(3);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		
		obj.push(4);
		obj.push(5);
		obj.push(6);
		
		obj.push(7);
		obj.push(8);
		obj.push(9);
		
		obj.push(10);
		//obj.push(11);
		//obj.push(12);
		
		obj.printStackList();
		
		int element = obj.popAt(3);
		System.out.println("Element popped at index 2 is "+element);
		
		obj.printStackList();
		
	}

}
