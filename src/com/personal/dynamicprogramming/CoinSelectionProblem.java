package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 5/2/17.
 */
public class CoinSelectionProblem {

    public int getMaxValue(List<Integer> coinValues) {
        int[] result = new int[coinValues.size()];
        for(int i = 0 ; i < coinValues.size() ; i++) {
           if(i == 0) {
               continue;
           }
            if(i == 1){
                result[i] = coinValues.get(i);
                continue;
            }
            result[i] = Mathematical.maximum(coinValues.get(i) + result[i-2],result[i-1]);
        }
        return result[result.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new CoinSelectionProblem().getMaxValue(Arrays.asList(0,5,1,2,10,6,2)));
    }
}
