package weekFour;
//////////////////////////////////////////////////////////
//File Name: Automobile.java
//Author: Eddy Owings
//Date: 11/14/2020
//Description: A class that builds an automobile object
// this class has two subclasses that both extend the
// super class.
//////////////////////////////////////////////////////////
public class Automobile {
    private
    String makeAndModel;
    int purchasePrice;
    
    // 1. A constructor that allows the make and purchase price to be initialized.
    public Automobile (String mkNMod, int price) {
        makeAndModel = mkNMod;
        purchasePrice = price;
    }
    // 2. A method named salesTax that returns the base sales tax computed as 5% of the sales price.
    public double salesTax() {
        double tax = 0.05;
        double taxCalculated = tax * purchasePrice;
        return taxCalculated;
    }
    // 3. A toString method that returns a string containing the make and model of the automobile, the sales price, and the sales tax, appropriately labeled.   
    public String toString() {
        double tax = salesTax();
        return "\nMake and Model: " + makeAndModel + "\n" +
                "Sale Price: " + purchasePrice + "\n" +
                "Sales Tax: " + tax + "\n";                
    }     
}

//Electric subclass
class Electric extends Automobile {
    private int weightInPounds;
    
    // 1. A constructor that allows the automobile’s make and model, purchase price and weight to be initialized.
    public Electric(int wt, String mkNMod, int price) {
        super(mkNMod, price);
        weightInPounds = wt;
    }
    
    // 2. An overridden method salesTax that returns the total sales tax. The sales tax for an electric automobile consists of the base sales tax of 5% that applies to all automobiles minus a discount. If the weight is less than 3000 pounds the discount is $200. Otherwise it is $150.
    @Override
    public double salesTax() {
        int discount = 0;
        double tax = 0.05;
        double taxCalculated = tax * purchasePrice;
        if (weightInPounds < 3000) {
            discount = 200;
        } else {
            discount = 150;
        }
        double taxAfterDiscount = taxCalculated - discount;
        return taxAfterDiscount;
    } 
    
    // 3. An overridden toString method that returns a string containing the make and model of the automobile, the sales price, sales tax and the weight, appropriately labeled.
    @Override
    public String toString() {
        return super.toString() + "Electric Vehicle\nWeight: " + weightInPounds + "\n";                
    }    
}

//Hybrid subclass
class Hybrid extends Automobile {
    private int milesPerGallon;
    
    // 1. A constructor that allows the automobile’s make and model, purchase price and miles per gallon to be initialized.
    public Hybrid(int mpg, String mkNMod, int price) {
        super(mkNMod, price);
        milesPerGallon = mpg;
    } 
    
    // 2. An overridden method salesTax that returns the total sales tax The sales tax for a hybrid automobile consists of the base sales tax of 5% minus a discount. If the number of miles per gallon is less than 40, the discount is $100. Otherwise there is an additional discount of $2 for every mile per gallon in excess of 40.
    @Override
    public double salesTax() {
        int discount = 0;
        double tax = 0.05;
        double taxCalculated = tax * purchasePrice;
        if (milesPerGallon < 40) {
            discount = 100;
        } else {
            discount = (milesPerGallon - 40) * 2 + 100;
        }
        double taxAfterDiscount = taxCalculated - discount;
        return taxAfterDiscount;
    } 
    
    // 3. An overridden toString method that returns a string containing the make and model of the automobile, the sales price, sales tax and the number of miles per gallon, appropriately labeled.
    @Override
    public String toString() {
        return super.toString() + "Hybrid Vehicle\nMiles Per Gallon: " + milesPerGallon + "\n";                
    }        
}