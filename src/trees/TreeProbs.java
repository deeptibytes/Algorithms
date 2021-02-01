cpackage trees;

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
	
	public  ArrayList<LinkedList<Node>>  getListAtDepth(Node root){
		
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		getListAtDepth(root, result, 0);
		return result
		
		
	}
	
	public void getListAtDepth(Node root, ArrayList<LinkedList<Node>> result, int level) {
		
	      if(root == null) {
	    	    return;
	      }
	      LinkedList<Node> levelList = null;
	      if(result.size() == level) {//we are going down to left side first time 
	    	    levelList = new LinkedList<Node>();
	    	    result.add(levelList);
	      }else {//now we are going up in recursion call
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
   
  private int getRank(Node2 node, int x) {//rank means how many nums are smaller than the given number
    	 
	 if(x== node.data) return node.leftCount;
	 
	 if(x < node.data) {
		 
		 if(node.left == null) return -1;
		 
		return getRank(node.left, x);
		 
		 
		 
	 }else { //x > node.data
		 
		 if(node.right == null) return -1;
		 
		 int leftSubTreesize = node.leftCount;
		 
		 int letNodeCount = getRank(node.right, x);
				 
		return leftSubTreesize + letNodeCount + 1;//i is for adding root
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
  * Path may or may not include the root element. So first check if path is there with root or not. Then check paths in left subtree and then right subtree
  */
 
private int countPaths(Node root, int target) {
	 
	 if(root == null)return 0;
	 
	Path path = new Path(); //if you want to preserve a variable in recursive calls, go with objects and pass them as params. Do not return objects if possible. 
	//If you use primitives in recursive calls, you must return it to get the most updated value.  But in case of objects, they dont need to be returned
	countPathsFromNode(root, target, 0, path   );//this will check paths from root node
	
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
		 //currentSu var is being used in recursive call. It isok because we dont need this var outside this method. 
		 //We need path outside of this method so we must use object. 
		 
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
  
//Create mirror tree  
  public void createMirror(Node node){
  if(node == null) return;
  
  Node Temp = node.left;
  node.left = node.right;
  node.right = Temp;
  
  createMirror(node.left);
  createMirror(node.right);

}


/* Every node is sum of its two child nodes
 */
public boolean checkSumTree(Node node){
  if(node == null) return true;
  boolean isSum = false;
  if(node.left == null && node.right == null) return true;
  
  else if(node.left !=null && node.right !=null){
     isSum = (node.val ==node.left.val + node.right.val) ? true: false;
  }else if(node.left != null) {
       isSum = (node.val ==node.left.val) ? true: false; 
  }else{  
      isSum = (node.val ==node.right.val) ? true: false; 
  }
  
  return isSum && checkSumTree(node.left) && checkSumTree(node.right);
  
 /* Example of sum tree    
  * TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(9);*/
 
 
}



/*
     Given a tree and a sum, 
     return true if there is a path
     from the root down to a leaf,
     such that adding up all
     the values along the path 
     equals the given sum. It is enforcing that path must have root
 
     Strategy: subtract the node 
     value from the sum when
     recurring down, and check to 
     see if the sum is 0 when
     you run out of tree.
     
     12
   8
 3
     */
 
    boolean hasPathSum(Node node, int sum)
    {
        if (node == null)
            return sum == 0;//this is not sum =0!!
            
            boolean isFountLeft = hasPathSum(node.left, sum - node.data);//while recursing, passing sum - node.data
            booelan isFoundRight = hasPathSum(node.right, sum - node.data);
            
            //if any of the boolean is true that means path is found.
            
            return isFountLeft || isFoundRight;
    }
 
  
 //Serialize/Deserialize Binary tree

public String serialize(TreeNode root, String str){//it will convert BT into String in preorder traversal order

//since String is object type, we can use that in multiple recursive call retaining the value
 if(root == null){
   str = str + "X" + ",";
 } else{///notice here keeping this in else part is necessary because we are not returning anything in base case. 
 //If we are returning any thing in base case, no need to use else because after return no code is executed.
 //But if not returning, then else should be used

	 str = str + root.val + ",";
	 str = serialize(root.left, str);//imp to return here. if method is returning anything, recursive call should also return something
	 //when we do oreorder traversal, retrun type is void so we dont need return anything in recursive call. 
	 //But here method return type is String so we should return
	 str = serialize(root.right, str);
 }	 
 return str;
}

public String serialize(TreeNode root){//it will convert BT into String in pre order traversal order

 String str= new String("");
 return serialize(root, str);
}

public TreeNode deserialize(String str){//this will convert String into binary Tree

	//convert String into String array
	String[] strArray = str.split(",");
	List list = new LinkedList<String>(Arrays.asList(strArray) );
	return populateTree(list);
}

public TreeNode populateTree(List list){

 	    if(list.get(0).equals("X") ){//we can also do list.poll() because it is Linkedlist
 	      list.remove(0);
 	      return null;//base case
		
 	    }//what is put below part in else?? dont do that. It will cause trouble because in that case when you return root, it will not
 	    //compile because root is defined in else block. Remember if base case is returning something, no need to use else!!!
 	    
 	      TreeNode root = new TreeNode(Integer.parseInt((String)list.get(0)));
		  list.remove(0);
		  root.left =  populateTree(list);
		  root.right = populateTree(list);
		  return root;
          
   }

 
  
/*
 * //ZigZag level order traversal 
 * 
 * Testing code
 *     TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        
      Trees obj = new Trees();
      
     List<LinkedList<TreeNode>> list = obj.zigZakTraversal(node);
     
     for(LinkedList<TreeNode> llist : list){
       System.out.println("printing level ");
        for ( TreeNode nodec:llist){
          System.out.println(nodec.val);
        
        }
 */
	
public List<LinkedList<TreeNode>> zigZakTraversal(TreeNode root){

	int height = getMaxTreeHeight(root);
	List<LinkedList<TreeNode>> finalList = new ArrayList<LinkedList<TreeNode>>();
	zigZakTraversal(root, finalList, 0, height);	
	return finalList;
}

public void zigZakTraversal(TreeNode root, List<LinkedList<TreeNode>> finalList, int level, int height){

  if(level >= height) return;//level and height cant be same. If height is 3, maxLavel will be 2
  
  if(finalList.size() == level){//mens list does not exist yet for that level
     LinkedList<TreeNode> list = new LinkedList<TreeNode>();
     list.add(root);
     finalList.add(list);  
  }else{
      LinkedList<TreeNode> list = finalList.get(level);
      if(level % 2 == 0){  //level is even, add node at head
        list.push(root);//add at front
     
      }else{//level is odd, add node at tail
         list.add(root);//add at end
      
      }
  }
  
  zigZakTraversal(root.left, finalList, level + 1, height);
  zigZakTraversal(root.right, finalList, level + 1, height);


}

  
  
  
  
     
	public static void main(String[] args) {
		
		TreeProbs obj = new TreeProbs();
		
		
		
		
	}
	


}
