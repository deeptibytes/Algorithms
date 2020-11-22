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
