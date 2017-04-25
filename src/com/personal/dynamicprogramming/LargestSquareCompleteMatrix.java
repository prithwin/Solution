package com.personal.dynamicprogramming;

import com.personal.util.CustomStringUtils;
import com.personal.util.Mathematical;

/**
 * Created by pr250155 on 4/21/17.
 */
public class LargestSquareCompleteMatrix {

    public void findLargetCompleteMatrix(int[][] target) {
        class Result {
            int startPointX;
            int startPointY;
            int size = Integer.MIN_VALUE;
        }
        Result result = new Result();

        int[][] resultMatrix = new int[target.length][target[0].length];
        for ( int i = 0 ; i < resultMatrix.length ; i++ ) {
            for ( int j = 0 ; j < resultMatrix[i].length ; j++ ) {
                if(i == 0 || j==0) {
                    //copy the first row as is
                    resultMatrix[i][j] = target[i][j];
                }
                 else if(target[i][j] == 0) {
                    //there are no square matrices ending here
                    resultMatrix[i][j] = target[i][j];
                }
                else if(target[i][j] == 1) {
                    if(i == 4 && j == 2){
                        System.out.println();
                    }
                    resultMatrix[i][j] = 1+ (Mathematical.min(
                                                    Mathematical.min(resultMatrix[i-1][j],
                                                            resultMatrix[i][j-1])
                            ,resultMatrix[i-1][j-1]));
                    if(resultMatrix[i][j] > result.size) {
                        result.size = resultMatrix[i][j];
                        result.startPointX = (i+1) - result.size;
                        result.startPointY = (j+1) - result.size;
                    }
                }
            }
        }
        System.out.printf("the largest matrix is of size %d by %d which starts at %d,%d",result.size,result.size,result.startPointX,result.startPointY);

    }

    public static void main(String[] args) {
        int[][] matrix = { {0,1,1,0,1,0,0},
                           {0,1,0,1,0,1,0},
                           {0,1,1,1,1,0,0},
                           {0,1,1,1,0,1,0},
                           {0,1,1,1,1,0,0},
                           {0,0,0,0,0,0,0}
        };
        new LargestSquareCompleteMatrix().findLargetCompleteMatrix(matrix);
     }

    /**
     * Created by pr250155 on 4/2/17.
     */
    public static class LongestCommonSubsequenceProblem {
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
            String lcs = new CustomStringUtils().reverse2(new LongestCommonSubsequenceProblem().lcs("ABCDGHLQR","AEDPHR"));
            System.out.printf("the longest String is %s and its size is %d",lcs,lcs.length());
        }
    }
}
