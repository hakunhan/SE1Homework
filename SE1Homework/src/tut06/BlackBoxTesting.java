import utils.NotFoundException;


public class BlackBoxTesting {
  public static void main(String[] args) {
  }

  /**
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
      throw new NullPointerException("BlackBoxTesting.search");
    
    for (int i = 0; i < a.length; i++) {
      if (a[i] == x) return i;
    }
    
    throw new NotFoundException("BlackBoxTesting.search: value not in array: " + x);
  } 
}
