package tut03.exercise;
import utils.EmptyException;
/**
 * @overview a standalone procedure that multiples each element
 * of array a to the sum of array b
 */
public class Exercise_4_4 {
    /**
     * @modifies a
     * @effects
     * if a eq null || b eq null
     *      throw NullPointerException
     * else if a is empty || b is empty
     *      throw EmptyException
     * else
     *      elements in a = elements * sum(b)
     */
    public static void combine(int[] a, int[] b) throws NullPointerException,EmptyException{
        if (a == null || b == null){
            throw new NullPointerException("Invalid arrays");
        }else if(a.length == 0 || b.length == 0){
            throw new EmptyException("Invalid arrays");
        }
        int sum = Exercise_4_3.sum_throw_exception(b);
        for (int e: a){
            e *= sum;
        }
    }
}
