package junit4.templates;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @overview A test driver for ...
 */
public class Template2 {
  
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
  
  /**
   * @modifies System.out
   * @effects 
   *    initialise resources
   *    for each test case 
   *      run the unit with the test case
   *      if expected result is not the same as actual result
   *        throws AssertionError 
   *      else 
   *        displays result on the standard output
   *        
   * @testcases
   *  RANGE(s):
   *  
   *  TDS(s):
   */
  @Test
  public void exampleMethod() throws AssertionError {
    // initialise the test data sets 
    
    // initialise test results
    
    // run unit with each test case and check the results
  }
}
