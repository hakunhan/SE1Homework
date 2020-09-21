import java.util.ArrayList;
import java.util.Collections;

import utils.DomainConstrains;
/**
 * @overview arrayList<Integer> that get min, max elements of array
 * @attribute
 * min Integer
 * max Integer
 */
public class MaxMinIntListA extends ArrayList<Integer> {
    @DomainConstrains(type = "Integer")
    private Integer min;
    @DomainConstrains(type = "Integer")
    private Integer max;
    
    /**
     * @effects 
     *      if max eq null || e > max
     *          max = e
     *      else if min eq null || e < min
     *          min = e
     *      
     *      invoke super.add(e)
     */
    @Override
    public boolean add(Integer e){
        if(max == null || e > max){
            max = e;
        }else if(min == null || e < min){
            min = e;
        }
     
        super.add(e);
        return true;
    }
    
    /**
     * @effects 
     *      if e eq min
     *          get second smallest Integer
     *      else e eq max
     *          get second largest Integer
     * 
     *      invoke super.remove(e)
     */
    @Override
    public boolean remove(Object e){
        if(e == min){
            ArrayList a =  (ArrayList) super.clone();
            Collections.sort(a);
            
            min = (Integer) a.get(1);
        }else if(e == max){
            ArrayList a =  (ArrayList) super.clone();
            Collections.sort(a);
            
            
            max = (Integer) a.get(a.size() - 2);
        }
        
        super.remove(e);
        return true;
    }
    
    /**
     * @effects return maximum Integer element of the array 
     */
    public Integer getMax(){
        return max;
    }
    
    /**
     * @effects return minimum Integer element of the array 
    */
    public Integer getMin(){
        return min;
    }
}
