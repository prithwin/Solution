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

    public int findSizeOfLongestPallindromicSubsequence(String s){
        int[][] r = new int[s.length()][s.length()];
        for(int i = 0 ; i < r.length ; i++) {
            int I = 0;
            for(int j = i ; j < r.length ; j++,I++) {
                if(I == j) {
                    r[I][j] = 1;
                } else {
                    if(s.charAt(I) == s.charAt(j)) {
                        r[I][j] = 2 + r[I+1][j-1];
                    } else {
                        r[I][j] = Math.max(r[I+1][j] , r[I][j-1]);
                    }
                }
            }
        }
        MatrixUtil.print2dMatrix(r);
        return r[0][s.length() -1 ];
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