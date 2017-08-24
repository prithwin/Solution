package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

/**
 * Created by prajeeva on 7/4/17.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        if(word1.charAt(0) != word2.charAt(0)) {
            return 1+ Math.min(
                        minDistance(word1.substring(1) , word2.substring(1)) ,
                        Math.max(minDistance(word1 , word2.substring(1)) , minDistance(word1.substring(1) , word2))
                    );
        } else {
            return minDistance(word1.substring(1) , word2.substring(1));
        }
    }

    public int getEditDistanceRR(String thiz , String that) {
        if(thiz.length() == 0) return that.length();
        if(that.length() == 0) return thiz.length();
        if(thiz.charAt(0) == that.charAt(0)) {
            return getEditDistanceRR(thiz.substring(1), that.substring(1));
        } else {
            return 1 + Mathematical.min(getEditDistanceRR(thiz,that.substring(1)),
                                Mathematical.min(getEditDistanceRR(thiz.substring(1) , that),
                                        getEditDistanceRR(thiz.substring(1),that.substring(1))
                                )
            );
        }
    }

    public int getEditDistance(String thiz , String that) {
        int[][] results = new int[thiz.length()+1][that.length()+1];
        for(int i = 0 ; i < results.length ; i++) {
            for( int j = 0 ; j < results[i].length ; j++) {
                if(i == 0) {results[i][j] = j;continue;}
                if(j == 0) {results[i][j] = i;continue;}

                if(thiz.charAt(i-1) == that.charAt(j-1)) {
                    results[i][j] = results[i-1][j-1];
                } else {
                    results[i][j] = 1 + (Mathematical.min(
                                        results[i-1][j],
                                                    Mathematical.min(results[i][j-1] ,
                                                            results[i-1][j-1])
                    ));
                }
            }
        }
        MatrixUtil.print2dMatrix(results);
        return results[thiz.length()][that.length()];
    }
}
