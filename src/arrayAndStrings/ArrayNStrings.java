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
		
		//1. using additional DS (SET)
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
	
		
		//without using DS
		
	
	
	
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
	
	
private String sortString(String s) {
		
		char[] arr = new char[s.length()];
				arr = s.toCharArray();
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
	
	
	
	



