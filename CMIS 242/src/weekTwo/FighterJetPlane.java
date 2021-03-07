package weekTwo;

public class FighterJetPlane extends AirPlane {
    // FighterJetPlane has one field
    int munitionsCapacityPounds; 
    
    // FighterJetPlane has one constructor 
    public FighterJetPlane(int muns, int wing, int thrust, int pax, int range) {
        super(wing, thrust, pax, range);
        munitionsCapacityPounds = muns;
    }
    
    // FighterJetPlane has one method
    public String toString() {        
        return super.toString() + "Munitions Capacity: " + 
                                   munitionsCapacityPounds + " lbs\n";                
    }   
}