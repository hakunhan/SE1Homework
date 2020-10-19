package junit4.templates;


import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * @overview A test driver for ...
 */
public class Template3 {
  
  /** 
   * STATIC attributes for 
   * - each test data set, and 
   * - the expected results 
   * 
   * Use the actual data types instead of Object and replace X by the input 
   * parameter of the unit 
   */
  private static Object tdsX;
  
  // ... more tds here
  
  private static Object results;
  
  /**
   * @effects 
   *    initialise test data sets and test results
   *    
   * @testcases
   *  RANGE(s):
   *  
   *  TDS(s):
   */
  @BeforeClass
  public static void setUp() {
   // TODO
  }
  
  /**
   * @effects 
   *    delete test data sets and test results
   */
  @AfterClass
  public static void tearDown() {
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
