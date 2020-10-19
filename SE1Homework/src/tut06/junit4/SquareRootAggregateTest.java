package junit4;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import tut06.Num;

/**
 * @overview A test driver for the <tt>Num.sqrt</tt> method.
 */

public class SquareRootAggregateTest {
  // test cases
  private static float[][] testCases;

  @BeforeClass
  public static void setUp() {
    // print out the test program name
    System.out.println(SquareRootAggregateTest.class.getName());

    // test cases
    float[] tcEps = { 0.00002f, 0.0001f, //
        0.009f //
    };

    float[] tcX = { 0f, 0.001f, 0.01f, 0.09f, 0.5f, 1f, 2f, 10f, //
        100f, //
        2147483600f };

    // test results
    float[] results = new float[tcX.length];
    for (int i = 0; i < tcX.length; i++) {
      results[i] = (float) Math.sqrt(tcX[i]);
    }

    float x, e, r;
    testCases = new float[tcX.length * tcEps.length][];

    for (int i = 0; i < tcX.length; i++) {
      x = tcX[i];
      r = results[i];
      for (int j = 0; j < tcEps.length; j++) {
        e = tcEps[j];
        testCases[i * tcEps.length + j] = new float[] { x, e, r };
      }
    }
  }

  /**
   * @requires <tt>testCases != null</tt>
   * @modifies <code>System.out</code>
   * @effects <pre>
   *            for each test case <x,e,r> 
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

    float[] testCase;
    float x, e, r;
    for (int i = 0; i < testCases.length; i++) {
      System.out.println(">>Test case " + i);
      testCase = testCases[i];
      x = testCase[0];
      e = testCase[1];
      r = testCase[2];
      float result = Num.sqrt(x, e);
      // assume same delta error between the expected result and our result
      assertEquals(r * r, result * result, 2 * e);

      System.out.printf("sqrt(%f,%f) = %f (expected = %f) %n", x, e, result, r);
    }
  }

  /**
   * @requires <tt>testCases != null</tt>
   * @modifies <code>System.out</code>
   * @effects <pre>
   *            for each test case <x,e,r> 
   *              if |Num.sqrt(x)^2 - r^2| > e 
   *                throws AssertionError 
   *              else 
   *                displays Num.sqrt(x) on the standard output
   *          </pre>
   */
  @Test(timeout = 5000)
  public void squareRoot2() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.sqrt2");

    float[] tc;
    for (int i = 0; i < testCases.length; i++) {
      System.out.println(">>Test case " + i);
      tc = testCases[i];
      float x = tc[0];
      float e = tc[1];
      float r = tc[2];

      float result = Num.sqrt2(x, e);
      // assume same delta error between the expected result and our result
      assertEquals(r * r, result * result, 2 * e);

      System.out.printf("sqrt(%f,%f) = %f (expected = %f) %n", x, e, result, r);
    }
  }
}
