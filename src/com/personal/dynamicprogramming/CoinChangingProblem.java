package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

import java.util.List;

/**
 * Created by pr250155 on 5/3/17.
 *
 *      0 1 2 3 4 5 6 7 8 9 10 11
 *   1  0 1 2 3 4 5 6 7 8 9 10 11
 *   5  0 1 2 3 4 1 2 3 4 5 2  3
 *   6  0 1 2 3 4 1 1 2 3
 *   8
 */
public class CoinChangingProblem {

    public int getNumberOfCoins(List<Integer> denominations, int total) {

        int[][] solutionMatrix = new int[denominations.size()][total+1];
        for (int i = 0; i < solutionMatrix.length; i++) {
            for (int j = 0; j < solutionMatrix[i].length; j++) {
                if(j == 0){
                    solutionMatrix[i][j] = 0; continue;
                }
                if(i == 0) {
                    if(denominations.get(i) > j) {
                        solutionMatrix[i][j] = -1;
                    } else {
                        if(j % denominations.get(i) == 0){
                            solutionMatrix[i][j] = j/denominations.get(i);
                        } else {
                            solutionMatrix[i][j] = -1;
                        }
                    }
                    continue;
                }
                if(denominations.get(i) > j) {
                    solutionMatrix[i][j] = solutionMatrix[i-1][j];
                } else {
                    solutionMatrix[i][j] = Mathematical.min(solutionMatrix[i - 1][j], 1 + solutionMatrix[i][j - denominations.get(i)]);
                }
            }
        }
        MatrixUtil.print2dMatrix(solutionMatrix);
        return solutionMatrix[denominations.size()-1][total];
    }

    public int getNumberOfCoinsOS(List<Integer> denominations,int total) {
        if(total == 0) {
            return 0;
        }
        int sample = denominations.get(denominations.size()-1);
        if(denominations.size() == 1) {
            if(sample > total) return 0;
            if(total % sample == 0) {
                return total / denominations.get(0);
            } else {
                return 0;
            }
        }


        List<Integer> reminder = denominations.subList(0,denominations.size()-1);
        if(sample > total) {
            return getNumberOfCoinsOS(reminder,total);
        } else {
            return Mathematical.min(getNumberOfCoinsOS(reminder,total) ,
                      1 + getNumberOfCoinsOS(reminder,Math.abs(total-sample))
                    );
        }
    }
}
