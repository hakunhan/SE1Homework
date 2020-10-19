package junit4;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tut06.Num;

/**
 * @overview A test driver to test the 
 *           <code>Num.sqrt</code> method using parameterised test runner. 
 * @author dmle
 */
/** Run this class using Parameterized test runner */
@RunWith(Parameterized.class)
public class SquareRootParameterisedTest {
  private float x;
  private float e;
  private float r;

  /**
   * @effects <pre>initialises this with a test case < x,e,r ></pre>
   */
  public SquareRootParameterisedTest(float x, float e, float r) {
    this.x = x;
    this.e = e;
    this.r = r;
  }
  
  @BeforeClass
  public static void init() {
    System.out.println(SquareRootParameterisedTest.class.getName());
  }

  // test data
  /**
   * A method to set up the test data to run
   * 
   * @effects Returns an <tt>Collection</tt> of <tt>[x,e,r]</tt> array
   *          where <tt>x,e</tt> are input and <tt>r</tt> is the 
   *          expected result of method <tt>Num.sqrt</tt>.
   */
  @Parameters
  public static Collection params() {
    // test cases
    float[] tcEps = {
        0.00002f, 
        0.0001f, //
        0.009f //
        };

    float[] tcX = { 
        0f, 0.001f, 0.01f, 0.09f, 0.5f, 1f, 2f, 
        10f, // 
        100f, // 
        2147483600f
        }; 
    
    // test results
    float[] results = new float[tcX.length]; 
    for (int i = 0; i < tcX.length; i++){
      results[i] = (float) Math.sqrt(tcX[i]);
    };

    // test data collection
    Vector v = new Vector();
    float x,e,r;
    for (int i = 0; i < tcX.length; i++) {
      x = tcX[i];
      r = results[i];
      for (int j = 0; j < tcEps.length; j++) {
        e = tcEps[j];
        v.add(new Object[] {x,e,r});
      }
    }
    
    return v;
  }

  /**
   * @modifies <code>System.out</code>
   * @effects <pre>
   *              if |Num.sqrt(x)^2 - r^2| > e 
   *                throws AssertionError 
   *              else 
   *                displays Num.sqrt(x) on the standard output
   *          </pre>
   */
  @Test
  // (timeout = 5000)
  public void squareRoot() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.sqrt");

    float result = Num.sqrt(x, e);
    // assume same delta error between the expected result and our result
    assertEquals(r * r, result * result, 2 * e);

    System.out.printf("sqrt(%f,%f) = %f (expected = %f) %n", x, e, result, r);
  }
}
