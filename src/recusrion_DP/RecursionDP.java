package recusrion_DP;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

public class RecursionDP {

	/*
	 * Triple Step: A child is running up a staircase with n steps and can hop either 1, 2 or 3 steps at a time. Implement a method
	 * to count how many ways the child can run up the stairs
	 */
	
	/*
	 * Find out the magic index in a sorted array
	 * 
	 * int[] arr = {-2, -1, 0, 3, 5, 7, 9, 14, 18}//magic index is 3 because arr[3] = 3
	 * int[] arr = {-2, -1, 0, 1, 2, 3, 6, 10, 14, 18 20 22}//magic index is 3 because arr[6] = 6
	 * Magic index in sorted array = elements before magic index will always be increment by 1 (if all are positive)
	 * sorted array means modification of binary search
	 * 1 3 4 6 7 8 9 10 11 12 13 14
	 */
		
	private int findMagicIndex(int[] arr) {
		return findMagicIndex(arr, 0, arr.length -1);
	}
	
	private int findMagicIndex(int[] arr, int low, int high) {
		if(high < low) {
			return -1;
		}
		
		int mid = (high + low)/2; 
		
		if(mid == arr[mid]) return mid;
		else if(mid < arr[mid])  return findMagicIndex(arr, low, mid -1);//mid = index 4,  arr[mid] = 5
		else return findMagicIndex(arr, mid +1, high);//mid = 5,  arr[mid] = 3   
		
	}
	
	
	/*
	 * Write a method to return all subsets of a set. Number of subsets are 2 to the power of n where n is number of elements in set
	 * {1} = {}, {1}
	 * {1, 3} = {}, {1}, {3}, {1, 3}
	 * {1, 3, 5} = {subsetOf 1,3} ,     {add 5 in all subsets of 1,3}, 
	 * 
	 */
	
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();		
		return getSubsets(set, finalList);
	}
	
	
	
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> preList) {
		
    	 //base case starts
    	/*
    	 * {1} = {}, {1}
    	 */
    	if(set.size() == 1) {
    		ArrayList<Integer> subset0 = new ArrayList<Integer>();
    		subset0.add(set.get(0));
    		
    		preList.add(new ArrayList<Integer>());//empty set
    		preList.add(subset0);//added {1}
    		
    		return preList;
    		
    /*
     * {1, 3} = {}, {1}, {3}, {1, 3}		
     */
    	}else if(set.size() == 2) {
    		
    	
    		/*
    		 * Creating {1}, adding element from index 0
    		 */
    		ArrayList<Integer> subset0 = new ArrayList<Integer>();
    		subset0.add(set.get(0));
    		
    		
    		/*
    		 * Creating {3}  adding element from index 1
    		 */
    		ArrayList<Integer> subset1 = new ArrayList<Integer>();
    		subset1.add(set.get(1));
    		
    		/*
    		 * creating {1, 3}	
    		 */
    		ArrayList<Integer> subset2 = new ArrayList<Integer>();
    		subset2.add(set.get(0));
    		subset2.add(set.get(1));
    		
    		/*
    		 * Populating final list
    		 */
    		preList.add(new ArrayList<Integer>());//adding empty set {}
    		preList.add(subset0);//added {1}
    		preList.add(subset1);//added {3}
    		preList.add(subset2);//added {1, 3}
    		
    		return preList;
    		
    	}
    	
    	/*
    	 * Base case ends
    	 */
    	
    	  int last = set.remove(set.size() -1);
    	  preList =  getSubsets(set, preList);
    	  
    	  
    	  ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
    	  
    	  /*
    	   * adding all subsets from (1, 3}
    	   */
    	  finalList.addAll(preList);
    	  
    	  //Now add 3rd element to each subset of {1,3}
    	  for(ArrayList<Integer> subset: preList) {
    		  ArrayList<Integer> elementSet = new ArrayList<Integer>();
    		  elementSet.addAll(subset);
    		  //adding 3rd element to each subset of {1,3}
    		  elementSet.add(last);
    		  finalList.add(elementSet);
    	  }
    
    	 
    	  set.add(last);	
	  return finalList;
	}
	
	
	
	
	void printList (ArrayList<ArrayList<Integer>>  set){
		System.out.print("   {     ");
		for(ArrayList<Integer> subSet: set) {
			System.out.print("{ ");
			for(int x: subSet) {
				System.out.print(x + ", ")	;
			}
			System.out.print("}, ");
		}
		
		System.out.print("  }       ");
	}
	
	/*
	 * Recursive Multiply of two positive integers
	 */
	
	private int recMultiply(int a,  int b) {
		
		/*
		 * Base Case start
		 */
		if(a == 0 || b == 0) return 0;
		
		if(a == 1) return b;
		if(b == 1) return a;
		
		if(b == 2) return a + a;
		
		/*
		 * Base Case end
		 */
		
		return a + recMultiply(a, b - 1);
		
	
	}
	
	
	
	
	public static void main(String[] args) {
		RecursionDP obj = new RecursionDP();
		
		/*int[] arrA = {-2, -1, 0, 3, 5, 7, 9, 14, 18};//magic index is 3 because arr[3] = 3
		int[] arrB = {-2, -1, 0, 1, 2, 3, 6, 10, 14, 18, 20, 22};//magic index is 3 because arr[6] = 6
		
		System.out.println("Magic Index is "+obj.findMagicIndex(arrB));*/
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		
		//ArrayList<ArrayList<Integer>> resultSet = obj.getSubsets(set);
		//obj.printList(resultSet);
		
		System.out.println("Multiplication is "+obj.recMultiply(9, 8));
		
		
		
		

	}

}
