package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

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

    public int findSizeOfLongestPallindromicSubsequence(String target){
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
        return solutionMatrix[0][target.length()-1];
    }

    public int longestPalindromicSubsequence(String target){
        if(target.length()==1) return 1;
        if(target.charAt(0) == target.charAt(target.length()-1)) {
            return 2 + longestPalindromicSubsequence(target.substring(1,target.length()-1));
        } else {
            return Mathematical.maximum(longestPalindromicSubsequence(target.substring(0,target.length()-1)),
                    longestPalindromicSubsequence(target.substring(1,target.length())));
        }
    }
    public static void main(String[] args) {
        System.out.println(new LongestPallindromicSubsequence().longestPalindromicSubsequence("BBABCBCAB"));
    }
}