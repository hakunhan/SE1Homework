package tut1_2;

import utils.AttrRef;
import utils.DomainConstraint;

/**
 * @overview Bus is a sub-class of Vehicle representing a bus (also omnibus or
 *           autobus), which is a road vehicle designed to carry passengers. Buses have
 *           a capacity as high as 300 passengers and are widely used for public
 *           transportation.
 * @abstract_properties
 *    P_Vehicle /\ 
 *    min(weight)=5000 /\ max(weight)=20000 /\
 *    min(length)=4 /\ max(length) = 10 /\
 *    min(seatingCapacity)=30 /\
 *    length(registrationNumber)=8
 * @author dmle
 */
public class Bus extends Vehicle {

  private static final double MIN_WEIGHT = 5000;
  private static final double MAX_WEIGHT = 20000;
  private static final double MIN_LENGTH = 4;
  private static final double MAX_LENGTH = 10;
  private static final double MIN_SEATCAP = 30;

  // constructor methods
  /**
   * @effects <pre>
   *            if n, d, h, l, w, c are valid
   *              initialise this as Bus:<n,d,h,l,w,c>
   *            else
   *              print error message
   *          </pre>
   */
  public Bus(@AttrRef("name") String n, 
      @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l, 
      @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c, @AttrRef("registrationNumber") String r) {
    super(n, d, h, l, w, c, r);
  }
  
  @Override  
  public String toString() {
    return "Bus(" + getName() + ")";
  }
  
  /**
   * @effects <pre>
   *   if w is valid 
   *     return true 
   *   else 
   *     return false</pre> 
   */
  @Override
  @DomainConstraint(type="Double",min=MIN_WEIGHT,max=MAX_WEIGHT,optional=false)
  protected boolean validateWeight(double w) {
    // not needed: super.validateWeight(w);
    
    if (w < MIN_WEIGHT || w > MAX_WEIGHT)
      return false;
    else // means: w >= MIN_WEIGHT -> w > 0
      return true;
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
  @DomainConstraint(type="Integer",min=MIN_SEATCAP,optional=false)
  protected boolean validateSeatingCapacity(int c) {
    if (c < MIN_SEATCAP)
      return false;
    else 
      return true;
  }

  /**
   * @effects <pre>
   *            if r is valid
   *              return true
   *            else
   *              return false</pre>
   */
  @Override
  @DomainConstraint(type="String",mutable = false,optional=false, length=8)
  protected boolean validateRegistrationNumber(String r) {
    if (super.validateRegistrationNumber(r) && r.length() <= 8)
      return false;
    else
      return true;
  }
}
