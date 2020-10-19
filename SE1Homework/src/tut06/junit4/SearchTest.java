package junit4;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import tut06.BlackBoxTesting;
import tut06.Num;
import utils.NotFoundException;

/**
 * @overview A test driver for the <code>search</code> method.
 */
public class SearchTest {

  // test cases
  private static int[][] tcA;

  private static int[] tcX;

  // test results
  private static Object[][] results;

  @BeforeClass
  public static void setUp() {
    // test cases
    tcA = new int[][] { //
    null,           //a0
    {},             //a1
    { 1 },          //a2
    { 3, 1 },       //a3
    { 3, 1, 4 },    //a4
    { 3, 5, 1, 4 }  //a5
    };

    tcX = new int[] {
      1, //
      2, //
      3, //
      4, //
      5, //
    };

    // test results
    results = new Object[][] {
    /** for a0 */
    { //
      NullPointerException.class, //
      NullPointerException.class, //
      NullPointerException.class, //
      NullPointerException.class, //
      NullPointerException.class //
    }, //
    /** for a1 */
    { //
      NotFoundException.class, //
      NotFoundException.class, //
      NotFoundException.class, //
      NotFoundException.class, //
      NotFoundException.class //
    },
    /** a2 */
    { //
      0, //
      NotFoundException.class, //
      NotFoundException.class, //
      NotFoundException.class, //
      NotFoundException.class //
    },
    /** a3 */
    { //
      1, //
      NotFoundException.class, //
      0, //
      NotFoundException.class, //
      NotFoundException.class //
    },
    /** a4 */
    { //
      1, //
      NotFoundException.class, //
      0, //
      2, //
      NotFoundException.class //
    },
    /** a5 */
    { //
      2, //
      NotFoundException.class, //
      0, //
      3, //
      1 //
    }};
  }

  /**
   * Test method for the buggy <tt>Num.search</tt> method.
   * 
   * @modifies <code>System.out</code>
   * @effects <pre>
   *            if a test case fails 
   *              throws AssertionError 
   *            else 
   *              displays result on standard output
   *          </pre>
   */
  //@Ignore
  @Test
  public void buggySearch() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.search");

    /** a flag to delay the report of result */
    final boolean delayReport = false;

    int[] a;
    int x;
    Object[] result;
    Object actual;
    Object expected;
    final int numTCs = tcA.length * tcX.length;
    String[] procs = new String[numTCs];
    Object[] actualResults = new Object[numTCs];
    String proc;
    int index;
    for (int j = 0; j < tcX.length; j++) {
      x = tcX[j];
      for (int i = 0; i < tcA.length; i++) {
        a = tcA[i];
        result = results[i];
        expected = result[j];
        index = (j * tcA.length) + i;
        proc = "buggySearch(" + Arrays.toString(a) + "," + x + ")";
        if (delayReport) { // to delay report
          procs[index] = proc;
          try {
            actual = doSearch(a, x, expected);
            // ok
            actualResults[index] = actual;
          } catch (AssertionError e) {
            // test case failed
            actualResults[index] = e;
          }
        } else {
          System.out.println(">>Test case " + (index + 1));
          System.out.println(proc);
          actual = doSearch(a, x, expected);
          System.out.println(" = " + actual);
        }
      }
    } // end for

    // if delay report is true then print a report at the end
    if (delayReport) {
      for (int i = 0; i < procs.length; i++) {
        System.out.println(">>Test case " + (i + 1));
        System.out.println(procs[i]);
        expected = actualResults[i];
        if (expected instanceof AssertionError) {
          System.out.println(((AssertionError) expected).getMessage());
        } else {
          System.out.println(" = " + expected);
        }
      }
    }
  }

  /**
   * Test method for the correct <tt>BlackBoxTesting.search</tt> method.
   * 
   * @modifies <code>System.out</code>
   * @effects <pre>
   *            if a test case fails 
   *              throws AssertionError 
   *            else 
   *              displays result on standard output
   *          </pre>
   */
  @Ignore
  @Test
  public void search() throws AssertionError {
    System.out.println("=======================");
    System.out.println("BlackBoxTesting.search");

    int[] a;
    int x;
    int r = 0;
    Object[] result;
    for (int i = 0; i < tcA.length; i++) {
      a = tcA[i];
      result = results[i];
      for (int j = 0; j < tcX.length; j++) {
        System.out.println(">>Test case " + ((i * tcX.length) + j + 1));
        x = tcX[j];

        System.out.println("search(" + Arrays.toString(a) + "," + x + ")");

        try {
          r = BlackBoxTesting.search(a, x);
          assert (result[j].equals(r)) : "invalid result " + r;
          System.out.println(" = " + r);
        } catch (Exception e) {
          // thrown exception must be of the correct type
          assert (e.getClass() == result[j]) : "invalid exception: " + e;

          System.out.println(" = " + e);
        }
      }
    }
  }

  /**
   * a buggy search 
   */
  private Object doSearch(int[] a, int x, Object expectedResult)
      throws AssertionError {
    int r;
    try {
      // buggy
      r = Num.search(a, x);
      assert (expectedResult.equals(r)) : "invalid result " + r
          + ", expecting: " + expectedResult;
      // ok
      return r;
    } catch (Exception e) {
      // thrown exception must be of the correct type
      assert (e.getClass() == expectedResult) : "invalid result: " + e
          + ", expecting: " + expectedResult;
      // ok
      return e;
    }
  }

  /**
   * Test method for the buggy <tt>Num.search2</tt> method.
   * 
   * @modifies <code>System.out</code>
   * @effects <pre>
   *            if a test case fails 
   *              throws AssertionError 
   *            else 
   *              displays result on standard output
   *          </pre>
   */
  @Ignore
  @Test
  public void buggySearch2() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.search2");

    int[] a;
    int x;
    int r = 0;
    Object[] result;
    for (int i = 0; i < tcA.length; i++) {
      a = tcA[i];
      result = results[i];
      for (int j = 0; j < tcX.length; j++) {
        System.out.println(">>Test case " + ((i * tcX.length) + j + 1));
        x = tcX[j];

        System.out.println("search(" + Arrays.toString(a) + "," + x + ")");
        try {
          // buggy 
          r = Num.search2(a, x);
          assert (result[j].equals(r)) : "invalid result " + r;
          System.out.println(" = " + r);
        } catch (Exception e) {
          // thrown exception must be of the correct type
          assert (e.getClass() == (result[j])) : "invalid exception: " + e;

          System.out.println(" = " + e);
        }
      }
    }
  }
}
