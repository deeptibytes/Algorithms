package misc;

import java.util.HashMap;
import java.util.LinkedList;

class ListNode{

String city;//value
int zipCode ;//key

public ListNode(int zipCode, String city){
  this.zipCode = zipCode;
  this.city = city;
}


}


/*
 * 
 * Head of LL (very last element added) = MRU
 * Tail of LL (very first element added) = LRU
 * in LRU implementation, elements are always added to head by using insertFirst method. Removal of nodes is always done from tail.
*/
public class LRUCache {

HashMap<Integer, ListNode> map;
LinkedList<ListNode> nodeLinkList = null;
int currSize;
int maxSize;

public LRUCache(int size){

  this.maxSize = size;
  map = new HashMap<Integer, ListNode>(size);
  nodeLinkList = new LinkedList<ListNode>();
}

public ListNode get(int zipCode, String DBValue){
  
  
  ListNode node = null; 
  
  if(! map.containsKey(zipCode)){//cache does not have value that is asked
  
   if(currSize == maxSize){//size is full, so delete tail element to make space so newly fetched value from DB can be put in cache 
       node = nodeLinkList.removeLast(); 
       map.remove(node.zipCode);
       currSize--;
     }
   
     String city = DBValue;//mock fetching of value from DB
     node = new ListNode(zipCode, city);
     nodeLinkList.push(node);//push on the front
     map.put(zipCode, node);//push the key in map
     currSize++;
     
  }else{//no need to create space, just put it on the front
     
     node = map.get(zipCode);
     nodeLinkList.remove(node);//remove the node
     nodeLinkList.push(node);  //push it on the front     
  }
  
  return node;

}

public void put(int zipCode, String city){//this method is to populate the list initially for testing purpose
   
   ListNode node = new ListNode(zipCode, city);
   nodeLinkList.add(node);
   map.put(zipCode, node);
   currSize++;
    
}


public static void main(String[] args){

 LRUCache obj  = new LRUCache(4);
 obj.put(123, "Fremont");
 obj.put(122, "Union City");
 obj.put(125, "Alameda");
 obj.put(234, "Abc");
 //obj.put(612, "bce");
 
 obj.get(525,  "DBCity");
 
}


}
