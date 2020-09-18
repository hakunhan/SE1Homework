package tut1_2;

import utils.AttrRef;
import utils.DomainConstraint;

/**
 * @overview Car is a sub-class of Vehicle representing an automobile, motor
 *           car, or car is a wheeled motor vehicle used for transporting
 *           passengers, which also carries its own engine or motor.
 * @abstract_properties
 *    P_Vehicle /\ 
 *    min(weight)=1000 /\ max(weight)=2000 /\
 *    min(length)=1.5 /\ max(length)=3.5 /\
 *    max(seatingCapacity)=7 /\
 *    length(registrationNumber)=6
 * @author dmle
 */
public class Car extends Vehicle {

  private static final double MIN_WEIGHT = 1000;
  private static final double MAX_WEIGHT = 2000;
  private static final double MIN_LENGTH = 1.5;
  private static final double MAX_LENGTH = 3.5;
  private static final double MAX_SEATCAP = 7;

  // constructor methods
  /**
   * @effects <pre>
   *            if n, d, h, l, w, c are valid
   *              initialise this as Car:<n,d,h,l,w,c>
   *            else
   *              print error message
   *          </pre>
   */
  public Car(@AttrRef("name") String n, 
      @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l, 
      @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c, @AttrRef("registrationNumber") String r) {
    super(n, d, h, l, w, c, r);
  }

  /**
   * @effects <pre>
   *            if w is valid 
   *              return true 
   *            else 
   *              return false</pre>
   */
  @Override
  @DomainConstraint(type="Double",min=MIN_WEIGHT,max=MAX_WEIGHT,optional=false)
  protected boolean validateWeight(double w) {
      return w > MIN_WEIGHT && w < MAX_WEIGHT;
  }

  /**
   * @effects <pre>
   *     if l is valid
   *      return true
   *     else
   *      return false
   * </pre>
   */
  @Override
  @DomainConstraint(type="Double",min=MIN_LENGTH,max = MAX_LENGTH,optional = false)
  protected boolean validateLength(double l){
    return l > MIN_LENGTH && l < MAX_LENGTH;
  }

  /**
   * @effects <pre>
   *            if c is valid
   *              return true
   *            else
   *              return false</pre>
   */
  @Override
  @DomainConstraint(type="Integer",min=MAX_SEATCAP,optional=false)
  protected boolean validateSeatingCapacity(int c) {
    if (!(super.validateSeatingCapacity(c)))
      return false;

    if (c > MAX_SEATCAP)
      return false;
    else
      return true;
  }

  /**
   * @effect print message to the console information about the travelling i.e the type of vehicle,
   *         starting location and number of seats
   */
  @Override
  public void travel(String startPoint, String endPoint, int numberOfSeats){
    System.out.printf("This vehicle: \u25C7 (%s) is going from %s to %s, with number of seats are %d"
            , toString(), startPoint, endPoint, numberOfSeats);
  }

  /**
   * @effects <pre>
   *            if c is valid
   *              return true
   *            else
   *              return false</pre>
   */
  @Override
  @DomainConstraint(type="String",mutable=false,optional=false,length=6)
  protected boolean validateRegistrationNumber(String r) {
    if (super.validateRegistrationNumber(r) && r.length() <= 6)
      return true;
    else
      return false;
  }
}
