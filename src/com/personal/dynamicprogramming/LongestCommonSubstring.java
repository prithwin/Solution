package com.personal.dynamicprogramming;

import com.personal.util.Print2DMatrix;

/**
 * Created by pr250155 on 4/28/17.
 * ABCDTOPAZISALOZEREFGH and BTOPAZID
 *     A B C D T O P A Z I S A L O Z E R E F G H
 *
 * B   0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * T   0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * O   0 0 0 0 0 2 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0
 * P   0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * A   1 0 0 0 0 0 0 4 0 0 0 1 0 0 0 0 0 0 0 0 0
 * Z   0 0 0 0 0 0 0 0 5 0 0 0 0 0 1 0 0 0 0 0 0
 * D   0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */
public class LongestCommonSubstring {

    class Answer {
        int length;
        String answer;
    }

    public Answer getLongestCommonSubstringDetails(String thiz, String thatj) {

        int[][] substringRegistry = new int[thiz.length()][thatj.length()];
        int longestSubstring = Integer.MIN_VALUE;

        int longestJ = 0;

        for(int i = 0 ; i < substringRegistry.length ; i++) {
            for (int j = 0; j < substringRegistry[i].length; j++) {
                if(i == 0 || j == 0) {
                    if(thiz.charAt(i) == thatj.charAt(j)) {
                        substringRegistry[i][j] = 1;
                    }
                } else {
                    if(thiz.charAt(i) == thatj.charAt(j)) {
                        int currentMax = substringRegistry[i-1][j-1] + 1;

                        if(currentMax > longestSubstring){
                            longestSubstring = currentMax;
                            longestJ = j;
                        }
                        substringRegistry[i][j] = currentMax ;
                    }
                }

            }
        }
        Answer answer = new Answer();
        answer.length = longestSubstring;
        answer.answer = thatj.substring( longestJ - longestSubstring + 1 , longestJ + 1 );
        Print2DMatrix.print2dMatrix(substringRegistry);
        return answer;
    }

    public static void main(String[] args) {
        Answer answer = new LongestCommonSubstring().getLongestCommonSubstringDetails("GEEKSFORGEEKS","GEEKSQUIZ");
        System.out.printf("the longest substring is of size %d and is the string %s",answer.length,answer.answer);
    }
}
