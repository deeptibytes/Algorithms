package stacks;

import java.util.Stack;

public class SortedStack {

	
	
	/*
	 * https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
	 * 1. Create temp stack with max on top
	 * 2. Then copy from temp stack to original stack to have minimum on the top
	 */
	
	public void sortStack(Stack<Integer> input) {
		
		Stack<Integer> tempStack = new Stack<Integer>();
		int temp;
		
		while (!input.isEmpty() ) {
			temp = input.pop();
			
		       // if(temp < tempStack.peek()) {//will be false for 27 & 29, true for 24(temp)//this check is not required as it is covered in while condition
		        	   while(! tempStack.isEmpty() && temp < tempStack.peek()) {
				 		    input.push(tempStack.pop());
						 					
					}
		         
				 
				tempStack.push(temp);
			
			}
		
		//copy to original array
		while (! tempStack.isEmpty()) {
			input.push(tempStack.pop());
		}
			
			
		}
	
	public static void main(String[] args) {
		
		Stack<Integer> input = new Stack<Integer>();	
		input.push(5); 
	    input.push(24); 
	    input.push(21); 
	    input.push(18); 
	    input.push(20); 
	    input.push(23); 
	  

		

	}

}
