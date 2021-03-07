package weekTwo;

public class TestAirPlane {
    public static void main(String[] args) {
        AirPlane boeing747 = new AirPlane(211, 226607, 366, 8357);
        FighterJetPlane f16A = new FighterJetPlane(4500, 33, 27000, 1, 2622);
        
        System.out.println("Boeing 747: \n" + boeing747.toString());
        System.out.println("F16A: \n" + f16A.toString());
    }   
}
