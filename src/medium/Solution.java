package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {


/*
 * Rotate image by 90 degrees
 * https://www.gyanblog.com/coding-interview/leetcode-solution-rotate-image/
 */
  public void rotate(int[][] matrix) {
        
       int rowCt = matrix.length;
       int layers = rowCt/2;//they are always n/2
        
        for(int iLayer = 0; iLayer < layers ; iLayer++ ){
            
             for(int j = iLayer; j < rowCt-1 - iLayer; j++){ //pay attention why we did j < rowCt-1 - iLayer
                 
                 int temp = matrix[iLayer][j];
                 
                 //put (2, 0) in (0,0) place. We already saved (0,0) value in temp
                 
                 matrix[iLayer][j] = matrix[rowCt - 1 - j][iLayer];
                 matrix[rowCt - 1 - j][iLayer] = matrix[rowCt - 1 - iLayer][rowCt - 1 - j];
                 matrix[rowCt - 1 - iLayer][rowCt - 1 - j] = matrix[j][rowCt - 1 - iLayer];
                 matrix[j][rowCt - 1 - iLayer] = temp;
                 
             }
        }
        
     } 

/*
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *      
 * /
 
  
  
  
  
  



/*
 * Longest palindromic substring
 */
 
 
 /*
  * 3 sum
  * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
  */
  
  public List<Integer> get3Sum(int[] arr, int target){ //O(N square)
  
    //sort
    Arrays.sort(arr);
    int j ;
    int k;
    List<Integer> list = ArrayList<Integer>();
  
    for(int i = 0; i < arr.length - 2 ; i++){ //why we did -2 ???we want to run the loop only till last 3rd
     int comp = target - arr[i];
     j = i + 1;
     k = arr.length - 1;
     
     while(j < k){
	     if(arr[j] + arr[k] == comp){
	        list.add(arr[i]); list.add(arr[j]);  list.add(arr[k]); 
	        return list;
	     }else if( arr[j] + arr[k] < comp){
	        j++;
	     }else{ //arr[j] + arr[k] > comp
	       k--;
	     }    
     }
     
  
    }
    
    return list;
  
  }
  
  
   /*
  * Valid Sudoku
  */
  
  
   /*
  * Maximum Subarray
  */
  
   /*
  * House Robber
  */
  
   /*
  * Climbing STairs
  */


/*
 * Roman to Integer
 * https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 */
 int getIntFromRoman(char roman){
    
        if (roman == 'I')
            return 1;
        if (roman == 'V')
            return 5;
        if (roman == 'X')
            return 10;
        if (roman == 'L')
            return 50;
        if (roman == 'C')
            return 100;
        if (roman == 'D')
            return 500;
        if (roman == 'M')
            return 1000;
        return -1;
   }
   
 public int convert( String roman){
 
    
         if(roman.length() == 1){
           return getIntFromRoman(roman.charAt(0));
        }
   
   int result = 0;
   
   for(int i = 0 ; i < roman.length(); i++){
       
       int current = getIntFromRoman(roman.charAt(i));
      
 
      if(i != roman.length() -1 && current < getIntFromRoman(roman.charAt(i + 1))){
        result = result + getIntFromRoman(roman.charAt(i + 1)) - current;
        i++;
      }else{
      
        result = result + current;
      }    
    }
   return result;
 } 
/*
 * Valid Parenthesis
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
 public static boolean isOpening(char x){
 
  if(x == '(' ||
     x == '{' ||
     x == '[' ){
    
    return true; 
  }
  
  return false;  
 
 
 }
 
 public static boolean isClosing(char x){
 
  if(x == ')' ||
     x == '}' ||
     x == ']' ){
    
    return true; 
  }
  
  return false;  
 
 
 }
 
 public static boolean isValidClosing(char open, char close){
 
  if(    ( close == ')' && open == '(' )
      || (close == '}' && open == '{'  )
      || (close == ']' && open == '['  ) ){
      
      return true;
  }
   return false;
 
 }
 
 
 public static boolean isValid(){
  String input = "[{}{}]()";
  Stack<Character> stack = new Stack<Character>();
  
  for(int i = 0; i < input.length() ; i++){
  
     if( isOpening(input.charAt(i)  )){
       stack.push(input.charAt(i));
       
     }else if( isClosing(input.charAt(i)  )){
       if(stack.isEmpty()) 
          return false;//it cant be empty at this point.Empty means no oepning bracket is present
         
       char opening = stack.pop();       
       if( ! isValidClosing(opening, input.charAt(i) )){
         return false;
       }
     }
  
  }
  
  return stack.isEmpty();
 
 
 
 }
 
 /*
  * Meeting Rooms 
  */
  
  /*
   * Basic Calculator
   */ 


 
 /*
   * Validate string is xml
   * input
   * <html>
   *  <head>hello</head>
   *  <eBay>value</ebay>
   * </html>
   * 
   * Testing
   * String input = "<html><head>hello</head><eBay>value</eBay></html>";
 boolean result = validateXML(input);
 System.out.println(result);
   * 
   */
 public static boolean validateXML( String input){
   
      int len = input.length();
   
     //Base Condition
     if(input.charAt(0) != '<') return false;
     if(input.charAt(len - 1) != '>') return false;
     
     Stack<String> stack = new Stack<String>();
     int j = 0;//.what is the purpose of J here??? 
     int index;
     String element = "";
     
     for(int i = 0; i < len ; i++){
     
      if(input.charAt(i) == '<' && input.charAt(i +1) == '/'){
        index = getEndIndex(i, input);
        element = input.substring(i + 2, index);
        String poppedEle = stack.pop();
        if( !poppedEle.equals(element) ){
           return false;
        }
        i = index;
        j = index;
        
       }
     
      else if(input.charAt(i) == '<'){
        index = getEndIndex(i, input);
        element = input.substring(i + 1, index );
        stack.add(element);
        i = index;
        j = index;
      
       }
      
    }
    
   return stack.isEmpty();
   
}
  public static int getEndIndex(int start, String input){
   
     while( input.charAt(start) != '>'){
   
       start++;
     }
     return start;
  }
  
  
  /*
   * Validate string is xml -- end
   /*
    * 
    * 
    * 
    * Median of two sorted arays
    * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
    *  /
    *  
public 



 /*
   * Spiral Matrix
   * https://www.techiedelight.com/print-matrix-spiral-order/
   */
   
   
   /*
    * Partition Labels
    * /*
 * Partition Labels
 * A string S of lowercase English letters is given. We want to partition this string into as many parts
 *  as possible so that each letter appears in at most one part, and return a list of integers representing 
 *  the size of these parts.


 */
    
    
    /*
     * Position of Large Groups
     */
  
  /*
   *  Generate Parenthesis
   */ 
   
   public static List<String> generateParen(int pairs){
   
    List<String> list = new ArrayList<String>();
    generateParen(list, "", 0, 0, pairs);
    return list;
   
   }
   
   public static void generateParen(List<String> list, String seq, int opening, int closing, int pairs){
   
     if(seq.length() == pairs * 2){
       list.add(seq);
       return;
     }
     
     if(opening < pairs){
       generateParen(list, seq + "(" , opening + 1 , closing, pairs);
     }
     
      if( closing < opening) {
       generateParen(list, seq + ")" , opening , closing + 1, pairs);
      }
   
   
   }

   /*
    * Word Search
    */
/*
 * Prettify String
 * String input = "{id:0001,type:donut,name:Cake,ppu:0.55,embed:{id=2,address=xyz,street=culver}, key:value}";
  String out = prettyfy(input, " ", "");
  System.out.println(out);
 */

/*public static String prettyfyBasic(String input){

  String[] tokens = input.split(",");
  
  StringBuilder sb = new StringBuilder();
  
  String newLine = "\n";
  String indent = "    ";
  
  for(int i = 0; i < tokens.length ; i++){
    String token = tokens[i];
    
    if(i == 0){
      token = token.substring(1);//removing first {
    }else if(i == tokens.length -1){
      token = token.substring(0, token.length() - 1);//removing last }
    }
   
    if(token.contains("{"){
     int j = i + 1;
     String value = token.substring(token.indexOf("{") ) + ",";
      while( !token[j].contains("}"){
        value = value + token[j] + ","
        j++;
         
      }       
       value = value + token[j].substring(0, token[j].indexOf("}"))
    }
    
    
    
    String comma = (i==tokens.length -1) ? "" : ",";
    
    sb.append(indent + token +  comma + newLine );
  }
  
  String output = "{" + newLine + sb.toString() + newLine + "}";
  
  System.out.println(output);
  
  return output;
  

}*/


public static String prettyfy(String input, String indent, String endIndent){

  String newLine = "\n";

  String comma = ",";
  
  StringBuilder sb = new StringBuilder();
  sb.append("{" + newLine + indent);
  int j = 1;
  String  value = "";

  for(int i = 1; i < input.length() ; i++){
    
   if(input.charAt(i) == ','){
   
    value = input.substring(j, i + 1);
    sb.append(value + newLine + indent);
    j = i + 1;
       
   }
   
   else if(input.charAt(i) == '{'){
   
	 
	    value = input.substring(j, i);
	    sb.append(value + newLine + indent);
	    int endIndex = endIndex( i, input );
	  
	    String embedded = input.substring(i, endIndex + 1);
	 
	    String formatted = prettyfy(embedded, "  ", " ");//recursive call
	    sb.append(formatted + newLine + indent);
	    i = endIndex+ 1 ;
	    j = endIndex + 2;
    
   }
   
   else  if(input.charAt(i) == '}'){
    
     value = input.substring(j, i);
     sb.append(value );
    
    }
  
  
  }
  
  sb.append(newLine + endIndent+ "}");
 
  return sb.toString();

 


}

public static int endIndex(int index, String input){
  int i = index;
  while(  input.charAt(i) != '}'){
       i++; 
  }
 return i;
}

/*
 * Prettify String End
 */

public static void main(String[] args){

 List<String> list = generateParen(2);
 System.out.println(list);
  
  }  
 
    
     
   
  
  


}


