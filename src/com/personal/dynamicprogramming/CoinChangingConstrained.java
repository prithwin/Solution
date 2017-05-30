package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 5/3/17.
 * only a fixed set of coins is provided. in other words its a 0-1 coin changing problem.
 */
public class CoinChangingConstrained {

    public int getNumberOfCoins(List<Integer> denominations, int total) {
        int[][] solutionMatrix = new int[denominations.size()+1][total+1];
        for (int i = 0; i < solutionMatrix.length; i++) {
            for (int j = 0; j < solutionMatrix[i].length; j++) {
                if(i==0 || j == 0) {solutionMatrix[i][j] = -1 ;continue;}
                int sample = denominations.get(i-1);
                if(sample == j) {
                    solutionMatrix[i][j] = 1; continue;
                }
                if(sample > j) {
                    solutionMatrix[i][j] = solutionMatrix[i-1][j];
                } else {
                    if(solutionMatrix[i-1][Math.abs(j-sample)] != -1)
                        solutionMatrix[i][j] = 1 + solutionMatrix[i-1][Math.abs(j-sample)];
                    else
                        solutionMatrix[i][j] = -1;
                }
            }
        }
        MatrixUtil.print2dMatrix(solutionMatrix);
        int returnValue = Integer.MAX_VALUE;
        for(int i = 0 ; i < solutionMatrix.length ; i++) {
            if(solutionMatrix[i][total]!= -1 && solutionMatrix[i][total] < returnValue)
                returnValue = solutionMatrix[i][total];
        }
        return returnValue;
    }

    public int getNumberOfCoinsOS(List<Integer> denominations, int total) {
        if(denominations.size() == 0 || total == 0) return -1;

        Integer sample = denominations.get(0);
        if(sample == total) return 1;
        List<Integer> remainder = denominations.subList(1,denominations.size());
        if(sample > total) {
            return getNumberOfCoinsOS(remainder,total);
        } else {
            if(getNumberOfCoinsOS(remainder,Math.abs(total-sample)) != -1)
                return (1 + getNumberOfCoinsOS(remainder,Math.abs(total-sample)));
            return -1;
        }
    }
}
