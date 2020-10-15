package tut03.exercise;

import utils.EmptyException;
/**
 * @overview 3 procedures that return the sum of the array
 * with 3 kinds of handling null array
 * (best one is sum_throw_exception as it is the defensive procedure
 * that does not return a misleading value)
 */
public class Exercise_4_3 {

    /**
     * @require arr neq null
     * @effect return sum of elements of the array
     */
    public static int sum_require(int[] arr){
        int sum = 0;
        for (int e: arr){
            sum+=e;
        }
        return sum;
    }

    /**
     * @effect
     * if arr eq null
     *      return 0
     * else
     *      return sum of elements of the array
     */
    public static int sum_if_null_return_0(int[] arr){
        int sum = 0;
        if (arr == null)
            return 0;

        for (int e: arr){
            sum+=e;
        }
        return sum;
    }

    /**
     * @effects
     * if arr eq null
     *      throw NullPointerException
     * else
     *      return sum of elements of the array
     */
    public static int sum_throw_exception(int[] arr) throws NullPointerException {
        int sum = 0;
        if (arr == null) {
            throw new NullPointerException("Invalid array!");
        }
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }
}
