package junit4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tut06.Num;

/**
 * @overview A test driver for the <tt>Num.sqrt</tt> method.
 */
public class SquareRootTest4 {

  private float[] tcEps;
  
  private float[] tcX;
  
  private float[] results;
  
  public SquareRootTest4() {
    // test cases
    tcEps = new float[] {
        0.00002f, 
        0.0001f, //
        0.009f //
        };

    tcX = new float[] { 
        0f, 0.001f, 0.01f, 0.09f, 0.5f, 1f, 2f, 
        10f, // 
        100f, // 
        2147483600f
        }; 
    
    // test results
    results = new float[tcX.length]; 
    for (int i = 0; i < tcX.length; i++){
      results[i] = (float) Math.sqrt(tcX[i]);
    };      
  }
    
  /**
   * @modifies <tt>System.out</tt>
   * @effects <pre>
   *            for each test case tc = < x,e,r > 
   *              if |Num.sqrt(x)^2 - r^2| > e 
   *                throws AssertionError 
   *              else 
   *                displays Num.sqrt(x) on the standard output
   *          </pre>
   */
  @Test//(timeout = 5000)
  public void squareRoot() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.sqrt");

    float x,e,r;
    for (int i = 0; i < tcX.length; i++) {
      x = tcX[i];
      r = results[i];
      for (int j = 0; j < tcEps.length; j++) {
        System.out.println(">>Test case " + ((i*tcEps.length)+j));
        e = tcEps[j];
        float result = Num.sqrt(x, e);
        // check same sign
        assert (r*result>=0) : "Invalid result " + result + " (expected: ) " + r;
        // check delta error (assume same delta error between the expected result and our result)
        assertEquals(r * r, result * result, 2 * e);
        //assert (r*r == result*result);

        System.out.printf("sqrt(%f,%f) = %f (expected = %f) %n", x, e, result, r);
      }
    }
  }
}
