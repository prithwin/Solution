package com.personal.dynamicprogramming;

import com.personal.util.Print2DMatrix;

/**
 * Created by pr250155 on 5/9/17.
 *    0 1 2 3
 * 0  0
 * 1    0
 * 2      0
 * 3        0
 */
public class MatrixChainMultiplication {
    public int findMinimumCost(int[] ... matrices ) {
        int[][] resultMatrix = new int[matrices.length][matrices.length];
        int jstart = 0;
        for(int i = 0 ; i < matrices.length ;) {
            int oldI = i;
            for(int j = jstart ; j < matrices.length ; j++) {
                if(i == j){
                    resultMatrix[i][j] = 0; continue;
                }
                if(i>j)continue;
                int minValue = Integer.MAX_VALUE;
                for(int k = i ; k < j  ; k++) {
                    int cost = resultMatrix[i][k] + resultMatrix[k+1][j] + (matrices[i][0] * matrices[k][1] * matrices[j][1]);
                    if(cost < minValue){
                        minValue = cost;
                    }
                }
                resultMatrix[i][j] = minValue;
                i++;
            }
            i = oldI;
            jstart++;
            if(jstart==matrices.length){
                break;
            }

        }
        return resultMatrix[0][resultMatrix[0].length-1];
    }
}
