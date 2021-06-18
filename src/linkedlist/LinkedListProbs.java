package linkedlist;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LinkedListProbs {

/*
 * Remove Duplicates from unsorted list	
 */
//If Temp Buffer is allowed

	void delDuplicates( SinglyLinked list) {
		Node first = list.first;
		Node current = first;
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		
		while (current !=null) {
			if(set.contains(current.data)) {
				previous.next = current.next; //removing dup element				
			}else {
				set.add(current.data);
				previous = current;//if you are changing the linking in if block, this should be in else. suppose 5 5 15. Seconf 5 gets deleted
				//now it becomes 5 15. current is 15 now but previous is still 5!! that is why whenever we delete element, previous should remain the same.
			}
			
			current = current.next;
			
		}
	}
	
	
	
	
//If Temp Buffer is NOT allowed
	
	/*void delDuplicates( SinglyLinked list) {
		Node first = list.first;
		Node current = first;
		
		
		while (current !=null) {
			Node checker = current;
			while(checker.next != null) {//if comparing with checker.next, no need to maintain previous variable
				if(current.data == checker.next.data) {
					checker.next = checker.next.next;
				}else//why using else here??? because we are comparing with checker.next. Suppose 3 elements 5, 5, 15, second 5 gets deleted
					//now compariosn should happen b/w 5 and 15. Checked.next is now pointing to 15 so no need to do checker.next
					checker = checker.next;				
				
			}
			
			current = current.next;
			
		}
	}*/

	
	/*
	 * Return Kth to Last
	 */
/*//Iterative Approach	
	Node KthToLast(SinglyLinked list, int k) {
		
		Node current = list.first;
		Node p1 = current;
		Node p2 = current;
		
		
		while(p1 != null && k > 0) {
			p1 = p1.next;
			k--;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		System.out.println("Kth element is "+p2.data);
		return p2;
	}*/
	
	//Iterative Approach	
		/*Node KthToLast(SinglyLinked list, int k) {
			
			Node current = list.first;
			Node p1 = current;
			Node p2 = current;
			
			
			while(p1 != null && k > 0) {
				p1 = p1.next;
				k--;
			}
			
			while(p1 != null) {
				p1 = p1.next;
				p2 = p2.next;
			}
			
			System.out.println("Kth element is "+p2.data);
			return p2;
		}*/
	
	//Only Print
	
	/*int printKthToLast(Node head, int k) {
		
		if(head == null) return 0;
		
		int index = 1 + printKthToLast(head.next, k);
		if(index == k) {
			System.out.println("Kth element is "+head.data);
		}
		
		return index;
		
		
	}*/
	
	//Return kth node value. Recursion
	
	/*public class Index{
		
		int value = 0;
		
	}
	
	Node kthToLast(Node head, int k) {
			
			Index idx = new Index();
			return kthToLast(head, k, idx);
			
		}
	
    Node kthToLast(Node head, int k, Index Idx) {
    	
    	if(head == null) return null;
    	
    	Node node = kthToLast(head.next, k, Idx);
    	Idx.value = Idx.value+1;
    	
    	if (Idx.value == k) {
    		return head;
    		
    	}
    	
    	return node;
	 
	 
	 
 } */
	
	
	//Why cant we use integer Idx, why do we need wrapper class??
		 Node kthToLastNode(Node head, int k, int Idx) { //int is primitive type, it is value is changed inside method but outside methid it will always be 0.
			 //The moment control exits the method, Idx value will always be zero: Primitive pass by valeu
			 //In case of wrapper class it is pass by reference. meaning value of wrapper class is changed inside and remained changed 
			 //even after exiting the method
		    	
		    	if(head == null) return null;
		    	
		    	Node node = kthToLastNode(head.next, k, Idx);
		    	Idx = Idx+1;
		    	
		    	if (Idx == k) {
		    		return head;
		    		
		    	}
		    	
		    	return node;
		
		 }
	
	////Return kth node value using wrapper class//Deeepti's way. Why we need wrapper class. After base case is met, we have to keep track of
	//index as well as Node. Both can be tracked only if we use warpper class.
	
	class IndexWrapper {
		int id;
		Node node;
		int k;
		
		public IndexWrapper(int id, Node node, int k) {
			this.id = id;
			this.node = node;
			this.k = k;
		}
		
		void setNode(Node node) {
			this.node = node;
		}
		
		void setId(int Id) {
			this.id = Id;
		}
		
		
		
	}
	
	
	
	IndexWrapper returnKthNode(Node node, int k) {
		
		if(node == null) return new IndexWrapper( 0, null,  k);
		
		IndexWrapper wrapper = returnKthNode(node.next, k);
		wrapper.id = wrapper.id + 1;
		
		if(wrapper.id == k) {
			wrapper.setNode(node);//after base case is met, we set Node only index == k, for other k values it is always null so at he end, we always return
			//kth node
		} 
		
		return wrapper;
		
	}
	
	Node returnKth(Node head, int k) {
		
		return returnKthNode(head, k).node;
		
	}
	
	
/*
 * Delete Middle node when access to head is not given	
 */
  
    boolean deleteMiddle(Node middle){
    	
    	if(middle == null || middle.next == null) return false;
   // 	copy data from next to the middle
    	
    	Node next = middle.next;
    	middle.data = next.data;
    	middle.next = next.next;
    	return true;
    	
    }
    
/*
 * Partition List	
 */
    
    Node partition(Node node, int x) {
      
   
    
    Node tail = node;
    	Node head = node;;
    	
    	
    	while(node !=null) {
    		Node next = node.next;
    		if(node.data < x) { //grow towards left
    			
    		  node.next = head;//linking 
    		  head = node;//assignment
    			
    		}else {//grow towards right
    			
    			tail.next = node;
    			tail = node;
    			
    		}
    		
    		node = next;   		
    	}
    	tail.next = null;
   
    	
    	return head;
    	
    }
    
  /*
   * Sum of nodes::: 1's is in Head  
   * //L1 = 4 1 6
	//L2 =  3 9 2
   */
 /* Node sumLists(Node one, Node two) {
    	
   System.out.println(one.next.data +"  "+two.next.data);
    int carry = 0;
    int sum = 0; 
    Node head = null;
    Node result = null;
    
    while(one !=null && two != null) {
    	
    	 sum = carry +one.data + two.data;
    	 carry = (sum >= 10)? 1: 0;
    	 //Populate the list
    	 
    	 if(result ==null) {
    		 result = new Node(sum % 10);
    		 head = result;//maintaining head here to return it at the end
    	 }else {
    		 result.next = new Node(sum % 10);
    		 result = result.next;
    		 
    	 }   	 
    	 one = one.next;
    	 two = two.next;    	
    }
    	
    if(one != null) {//if one list smaller or larger
    	sum = carry + one.data;
    	result.next = new Node(sum);
    }
    
    if(two != null) {//if one list smaller or larger
    	sum = carry + two.data;
    	result.next = new Node(sum);
    }
    	
    	return head;
    }*/
  
  
  /*
   * Sum of nodes::  1's is in last  //without using wrapper
   */
    
  
 /* int sumLists(Node one, Node two, Node head) {  
    	 
	//L1 = 4 1 6
	//L2 = 3 9 2
	  
	  if(one ==null && two == null) {
		  return 0;
	  }
	  	  
	 int carry = sumLists(one.next, two.next, head);
	 int sum = one.data + two.data + carry;
	 carry = (sum >= 10)? 1: 0;
	 
	 if(head == null) {
		 head = new Node (sum % 10); 
		 System.out.println(head.data);
	 }
	 else {
		 Node newNode = new Node(sum % 10);
		 newNode.next = head;
		 head = newNode;
		 System.out.println(head.data);
	 }
	
	
	
	 return carry;
	 
  
    }
    */
    /*
     * Sum of nodes::  1's is in last  // using wrapper
     */ 
  //L1 = 4 1 6
  //L2 = 2 9 2
    
  //sum = 7 0 8
    class CarrryWrapper{
    	 int carry;
    }
    
    Node sumList(SinglyLinked list1, SinglyLinked list2) {
    	
    	/*
    	 * If size of lists is diff. in that case, add padding at the head of shorter list
    	 */
    	
    	//L1 = 4 1 6
    	//L2 = 2 9 
    	 //add 0 in L2 at head to make it 0 2 9
    	
    	//4 1 6
    	//0 2 9       4 4 5
    	if(getLength(list1.first) != getLength(list2.first)) {
    		int diff = Math.abs(getLength(list1.first) - getLength(list2.first));
        	SinglyLinked shorterList = 	(    getLength(list1.first) < getLength(list2.first)  ) ? list1: list2;
        	//add padding to shorter list
        	while(diff > 0) {
        		shorterList.insertFirst(0);
        		diff--;
        	}       
    	}
    
    
    	  return sumLists(list1.first, list2.first, new CarrryWrapper(), null);
    }
    
    Node sumLists(Node one, Node two, CarrryWrapper carry, Node head) {  
   	 
    	//L1 = 4 1 6
    	//L2 = 2 9 2
    	  
    	  if(one ==null && two == null) {
    		  return null;
    	  }
    	  	  
    	 head = sumLists(one.next, two.next, carry, head);
    	 int sum = one.data + two.data + carry.carry;
    	 carry.carry = (sum >= 10)? 1: 0;
    	 
    	 if(head == null) {
    		 head = new Node (sum % 10); 
    		// System.out.println(head.data);
    	 }
    	 else {
    		 Node newNode = new Node(sum % 10);
    		 newNode.next = head;
    		 head = newNode;
    		// System.out.println(head.data);
    	 }
    	
    	
    	
    	 return head;
    	 
      
        }
    
    /*
     * Check if list is palindrome: Reverse by iteration and compare
     */
        
   /*private boolean isPalindrome(Node head) {
	   Node reverseHead = reverseList(head);
	   return isEqual(head, reverseHead);   
   }
   
   //using iteration. This is not in place. Do inPlace reverse by just changing mapping
   private Node reverseList(Node node) { 
	   Node head = null;
	   while(node != null) {
		   Node newNode = new Node(node.data);
		   newNode.next = head;
		   head = newNode;
		   node = node.next;
	   }	   
	   return head;
   }
   
   private boolean isEqual(Node node, Node reverseNode) {
	   
	    while(node != null && reverseNode != null) {
	    	
	    	if(node.data != reverseNode.data) return false;
	    		
	    	  node = node.next;
	    	  reverseNode = reverseNode.next;
	    	  
	    	  
	    	
	    }
	    
	    return true;
	   
   }*/
    
   /* 
     * Check if list is palindrome: Reverse using stack and compare
     
    
    
    private boolean isPalindrome(Node node) { 
 	   Stack<Integer> reverseStack = new Stack<Integer>();
 	   Node current = node;
 	  while(current !=null) {
 		  reverseStack.push(node.data);
 		  current = current.next;
 	  }
 	  
 	  return isEqual(reverseStack, node);
    } 
 	  
 	  private boolean isEqual(Stack<Integer> stack, Node node) {
 		  
 		  while (node != null) {
 			  
 			  if(stack.pop() != node.data) return false;
 			  node= node.next;
 		  }
 		  
 		  
 		  return true;
 	  }
 	   
 	   
 	   */
    
    /* 
     * Check if list is palindrome: Reverse using stack but reverse only till half
 	 */ 
    
    
    //reverse half list
    private boolean isPalindrome(Node node) {//5 10 20 16 20 10 5  //odd  ||| /5 10 20  20 10 5 even   ABBA
    	
    	
      	Node pt1 = node;
      	Node pt2 = node;
      	//get mid point of list and create stack from first half of list
      	Stack<Integer> stack = new Stack<Integer>();
      	while(pt2.next != null) {
      		stack.push(pt1.data);
      		pt2 = pt2.next.next;
      		pt1 = pt1.next;
      	}
      	
      	//now compare stack element with second half of list
      	
      //	if list length is odd, we wont compare middle node 1 2 3 4 3 2 1, here 4 will be the middle element that wont be compared but stack has that 4
      	
      	if(getLength(node) % 2 == 1) {//odd
      		pt1 = pt1.next;//skipping middle element
      	}
      	while(pt1 !=null) {
      		
      	  if(stack.pop() != pt1.data) return false;
      	  pt1 = pt1.next;
        }
      		
      		
      		
      	
      	
      	return true;
      	
    }
    
    
	/*
	 * get Size of list by iteration
	 */
	/*int getLength (SinglyLinked list) {
		Node current = list.first;
		int length = 0;
		while (current !=null) {
			length++;
			current = current.next;
		}
		
		return length;
	}*/
	
	/*
	 * get Size of list by recursion
	 */
	int getLength (Node head) {
		if(head == null) return 0;
		
		return 1+ getLength(head.next);	
	}
	
	
	public void displayList(Node head) {
		
		System.out.println("Dislaying from first to last**");
		Node currentNode = head;
		
		while(currentNode!=null) {
			
			System.out.print("  "+ currentNode.data);
			currentNode = currentNode.next;
		}
		System.out.println();
		}

	
	
	/*
	 * Determine if the two linkedlists intersect and if they do, return the intersecting node
	 */
	
	private Node getIntersection(Node one, Node two) {
		
	/*	if(!isIntersecting(one, two)) return null;///this will have while loop
					
		int lenOne = getLength(one);//this will also have while loop
		int lenTwo=  getLength(two);*/
		
     //we can combine above two in one method using wrapper class as return type
		
		Result resultOne = getTailAndSize(one);
	    Result resultTwo = getTailAndSize(two);
	    
	    if(resultOne.tail != resultTwo.tail) return null; //since last node is diff, they are not intersecting
	    
			Node bigger =  (resultOne.size > resultTwo.size) ? one: two;
			Node smaller = (resultOne.size < resultTwo.size)? one: two;			
			int diff = Math.abs(resultOne.size - resultTwo.size);
			
			//chop off extra nodes from bigger. If diff is 4, get 4th node 
			bigger = getKthNode(diff, bigger);
			
		
		while(bigger!=null && smaller!=null) {
			
			if(bigger == smaller) return bigger;//u can return smaller too as they both are same
			
			bigger = bigger.next;
			smaller = smaller.next;
		}
		
	return null;		
	}
	
	Node getKthNode (int k, Node head) {
		Node current = head;
		while( k > 0  && current != null) {//why the second condition is imp. SUppose list has 3 elements and and k =5
			current = current.next;
			k--;
		}
		return current;
		
	}
	
	class Result{
		int size;
		Node tail;
		
		public Result(int size, Node tail) {
			this.size = size;
			this.tail = tail;
		}
		
		
	
	}
	
	private Result getTailAndSize(Node node) {
		int size = 1;//think why it is 1 not 0
		while(node.next != null) { ///to get last element, always use node.next in while condition. To get size, use node !=null in while 
			size++;
			node = node.next;
		}
	return new Result(size, node);
	}
	
	
	/*
	 * Detect if Linkedlist has a loop using additional DS, return node from where loop starts
	 */
	
	/*private Node getLoopNode(Node head) {
		
		HashSet<Node> set = new HashSet<Node>();
		
		while(head !=null) {
			if(set.contains(head)) {
				return head;
			}
			set.add(head);
			head= head.next;
			
		}
		
		return null;
		
	}*/
	
	/*
	 * Detect if Linkedlist has a loop without using additional DS. return true/false
	 
	
	private boolean getLoopNode(Node head) {  //4 1  6 12 14 15  (15 points to 6
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}			
		}
		
		return false;
		
	}
	*/
	
	
	/*
	 * Detect if Linkedlist has a loop without using additional DS. return node where loop starts
	 */
	
	private Node getLoopNode(Node head) {  //4 1  6 12 14 15  16 (16 points to 6
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast !=null) {//consider even and odd number of node. even# fast!=null, odd # = fast.next !=null
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}			
		}
		
		if (fast == null || fast.next == null) {//means no loop. This is imp. If loop runs without breaing, means no loop so check here
			return null;
		}
		
		slow = head;
		
		while(slow !=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
		
	}
	
	
	class ListNode {

	
	public int val;
	public ListNode next;
	private ListNode random;
	
	public ListNode(int val) {
		
		this.val = val;
	}
	}
	 public ListNode removeDups(ListNode head){
	//5 5 6 2 6 2
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		 print(head);
		
		ListNode pre = dummy;
		Set<Integer> set = new HashSet<Integer>();
		
		while(head !=null){
		 
		 if(set.contains(head.val)){
		   pre.next = head.next;
		 
		 }else{
		   set.add(head.val);
		   pre = head;
		 }
		 
		 head = head.next;
	
	
	}
	   print(dummy.next);
	   return dummy.next;
	
	
	}
	
	
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		
	}

	public ListNode removeDupsInPlace(ListNode head){
	 
	 print(head);
	 ListNode node = null;;
	 ListNode first = head;
	 ListNode previous = null;
	 
	 //5  6  6 2
	 while(first !=null){
	    node = first.next;
	    previous = first;
	    while(node !=null){
	      
	      if(first.val == node.val){
	      
	        previous.next = node.next;
	      
	      }else{
	      
	        previous = node;
	      }
	      
	      node = node.next;	    
	    }
	    
	    first = first.next;	 
	 
	 }
	 
	 print(head);
	 return head;
	 	
	}
	
	
	
	public ListNode removeKth(ListNode head, int k){
	
	print(head);
	ListNode slow = head;
	ListNode dummy = new ListNode(-1);
	dummy.next = head;
	
	ListNode previous = dummy;
	
	ListNode fast = head;
	
	while(fast !=null && k > 1){
	  fast = fast.next;
	  k--;	
	}
	
	while(fast.next !=null){
	  fast = fast.next;
	  slow = slow.next;
	  previous = previous.next;
	
	}
	
	previous.next = slow.next;

	print(head);
	return dummy.next;
	
	
	}
	
	public boolean removeMiddle(ListNode node){
	
	ListNode pre = null;
	if(node == null) return false;
	while(node.next !=null){
	    
	    node.val = node.next.val;
	    pre = node;
	    node = node.next;

	}
	
	   pre.next = null;
	   return true;
}
	
	/*void sortList() 
    { 
       // initialise count of 0 1 and 2 as 0 
       int count[] = {0, 0, 0};  
         
       Node ptr = head; 
         
        count total number of '0', '1' and '2' 
        * count[0] will store total number of '0's 
        * count[1] will store total number of '1's 
        * count[2] will store total number of '2's  
       while (ptr != null)  
       { 
            count[ptr.data]++; 
            ptr = ptr.next; 
       } 
  
       int i = 0; 
       ptr = head; 
  
        Let say count[0] = n1, count[1] = n2 and count[2] = n3 
        * now start traversing list from head node, 
        * 1) fill the list with 0, till n1 > 0 
        * 2) fill the list with 1, till n2 > 0 
        * 3) fill the list with 2, till n3 > 0  
        while (ptr != null)  
        { 
            if (count[i] == 0) 
                i++; 
            else 
            { 
               ptr.data= i; 
               --count[i]; 
               ptr = ptr.next; 
            } 
         } 
    } 
    */
    
    ///Efficiently merge K sorted linked lists
    
    public ListNode mergeKLists(ListNode[] lists){ //O(NlogK)
    
        
         if(lists.length < 1){
             return null;
         }
    
          //Define comparater
    Comparator<ListNode> comp = new Comparator<ListNode>()//pass the method in constructor
    {
        
          @Override
     public int compare(ListNode n1, ListNode n2){
      if(n1.val > n2.val) return 1;
      if(n1.val < n2.val) return -1;
      return 0;
      
      //we can also do n1.data.compareTo(n2.data);
    }
    
    };
        
    //Create PQ  (min Heap)  
    Queue<ListNode> pQ = new PriorityQueue<ListNode>(comp);
   
    //Populate pQ with all elements (head) of passed lists

    for(ListNode node: lists){
            pQ.offer(node);
    }
  
    ListNode dummy = new ListNode(-1);
    ListNode runner = dummy;
    
    
    while(! pQ.isEmpty()){
      ListNode node = pQ.poll();
      runner.next = node;
      runner = runner.next;
    if(node.next!=null) pQ.offer(node.next); //null check is imp here
         
    }//while
    
    return dummy.next;
    
    
    
    
    
    }//method
    
   
    
    //Copy a Linked List with Random Pointers
  
  public ListNode copyList(ListNode head){
  
    ListNode dummy  = new ListNode(-1);
    ListNode dummyP =   dummy;;
    ListNode runner = head;
    
    //Stich new node nodes next to original nodes
    while(runner !=null ){
    
	    ListNode newNode = new ListNode(runner.val);	   
	    newNode.next = runner.next;  
	    runner.next = newNode; 
	    runner = runner.next.next;
    }
    
    runner = head;
    
    //copy random pointer and create new nodes
     while(runner !=null ){
     
       ListNode random = runner.random;
       runner.next.random = random;
       dummyP.next = runner.next;
       
       dummyP = dummyP.next;
       runner = runner.next.next;     
    }
    
 
    return dummy.next;
    
    /*Test Code
     * ListNode head1 = new ListNode(7); head1.random = null;
		head1.next =  new ListNode(8); head1.next.random = head1;
		head1.next.next =  new ListNode(12); head1.next.next.random = head1.next;
		
		ListNode copy = obj.copyList(head1);
		
		while(copy!=null){
		
	    System.out.println(copy.val +"---" );
	    int random = copy.random ==null ? -1 : copy.random.val;
	    System.out.println(random );
	    copy = copy.next;
	
	    }
     */
  
  }
                       
  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Create a list
 */
		SinglyLinked	 list = new SinglyLinked(new Node(5));
		list.insertLast(10);
		list.insertLast(20);
		list.insertLast(16);	
		list.insertLast(20);		
		list.insertLast(11);		
		list.insertLast(5);		
		//list.insertLast(8);		
	  //  list.displayList();
		 LinkedListProbs obj = new LinkedListProbs();
		// System.out.println("Length of list is "+obj.getLength(list.first));
		
	   
	  ///  obj.delDuplicates(list);
	    //list.displayList();
	    
	 // obj.KthToLast(list, 3);
		// System.out.println(obj.kthToLastNode(list.first, 3, 0).data);
		
		/* obj.deleteMiddle(list.first.next.next.next);//passing 4th node to method //16
		 System.out.println("After deleting");
		 list.displayList();*/
		 
		 //SinglyLinked listArr = obj.partition(list.first, 10);
		 //listArr.displayList();
		 //list.first = obj.partition(list.first, 10);
		 
		 //list.displayList();
		 
		 SinglyLinked list1 = new SinglyLinked(new Node(4));
			list1.insertLast(1);
			list1.insertLast(6);
			list1.insertLast(12);
			list1.insertLast(14);
			
			SinglyLinked list2 = new SinglyLinked(new Node(2));
			list2.insertLast(9);
			list2.insertLast(2);
			
			SinglyLinked list3 = new SinglyLinked(new Node(20));
			list3.insertLast(9);
			list3.insertLast(2);
		
			
			//Create intersecting list. list1 and list2 merge with list 3 making list1 and list2 intersecting with each other
			
			list1.first.next.next.next.next.next = list3.first;
			list2.first.next.next.next = list3.first;
			
			//Node result = obj.getIntersection(list1.first,list2.first);
			
			//System.out.println((result == null) ? "null": result.data);
			
			
			
			//Node head = obj.sumLists(list1.first, list2.first);
			
			 //obj.displayList(head);
	 
	         // Node head = obj.sumList(list1, list2);
	         // obj.displayList(head);
			
			//System.out.println(obj.isPalindrome(list.first));
			
			SinglyLinked loopedList = new SinglyLinked(new Node(4));
			loopedList.insertLast(1);
			loopedList.insertLast(6);
			loopedList.insertLast(12);
			loopedList.insertLast(14); 
			loopedList.insertLast(15);
			loopedList.first.next.next.next.next.next.next = loopedList.first.next.next;//making loop, last ele pointing to third
	        
			Node rs = obj.getLoopNode(loopedList.first);
			System.out.println((rs == null) ? "null": rs.data);
			
		
	}
	
	
	}
