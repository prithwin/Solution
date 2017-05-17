package com.personal.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by pr250155 on 5/17/17.
 *      0  1  2  3  4  5  6  7  8  9 10  11
 *  0   T  F  F  F  F  F  F  F  F  F  F  F
 *  2   T  F  T  F  F  F  F  F  F  F  F  F
 *  3   T  F  T  T  F  T  F  F  F  F  F  F
 *  7   T  F  T  T  F  T  F  T  F  T  T  F
 *  8   T  F  T  T  F  F  F  T  T  T  T  T
 *  10  T  F  T  T  F  F  F  T  T  T  T  T
 */
public class SubsetSumProblem {
    public boolean isSumPossibleR(int[] target,int sum) {
        if(target.length == 1){
            if(target[0] == sum) return true;
            return false;
        }
        for(int i = target.length - 1 ; i >=0 ; i--) {
            if(target[i] == sum ||
                    isSumPossibleR(Arrays.copyOfRange(target,0,i),Math.abs(sum-target[i])) ||
                    isSumPossibleR(Arrays.copyOfRange(target,0,i),sum)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSumPossible(int[] target, int sum) {
        boolean[][] solutionMatrix = new boolean[target.length+1][sum + 1];

        for(int i = 0 ; i < solutionMatrix.length ; i++) {
            for (int j = 0; j < solutionMatrix[i].length; j++) {
                if(j == 0) {
                    solutionMatrix[i][j] = true; continue;
                }
                if(i==0) {
                    solutionMatrix[i][j] = false ;continue;
                }

                if(j < target[i-1]) {
                    solutionMatrix[i][j] = solutionMatrix[i-1][j];
                } else {
                    if(j == target[i-1] || solutionMatrix[i-1][j] || solutionMatrix[i-1][Math.abs(j-target[i-1])]) {
                        solutionMatrix[i][j] = true;
                    } else {
                        solutionMatrix[i][j] = false;
                    }
                }

            }
        }
        return solutionMatrix[target.length][sum];
    }
}
