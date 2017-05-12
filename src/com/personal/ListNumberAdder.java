package com.personal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/9/17.
 */
public class ListNumberAdder {
    public int add(List<Integer> daye, List<Integer> baye){
        int sum = 0;
        int radix = 1;
        int reminder = 0;
        for(int i = daye.size()-1 , j = baye.size()-1;;){
            int sumInPlace = reminder;
            if(i<0 && j<0 && reminder == 0){
                break;
            }

            if(i >= 0){
                sumInPlace += daye.get(i);
            }
            if(j >= 0){
                sumInPlace += baye.get(j);
            }

            if(sumInPlace > 9){
                reminder = 1;
                int radixSum = sumInPlace % 10;
                sum += radix * radixSum;

            } else {
                reminder = 0;
                sum += radix * sumInPlace;

            }

            radix *= 10;
            i--;
            j--;
        }
        return sum;
    }
}
