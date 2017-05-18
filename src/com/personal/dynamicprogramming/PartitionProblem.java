package com.personal.dynamicprogramming;

/**
 * Created by pr250155 on 5/18/17.
 * Given an array can you partition it such that the summ of both parts is the same.
 *       0   1  2  3  4  5   6  7  8  9  10  11
 *    1  T   T  F  F  F  F   F  F  F  F  F   F
 *    5  T   T  F  F  F  T
 *    11 T
 *    5  T
 */
public class PartitionProblem {
     public boolean isPartitionPossible(int[] target) {
         int sum = 0;
         for (int i = 0 ; i < target.length ; i++) {
             sum += target[i];
         }
         if(sum % 2 == 0 ){
             return new SubsetSumProblem().isSumPossible(target,sum/2);
         }
         return false;
     }
}
