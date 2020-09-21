/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 * @overview arrayList<Integer> that get min, max elements of array
 */
public class MinMaxIntListB extends ArrayList<Integer>{
    
    /**
     * @effects return maximum Integer element of the array 
     */
    public Integer getMax(){
        ArrayList a = (ArrayList) super.clone();
        Collections.sort(a);
        return (Integer) a.get(a.size() - 1);
    }
    
    /**
     * @effects return minimum Integer element of the array 
     */
    public Integer getMin(){
        ArrayList a = (ArrayList) super.clone();
        Collections.sort(a);
        return (Integer) a.get(0);
    }
}
