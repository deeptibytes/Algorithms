package misc;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) 
    { 
        SortedSet<String> ts 
            = new TreeSet<String>(); //sortedSet is Interface
            
            /*Tree set does NOT Maintain the insertion order of elements. Duplicate values are considered as if they were never added to the set
              No matter what was the order of elements while adding, they were added internally in an ascending order. This is contrast to arrayList
              where values are added in the order of adding.
             */
  
        // Elements are added using add() method 
        ts.add("C"); 
        ts.add("B"); 
        ts.add("C"); 
        ts.add("A"); 
  
        System.out.println("Sorted Set is " + ts); //[A, B, C]
        //When we print the set, it prints them in the ascending order. If it were a normal set, it will be printed as B  C A
        //If we iterate the treeset, same result we will get
        String check = "D"; 
  
        // Check if the above string exists in 
        // the SortedSet or not 
        System.out.println("Contains " + check 
                           + " " + ts.contains(check)); 
  
        // Print the first element in 
        // the SortedSet 
        System.out.println("First Value " + ts.first()); //it is not the first value added, it is the first value after ordering elements of a treeset
  
        // Print the last element in 
        // the SortedSet 
        System.out.println("Last Value " + ts.last()); //It will be C //it wont be A because treeset ignores duplicate values.
    } 
} 

