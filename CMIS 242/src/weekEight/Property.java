package weekEight;
//////////////////////////////////////////////////////////
//File Name: Property.java
//Author: Eddy Owings
//Date: 12/11/2020
//Description: A class that implements StateChangeable and
// gathers passed integers for database and sets default
// property status.
//////////////////////////////////////////////////////////
public class Property <T extends Enum<T>> implements StateChangeable<T> {
    // Variables
    private String propertyAddress;
    private int numberOfBedroom;
    private int squareFoot;
    private int price;
    private Status saleStatus;

    // Constructor
    public Property(String propAdd, int numBed, int sqFt, int pri) {
        propertyAddress = propAdd;
        numberOfBedroom = numBed;
        squareFoot = sqFt;
        price = pri;
        this.saleStatus = Status.FOR_SALE;
    }// End Constructor
    
    // changeState Method
    public void changeState(T inputStatus) {
        this.saleStatus = (Status)inputStatus;
    }
    
    // toString Method
    @Override
    public String toString() { 
        return new String("Property Address: " + propertyAddress + "\n" +
                "Number of Bedrooms: " + numberOfBedroom + "\n" +
                "Square Footage: " + squareFoot + "\n" +
                "Price: " + price + "\n" +
                "Status: " + saleStatus);
        
    }    
}// End Property