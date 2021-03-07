package weekThree;

public class WeekThreeDiscussion {
    int a = 0;
    int b = 1;    
    public void method1() {
        System.out.println("1");
        System.out.println(b/a);     
     }

    public void method2() {        
        System.out.println("2");
        method1();              
    }
    
    //Stack starts with method3 and reads backwards to 1
    public void method3() {
        System.out.println("3");
        try {
            method2();
         } catch(ArithmeticException e) {
            System.out.println("Exception is caught");
         }    
    }    

    public static void main(String[] args) {        
        WeekThreeDiscussion exception = new WeekThreeDiscussion();
        System.out.println("Call stack order is:");       
        // Call the stack.
        exception.method3();
    }        
}
        
