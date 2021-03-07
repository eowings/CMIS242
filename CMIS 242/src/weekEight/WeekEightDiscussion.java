package weekEight;

import java.util.*;

class WeekEightDiscussion {
    
    public static void main(String args[]) {
        
        //Example One 
        List<Character> arrayList = new ArrayList<>();   
        arrayList.add('A');  
        arrayList.add('B');    
        arrayList.add('C');    
        arrayList.add('D');    
    
        List<Character> linkedList = new LinkedList<>();    
        linkedList.add('A');  
        linkedList.add('B');    
        linkedList.add('C');    
        linkedList.add('D');    
    
        System.out.println("arraylist: " + arrayList);  
        System.out.println("linkedlist: " + linkedList + "\n\n");  
        
        //Example Two
        arrayList.remove(2);
        linkedList.remove(2);
        System.out.println("arraylist: " + arrayList);  
        System.out.println("linkedlist: " + linkedList + "\n\n"); 
        
        //Example Three
        arrayList.remove((Character)'B');
        linkedList.remove((Character)'B');        
        System.out.println("arraylist: " + arrayList); 
        System.out.println("linkedlist: " + linkedList);  
    }    
}
