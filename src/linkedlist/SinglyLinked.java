package linkedlist;



public class SinglyLinked {
	
	public Node first; //point to head
	
	public SinglyLinked (Node node) {
		this.first = node;
	}
	
	
	
	
public void insertFirst(int data) {//inserts at the beginning
		
		Node newNode = new Node(data);
		if(isEmpty()) {
			first = newNode;
		}else {
			newNode.next = first;
			first = newNode;
		}
		
	}



	
	
public Node deleteFirst(int data) throws Exception{//deletes at the beginning
		
		
		if(isEmpty()) {
			throw new Exception("Nothing to delete, List is empty");
		}else {
			Node tmp = first;
			first = first.next;
			return tmp;
		}
		
	}


public void insertLast(int data) {//inserts at the last. Need to traverse from first to last
	
	Node newNode = new Node(data);
	if(isEmpty()) {
		first = newNode;
	}else {
		Node current = first;
		
		while(current.next!=null) {
			current = current.next;			
		}
		
		current.next = newNode;
		
	}
	
}
		
public boolean isEmpty() {
			return (first==null);
}

public void displayList() {
	
	System.out.println("Dislaying from first to last**");
	Node currentNode = first;
	
	while(currentNode!=null) {
		
		System.out.print("  "+ currentNode.data);
		currentNode = currentNode.next;
	}
	System.out.println();
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

}
