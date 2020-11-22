package trees;

import java.util.Random;

public class BSTRandom {
	
class Node{
	
	int data;
	Node left, right;
	int size;
	
	public Node(int data) {
		this.data = data;
		size = 1;//why initialize to 1?? think think:)
	}
	
	private int getSize() {
		return this.size;
	}
		
}

Node root = null;


 public Node insert(Node root, int data) {
	 
	 if(root == null) {
		 root = new Node(data);
		 return root;
	 }
	 
	 if(data < root.data) 
		 root.left = insert(root.left, data);
	 
	 if(data > root.data) 
		 root.right = insert(root.right, data);
	
	 
	root.size++;//this way size attribute will increase for all nodes. 
	            ///Anytime if we want to check the size of tree, we just need to get root.size
	return root;
}
 
 public Node getRandomNode(Node root) {
		
	//get the size of left sub tree
	 
	 if(root == null) return null;
	 
	 int leftSize = (root.left == null)? 0: root.left.getSize();//left subtree size
	 Random random = new Random();
	 int index = random.nextInt(root.size);//total tree size is 50, random gives 45. left size is 5'
	 
	 if(index == leftSize) return root;
	 
	 if(index < leftSize) return getRandomNode(root.left);
	 else  //index > leftSize
	 return  getRandomNode(root.right);
	
	 
 }
 
 /*
  * Minimize random() call as that is expensive
  */
 
 
 public Node getRandomNode2(Node root) {
		
		//get the size of left sub tree
		 
		 if(root == null) return null;
		 
		
		 Random random = new Random();
		 int index = random.nextInt(root.size);//total tree size is 50, random gives 45. left size is 5'
		 
		 return getIthNode(root, index);
		
		 
	 }
 
 public Node getIthNode(Node root, int index) {
		
		//get the size of left sub tree
		if(root == null)return new Node(0);
		 
		 int leftSize = (root.left == null)? 0: root.left.getSize();//left subtree size
		 if(index ==leftSize ) return root;
		 
		 if(index < leftSize) 
			 return getIthNode(root.left, index);//left size = 40, index = 36 right size = 10
		 
		 else ////index > leftSize
			 return getIthNode(root.right,  index - leftSize);	//left size = 40, index = 45 right size = 10, why are doing this
		 //index - leftSize  think?
		 
	 }
 
 public void find(Node node) {
		
		
 }



  public static void main(String[] args) {
	
	BSTRandom obj = new BSTRandom();
	obj.root = obj.insert(obj.root, 50);
	obj.insert(obj.root, 45);
	obj.insert(obj.root, 42);
	obj.insert(obj.root, 40);
	obj.insert(obj.root, 57);	
	obj.insert(obj.root, 55);
	
	
	
	System.out.println("Random Node :"+obj.getRandomNode2(obj.root).data);
	System.out.println("Tree size "+obj.root.size);
	
	
	
	
	
  }



}
