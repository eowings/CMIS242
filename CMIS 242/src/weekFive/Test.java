package weekFive;

/*
* File: Discussion5.java
* Author: Jonathan Marsh
* Date: 11/21/2020
* Instructor: Elsaghir, Hesham
* Class: CMIS 242
* Assignment: week 5 discussion
* Purpose: simple interface example
 */
import java.util.*;

  interface Vehicle {
        int Cost();
        void Print();
        
    }

public class Test {
    

    public static void main(String[] args) {
        
        Vehicle vicOne = new MotorCycle(2,17500);
        Vehicle vic2 = new Truck(4);
        
       System.out.println("Motorcyle without Cost() method called") ;
       vicOne.Print();
       System.out.println("\nMotorcyle after Cost() method called") ;
       vicOne.Cost();
       vicOne.Print();
       
       System.out.println("\nTruck called with Cost() in constructor") ;
       vic2.Print();
       
       
        
    }
    
}
 
class MotorCycle implements Vehicle {
        int cost;
        int tires;

    MotorCycle(int tire,int stickerPrice){
     tires = tire;
     cost = stickerPrice;  
    }
    
        @Override
    public void Print(){
       System.out.println("A MotorCycle with "+tires+" Tires at a cost of $"+cost+" was created.");
    }
    
        @Override
    public int Cost(){
      cost += 100;  
      return cost;
    }
}//motorcycle
class Truck implements Vehicle {
        int cost;
        int tires;

    Truck(int tire){
     tires = tire; 
     this.Cost();
    }
    
        @Override
    public void Print(){
       System.out.println("A MotorCycle with "+tires+" Tires at a cost of $"+cost+" was created.");
    }
    
        @Override
    public int Cost(){
      Random n = new Random();
      cost = 1000*(n.nextInt(50)+25);
      return cost;
    }
}//motorcycle