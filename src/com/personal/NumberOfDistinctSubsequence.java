package com.personal;

import com.personal.util.MatrixUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by prajeeva on 7/14/17.
 */
    public class NumberOfDistinctSubsequence {

    public int numDistinct(String thiz, String that) {
        if(thiz.length() < that.length()) return 0;
        if(that.length() == 0) {
            return 1;
        }
        if(thiz.charAt(0) == that.charAt(0)) {
            return numDistinct(thiz.substring(1) , that.substring(1)) + numDistinct(thiz.substring(1),that);
        } else {
            return numDistinct(thiz.substring(1),that);
        }
    }

    public int numDistinctDp(String thiz , String that) {
        int[][] result = new int[thiz.length() + 1][that.length() + 1];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {

                if (thiz.charAt(i - 1) == that.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[thiz.length()][that.length()];
    }

    public int numDistinctBf(String thiz ,String that) {
        PermutationsAndCombinations<String> pc = new PermutationsAndCombinations<>();
        //pc.P(Arrays.asList("r","a","b","b","b","i","t"), 6).parallelStream().map();

        return 0;
    }


}
