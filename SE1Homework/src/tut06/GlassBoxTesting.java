package tut06;

public class GlassBoxTesting {
  public static void main(String[] args) {
    int n = 4;
    int fact = fact(n);
    System.out.println("Factorial of " + n + ": " + fact);
  }

  // an implementation of fact using recursion
  /**
   * @requires <tt>n > 0</tt>
   * @effects returns the factorial of n
   */
  static int fact(int n) {
    if (n == 1)
      return 1;
    else
      return n * fact(n - 1);
  }

  static int maxOfThree(int x, int y, int z) {
    if (x > y) {
      if (x > z)
        return x;
      else
        // z >= x
        return z;
    } else { // x <= y
      if (y > z) {
        return y;
      } else { // y <= z
        return z;
      }
    }
  }

  static void myMethod(int n) {
    int m = (int) (Math.random()*1000);    
    for (int i = 1; i <= n; i++) {
      if (pred(i * m))
        m++;
    }
  }

  static boolean pred(int i) {
    return i % 2 == 0;
  }

  static void someMethod(int x) {
    while (x > 0) {
      // do something
      if (x % 10 == 3)
        break;
      x--;
    }
  }
  
//  static void processIntSet(IntSet s) {
//    int n = s.size();
//    int e;
//    for (int i = 0; i < n; i++) {
//      e = s.choose();
//      if (e % 2 == 0) {
//        System.out.println("even");
//      } else {
//        System.out.println("odd");
//      }
//    }
//  }  
}
