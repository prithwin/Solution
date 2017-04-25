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

    public List<Object> findSizeOfLongestPallindromicSubsequence(String target){
        List<Object> returner = new ArrayList<>();
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
        returner.add(solutionMatrix[0][target.length()-1]);
        int count = solutionMatrix[0][target.length()-1];
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            chars.add('-');
        }
        for(int i = 0, j=solutionMatrix.length-1 ; count >0; ){
            if(solutionMatrix[i+1][j-1]+2 == solutionMatrix[i][j]){
                chars.add(i,target.charAt(i++));
                chars.add(j,target.charAt(j--));
                count-=2;
            } else if(solutionMatrix[i][j] == solutionMatrix[i][j-1]){
                j--;
            } else {
                i++;
            }
        }
        chars.stream().forEach(System.out::print);
        returner.add(chars);
        return returner;
    }

    public static void main(String[] args) {
        new LongestPallindromicSubsequence().findSizeOfLongestPallindromicSubsequence("agbdba");
    }
}