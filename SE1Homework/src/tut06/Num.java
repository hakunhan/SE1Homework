package tut06;

import java.math.BigDecimal;

import utils.NotFoundException;
import utils.NotPossibleException;
import utils.Tool;

public class Num extends ch2.Num {
  private static boolean debug = false;

  /**
   * @effects 
   *  return the arithmetic sum of x, y, i.e. result = x + y 
   */
  public static double add(double x, double y) {
    // now correct code region!
    double  result = x + y;
    
    return result;
  }
  
  /**
   * @requires <tt>x >= 0 && .00001 < epsilon < .001</tt>
   * @effects returns <tt>n</tt> such that
   * 
   * <pre>x - epsilon < n^2 <= x + epsilon</pre>
   */
  public static float sqrt(float x, float epsilon) {
    if (x == 0)
      return 0;

    double ans = x / 2.0F;

    // need to use big decimal to preserve the precision values
    final BigDecimal bdX = new BigDecimal(x);
    final BigDecimal dlower = bdX.subtract(new BigDecimal(epsilon));
    final BigDecimal dupper = bdX.add(new BigDecimal(epsilon));

    BigDecimal sq;
    while (true) {
      /* valid code */
      ans = ans - ((ans * ans - x) / (2 * ans));
      /* buggy code */
      //ans = ans - ((ans * ans + x) / (2 * ans));      
      
      sq = new BigDecimal(ans * ans);
      if (dlower.compareTo(sq) < 0 && dupper.compareTo(sq) >= 0) // found
        break;
    }

    return (float) ans;
  }
  
  /**
   * An incorrect implementation of {@link #sqrt(float, float)}
   * that does not use BigDecimal.
   * 
   * @requires <tt>x >= 0 && .00001 < epsilon < .001</tt>
   * @effects returns <tt>n</tt> such that
   * 
   * <pre>x - epsilon < n^2 <= x + epsilon</pre>
   */
  public static float sqrtErr(float x, float epsilon) {
    if (x == 0)
      return 0;

    float ans = x / 2.0F;

    // need to use big decimal to preserve the precision values
    final float dlower = x - epsilon;
    final float dupper = x + epsilon;

    float sq; 
    float prev;
    while (true) {
      prev = ans;
      ans = ans - ((ans * ans - x) / (2 * ans));
      
      sq = ans * ans;      
      if (dlower < sq && dupper >= sq) // found
        break;

      /**
       * if ans = prev at this point then we have 
       * a contradiction (bug): sq = x and  
       * sq failed the delta error check above
       *
       * This bug occurs when x is very large. A symptom 
       * is that the program hangs (caused by an endless loop).
       * 
       * This check is designed to stop the loop and reveal the bug.
       * 
       * debug: since the logic is sound, a plausible explanation
       * is that precision was lost 
       * in the computations of the intermediate results (ans, dlower, dupper)
       * 
       * This explanation proves correct since this bug disappear 
       * when this code is modified (see method {@link #sqrt(float,float)})
       * such that the computations are performed using BigDecimal 
       */
      assert (ans != prev) : "precision error at: " + ans;
    }

    return ans;
  }

  /**
   * Another implementation of {@link #sqrt(float, float)}.
   * 
   * @requires <tt>x >= 0 && .00001 < epsilon < .001</tt>
   * @effects returns <tt>n</tt> such that
   * 
   * <pre>x - epsilon < n^2 <= x + epsilon</pre>
   */
  public static float sqrt2(float x, float epsilon) {
    if (debug)
      Tool.printf("x %f, epsilon %f %n", x, epsilon);

    // x = 1
    if (x == 1)
      return 1f;

    if (0 < x && x < 1) {
      return 1 / sqrt2(1 / x, epsilon);
    }

    // uses binary division to search for the first floating point that is
    // closed to
    // the sqrt(x)
    long j = 2;

    double m, msq;
    double a = 0;
    // find the square root by successively incrementing m by a fraction
    while (true) {
      m = a + x / j;
      msq = m * m;

      if (debug)
        Tool.printf("a: %f, j: %d, m: %f, m^2: %f, m^2-x: %f %n", a, j, m, msq,
            (msq - x));

      if (Math.abs(msq - x) < epsilon)
        break;

      if (msq < x) {
        a = m;
      }

      j = 2 * j;
      if (j == 0) { // normally this should not happen
        throw new NotPossibleException("Num.sqrt: x, epsilon = " + x + ","
            + epsilon);
      }
    }

    return ((float) m);
  }

  /**
   * An incorrect implementation of {@link #sqrt2(float, float)} used to
   * demonstrate the need for glass-box testing.
   */
  public static float sqrtErr2(float x, float epsilon) {
    if (debug)
      Tool.printf("x %f, epsilon %f %n", x, epsilon);

    // x = 1
    if (x == 1)
      return 1f;

    // ERROR: the following fail to measure sqrt for the case
    // where x in (1,2)
    // find the closest integer to the square root of x
    int i = 2;
    long n = (long) x / i; // needs to cast to long to support big numbers
    long nsq = n * n;
    while (nsq > x) {
      i++;
      n = (long) x / i;
      nsq = n * n;
    }

    // omitting this line will result in errors for square numbers (e.g. 4, 9,
    // ....)
    if (n * n == x)
      return n;

    // find the square root by successively incrementing x by a fraction
    double a = n;
    double j = 1f / 2f;
    double m;
    double msq;

    while (true) {
      m = a + j;

      msq = m * m;

      if (debug)
        Tool.printf("a: %f, j: %.50f, m: %f, m^2: %f, m^2-x: %f %n", a, j, m,
            msq, (msq - x));

      if (Math.abs(msq - x) < epsilon)
        break;

      if (msq < x) {
        a = m;
      }

      j = j / 2;

      if (j == 0) { // normally this should not happen
        throw new NotPossibleException("Num.sqrt: x, epsilon = " + x + ","
            + epsilon);
      }
    }

    return ((float) m);
  }
  
  /**
   * A buggy implementation of <tt>search</tt>.
   * 
   * @effects <pre>
   *          if a is null
   *            throws NullPointerException
   *          else if x is in a
   *            returns i such that a[i] = x
   *          else 
   *            throws NotFoundException</pre>
   */
  public static int search(int[] a, int x) throws NullPointerException, NotFoundException {
    if (a == null)
      throw new NullPointerException("Num.search");
    
    for (int i = 0; i < a.length; i++) {
      if (x != a[i]) return i;
    }
    
    throw new NotFoundException("Num.search: value not in array: " + x);
  }  
  
  /**
   * Another buggy implementation of <tt>search</tt>.
   * 
   * @effects <pre>
   *          if a is null
   *            throws NullPointerException
   *          else if x is in a
   *            returns i such that a[i] = x
   *          else 
   *            throws NotFoundException</pre>
   */
  public static int search2(int[] a, int x) throws NullPointerException, NotFoundException {
    if (a == null)
      throw new NullPointerException("Num.search");
    
    for (int i = 0; i < a.length; i++) {
      if (i == x) return i;
    }
    
    throw new NotFoundException("Num.search: value not in array: " + x);
  }  
}
