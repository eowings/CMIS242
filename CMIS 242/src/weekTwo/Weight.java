package weekTwo;
//////////////////////////////////////////////////////////
//File Name: Weight.java
//Author: Eddy Owings
//Date: 10/31/2020
//Description: A class that will allow data to be passed
//to it for recording weights.
//////////////////////////////////////////////////////////
public class Weight {
    private
    int pounds;
    double ounces;
    static final int OZPERPOUND = 16;
    
    //Constructor
    public Weight(int lbs, double oz) {            
        pounds = lbs;
        ounces = oz;
        normalize();
    }        
    // Public Method 1
    public boolean lessThan(Weight parameter) {
        parameter.normalize();
        if (pounds > parameter.pounds) {
            return false;            
        }
        if ((pounds == parameter.pounds) && (ounces > parameter.ounces)) {
            return false;            
        }
        return true;        
    }
    // Public Method 2    
    public void addTo(Weight parameter) {
        pounds += parameter.pounds;
        ounces += parameter.ounces;
        normalize();
    }
    // Public Method 3    
    public void divide(int divisor) {
        pounds = this.pounds/divisor;
        ounces = this.ounces/divisor;
        normalize();
    }
    // Public Method 4    
    public String toString() {
        return pounds + " lbs " + String.format("%.3f", ounces) + " oz";           
    }    
    // Private Method 1
    // I think this method should have been used in one of the other
    // methods within this class, yet I did not use it as I could not locate 
    // where it made sence to use it.
    private double toOunces() {
        double totalOz = pounds * OZPERPOUND + ounces;
        return totalOz;     
    }
    // Private Method 2    
    private void normalize() {        
        while (ounces >= OZPERPOUND) {
        pounds += 1;
        ounces = ounces -16;
        }
    }

}//End Weight
