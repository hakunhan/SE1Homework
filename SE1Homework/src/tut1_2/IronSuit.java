package tut1_2;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

/**
 * @overview type of vehicle that use by Mr.Stark aka IronMan
 * @attribute
 * energyCapacity Double (kWh)
 * structure String
 * flightSpeed Double (km/h)
 * @abstract_properties
 * P_Vehicle /\
 * max(seatingCapacity) = 1 /\
 * mutable(energyCapacity) = true /\ optional(energyCapacity) = false /\ min(energyCapacity) = 10000 /\
 * mutable(structure) = false /\ optional(structure) = false /\ length(structure) = 100 /\
 * mutable(flightSpeed) = true /\ optional(flightSpeed) = false /\ min(flightSpeed) = 880
 */
public class IronSuit extends Vehicle{
    @DomainConstraint(type = "Double", min = 10000)
    private double energyCapacity;
    @DomainConstraint(type = "String", length = 100)
    private String structure;
    @DomainConstraint(type = "Double", min = 880)
    private double flightSpeed;

    /**
     * @effects <pre>
     *            if seatCapacity is valid
     *              return true
     *            else
     *              return false</pre>
     */
    @Override
    @DomainConstraint(type = "Double", max = 1, optional = false)
    protected boolean validateSeatingCapacity(int seatCapacity){
        return super.validateSeatingCapacity(seatCapacity) && seatCapacity <= 1;
    }

    /**
     * @effects <pre>
     *            if energyCapacity is valid
     *              return true
     *            else
     *              return false</pre>
     */
    @DomainConstraint(type = "Double",mutable = true, optional = false, min = 10000)
    private boolean validateEnergyCapacity(double energyCapacity){
        return energyCapacity >= 10000;
    }

    /**
     * @effects <pre>
     *            if structure is valid
     *              return true
     *            else
     *              return false</pre>
     */
    @DomainConstraint(type = "String",mutable = false, optional = false, length = 100)
    private boolean validateStructure(String structure){
        return structure != null && structure.length() > 0 && structure.length() <= 100;
    }

    /**
     * @effects <pre>
     *            if flight speed is valid
     *              return true
     *            else
     *              return false</pre>
     */
    @DomainConstraint(type = "Double",mutable = true, optional = false, min = 800)
    private boolean validateFlightSpeed(double flightSpeed){
        return flightSpeed >= 800;
    }

    public IronSuit(@AttrRef("name") String n,
                    @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l,
                    @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c, @AttrRef("registrationNumber") String r,
                    @AttrRef("energyCapacity") double energyCapacity, @AttrRef("structure") String structure,
                    @AttrRef("flightSpeed") double flightSpeed){
        super(n,d,h,l,w,c,r);

        if(validateEnergyCapacity(energyCapacity) && validateStructure(structure) && validateFlightSpeed(flightSpeed)){
            this.energyCapacity = energyCapacity;
            this.structure = structure;
            this.flightSpeed = flightSpeed;
        }else{
            System.err.println("IronSuit<init>: invalid arguments");
        }
    }

    /**
     * @effects return <tt>this.energyCapacity</tt>
     */
    public double getEnergyCapacity() {
        return energyCapacity;
    }
    /**
     * @effects return <tt>this.structure</tt>
     */
    public String getStructure() {
        return structure;
    }

    /**
     * @effects return <tt>this.flightSpeed</tt>
     */
    public double getFlightSpeed() {
        return flightSpeed;
    }

    /**
     * @effects <pre>
     *            if energyCapacity is valid
     *              return true
     *            else
     *              return false</pre>
     */
    public void setEnergyCapacity(double energyCapacity) {
        if(validateEnergyCapacity(energyCapacity))
            this.energyCapacity = energyCapacity;
    }

    /**
     * @effects <pre>
     *            if structure is valid
     *              return true
     *            else
     *              return false</pre>
     */
    public void setStructure(String structure) {
        if(validateStructure(structure))
            this.structure = structure;
    }

    /**
     * @effects <pre>
     *            if flightSpeed is valid
     *              return true
     *            else
     *              return false</pre>
     */
    public void setFlightSpeed(double flightSpeed) {
        if(validateFlightSpeed(flightSpeed))
            this.flightSpeed = flightSpeed;
    }

    /**
     * @require <pre>
     *      startPoint not eq null /\ startPoint.length() > 0
     *      endPoint not eq null /\ endPoint.length() > 0
     *      distance > 0
     * </pre>
     * @effects <pre>
     *          print to the console information of the flying facts i.e start point, end point and
     *          the distance between two point
     * </pre>
     */
    public void fly(String startPoint, String endPoint, double distance){
        if(startPoint == null || startPoint.length() == 0){
            System.err.println("Can not find start point");
            return;
        }
        if(endPoint == null || endPoint.length() == 0){
            System.err.println("Can not find where to land");
            return;
        }
        if(distance == 0){
            System.out.println("We have reached the destination!");
            return;
        }

        System.out.printf("We will start at %s and end at %s. The distance between the two is %f kilometers",
                           startPoint, endPoint, distance);

        int travelTime = (int) (distance / flightSpeed);

        System.out.print("Travelling");

        if(travelTime == 0){
            try{
                Thread.sleep(100);

                System.out.print("...");
                System.out.println("We have reached the destination!");
                return;

            }catch(InterruptedException e){

            }
        }


        for(int i = 0; i < travelTime; i++){
            try{
                Thread.sleep(500);
                System.out.print(".");
            }catch(InterruptedException e){

            }
        }

        System.out.println("We have reached the destination!");
    }

    /**
     * @effects <pre>
     *            if this satisfies rep invariant
     *              return true
     *            else
     *              return false</pre>
     */
    @Override
    public boolean repOK(){
        return super.repOK() && validateEnergyCapacity(energyCapacity) && validateStructure(structure) &&
                validateFlightSpeed(flightSpeed);
    }
}
