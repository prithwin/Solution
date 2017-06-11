package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

import java.util.Arrays;

/**
 * Created by pr250155 on 5/3/17.
 * there is a rod n or 1 units long, what is the maximum price that can be obtained by cutting it.where the price of th
 * ith length piece is I unit Long is in the list {1, 5, 8, 9, 10, 17, 17, 20};
 *    1  2  3  4  5  6  7  8
 * 1  1  2  3  4  5  6  7  8
 * 2  1  5
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 *
 */
public class RodCutting {
    public int getMaxValue(int[] valuesList) {
        int[][] solutionMatrix = new int[valuesList.length][valuesList.length+1];

        for(int i=0 ; i < solutionMatrix.length ; i++){
            for(int j=0; j < solutionMatrix[i].length; j++) {
                if(j==0) {
                    solutionMatrix[i][j] = 0;continue;
                }
                if(i==0) {
                   solutionMatrix[i][j] = valuesList[i] * j;continue;
                }
                if(j>i) {
                    solutionMatrix[i][j] = Mathematical.maximum(solutionMatrix[i - 1][j], valuesList[i] + solutionMatrix[i][j - i - 1]);
                } else {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j];
                }
            }
        }
        MatrixUtil.print2dMatrix(solutionMatrix);
        return solutionMatrix[valuesList.length-1][valuesList.length];
    }

    public int getMaxValue(int[] values, int rem) {
        if(rem == 0) return 0;
        if(values.length == 0) return 0;
        if(values.length <= rem) {
            return Mathematical.maximum(
                    getMaxValue(Arrays.copyOfRange(values, 0, values.length - 1), rem),
                    values[values.length - 1] +
                            getMaxValue(Arrays.copyOfRange(values, 0, values.length - 1), (rem - values.length))
            );
        } else {
            return getMaxValue(Arrays.copyOfRange(values, 0, values.length - 1),rem);
        }
    }
}

