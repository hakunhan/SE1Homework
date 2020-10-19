package tut06.junit4;

import org.junit.Test;

import tut06.Num;

/**
 * @overview A test driver to test Num.add method. 
 */
public class AddTest {
  
  /**
   * @modifies System.out
   * 
   * @effects 
   *  for each test case tc = <x,y,r>
   *    if Num.add(x,y) != r
   *      throws AssertionError
   *    else
   *      display the result on standard output.
   *  
   * @testcases
   *  RANGES
   *    x: (-INF,+INF)
   *    y: (-INF,+INF)
   *    
   *  TDSes
   *    x: {-1000000000,-105, -2.6, 0, 2.5 , 2.6, 100, 1000000001.5}
   *    y: {-1000000000, 2.5,    0, 0, 2.6 , 100, -2.6, 100}
   *    
   *  Results:
   *    {-2000000000, -102.5, -2.6, 0, 5.1, 102.6, 97.4, 1000000101.5}
   */
  @Test
  public void testAdd() throws AssertionError {
    double[] tcXs = {-1000000000,-105, -2.6, 0, 2.5 , 2.6, 100, 1000000001.5};
    double[] tcYs = {-1000000000, 2.5,    0, 0, 2.6 , 100, -2.6, 100};
    double[] tcRs = {-2000000000, -102.5, -2.6, 0, 5.1, 102.6, 97.4, 1000000101.5};
    
    for (int i = 0; i < tcXs.length; i++) {
      double x = tcXs[i];
      // for (int j = 0; j < tcYs.length; j++) {
      double y = tcYs[i];
      double r = tcRs[i];
      
      double result = Num.add(x, y);
      
      assert (result == r) : "invalid result: ("+x+","+y+") -> " + result + " (expected result: " + r+ ")";
      
      System.out.printf("Num.add(%f,%f)=%f%n", x, y, result);
      
    }
  }
}
