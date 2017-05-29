package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 5/3/17.
 * only a fixed set of coins is provided.
 *      0 1 2 3 4 5 6 7 8 9 10 11
 *
 *   1  0 1 $ $ $ $ $ $ $ $ $  $
 *   5  0 1 $ $ $ 1 2 $ $ $ $  $
 *   6  0 1 $ $ $ 1 1
 *   8
 */
public class CoinChanginConstrained {

    public int getNumberOfCoins(List<Integer> denominations, int total) {
        int[][] solutionMatrix = new int[denominations.size()][total+1];
        for (int i = 0; i < solutionMatrix.length; i++) {
            for (int j = 0; j < solutionMatrix[i].length; j++) {
               if(j==0){
                   solutionMatrix[i][j] = 0;continue;
               }
               if(i==0) {
                   if(j==denominations.get(i)){
                       solutionMatrix[i][j] = 1; continue;
                   }
                   solutionMatrix[i][j] = -1;continue;
               }
               if(j < denominations.get(i)){
                   solutionMatrix[i][j] = solutionMatrix[i-1][j];
               } else {
                   if(solutionMatrix[i-1][j]==-1 && solutionMatrix[i][j-denominations.get(i)] == -1) {
                       solutionMatrix[i][j] = -1;continue;
                   } else {
                       if(solutionMatrix[i-1][j]==-1 && solutionMatrix[i][j-denominations.get(i)] != -1) {
                           solutionMatrix[i][j] = 1+solutionMatrix[i][j-denominations.get(i)];
                       } else if (solutionMatrix[i][j-denominations.get(i)]==-1 && solutionMatrix[i-1][j]!=-1 ) {
                           solutionMatrix[i][j] = solutionMatrix[i-1][j];
                       } else {
                           solutionMatrix[i][j] = Mathematical.min(solutionMatrix[i-1][j], 1 + solutionMatrix[i][j-denominations.get(i)]);
                       }
                   }
               }

            }
        }
        MatrixUtil.print2dMatrix(solutionMatrix);
        return solutionMatrix[denominations.size()-1][total];
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
            return (1 + getNumberOfCoinsOS(remainder,total-sample));
        }
    }
}
