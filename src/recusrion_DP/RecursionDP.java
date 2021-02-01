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
		return getSubsets(set, finalList, set.size()-1);//pass last index
	}
	
	
	
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> preList, int index) {
		
    	 //base case starts
    	/*
    	 * {1} = {}, {1}
    	 */
    	if(index == 0) {//if the size is one, index will be zero
    		ArrayList<Integer> subset0 = new ArrayList<Integer>();
    		subset0.add(set.get(0));
    		
    		preList.add(new ArrayList<Integer>());//empty set
    		preList.add(subset0);//added {1}
    		
    		return preList;
    	}
    	/*
    	 * Base case ends
    	 */
    	//{1,3}
    	//if input size is two, we will pass 1 here, so first we will calculate subsets of first element
    	  preList =  getSubsets(set, preList, index - 1);//this will calculate subset of {1}
    	  
    	  
    	  ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
    	  
    	  /*
    	   * adding all subsets from (1}
    	   */
    	  finalList.addAll(preList);
    	  
    	  //Now add 2nd element (3) to each subset of {1}
    	  for(ArrayList<Integer> subset: preList) {
    		  ArrayList<Integer> elementSet = new ArrayList<Integer>();
    		  elementSet.addAll(subset);//do not modify subset !!!! it will modify original subset element in finalList
    		  //adding 3rd element to each subset of {1,3}
    		  elementSet.add(set.get(index));
    		  finalList.add(elementSet);
    	  }   	 
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
	

/*
 * Calculate permutations of string with unique chars
 * P(a1a2a3) = {a1 + P(a2a3)} + {a2 + P(a1a3)}+ { a3 + P(a1a2)
 * Iterate through char by char, construct substring by removing char at ith position, calculate P of that substring and then append ith char with
 * all permutations
 */

public ArrayList<String> stringPermutations(String input){//abc
  
   
   ArrayList<String> preList = new ArrayList<String>();
   
   if(input.equals("")){
    preList.add("");
    return preList;
   }
  
  if(input.length() == 1){//size is one   
    preList.add(input);
    return preList;
  
  }
  
  if(input.length() == 2){//ab  
   preList.add(input.substring(0,1) + input.substring(1,2) );//ab
   preList.add( input.substring(1,2) + input.substring(0,1) );  //ba
   return preList;
  
  }
  
  //If length does not 0 or 1 or 2, call below method
  return permutations(input);
 
  }
  
public ArrayList<String> permutations(String input){
  
  ArrayList<String> finalList = new ArrayList<String>();
  
    
  for(int i=0; i<input.length(); i++){
  
    String single = input.substring(i, i+1);//get "single char" at ith
    String remainder = input.substring(0, i) + input.substring(i + 1);//get remainder string. Meaning chars before "single char" and after "single char"
  
     ArrayList<String> list =  stringPermutations(remainder);
  
     for(String str: list){
        finalList.add(single + str);
     }
  }
  
 
  return finalList;
 
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
