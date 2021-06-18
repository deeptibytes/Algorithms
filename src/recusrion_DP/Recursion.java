package recusrion_DP;

public class Recursion {

	
	
	
public static long getFactorial(int n) {
		
		
		/*//first way
		if (n==1) {	//similar to for loop condition in the middle		
			return 1;
		}else {//
			return n * getFactorial(n-1);
		}*/
		
		
		//loop way 
		/*int n = 40;
		long factorial = n; 
		int counter = 0; 
		for(int i = 1; i < n-1 ; i++) {
			 factorial = factorial * (n-i); 
			 counter++;
			
		}*/
		
		//second way
		
		long factorial;
		if(n != 1) {
			factorial =  n * getFactorial(n-1);

		}else {
			factorial = 1;
		}
		
		return factorial;
	
		
	}
	
	
	
		  
		  
public static int bunnyEars2(int bunnies){
			
			  //Recursion
		if(bunnies == 0) {
			return 0;
		}else {
			
			if (bunnies % 2 == 0) {
				return 3 + bunnyEars2(bunnies-1);
			}else {
				return 2 + bunnyEars2(bunnies-1);
			}
			
			
		}
						  
				  //loop
				  
				 /* int ears=0;
				  for(int i =1; i<=bunnies; i++) {
					  if (bunnies % 2 == 0) {
						  ears = ears + 3;
					  }else {
							  ears = ears + 2;  
						  }
					  }
					  
				  return ears;*/

		    
		  }
		  
		  /*Given a non-negative int n, return the count of the occurrences of 7 as a digit, 
				  so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
				  while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).*/
	
		  
		  
		  
		  
public static int getSeven(int input) {///667787
			  
			  //loop
			 
			  /*int counter = 0;
			  while(input > 0) {
				  if(input % 10==7) {
					  counter++;
				  }
				  input = input/10;
				  
			  }
			  
			  return counter;*/
	
         //recursion
	
	    //int counter = 0;
        if (input == 0) {  //last case, similar to for condition     	
          	return 0;        	
        }else {
          	if(input % 10==7) {//the very first 
          		return 1 + getSeven(input/10);
          	}else {
          		return getSeven(input/10);
          	}
        	
         
        }  
	}

/*
 * 
Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.


countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0
 */
public static int findChar(String input) {
	//Loop
	/*int counter = 0; 
	int i  = 0; 
	while(i <  input.length()) {
		if(input.charAt(i)=='x') {
			counter++;
		}
		i++;
		
	}	
	return counter; 
	
	*/
	
	//recursion
	
	if(input.equals("")) {
		return 0;
		
	}
		
		
		if(input.charAt(( input.length())-1) == 'x') { //"xxrtyxsxxwXX
			return 1 + findChar(input.substring(0, (input.length()) - 1));
		}else{
			return findChar(input.substring(0, (input.length()) - 1));
		}
}


/*
 * Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".


changePi("xpix") → "x3.14x"
changePi("pipi") → "3.143.14"
changePi("pip") → "3.14p"
*/

public static String replacePi(String input) {
	
	//loop
	/*int i = 0;
	String output = "";
	while (i < input.length() ){
		if( i != input.length()-1 //i is not last index
				&& input.charAt(i)=='p' 
				&& input.charAt(i+1) == 'i') {
			i = i+2;
			output = output + "3.14";
		
		}else {
			output = output + input.charAt(i);
			i++;
		}
		
	}
	return output;*/
	
	//recursion 
	
	if (input.length() == 1 || input.equals("")) {
		return input;
	}
	
	if(input.charAt(0) =='p' && input.charAt(1) =='i') { //xpi
		
		return "3.14"+ replacePi(input.substring(2));
	}else {
		return input.charAt(0) + replacePi(input.substring(1));
	}
}

/*
 * 
Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. 
In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
 */
//first way
public static int count11(int[] arr, int index) {
	
	
	
	if(index > arr.length - 1) {//base case
		return 0;
	}
	
	if( arr[index] == 11) {
		return 1 + count11(arr, index+1);
	}else {
		return count11(arr, index+1);
	}
}

//Second way
public static int countEleven(int[] arr, int index) {
	
	
	if(index < 0)//base case
		return 0;
	
	
	if( arr[index] == 11) 
		return 1 + countEleven(arr, index - 1);
	else 
		return countEleven(arr, index - 1);
	

}

/*
 * Given a string, compute recursively a new string where identical chars that are adjacent in the original string are 
 * separated from each other by a "*".


pairStar("hello") → "hel*lo"
pairStar("xxyy") → "x*xy*y"
pairStar("aaaa") → "a*a*a*a"
 */
 
public static String pairStar(String input) {
	
	//base case
	if(input.length() < 2) {
		return input;
	}
	
	if( input.charAt(0) == input.charAt(1)) {
		return Character.toString(input.charAt(0)) +"*" + pairStar(input.substring(1));
		
	}else {
		
		return Character.toString(input.charAt(0))  + pairStar(input.substring(1));
		
	}
	
}

/*
 * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.


countAbc("abc") → 1
countAbc("abcxxabc") → 2
countAbc("abaxxaba") → 2
countAbc("xxabaxxabatt") → 2
 */

public static int countAbc(String input) {
	
	//base case
	if (input.length() < 3) {
		return 0;
	}
	
	if(input.substring(0, 3).equals("abc") || input.substring(0, 3).equals("aba")) {
		return 1 + countAbc(input.substring(2));//it should be 2 not 3!!!! to cover ababc. It has both aba and abc
	}else {
		return countAbc(input.substring(1));
	}
}




/*
 * Given a string and a non-empty substring sub, compute recursively the number of times that 
 * sub appears in the string, without the sub strings overlapping.


strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0
sub
subsub
xyzsub
zyz, x
su
 */

public static int countSub(String input, String sub) {
	
	int len = sub.length();
	if(input.length() < len ) return 0; 
	
	
	if(input.substring(0, len).equals(sub)) {
		return 1 + countSub(input.substring(len), sub);
	}
	return countSub(input.substring(1), sub);
}

/*
 * 
We have a number of bunnies and each bunny has two big floppy ears. 
We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).


 */

public static int countEars(int bunnies) {
	
	if(bunnies < 1) return 0;
	
	return 2 + countEars(bunnies - 1);
	
}

/*
 * The fibonacci sequence is a famous bit of mathematics, 
 * and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). 
 * Each subsequent value is the sum of the previous two values, 
 * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
 * Define a recursive fibonacci(n) method that returns the nth fibonacci number, 
 * with n=0 representing the start of the sequence.


fibonacci(0) → 0
fibonacci(1) → 1
fibonacci(2) → 1
 */

public static int findFibonacci(int num) {
	
	if(num == 0) return 0;
	if (num == 1)return 1;
	
	return findFibonacci(num - 1) + findFibonacci(num - 2);
	
	/*
	 * 5th = 4th + 3rd  5
	 * 4th = 3rd + 2nd  = 3
	 * 3rd = 2nd + 1st = 2
	 * 2nd = 0th + 1st = 1
	 */
	
}

/*
 * 
We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, 
the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the 
total number of blocks in such a triangle with the given number of rows.


triangle(0) → 0
triangle(1) → 1
triangle(2) → 3 (two rows)
triangle(3) → 6 (3 rows)
 */

public static int blocks(int rows) {
	
	if (rows < 1) return 0;
	
	return rows + blocks( rows - 1);
		
}


/*
 * 
Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, 
except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. 


count8(8) → 1
count8(818) → 2
count8(8818) → 4
88 -->3
788 --3
 */
public static int count8(int n) {
	
	if (n < 1) return 0;
	
	
	if (n  % 10 == 8  ) {
		if((n/10) % 10 == 8) 
			return 2 + count8(n/10);
		else return 1 + count8(n/10);
	}
	
	
	
	
	return count8(n/10);
	
	
}

/*
 * 
Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.


countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
 */
public static int countHi(String input) {
	
	
	if(input.length() < 2) return 0;
	
	if(input.substring(0, 2).equals("hi")){
		return 1 + countHi(input.substring(2));
		
	}
	
	return countHi(input.substring(1));
	
	
}

/*
 * Given a string, compute recursively the number of times lowercase "hi" appears in the string, 
 * however do not count "hi" that have an 'x' immedately before them.
countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0
xyxdfxhghi
xyhihi
xyhihihihx  3
xyhihihxhi  2
hixhi -->1
 */

public static int countHi2(String input) {
	
	int len = input.length();
	if(len < 2) return 0;
	
	if (input.substring(len - 2, len).equals("hi")) {
		if( len == 2 || (len > 2 && input.charAt(len - 3) != 'x') )
			return 1 + countHi2(input.substring(len - 1));
		
	}
	
	return countHi2(input.substring(len - 1));
	
}

/*
 * Given a string, compute recursively a new string where all the 'x' chars have been removed.


noX("xaxb") → "ab"
noX("abc") → "abc"
noX("xx") → ""
 */

public static String noX(String input) {
	
	if(input.equals("")) return ""; 
	
	if(input.charAt(0)== 'x') return "" + noX(input.substring(1));
	
	return input.substring(0, 1) + noX(input.substring(1));
	
}

/*
 * Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value 
 * times 10. We'll use the convention of considering only the part of the array that begins at the given index. 
 * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


array220([1, 2, 20], 0) → true
array220([3, 30], 0) → true
array220([3], 0) → false
 */

public static boolean array220(int[] nums, int index) {
	
	
	if(nums.length < 2) return false;
	
	
	if(index == nums.length -2 ) {
		if (nums [index+1] == nums [index] * 10 ) return true;
		else return false;
	}
	
	
	
	if (nums [index+1] == nums [index] * 10 ) return true;	
	return array220(nums, index+1);
		
}

/*
 * Given a string, compute recursively a new string where all the lowercase 'x' 
 * chars have been moved to the end of the string.


endX("xxre") → "rexx"
endX("xxhixx") → "hixxxx"
endX("xhixhix") → "hihixxx"
hixs  hisx
 */

public static String endX(String str) {
	
	if( str.equals("")) return "";
	
	if(str.charAt(0) == 'x') return endX(str.substring(1)) + "x";
	
	return  str.charAt(0) + endX(str.substring(1));
	
	  
}

/*
 * 
 */



public static void main(String[] args) {
			  
	//System.out.println(countHi2("hi"));
	//System.out.println(0.8%10);
	
	
				//System.out.println(getSeven(76877));
				//System.out.println(findChar("xxrtyxsxxwXX"));
				//System.out.println(129/10);
				String input = "";
				System.out.println("substring is** "+input.length());
				//System.out.println(input);
				//System.out.println(replacePi("pi"));
				int[] arr = {6};
				//System.out.println(count11(arr, 0));
				//System.out.println(countEleven(arr, arr.length-1));
				//System.out.println(pairStar("hll"));
				//System.out.println(countAbc("ababc"));
				

			}

}
