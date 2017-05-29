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
                if(i==0 || j == 0) {solutionMatrix[i][j] = 0 ;continue;}
                int sample = denominations.get(i-1);
                if(sample == j) {
                    solutionMatrix[i][j] = 1; continue;
                }
                if(sample > j) {
                    solutionMatrix[i][j] = solutionMatrix[i-1][j];
                } else {
                    solutionMatrix[i][j] = 1 + solutionMatrix[i-1][Math.abs(j-sample)];
                }
            }
        }
        MatrixUtil.print2dMatrix(solutionMatrix);
        return solutionMatrix[denominations.size()][total];
    }

    public int getNumberOfCoinsOS(List<Integer> denominations , int total) {
        if(denominations.size() == 0) return 0;
        if(denominations.size() == 1 && denominations.get(0).equals(total)) return 1;
        Integer sample = denominations.get(0);
        if(sample == total) return 1;
        List<Integer> remainder = denominations.subList(1,denominations.size()-1);
        if(sample > total) {
            return getNumberOfCoins(remainder,total);
        } else {
            return (1 + getNumberOfCoinsOS(remainder,Math.abs(total-sample)));
        }
    }
}
