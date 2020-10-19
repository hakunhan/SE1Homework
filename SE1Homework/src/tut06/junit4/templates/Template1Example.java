package junit4.templates;

import org.junit.Test;

/**
 * @overview A test driver for procedure search.
 */
public class Template1Example {
  
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
   * RANGE(s):
   *  a: {null}, {[]} + {[x 1 ,...,x n ] | x i are integers}
   *  
   *  x: {y | y in a} + {y | y not in a}
   *  
   * TDS(s):
   *   tdsX = {1,2}
   *   tdsA = {  null,        //a0
   *             [],          //a1
   *             [1],         //a2
   *             [3,1],       //a3
   *             [3,1,4],     //a4
   *             [3,5,1,4]    //a5
   *           }
   */
  @Test
  public void searchMethod() throws AssertionError {
    // initialise the test data sets
    
    
    // initialise test results
    
    // run unit with each test case and check the results
  }
}
