package weekSix;
//////////////////////////////////////////////////////////
//File Name: OutsideBounds.java
//Author: Eddy Owings
//Date: 11/28/2020
//Description: Defines a checked exception.
//////////////////////////////////////////////////////////
public class OutsideBounds extends Exception {
    
    public OutsideBounds(String errorMessage) {
        super(errorMessage);
    } 
}// End Class