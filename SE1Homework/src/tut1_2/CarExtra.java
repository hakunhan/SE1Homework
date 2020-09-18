package tut1_2;

import utils.AttrRef;
import utils.DomainConstraint;


/**
 * @overview Car is a sub-class of Vehicle representing an automobile, motor
 *           car, or car is a wheeled motor vehicle used for transporting
 *           passengers, which also carries its own engine or motor.
 * @attributes
 *  owner String
 * @abstract_properties
 *    P_Vehicle /\ 
 *    max(weight)=2000 /\
 *    max(seatingCapacity)=7 /\ 
 *    mutable(owner)=true /\ optional(owner)=true /\
 *    length(owner) = 255
 * @author dmle
 */
public class CarExtra extends Vehicle {
  private static final double MAX_WEIGHT = 2000;
  private static final double MAX_SEATCAP = 7;
  
  @DomainConstraint(type="String", length = 255)
  private String owner;
  
  // constructor methods
  /**
   * @effects <pre>
   *            if n, d, h, l, w, c are valid
   *              initialise this as Car:<n,d,h,l,w,c>
   *            else
   *              print error message
   *          </pre>
   */
  public CarExtra(@AttrRef("name") String n,
      @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l, 
      @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c, @AttrRef("registrationNumber") String r) {
    super(n, d, h, l, w, c, r);
  }

  /**
   * @effects 
   *  return this.owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * @effects 
   *  if owner is valid
   *    set this.owner=owner
   *  else
   *    print error message
   */
  public void setOwner(String owner) {
    if (validateOwner(owner)) {
      this.owner = owner;
    } else {
      System.err.println("Car.setOwner: owner is not valid " + owner);
    }
  }

  @Override
  public boolean repOK() {
    // validate other attributes first
    if (super.repOK()) {
      // validate owner
      return validateOwner(owner);
    } else {
      return false;
    }
  }
  
  @Override
  public String toString() {
    return "Car(" + getName() + ")";
  }

  /**
   * @effects <pre>
   *            if w is valid 
   *              return true 
   *            else 
   *              return false</pre>
   */
  @Override
  @DomainConstraint(type="Double",min=MAX_WEIGHT,optional=false)
  protected boolean validateWeight(double w) {
    if (!(super.validateWeight(w)))
      return false;

    if (w > MAX_WEIGHT)
      return false;
    else
      return true;
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
   * @effects 
   *  if owner is valid
   *    return true
   *  else
   *    return false
   */
  private boolean validateOwner(String owner) {
    if (owner != null || owner.length() == 0 || owner.length() > 255) {
      return false;
    } else {
      return true;
    }
  }
}
