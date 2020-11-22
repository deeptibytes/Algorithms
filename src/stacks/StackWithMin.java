package stacks;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {

	private Stack<Integer> s2;
	
	public StackWithMin(Stack<Integer> stack) {
		this.s2 = stack;
		
	}
	
	public void push(int value) {
		if(value <= getMin()) {
			s2.push(value);
		}
		super.push(value);
		
		
	}
	
    public Integer pop() {
		Integer value = super.pop();
		if(value == getMin()) {
			s2.pop();
			
		}
		 return value;
	}
    
    private Integer getMin() {
    	   if(s2.isEmpty()) return Integer.MAX_VALUE;
    	   else
      	return s2.peek();
    }
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		StackWithMin obj = new StackWithMin( new Stack<Integer>()  );
		obj.push(9);
		obj.push(7);
		obj.push(10);
		obj.push(12);
		obj.push(3);
		
		
		
		//System.out.println(Integer.MAX_VALUE);

	}

}
