package stacks;
/*
 * describe how you could use single array to implement n stacks. If all stacks have same length
 */
public class FixedMultiStack {

	
	private int[] stackArray;
	private int numOfStacks;
	private int maxSize; //maxSize of each stack
	private int[] tops; //array to hold curr value of TOP of all 3 stacks in this DS
	
	
	
	public FixedMultiStack(int size, int numberOfStacks) {
		this.maxSize = size;
		this.numOfStacks = numberOfStacks;
		stackArray = new int[numOfStacks * maxSize];
	    tops = new int[numOfStacks];
	   // initialize top to -1 for all 3 stacks
	   for(int i = 0; i < tops.length; i++) {
	       tops[i] = -1;
	    }
	    
	}
	
   public boolean isEmpty(int stackNum) { //if the given stack is empty
	   
	   return tops[stackNum] == -1;
	   
   }
   
   public boolean isFull(int stackNum) {//if the given stack is full;
	   
	   return tops[stackNum] == maxSize - 1;
	   
   }
   
   public void push(int stackNum, int value) throws Exception{
	   
	   if(isFull(stackNum)) throw new Exception("Stack is full");
	   
	   //increase the top var for that array slot
	   tops[stackNum]++;
	   
	   //Get targetIndex 
	   int targetIndex = getTargetIndex(stackNum);
	   System.out.println("Top is inside push method "+targetIndex);
	   
	   //update array
	   stackArray[targetIndex] = value;
	  
   }
   
   public int pop(int stackNum) throws Exception{
	  
	   if(isEmpty(stackNum)) throw new Exception("Stack is empty");
	   
	 //Get targetIndex 
	   int targetIndex = getTargetIndex(stackNum);
	   
	  //get value from tagetIndex
	   int value= stackArray[targetIndex];
	   
	   //decrease top
	   tops[stackNum]--;
	   
	   return value;
			   
	   
   }
   
  public int peek(int stackNum) {
	  
	  return stackArray[getTargetIndex(stackNum)];
	   
   }
  
  public int getTargetIndex(int stackNum) {
	  int slot = stackNum * maxSize;  //for 1st array (0 to 9) | 2nd array = 10 to 19, 3rd array: 20 to 29
	 return slot + tops[stackNum]; 
	 /*
	  * for 1st array, we will just use top var as is.
	  * for 2nd array, we will use 10 + top var
	  * for 3rd array, we will use 20 + top var
	  */
	  
  }
  
  public void printStackArray() {
	 
	  for(int i = 0; i < stackArray.length; i++) {
		  if(stackArray[i] != 0)
		  System.out.println("element at "+i +" is "+stackArray[i]);
	    }
	  
  }
	
	
	public void printTops() {
		for(int top: tops) System.out.println("top is "+top);
	}
	
	
	public static void main(String[] args) {
		
		FixedMultiStack obj = new FixedMultiStack(10, 4)	;
		try {
			obj.printTops();
			obj.printStackArray();
			System.out.println("Going to push now");
			obj.push(0, 10);
			obj.push(1, 20);
			obj.push(2, 30);
			obj.printTops();
			obj.printStackArray();
			
		}catch (Exception ex){
			
		}
		
		
		
		
		
		

	}

}
