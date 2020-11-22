package trees;

import java.util.ArrayList;
import java.util.LinkedList;



class Node{
	
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}		
}


public class TreeProbs {
	
	
	
	
	/*
	 * Create BST with minimal height. Input is sorted array from low to high
	 */
	
	
	
	
	/*
	 * CReate list linkedlist of nodes at each level : First Way
	 */
	
	public  void getListAtDepth(Node root){
		
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		getListAtDepth(root, result, 0);
		
		
	}
	
	public void getListAtDepth(Node root, ArrayList<LinkedList<Node>> result, int level) {
		
	      if(root == null) {
	    	    return;
	      }
	      LinkedList<Node> levelList = null;
	      if(result.size() == level) {
	    	    levelList = new LinkedList<Node>();
	    	    result.add(levelList);
	      }else {
	    	    levelList =  result.get(level);   	     
	      }
	      levelList.add(root);
	     
	     
	      
	      getListAtDepth (root.left, result, level +1);
	      getListAtDepth(root.right, result, level +1);
	      
	}
	
	/*
	 * CReate list linkedlist of nodes at each level : Second Way
	 */
	
	public ArrayList<LinkedList<Node>> getListAtDepth2(Node root){
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> levelList = new LinkedList<Node>();
		
		if(root == null) {
			return null;
		}
		
		levelList.add(root);
		
		
		while(levelList.size() > 0) {
		  result.add(levelList);
		  LinkedList<Node> parents = levelList;
		  levelList = new LinkedList<Node>();
		  for(Node parent: parents) {
			  
			  
			  if(parent.left !=null) {
				  levelList.add(parent.left);
			  }
			  
			  if(parent.right !=null) {
				  levelList.add(parent.right);
			  }
		  }
			
		}		
		return result;
		
		
	}
	
	
	class Node1{
		
		Node1 left, right, parent;
		int data;
		public Node1(int key) {
			data = key;
		}
		
	}
	/*
	 * If right subtree of node is not NULL, then succ lies in right subtree. Do the following.
Go to right subtree and return the node with minimum key value in the right subtree.
If right sbtree of node is NULL, then succ is one of the ancestors. Do the following.
Travel up using the parent pointer until you see a node which is left child of its parent. The parent of such a node is the succ.
	 */
	int getOrderSuccessor(Node1 root, Node1 input) {
		
		Node1 suc;
		if(root.right != null) {//right child not null
			suc =  getMinimamNode(input.right);
		}else { //right child is null
			suc = getParentSuc(input);
			
		}
		
		return suc.data;
	}
	
	/*
	 * Go to right subtree and return the node with minimum key value in the right subtree.
	 */
	Node1 getMinimamNode(Node1 root) {
		
		if (root==null) return null;
		
		if(root.left == null) return root;
		return getMinimamNode(root.left);		
	}
	
	/*
	 * Travel up using the parent pointer until you see a node which is left child of its parent. The parent of such a node is the succ.
	 */
	Node1 getParentSuc(Node1 parent) {
		Node1 child;
		while(parent!= null) {
			child = parent;			
			parent = parent.parent;
			if(child == parent.left) break;
		}
		return parent;
	}
	
	/*
	 * Lowest common ancestor of binary SEARCH tree
	 */
	
	Node1 getLCM(Node1 root, Node1 one, Node1 two) {
		
		/*
		 *                8
		 *           5        7
		 *         3   6   5     6
		 *       1
		 *     6               
		 *           
		 * 
		 * 
		 */
		
		
		/*
		 * Base Case Start
		 */
		if(root == null) return null;
		
		if(root == one.parent && root == two.parent) return root;		
		if(root == one.parent || root == two.parent) {
			
			return  root;
		}
		
		
		/*
		 * Base Case End
		 */
	
		Node1 p1 = getLCM(root.left, one, two);
		Node1 p2 = getLCM(root.right, one, two);
		
		
		
		//If level is different than find out which one is in lower level and then traverse up
		
		

		
		return null;
	}
	
/*
 * Get LCM if parent pointer is given
 * /*
		 *                8
		 *           5        7
		 *         3   6   5     6
		 *              
		 *      
		 * 
		 * 
		 */		
 
Node1 getLCM1(Node1 root, Node1 one, Node1 two) {
		
			
		/*
		 * Base Case Start
		 */
		if(root == null) return null;
		
		if(one.parent == two.parent) return one.parent;
		/* Base Case End
		 */
		
		return getLCM1(root, one.parent, two.parent);
		
}
	
  private Node1 getLowestCommonRoot(Node1 root, Node1 one, Node1 two) {
	  
	  int depth1 = getDepth(root, one);
	  int depth2 = getDepth(root, two);
	  
	 int diff = depth1 - depth2;
	 //If node Two is deeper, it depth will be more and diff will be negative
	 if(diff < 0) {
		 
		 while(diff != 0 ) {
			 
			 two = two.parent;
			 diff--;
		 }
		 
	 }else {//One is deeper
		 
          while(diff != 0 ) {
			 
			 one = one.parent;
			 diff--;
		 }
	 }
	 /*
	  * If level is same, none of the while loop will get executed
	  */
	return getLCM1(root, one, two);
	 
	 
	  
  }
	
  int getDepth(Node1 root, Node1 n) {
	  
	  
	  if(root == null) return -1;
	  
	  return 1 + getDepth(root, n.parent);
	  	 
  }
	
	
	/*
	 * Rank of integer of stream. For a given int x, find the number of nodes that are either smaller or same as x
	 * https://www.geeksforgeeks.org/rank-element-stream/
	 * 
	 * 
	 */
   class Node2{
	   
	   int data;
	   Node2 left , right = null;
	   int leftCount = 0;
	   
	   public Node2(int data) {
		   this.data = data;
		   
	   }
   }
   
   Node2 root2 = null;
   
   private Node2 createDSFromStream(Node2 root , int x) {//this is like insert method
	   
	   if(root == null) {
		   root = new Node2(x);
		   return root;
	   }
	   
	   if(x < root.data) {//25
		   root.left = createDSFromStream(root.left, x);	
		   root.leftCount++;
	   }else {// 20  23
		  root.right =  createDSFromStream(root.right, x);		 
	   }
	   
	   return root;//we always return root of tree that is passed in the original method invocation
	   
   }
   
  private int getRank(Node2 node, int x) {
    	 
	 if(x== node.data) return node.leftCount;
	 
	 if(x < node.data) {
		 
		 if(node.left == null) return -1;
		 
		return getRank(node.left, x);
		 
		 
		 
	 }else { //x > node.data
		 
		 if(node.right == null) return -1;
		 
		 int leftSubTreesize = node.leftCount;
		 
		 int letNodeCount = getRank(node.right, x);
				 
		return leftSubTreesize + letNodeCount + 1;
	 }
  
} 
  
 
   /*Check Subtree. T1 and T2 are very large Binary Trees. Create an algo to determine if T2 is a subtree of T1 
    * Using String builder method*/
   
  private boolean checkSubTree(Node node1, Node node2) {
	  
	  StringBuilder sb1 = new StringBuilder();
	  StringBuilder sb2 = new StringBuilder();
	  createPreOrderString(node1, sb1);
	  createPreOrderString(node2, sb2);
	  System.out.println(sb1.toString());
	  System.out.println(sb2.toString());
	  
	  return sb1.toString().contains(sb2);
  }
  
  private void createPreOrderString(Node node, StringBuilder sb) {
	  
	  //pre order traversal
	  
	  if(node == null) {
		  sb.append("X");
		  return;
	  }
	  
	  sb.append(node.data);
	  
	  /*//If only right child, append "x" for empty left child
	  if(node.left == null && node.right != null )sb.append("X");
	  else*/
	  createPreOrderString(node.left, sb);
	  
	  
	 /* //If only left child, append "x" for empty right child
	  if(node.right == null && node.left != null )sb.append("X");
	  else*/
	  createPreOrderString(node.right, sb);
	  
	  
	  
  }
  
  
  /*Check Subtree. T1 and T2 are very large Binary Trees. Create an algo to determine if T2 is a subtree of T1 
   * Using node by node comparison. 
   * Traverse  T1 using Preorder. Once the node in T1 (say node x) is equal to root Node of T2, compare the sub trees of x and root of T2*/
  
 private boolean checkSubTreeCompare(Node node1, Node node2) {
	  
	 if(node2 == null)return  true;//null is always considered subtree
	 if(node1 == null) return false;//if we encounter null node while traversing T1, comparing null with node2 will always return false
	
	 
	 if(node1.data == node2.data) { //root is equal, now check left and right sub trees for equality
		 return matchTrees(node1.left, node2.left) && matchTrees(node1.right, node2.right) ;
	 }
	 
	 return checkSubTreeCompare(node1.left, node2) || checkSubTreeCompare(node1.right, node2);
 }
 
 private boolean matchTrees(Node node1, Node node2) {
	 
	if(node1 == null && node2 == null) return true;
	if(node1 == null  || node2 == null) return false;
	 
	 
	 if(node1.data == node2.data) 
		 return matchTrees(node1.left, node2.left) && matchTrees(node1.right, node2.right) ;
	 
	 return false;
	 
 }
 
 void inOrderTraversal(Node2 root) {
		if(root == null) return ;		
		inOrderTraversal(root.left);
		System.out.println(root.data +">>>> LeftSize  "+ root.leftCount);
		inOrderTraversal(root.right);	
	}
  
 /*
  * How many paths in binary search tree sums to given sum 
  * https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
  */
 
private int countPaths(Node root, int target) {
	 
	 if(root == null)return 0;
	 
	Path path = new Path(); //if you want to preserve a variable in recursive calls, go with objects and pass them as params. Do not return objects if possible
	countPathsFromNode(root, target, 0, path   );
	
	int pathsLeft = countPaths(root.left, target);
	int pathsRight = countPaths(root.right, target);
	
	return  pathsLeft + pathsRight + path.count;
 }
 
  class Path {
	  
	  int count;
	  
	  Path(int count){
		  this.count = count;
	  }
	  
	  Path(){
		  
	  }
	 
	 
 }
  
  private void countPathsFromNode(Node root, int target, int currentSum, Path path) {
		 
		  // This is modification of pre-order traversal
		  
		 
		 if(root == null) return;
		 currentSum = currentSum + root.data;
		 if(currentSum == target) {
			 path.count++;
		 }
		 
		 countPathsFromNode(root.left, target, currentSum, path);
		 countPathsFromNode(root.right, target, currentSum, path);
		 
		 //return path;
	 }
	 
/*
 * Tower of Hanoi
 */
  
  //disk are numbered from 1 to n --> top to bottom 
  
 /*   1
   22
  3333
 444444*/

  void arrangeHanoi(int n, String origin, String  buffer, String dest   ) {
	  
     if(n < 1) return;
	  
	  if(n==1) {
		  
		  System.out.println("BS-1 ::Put disk#"+ 1+ " from "+origin + " to "+ dest);
		  return;
	  }
 
	  /*if(n==2) {
		  
		  System.out.println("BS-2 ::Put disk #"+ 1+ " from "+origin + " to "+ buffer);
		  System.out.println("BS-2 ::Put disk #"+ 2+ " from "+origin + " to "+ dest);
		  System.out.println("BS-2 ::Put disk #"+ 1+ " from " + buffer  + " to "+ dest);
		  return;
	  } */
	  
	  arrangeHanoi(n-1, origin, dest, buffer); //if n is odd --> dest and buffer will be same as main call stack
	  System.out.println("Put disk #"+ n+ " from "+origin + " to "+ dest);
	  arrangeHanoi(n-1, buffer, origin, dest);
	  
	  
  }
     
	public static void main(String[] args) {
		
		TreeProbs obj = new TreeProbs();
		
		
		obj.arrangeHanoi(3
				
				, "A" , "B", "C");
		
		int[] arr = new int[] {3, 6, 8, 9, 11};
		
		 /*BinarySearchTree  bst = new  BinarySearchTree();
	        bst.root = new Node(20); 
	        bst.root.left = new Node(10); //45
	        bst.root.right = new Node(30);
	        bst.root.left.left = new Node(40);//40
	        bst.root.left.right = new Node(47);
	        bst.root.right.left = new Node(25);
	        bst.root.right.right = new Node(40); */
		
		/*Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(7);
		root.right.left = new Node(3);
		
		Node root1 = new Node(7);
		root1.right = new Node(3);
		
		System.out.println(obj.checkSubTreeCompare(root, root1));*/
		
		Node2 root2 = null;
		/*
		root2 = obj.createDSFromStream(root2, 20);
		root2 = obj.createDSFromStream(root2, 15);
		root2 = obj.createDSFromStream(root2, 10);
		root2 = obj.createDSFromStream(root2, 5);
		root2 = obj.createDSFromStream(root2, 25);
		root2 = obj.createDSFromStream(root2, 23);
		root2 = obj.createDSFromStream(root2, 24);
		root2 = obj.createDSFromStream(root2, 13);
		
		
		obj.inOrderTraversal(root2);
		
		System.out.println("Rank of 24 " + obj.getRank(root2, 24));*/
		
		/*
		 * sum paths
		 */
		 Node root = new Node(1);    
		    root.left = new Node(3);  
		    root.left.left = new Node(2);  
		    root.left.right = new Node(1);  
		    root.left.right.left = new Node(1);  
		    root.right = new Node(-1);  
		    root.right.left = new Node(4);  
		    root.right.left.left = new Node(1);  
		    root.right.left.right = new Node(2);  
		    root.right.right = new Node(5);  
		    root.right.right.right = new Node(2); 
		    
		  //  System.out.println("Path sum "+ obj.countPaths(root, 5));
		    //obj.test();
		
		
	}
	


}
