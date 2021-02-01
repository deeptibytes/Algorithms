package stackWithQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

Queue<Integer> q1;
Queue<Integer> q2;
int currSize;;



public Stack(){
q1 = new LinkedList<Integer>();
q2 = new LinkedList<Integer>();

}

/*Pop Expensive
 * Q2 is always empty, Q1 contains all the elements . 
 * element is added to Q1 and then alll elements of q1 are shifted to Q1. Swap Q1 and Q2
 */
public void pushEasy(int x){

q1.add(x);
currSize++;


}

public int popExpensive(){

  while (q1.size() !=1){
    q2.add(q1.peek());
    q1.remove(); 
    
  }
  
  int x = q1.remove();
  currSize--;
  Queue temp = q1;
  q1 = q2;
  q2 = temp;
  return x;


}

public int peekExpensive(){

  while (q1.size() !=1){
    q2.add(q1.peek());
    q1.remove(); 
  }
  
  int x = q1.peek();
  q2.add(x);
  q1.remove();
  Queue temp = q1;
  q1 = q2;
  q2 = temp;
  return x;



}

/*Push Expensive
 * Q2 is always empty, Q1 contains all the elements . 
 * element is added to Q2 and then alll elements of q1 are shifted to Q1. Swap Q1 and Q2
 */
public void pushExpensive(int x){

q2.add(x);

while( ! q1.isEmpty()){

q2.add(q1.peek());
q1.remove();

}
currSize++;
Queue temp = q1;
q1 = q2;
q2 = temp;

}

public int peekEasy(){

 return q1.peek();

}
public int popEasy(){
currSize--;
int x = q1.remove();
return x;

 
}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.pushExpensive(1);
		stack.pushExpensive(2);
		stack.pushExpensive(4);
		stack.pushExpensive(5);
		System.out.println(stack.peekEasy());
		stack.pushExpensive(7);
		System.out.println(stack.peekEasy());
		int x = stack.popEasy();
		System.out.println(x);
		System.out.println(stack.peekEasy());
		
		
		Stack stack1 = new Stack();
		stack1.pushEasy(1);
		stack1.pushEasy(2);
		stack1.pushEasy(4);
		stack1.pushEasy(5);
		System.out.println(stack1.peekExpensive());
		stack1.pushEasy(7);
		System.out.println(stack1.peekExpensive());
		int xx = stack1.popExpensive();
		System.out.println(xx);
		System.out.println(stack1.peekExpensive());

	}

}
