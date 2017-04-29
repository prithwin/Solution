package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.Print2DMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 4/12/17.
 *      a  b  d  c  a
 *  1   1  1  1  1  1
 *  2
 *  3
 *  4
 *  5
 *
 */
public class LongestPallindromicSubsequence {

    public void findSizeOfLongestPallindromicSubsequence(String target){
        int[][] solutionMatrix = new int[target.length()][target.length()];
        for (int i = 0; i < solutionMatrix.length; i++) {
            solutionMatrix[i][i]=1;
        }
        for(int k = 1 ; k < target.length() ; k++){
            for(int i = 0 , j = k ; j < solutionMatrix.length || j <solutionMatrix.length ;i++,j++){
                if(target.charAt(i) == target.charAt(j)){
                    solutionMatrix[i][j] = solutionMatrix[i+1][j-1] + 2;
                } else {
                    solutionMatrix[i][j] = Mathematical.maximum(solutionMatrix[i][j-1],solutionMatrix[i+1][j]);
                }
            }
        }
        Print2DMatrix.print2dMatrix(solutionMatrix);
    }

    public static void main(String[] args) {
        new LongestPallindromicSubsequence().findSizeOfLongestPallindromicSubsequence("BBABCBCAB");
    }
}