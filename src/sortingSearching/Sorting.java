package sortingSearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

	
	/*Merge two sorted array given than array A has enough buffer at the end to hold all elements of array B
	  
	
	*/
	private int[] sortedMerge(int[] arrA, int[] arrB) {
		
		int i = (0 +arrA.length -1)/2;
		int j = arrB.length -1;
		int k = arrA.length -1;
		
		while(i >= 0 && j >= 0) {  //first : both 0 second i =0, j =1
			// int[] arrA = {2, 4, 6, 8, 0, 0, 0, 0};     int[] arrB = {1, 3, 5, 7};    
			
		if(arrA[i] > arrB[j]) {
			arrA[k] = arrA[i];
			i--;			
		}else {
			arrA[k] = arrB[j];
			j--;
			
		}
		k--;
		}
		
		if(i >= 0) {
			
			while (i >=0) {
				arrA[k] = arrA[i];
				i--;
				k--;
			}
		}
		
          if(j >= 0) {
			
			while (j >=0) {
				arrA[k] = arrB[j];
				j--;
				k--;
			}
		}
		
		
		
		return arrA;
	}
	
	/*
	 * Sort an array of Strings so that all anagrams are next to each other
	 */
	
	class AnagramComparator implements Comparator<String>{
	   
		private String sort(String s) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			//return arr.toString();//we cant do that why???
			return new String(arr);
		}
		
		
		
		
		public int compare(String one, String two) {
			
			return sort(one).compareTo(two);
		}
		
		
	}
	
	
   private void sortAnagrams(String[] strArr) {
	   
	   Arrays.sort(strArr, new AnagramComparator());
   }
   
 
 
 /*
  * Get anagrams
  */
public String[] getAnagrams(String[] arr){

Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
ArrayList<String> list = null;

for(String x: arr){

  char[] xy = x.toCharArray();
  Arrays.sort(xy);
  String sorted = new String(xy);

 if( map.containsKey(sorted) ){
     list = map.get(sorted); //we can also do map.get().add(sorted);
     list.add(x);   
 }else{
    list = new ArrayList<String>();
    list.add(x);
    map.put(sorted, list);    
 }  
}

int k = 0;

for(String key: map.keySet()){

    list = map.get(key);
    Collections.sort(list);
    
    for(String y : list){
     arr[k++] = y;    
    }
    
}
 return arr;

}
   
   
   /*
    * Check if sorted array is rotated.
    * Examples of rotated array
    * 3 4 5 6   1 2 
    * 7 8   2 3 4 5 6
    * 7     1 2 3 4 5 6
    * 
    * Non rotated array
    * 2 3 4 5 6 7 8 9
    * 0 1 2 3 4 5 6 7
    * 
    * all elements left of the pivot (including pivot) will be larger than all elements right of the pivot. If any such element (pivot)
    * does NOT exist in an array, that means array is not rotated.
    */
   
   public int findPivot(int[] arr) {	   
	   return findPivot(arr, 0, arr.length - 1);	 
	   
   }
   
   private int findPivot(int[] arr, int low, int high) {
	  
	   if(low > high) {
		   return -1; //array is not rotated. At some point, low will be equal to high and that means, no rotation
	   }
	  	   
	   int mid = (low + high)/2;
	   
      
	  /*
	   * Base cases start 
	   */
	   //if mid point lies next to pivot on right side
	   if(mid > low && arr[mid] < arr[mid -1]) return  (mid - 1);//this will never true if  array is not rotated
	   //why (mid > low) condition is there. In case mid lies on Low then comparing with mid -1 will gve indexArrayOutOfBounds
	   
	   
	   //if mid point lies at pivot itself	   
	   if(  mid < high && arr[mid] > arr[mid + 1]) return mid;//this will never true if  array is not rotated
	    /*
		* Base cases End
		*/
	   
	   
	   /* now find out mid is in which part of array, left side of pivot with all larger elements than pivot 
	    * or right side with all smaller elements
	    */
	   if(arr[low] >= arr[mid]) return findPivot(arr, low, mid - 1);// mid is in right subarray and that is why low will always be higher than mid
	   return findPivot(arr, mid + 1, high);// if(arr[low] <= arr[mid]), mid is in left subarray and that is why low will always be lower than mid
    
	  
   }
   
  
   /*
    * Calculate the size of array if you are not allowed to use length method
    */
   private int arraySize(int[] arr) {
	   
	   //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15//if the size is given, just do binary search
	   
	  //since length not available, cant know low and high 
	   int index = 1;
	   int preIndex = 0;
	 try {
		 
		 while(arr[index]!= -1) {
			   preIndex = index;//8
			   index = index * 2;//16 Meaning last element lies somewhere between these 2 indexes
				  
		    } 
		 
	 }catch(java.lang.ArrayIndexOutOfBoundsException ex) {
		try {
			while(arr[preIndex]!= -1 ) {
				 preIndex++;//doing liner search between 8 and 16
			 }
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Reched to the end "+--preIndex);
			System.out.println(" Size of the array is "+ ++preIndex);
		}
		 
		 
	 }
		   
   
	   return preIndex;
   }
   
   /*
    * Calculate the index of element x in SORTED array like DS but that DS does not have length or size function. 
    * Index out of bound gives -1
    * This question will require modification of arraySize
    * One way is to call arrYSize to get the size and do binary search but that is not optimal. If key is in the 
    * 4th element, we dont to go till the end array
    *    //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15//if the size is given, just do binary search
	   suppose key is 6 or 12
    */
   
   private int elementAt(int[] arr, int index) {
	   try {
		   return arr[index];
	
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	   
   }
   
   private int findIndex(int[] arr, int key) {
	   
	   int index = 1;
	   
	   while (elementAt(arr, index) != -1 && elementAt(arr, index)   < key ) {//keep on moving towards right until key > index
		   index = index * 2;
		   //key = 6, condition will fail when index is 8. low = 4, high = 8 . Now do binary search
		   //what is the key is 12? low = 8 high = 16 but 16 is out of bound we dont know where exactly array ended after index 8
	   }
	      
	   return binarySearchSpecial(arr, key, index/2, index);
   }
   
   private int binarySearchSpecial(int[] arr, int key, int low, int high) {
	   if (high < low) {
		   return -1;
	   }  
		   int mid = (high + low) /2;
		   
		   if(key == elementAt(arr, mid)) return mid;
		   
		   //if mid point is -1 menas search between low and mid -1
		   if (elementAt(arr, mid) == -1 || key <  elementAt(arr, mid) ) return binarySearchSpecial(arr, key, low, mid -1);
		   
		  
		  return binarySearchSpecial(arr, key, mid+1, high);//key > elementAt(arr, mid)
		  
	  	  
   }
   
   private int binarySearch(int[] arr, int x, int low, int high) {
	   if (high < low) {
		   return -1;
	   }  
		   int mid = (high + low) /2;
		   if(x == arr[mid]) return arr[mid];
		   if( x > arr[mid])  return binarySearch(arr, x, mid+1, high);
		   return binarySearch(arr, x, low, mid -1);
	  	  
   }
   
   
   /*
    * Given a sorted array of strings that is interspersed with empty strings, write method to find a location of given string
    * whenever array is sorted, that means, it will be modification of binary search
    * 
    * String[] arr = {"ghh" "", "shcgsd", "", "", "shdhhjj", "", "", ""};
    */
   
   
   private int findIndexOfString(String[] arr, String str) {
	   int low = 0;
	   int high = arr.length - 1;
	   
	   return binarySearchStrings(arr, str, low, high);   
   }
   
  private int findMid(String[] arr, int low, int high) {
	  
	  int mid = (high + low)/2;	  
	  if(arr[mid].equals("")) {		
		   while( arr[mid].equals(""))   {//go backwards till you find non empty element
			 --mid;
		 }
     }
	  
	  return mid;
	  
  }
   private int binarySearchStrings(String[] arr, String str, int low, int high) {
	   
	   if(high < low) {
		   return -1;
	   }
	   
	   int mid =  findMid(arr,low, high);	   
	   if(   str.compareTo(arr[mid]) == 0  ) return mid;
	   else if(  str.compareTo(arr[mid]) > 0    ) return binarySearchStrings(arr, str, mid +1, high);
	   else return binarySearchStrings(arr, str, low, mid -1);//str.compareTo(arr[mid]) < 0
	   //compareTo == postive value means str1 (cow) is lexicographically higher than str2 (goat)
   }
   
   
   /*
    * find element in a sorted matrix. Each row is sorted in ascending order, each column is sorted in ascending order
    * 
    * 3   5   9   16
    * 6   8   11  18
    * 8   10  15  20
    * 12  14  18  22
    * 
    * find element 10
    */
 private int searchElement(int[][] matrix, int key, int row, int col) {
	   
	 
	 //Base case
	 
	 if(row >= matrix.length  || col < 0)   return -1;
	 if(key == matrix[row][col]) return key;
	 
	   if( key > matrix[row][col]) {
		   row++;
	   }else {
		   col--;
	   }
	   
	   return searchElement(matrix, key, row, col);	  
	   
   }
   private int searchElement(int[][] matrix, int key) {
	   
	   
	   int row = 0;
	   int col = matrix[row].length-1;
	  	  
	   return searchElement(matrix, key, row, col);
	   
   }
   
   
   /* find element in a sorted matrix. Each row is sorted in ascending order, each column is sorted in ascending order. first
    * element in second row is more than last element of first row and so on
   * 
   * 3   5   9   16
   * 17  18  19   20
   * 22   25  27  30
   * 32  44  49  55
   * 
   * find element 10
   */
private int searchElement2(int[][] matrix, int key, int row, int col) {
	   
	 
	 //Base case
	 
	 if(row >= matrix.length  || col < 0)   return -1;
	 
	 if(key == matrix[row][col]) return key;
	 
	 /*
	  * between 16 and 20
	  */
	   if( key > matrix[row][col]  && key <= matrix[row + 1][col]) {
		   return binarySearch(matrix[row + 1], key, 0, col);
	   /*
	    * less than 16   
	    */
	   }else if(key < matrix[row][col]){ 
		   return binarySearch(matrix[row], key, 0, col - 1);
	   /*
	    * more than 16 but not less than 20   that means key does not exist in row 0 and row 1 so do row + 2 
	    */
	   }else { 
		   row = row + 2;
		   return searchElement(matrix, key, row, col);	
	   }
	   
	     
	   
  }
  private int searchElement2(int[][] matrix, int key) {
	   
	   
	   int row = 0;
	   int col = matrix[row].length-1;
	  	  
	   return searchElement2(matrix, key, row, col);
	   
  }
  
  private void printArrays(int[] arr) {
	  
	  for(int x: arr) {
		  
		  System.out.print(" , "+x);
	  }
  }
  
  /*
   * Order elements in an integer so peaks and valleys come alternate
   */
  
  private void getPeaksValleys() {
	  
	  int[] arr = {7, 5, 1, 3, 10, 11, 8, 13};
	  Arrays.sort(arr);
	 // printArrays(arr);
	  
	 // 0  3 2  7  5  11 9  13
	  
	  for(int i =1; i<arr.length - 1; i=i+2) {
		  //swap i with i+1
		  int temp = arr[i];
		  arr[i] = arr[i+1];
		  arr[i+1] = temp;
		  
		  
	  }
	 // System.out.println("After loop");
	  printArrays(arr);
	  System.out.println();
	  
	  
	 
	  
  }
  
 private void getPeaksValleysNoSorting() {
	  
	  int[] arr = {7, 5, 1, 3, 10, 11, 8, 13};
	
	  //we will make odd element (1, 3, 5 and so on as valleys)
	  for(int i =1; i<arr.length - 1; i=i+2) {
		  
		  //compare with previous element
		  if(arr[i]  > arr[i-1]) {//to be a valley , element must be less than previous
			  int j = i +1;
			  while(arr[j] > arr[i - 1] && j < arr.length) {
				  j++;				  
			  }
			  
			//swap i with j
			  int temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
			  //swap
			  
		  }
		  
		  
		  
		  //compare with next element
		  if(arr[i]  > arr[i+1]) {  //to be a valley , element must be less than next
			  int j = i +1;
			  while(arr[j] < arr[i] && j < arr.length) {
				  j++;				  
			  }
			  
			  //swap i+1 with j
			  int temp = arr[i + 1];
			  arr[i + 1] = arr[j];
			  arr[j] = temp;
			  //swap
			  
		  }
		  
		 
		  
		  
	  }
	//  System.out.println("After loop");
	  printArrays(arr);
	  System.out.println();
	   
  }
  
   /*
   * Count all distinct pairs with difference equal to k
   */
   
   //https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
  
  //If space is allowed 
  int countDistinct(int[] arr, int target){
  
    //1. Arrays.sort(arr);
    //2. Now remove duplicates
    int count = 0;
    
    //3.
     for(int i=0; i < arr.length ; i++){
       int complimenet = Math.abs(arr[i] + target);
       int index = binarySearch(arr, i+1, arr.length -1, complement);
       if(index != -1) count++;       
     }
      return count;
  }    
    
  }  
  int binarySearch(int[] , int low, int high, int key){
  
    if (low> high) return -1;   
    int mid = (low + high)/2;   
    if(arr[mid] == key) return arr[mid];   
    if(arr[mid] > key) return binarySearch(arr, 0, mid-1, key);   
    return binarySearch(arr, mid + 1, high, key);
  
  }

   
   
   


/*
 * Median of two sorted Arrays
 * 3  5   7
 * 1  2   8
 * int[] arrA = {1, 5, 8};
int[] arrB = {12, 15, 17};
 * 
 */
  public double findMedian(int[] arrA, int[] arrB){  //O(N)
 
 //Assuming array length is same
 
 int len = arrA.length;
 int mergedLen = len *2;//it will always be even number so median will be the average of (n-1)th and nth element of merged array 
 int i = 0;
 int j =0;
 //int k = 0;
 int counter = len + 1;//while loop should run len+1 times
 double previous = 0;//this will be (n-1)th item
 double nth = 0; //this will be nth item
 
 //If each of the array has size 3 (n) then median of the merged array will be 3rd (nth)  and forth (n+1)th element
 //array Index always starts at 0 so 
 //nth element = element at (n-1) index
 //(n+1)th element = element at n index
 //
 
 
 if( arrB[0] > arrA[len -1] ){ //if all elements of arrA are smaller than all elements of arrB. No need to run while loop
   return (arrB[0] + arrA[len -1])/2;
 }
 
  if(   arrA[0] > arrB[len-1] ){ //if all elements of arrA are larger than all elements of arrB. No need to run while loop
   return (arrA[0]  + arrB[len-1])/2;
 }
 
 
 while( i < len && j < len && counter >= 1){//this will run at least len times. len = length of one of the array. If two arrays have diff length, this will run at least 
 //equal to one of the arrayLength. This is minimum. means any two arrays when merged, loop will atleast run len times. it can run more also but minumum is len
 
  previous = nth;

 if(arrA[i] < arrB[j]){
   
    nth = arrA[i++];

 }else{
  
   nth = arrB[j++];
 
 }

 counter--; 
 }
 
 if( counter > 0){ //at this point, it is sure that k < len + 2 so we need to get only one more element and that will be nth element
 //these are left over elements in arrA and arrB. Please note when we merge sorted array, before i ir j reaches to len
 //it is sure that at least one of the aray elements are used . suppose we have two array with same length, one of the array will always 
 //be used. If length is diff, then we cant conclude which one is used but it is sure that one of them will be used in merging whether it is smaller or longer
 
 
   previous = nth;
   
   if( i < len){ //if arA has elements remaining
    nth = arrA[i];
   } 
     
    if( j < len){  //if arB has elements remaining
     nth = arrB[j];   
   }
 
      
 }
 
  return (nth + previous)/2; 
  
 
 
 }
		   
 
 
 /*//Merge Overlapping Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*Testing code/
*
*int[][] intervals ={ {1,3},{2,6},{8,10},{15,18}  };
int[][] intervals ={ {1,4},{4,5}  };

Stack<int[]> stack = obj.merge(intervals);

while(!stack.empty()){
 int[] x = stack.pop();
 System.out.println(x[0] +","+ x[1]);
}
*/

 public Stack<int[]> merge(int [][] intervals) {
 
 //1. Sort the 2D array by start time
		 sort(intervals, 0);
		 
		 Stack<int[]> stack = new Stack<int[]>();
		 
		 stack.push(intervals[0]);//it will be the lowest interval
		 
		 for(int i=1 ; i < intervals.length ; i++){
		   //Modify stack value
		   
		   if(checkOverlap(stack.peek(), intervals[i])){ //peek is 1,3 and interval[i] is 1,6 so modified value will be 1, 6  
		     int[] stackValue = stack.peek();//no need to pop and then modify, peek gives reference of value, we just need to modify that and it will modify the stack object
		     stackValue[1] = intervals[i][1]; 
		   }else{  
		      stack.push(intervals[i]); 
		 }
		 
		 }
		   return stack;   
}

boolean checkOverlap(int[] arrA, int[] arrB){

if(arrA[1] < arrB[1] && arrA[1] >= arrB[0]) return true;
return false;


}
    
  public void sort(int[][] arr, int col){
    
    Arrays.sort( arr, new Comparator<int[]>()  {
    
	    @Override
	    public int compare(int[] arrA, int[] arrB){
	    
	    
	    if(arrA[col] == arrB[col]) return 0;
	    if(arrA[col] < arrB[col]) return -1;
	    return 1;
    }
    
    });
    
  }
 
	
	public static void main(String[] args) {
		/*int[] arrA = {1, 3, 5, 7, 0, 0, 0, 0};
		int[] arrB = {2, 4, 6, 8};
		*/
		Sorting obj = new Sorting();
		
		//obj.sortedMerge(arrA, arrB);
		
		//for(int x: arrA) System.out.print(" "+ x);
		
		/*String[] strArr = new String[] { "efd", "fde", "ghi", "ihg", "abcd" , "def", "cba", "acd", "aam", "aan", "aan"};
		obj.sortAnagrams(strArr);
		for(String ele: strArr) {
			System.out.print(" "+ele);
		}*/
		
		int[] arrA = {3, 4, 5, 6, 1, 2};
		int[] arrB = {1, 2, 3, 4, 5, 6, 7};
		int[] arrC = {7, 8, 2, 3, 4, 5, 6};
		int[] arrD = { 8, 2, 3, 4, 5, 6};
		int[] arrE = {  3, 4, 5, 6, 7, 1};
		
		
		//System.out.println(obj.findPivot(arrB));
		//int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		/*int[] arr = {5};
	
		//System.out.println("ArraySize is "+obj.arraySize(arr));
		System.out.println("index of key "+obj.findIndex(arr, 5));  */
		
		int[][] matrix = 
		          {   {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}                     
		          };
		
		
		//int ele = obj.searchElement(matrix, 27);
		//System.out.println("element is matrix is "+ele);
		
		int[][] mat = 
					{
			        		 { 3,   5,   9,   16},			         
				         {17,  18,  19,   20},
			             { 22,   25,  27,  30},
				    	     { 32,  44,  49,  55}
					};
		
		//int ele = obj.searchElement2(mat, 56);
		//System.out.println("element is matrix is "+ele);
		
		obj.getPeaksValleys();
		obj.getPeaksValleysNoSorting();
		
	
		
		
		
		

	}

}
