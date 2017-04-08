package com.personal;

import com.personal.util.CustomStringUtils;
import com.personal.util.Mathematical;

/**
 * Created by pr250155 on 4/2/17.
 */
public class LongestSubsequenceProblem {
    public String lcs(String theString , String otherString){
        int[][] matrix = new int[theString.length()+1][otherString.length()+1];
        //these will ge initialized to zeroes
        for(int i = 1 ; i < matrix.length ; i++){
            for (int j = 1 ; j < matrix[0].length ; j++){
                if(theString.charAt(i-1) == otherString.charAt(j-1)){
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                } else {
                    matrix[i][j] = Mathematical.maximum(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        int max = matrix[theString.length()][otherString.length()];
        StringBuilder builder = new StringBuilder();
        int index = 4;
        for(int i = matrix.length-1 ; i >= 1 ;i-- ){
            for(int j = matrix[0].length-1 ; j >= 1 ; j--){
                if(matrix[i-1][j-1]+1 == matrix[i][j]){
                    if(index-- >0)
                        builder.append(otherString.charAt(j - 1));
                } else {
                }
            }
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        String lcs = new CustomStringUtils().reverse2(new LongestSubsequenceProblem().lcs("ABCDGHLQR","AEDPHR"));
        System.out.printf("the longest String is %s and its size is %d",lcs,lcs.length());
    }
}
