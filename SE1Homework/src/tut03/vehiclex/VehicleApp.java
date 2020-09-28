package lect01_2_ch7.vehicles;

/**
 * @overview A test application for vehicles.
 * 
 * @author dmle
 */
public class VehicleApp {
    public static void main(String[] args) {
        // create objects
        Vehicle v1 = new Bus("b1",3.0,3.0,10.0,6000,40);
        Vehicle v2 = new Car("c1",1.5,1.5,2.5,1500,4);
        // use objects
        System.out.println("Vehicle " + v1.getName() + 
            ", weight: " + v1.calcTotalWeight());
        System.out.println("Vehicle " + v2.getName() + 
            ", weight: " + v2.calcTotalWeight());
    }
}
