package weekSix;

/*
*File:Demo.java
*Author: John Wood
*Date:20201126
* This is java program that demonstrate the implementation of both iterative
* and recursive method to generate a series:
*    4 + 8 + 12 + 16 + ... + 4n
*/

public class Demo {
 
   //Iterative Method
   public static int iterativeNthTerm(int n){
     
       int nthTerm = 0;
       // iterative over 1 to n
       for(int i=1; i<=n; i++){
           nthTerm = nthTerm + 2;
       }
     
       return nthTerm;
   }
 
   // Recursive Method
 
   public static int recursiveNthTerm(int n){
       return recursiveNthTermUtil(1, n); // this is helper method
   }
 
   public static int recursiveNthTermUtil(int index, int n){
       if(index == n)// base case
           return 2;
       return 2 + recursiveNthTermUtil(index+1, n);// calling recursively
   }
 
   public static void main(String[] args) {
     
       // Series: 4 + 8 + 12 + 16 + 20 + .....4n
     
       System.out.println("10th Term Iterative: "+iterativeNthTerm(300));
       System.out.println("10th Term recursive: "+recursiveNthTerm(300));
   }
}
