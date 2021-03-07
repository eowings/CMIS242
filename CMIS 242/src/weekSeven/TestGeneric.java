package weekSeven;

public class TestGeneric {
    
    public static void main(String args[]) {  
    Generic<Integer> genInt = new Generic<Integer>();    
    genInt.add(2);    
    System.out.println(genInt.get());
    }
} 