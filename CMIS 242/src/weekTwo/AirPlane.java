package weekTwo;

public class AirPlane {
    // AirPlane class has four fields 
    private
    int wingSpanFeet;
    int engineThrustPounds;
    int maxPassengerCapacity;
    int rangeNauticalMiles;
    
    // AirPlane has one constructor
    public AirPlane(int wing, int thrust, int pax, int range) {
        wingSpanFeet = wing;
        engineThrustPounds = thrust;
        maxPassengerCapacity = pax;
        rangeNauticalMiles = range;
    }
        
    // AirPlane has one method   
    public String toString() {
        return "WingSpan: " + wingSpanFeet + " ft\n" +
               "Engine Thrust: " + engineThrustPounds + " lbs\n" +
               "Maximum Passsengers: " + maxPassengerCapacity + " persons\n" +
               "Range: " + rangeNauticalMiles + " nautical miles\n";                
    }
}