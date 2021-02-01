package arrayAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArrayNStrings {

/*
 * Check if string has all unique chars	
 */
	// using additional DS(array)
	public <Charactor> boolean checkUnique(String s) {//h e l l o
		
		//1. using additional DS (array)
		/*boolean[] arr = new boolean[128];
		int index = 0;
		for(int i=0 ; i <= s.length() -1; i++) {
			index = s.charAt(i);
			if(arr[index]) return false;
			arr[index] = true;
			
		}
		
		return true;*/
	
	//2. using additional DS (SET)
	
	/*Set<Character> charSet =  new HashSet<Character>();
	for(int i=0 ; i <= s.length() -1; i++) {
	   charSet.add(s.charAt(i));
	}
	if(charSet.size() != s.length())	return false;
	return true;
	}
	*/
	
	
		//3. using additional DS (Map)
	
	HashMap<Character, Integer>  map = new HashMap<>();
	for(int i=0 ; i <= s.length() -1; i++) {
		if(map.containsKey(s.charAt(i))) return false;
		map.put(s.charAt(i), 1);
	}
	
	return true;
	
		
		//without using DS Brute Force
		
	
	
	
	}	
	
/*
 * Check Permutation	
 */
	
	private boolean checkPermutation(String s1, String s2) {
		//1. *********Using sorting
		/*if(s1.length() != s2.length()) return false;
		
		return sortString(s1).equals(sortString(s2));*/	
		
		//2. *********using char counts. If char count is same in both, means permutation (using Hashmap)
		
		/*if(s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer>  map = new HashMap<>();//HELLO
		
		for(int i=0 ; i <= s1.length() -1; i++) {
			int value = map.getOrDefault(s1.charAt(i), 0);
			map.put(s1.charAt(i), ++value); //Map = {H,1}, {E,1}, {L,2}, {O,1}
		}
		
		for(int i=0 ; i <= s2.length() -1; i++) {			
			char key = s2.charAt(i);	
			
			
			if(!map.containsKey(key)) return false;//means this char was not in s1, cant be permutation
			
			int value = map.get(key);
			value--;
			if(value < 0) return false;
		    map.replace(key, value);		 
			
		}
		
		return true;*/
		
		//3. *********using char counts. If char count is same in both, means permutation (using Array)
		
		if(s1.length() != s2.length()) return false;
		
		int[] arr = new int[128];
		for(int i=0 ; i <= s1.length() -1; i++) {		
			int index = s2.charAt(i);
			arr[index]++;
		}
		
		for(int i=0 ; i <= s2.length() -1; i++) {		
			arr[s2.charAt(i)]--; //if count of char is same, it will be zero. If less than zero, means counts if char is more in s2
			
			if( arr[s2.charAt(i)] < 0 ) return false;
			
			
		}
		
		return true;
		
	}
	
	public boolean checPermutation(String str1, String str2){ ///T O(m + n) S O(m)
	
	if(str1.length() != str1.length()) return false;
	
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	for(int i=0; i < str1.length(); i++) {
	  map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);	
	}
	
	for(int i=0; i< str2.length(); i++){
	
	  if(! map.containsKey(str2.charAt(i))) return false;
	  map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) - 1  )	;
	   if(map.get(str2.charAt(i)) > 0) return false;	
	}
	
	return true;
	
	}	
	
	
	
private String sortString(String s) {
		
		char[] arr = new char[s.length()];
				//arr = s.toCharArray();
		Arrays.sort(arr);
		return arr.toString();
	}

/*
 * Check permutation of palindrome
 */

 private boolean checkPermutationOfPalindrome(String s) {
	 //1. Using hashMap. check odd after all iterations are done
	 /*HashMap<Character, Integer>  map = new HashMap<>();//HELLOLLEH
	
	 for(int i=0 ; i <= s.length() -1; i++) {
		 //Build CharFrequency Map
		    char key = s.charAt(i);
			int value = map.getOrDefault(key, 0);
			map.put(key, ++value); //Map = {H,2}, {E,2}, {L,2}, {O,1}			
		}
	 
	 //Now check how many chars are there with odd number. Mean frequency is not even.At max one odd is allowed to be palindrome
	  boolean oddFound = false;
	  for(int value : map.values()) {
		  
		  if(value %2 == 1) {//checking if number is odd
			  if(oddFound) return false;//it  ill be always false for first odd found, second onwards, it will be true
			  oddFound = true;
		  }
	  }
	  
	  return true;*/
	  
	  //2. Using hashMap but checking odd within the iteration: more optimized
	  
	  HashMap<Character, Integer>  map = new HashMap<>();//HELLOLLEH
		 int oddCounter = 0;
		
		 for(int i=0 ; i <= s.length() -1; i++) {
			 //Build CharFrequency Map
			    char key = s.charAt(i);
				int value = map.getOrDefault(s.charAt(i), 0);
				map.put(key, ++value); //Map = {H,1}, {E,1}, {L,2}, {O,1}
				
				if(map.get(key) % 2 == 1) { //if key is odd
					oddCounter++;
				}else {
					oddCounter--;
				}
				
				
			}
		 
		return (oddCounter <= 1);//if it is 1 or zero (menas all chars in even count) then return true
	
	
	
}

public boolean palindromePermutation( String str1){  //T O(N) S O(N)
	
	 int oddCounter = 0;
	 
	 Map<Character, Integer> map = new HashMap<Character, Integer>();
	 
	  for(int i=0; i < str1.length(); i++) {
	     map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);	     
	 }
	 
	 for(char c: map.keySet()){
	   if(! isEven(map.get(c))) oddCounter++;
	 }
	
	 
	 return (oddCounter > 1) ? false: true ;
	
	
	}
 
 
 /*
  * One edit away
  */
 
 private boolean isOneEditAway( String s1, String s2) {
	 
	 if(s1.length() != s2.length()) return oneDeletionAway(s1, s2);
	 return oneReplacementAway(s1, s2);
	 
 }
 
 private boolean oneReplacementAway(String s1, String s2) {
	 
	 int i = 0; int j = 0;
	 boolean diffFound = false;
	 
	 while (i <=s1.length() - 1   && j <= s2.length() - 1) {
		 if(s1.charAt(i) != s2.charAt(j)  ) {
			 if(diffFound) return false;
			 diffFound = true;
		 }
		 i++; j++;
		 
	 }
	 
	 return true;	 
 }
 
 private boolean oneDeletionAway(String s1, String s2) {  //PALE", "BALaA"
	 
	 int i = 0; int j = 0;
	 boolean diffFound = false;
	 boolean isFirstBigger = false;
	 
	 if( s1.length() > s2.length()) isFirstBigger = true;
	 
	 while (i <=s1.length() - 1   && j <= s2.length() - 1) {
		 
		 if(s1.charAt(i) != s2.charAt(j)  ) {
			 if(diffFound) return false;  //we can also do (if i != j) return false. in first match, i, j will be equal. Second and onwards, they wont be
			 diffFound = true;
			 
			 if(isFirstBigger) i++; //pointer should be increased for bigger string
			 else j++;
			 
		 }else {//if equal, both pointers should be increased
			 i++; j++;
		 }
		 
		 
	 }
	 
	 return true;
 }
 
 
 private String countConsecutive(String s) {
	 
	
	 
	 int counter = 0;
	 StringBuilder output = new StringBuilder();  //a a b c c c a a a b  or a b b b//a1b
	 
	 for(int i=0 ; i < s.length(); i++) { //append only if you found the diff, ele keep on increasing only the counter
		 
		 if(output.length() > s.length()) return s;
		 
		 counter++;
		 
		 if(i >= s.length() - 1 ||  s.charAt(i) != s.charAt(i + 1)) {
			
			 output.append(s.charAt(i)).append(counter);
			 counter = 0;			 
		 }
	 }	
	 return output.toString();	 
 }



	
	
	public String compress(String str){
	  
	  StringBuilder sb = new StringBuilder();
	  
	  int i = 0;
	  
	  for(int j=i+1 ; j< str.length(); j++){
	  
	   if(str.charAt(i) != str.charAt(j)) {
	       sb.append(str.charAt(i)).append(j -i);//
	       //check if sb.length() == str.length()) return str. No need to process further
	       i = j;	   	   
	   }	  
	  }
	  // loop exits. Add ith char to the sb
	  sb.append(str.charAt(i));
	  
	 // if i is at the end, meaning last char so it is there only one time
	  if(i == str.length() -1)  sb.append("1");
	  //if i is not at the end
	  else sb.append( j -i);
	  
	  
	  
	   return (sb.length() == str.length()) ? str : sb.toString();
	
	}
	
	public int[][] setZeroMatrix(int arr[][]){
	
	   int row = arr.length;
	   int col = arr[0].length;
	   
	   int[] rowArr = new int[row];//you can also make boolean
	   int[] colArr = new int[col];
	   
	   for(int i=0; i < arr.length ; i++){
	      for(int j=0; j < arr[i].length ; j++){
	        if(arr[i][j]==0){
	           rowArr[i] = 1;
	           colArr[j] = 1;
	        }
	      
	      }	   
	   }
	   
	    for(int i=0; i < row ; i++){
	      if(rowArr[i] == 1){
	        setRowZero(arr, i);
	      }
	    }
	    
	     for(int i=0; i < col ; i++){
	      if(colArr[i] ==1){
	        setColZero(arr, i);
	      }
	    }
	   
	  return arr;
	}
	
	public void setColZero(int out[][], int col){
	
      //setting all col zero
	        
	       for(int i=0; i < out.length ; i++){
	           out[i][col] = 0;
	       
	        }
	
	}
	
	public void setRowZero(int out[][], int row){
	
	   
	    //setting all row zero
	        for(int j=0; j < out[row].length ; j++){	        
	           out[row][j] = 0;
	        }
	
	}
	
	
	 
	 public String urliFy(String str){
	 
	    return str.trim().replaceAll("\\s", "%20");
	    //return out;
	    
	    
	 
	 }

//Find K’th largest element in an array	
	//If we sort >> O(nLogn) >> we want better performance
		 
public int findKthLargest(int[] arr, int k){//Using MinHeap
	
	    
        
       //Create minHeap of k elemenst
	Queue<Integer> pQ = new PriorityQueue<Integer>();//default is minHeap
	
	int i = 0;
	//put two elements in heap
	while(i < k){
	  pQ.offer(arr[i++]);	
	}
	
	for(i = k; i < arr.length ; i++){
	   
	   if(arr[i] > pQ.peek() ){//incoming number is less than heap root, no need to add that because we are finding largest.
	     pQ.poll();
	     pQ.add(arr[i] );
	   }
	
	}
	  return pQ.peek();	
}

public int findKthLargest(int[] arr, int k){//Using MaxHeap
	
	Comparator<Integer> comp = new Comparator<Integer>()//if defining comparatoer type as integer, compare method should have params of Integer type
	{
			
			@Override
			public int compare(Integer x, Integer y){
		
			if(x > y) return -1;
			if(x < y) return 1;
			else return 0;
			
			
			}
			
			
			
	};
	
	Queue<Integer> pq = new PriorityQueue<Integer>(comp);//since it is not default, we have to define and pass comparator
	
	//Create maxheap
	for(int x: arr){
	 pq.offer(x);
	}
	
	//Remove k-1 elements
	
	while(k > 1){
	
	  pq.poll();
	  k--;
	
	}
	
	return pq.peek();
	
	
	}




//Given a non-empty array of integers, return the k most frequent elements.
 public int[] topKFrequent(int[] arr, int k) {
        
         HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
  createFreqenecyMap(arr, map);
  //Create PQ sorted by values Min Heap
  
  Comparator<Integer> comp = new Comparator<Integer>()//sorting if hashMap keys which are integers so comp type is Integer. if key Type is Stringm then comp type will ne String
  
		  {
		  
		    @Override
		    public int compare(Integer n1, Integer n2){
		     return map.get(n1) - map.get(n2);//we can use map var here as it is defined outside of this function so it is in scope here
		    
		    }
		  		  
		  
		  };
  
Queue<Integer> pq = new PriorityQueue<Integer>(comp);//minheap of map keys. They will be ordered with their corresponding values

 //add k keys to the PQ
 
 int i = 0;
 for(int key: map.keySet()){//if K == 2 2 keys will be added to the PQ
 
   if(i == k) break;
   pq.offer(key);
   i++;
 
 }
 
 i =0;//setting i back to zero
 
 //Now add remaining keys to the PQ if they are more than pq.peek();
 
 for(int key: map.keySet()){//
   if(i >=k && map.get(key) > map.get(pq.peek()))  {//this block wont get executed for first two keys which are already in PQ
   
        pq.poll();
        pq.add(key);
     
   } 
   
   i++; 
 
 }
 
 int[] output = new int[k];
 
 i = 0;
 
 while(!pq.isEmpty()){
   output[i++] = pq.poll();
 }
  return output;
            
}
    
public void createFreqenecyMap(int[] arr, HashMap<Integer, Integer> map){

 for(int x : arr){
   map.put(x, map.getOrDefault(x, 0) + 1);
 }
}


//Two Sum Prob asking pair of index. If asking pair of elements, we can use binary search method or a simple set. but for index,  use below
 public int[] twoSum(int[] nums, int target) { //O(N)
        
     
      int[] output = new int[2];
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
      createIndexMap(nums, map);
        
        for(int i=0; i<nums.length; i++){   //you must be thinking we can also do for(int key: map.keySet). But that will fail in many test cases especually with duplicate element . //For ex [3,3] an target is 6. Map will have only one entry with key as 3 and value as 1. So it is important to iterate through array not the map because map will have less keys if duplicate elements are there.     
            int comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp) != i){// this check is imp here . for example [3,2,4] and target is 6. for element 3, comp will be 3 so when we do map.contains(3), it will return true. But actually comp is not there in array
            
                output[0]=i;
                output[1]=map.get(comp);               
                break;
            }           
        }
     
        return output;
        
    }
    
    
    void createIndexMap(int[]nums, Map<Integer, Integer> map){//putting element as keys and index as value
        
        for(int i=0; i<nums.length; i++){           
            map.put(nums[i], i);          
        }
  }
  
  //Container With Most Water
   public int maxArea(int[] height) {
        
        
        int lowId = 0;
        int highId = height.length-1;       
        int maxArea = 0;
        
        
        while(lowId < highId){
            
            int distance = highId - lowId;

            int area = Math.min(height[lowId], height[highId]) * distance;

            maxArea = Math.max(maxArea, area);

            if(height[lowId] <  height[highId]) 
                lowId++;
            else highId--;
            
            
        }
        
        return maxArea;
       
             
    }
    
    
    //Longest common substring with non repeating chars: abcabcbb>>abc
public int longestsubstring(String str){ ///O(N square)

	int len = str.length();     
    int result = 0; 
    
      
    for(int i = 0; i < len; i++) //outer loop.  window starting from 0, 1 and 2 and so on
    { 
          
        // Note : Default values in visited are false 
        boolean[] visited = new boolean[127]; //If string contains utf chars too, make this as 256
        //This array will be reset whenever inner loop is complete executing
          
        for(int j = i; j < len; j++) //inner loop, in this we check all elements form the window start
        // if they are already visited in that window, means duplicate elements. in input abcabcbb, window starts from 0, till index 2, we dont
        //find any duplicates. The moment we reach to index index 3, visited[str.charAt(j)] == true because we have alrready visisted a in current window.
        //inner loop will break.till this point result is 3 (abc). Now again start another window from index i+1 (1) and repeat
        { 
              
            // If current character is visited 
            // Break the loop 
            if (visited[str.charAt(j)]) 
                break; 
  
            // Else update the result if 
            // this window is larger, and mark 
            // current character as visited. 
            else
            { 
                result = Math.max(result, j - i + 1); 
                visited[str.charAt(j)] = true; 
            } 
        } 

    } 
    return result; 
	
}
    ///Longest Common Prefix
			//Big O = O(N*M)
			//N = Number of strings
			//M = Length of the largest string string 
			//


 public String longestCommonPrefix(String[] arr){ 

    if(arr.length == 0) return "";//base case
	if(arr.length < 2) return arr[0]; //base case//size 1
	
	String prefix  = commonPrefixUtil(arr[0], arr[1]);
		
	if(prefix.equals("") ) return "";//first two string does not have common prefix, no need to compare further

    if(arr.length < 3) return prefix;//this will make sure array has 3rd element
     
     
	 for(int i=2; i < arr.length ; i++){//now compare if 3rd elements contains same prefix or first few chars of prefix. If none of the elments
	 //of prefix are present in 3rd string, means there is no common prefix in aray elements and we return ""
	
		prefix =  commonPrefixUtil(prefix, arr[i]);
		
	    if(prefix.equals("") ) break;
	 }

   return prefix;
	
}

  public String commonPrefixUtil(String one, String two){//O(N)
  
  String result = "";
	   
  for(int i =0, j = 0; i < one.length() && j < two.length() ; i++ , j++){

	    if(one.charAt(i) != two.charAt(j)  ){
	      break;
	    }
	    
	    result = result + one.charAt(i);
  
  }

 return result;

}


//print matrix in zigZac fashion

	public List<Integer> spiralMatrix(int[][] arr){
	
	int rows = arr.length;
	int start;
    int end;
    List<Integer> list = new ArrayList<Integer>();
	
	for(int i =0; i < rows ; i++){		
		  start = 0;
		  end = arr[i].length - 1;	  

		
		if(i ==0 || i % 2 == 0){//even rows
		
		   for(int j =start; j <= end ; j++){
		     list.add(arr[i][j]);		   
		   }
		
		
		}else{//odd rows
		
		  for(int j =end; j >= start ; j--){
		     list.add(arr[i][j]);		   
		   }
		
		}
		  
	}
	
	return list;
	
}

////Positions of Large Groups


 public List<List<Integer>> largeGroupPositions(String str) {
        
         	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	
	int i = 0;
	int len = 0;
	ArrayList<Integer> list = null;
    int j;
	
	for( j = i+1; j < str.length(); j++){
	
	  if(  str.charAt(i) != str.charAt(j) ){
	    len = (j-1) -i + 1;
	    if(len >= 3){
	     list = new ArrayList<Integer>();
	     list.add(i); list.add(j-1);
	     result.add(list);
	    }
      i = j ;
	} 
        
  }
    
     len = (j-1) -i + 1;
     if(len >=3){
       list = new ArrayList<Integer>();
	     list.add(i); list.add(j-1);
	     result.add(list);
     }
    
    return result;
	
}
        
		 
	 
	

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				ArrayNStrings obj = new ArrayNStrings();
				//System.out.println(obj.checkUnique("HE ON8"));
				//System.out.println(obj.checkPermutation("HE 0N8", "8N0 EH"));
				//System.out.println(obj.checkPermutationOfPalindrome( "OHELLHELL"));
				//System.out.println(obj.isOneEditAway("PALA", "PAL"));
				//System.out.println(obj.countConsecutive("aabcccaaab"));
				//System.out.println(obj.countConsecutive("abcdefg"));
				
			}
	
		
		
		
		
}
	
	
	
	



