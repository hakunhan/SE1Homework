package junit4.templates;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @overview A test driver for ...
 * 
 * @testcases
 *  RANGE(s):
 *  
 *  TDS(s):
 * 
 */
public class Template4 {
  
  /** 
   * attributes for 
   * - each test data set, and 
   * - the expected results 
   * 
   * Use the actual data types instead of Object and replace X by the input 
   * parameter of the unit 
   */
  private Object tdsX;
  
  // ... more tds here
  
  private Object results;
  
  // constructor method
  /**
   * @effects 
   *    initialise test data sets and test results
   */
  public Template4() {
   // TODO        
  }
  
  /**
   * @modifies System.out
   * @effects 
   *    for each test case 
   *      run the unit with the test case
   *      if expected result is not the same as actual result
   *        throws AssertionError 
   *      else 
   *        displays result on the standard output
   */
  @Test
  public void exampleMethod() throws AssertionError {    
    // run unit with each test case and check the results
  }
}
