package stacks;

import java.util.Stack;

public class QueueWithStacks {
	
	/*
	 * Implement queue with 2 stacks
	 */

	Stack<Integer> inbox;//will be used to push
	Stack<Integer> outbox;//will be used to pop/peek
	//whenever we pop/peeek, we will take all elements from inbox and push them in outbox so last pushed element will be at the bottom of the outbox
	//leaving first pushed pushed at the top. This will satisfy queue property = first in first out
	
	public QueueWithStacks() {
		 inbox = new Stack<Integer>();
		 outbox= new Stack<Integer>();
	}
	
	public void push(int element) {
		
		inbox.push(element);
		
	}
	
	public int pop() {
		if(!inbox.isEmpty()) {
			leftShift();
			return outbox.pop();
		}
		
		return -1;
	}
	
	public int peek() {
		
		if(!inbox.isEmpty()) {
			leftShift();
			return outbox.peek();
		}
		
		return -1;
	}
	
	private void leftShift() {
		
		while(! inbox.isEmpty()) {
			outbox.push(inbox.pop());
		}
	}
	
	void printQueue() {
		
		System.out.println("**Printing inbox**");
		while(! inbox.isEmpty()) {
			System.out.print(" $ "+ inbox.pop());
		}
		
		
		System.out.println("**Printing outbox**");
		
		while(! outbox.isEmpty()) {
			System.out.print(" # "+ outbox.pop());
		}
	}
	
	public static void main(String[] args) {
		
		QueueWithStacks obj = new QueueWithStacks();
		
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.pop();
		obj.printQueue();
		
		
	}
	
	

}
