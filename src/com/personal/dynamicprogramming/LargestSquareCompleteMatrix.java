package com.personal.dynamicprogramming;

import com.personal.util.CustomStringUtils;
import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

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

    public int maximalSquare(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] resultMatrix = new int[matrix.length][matrix[0].length ];

        for(int i = 0 ; i < matrix.length ; i++) {
            for( int j = 0 ; j < matrix[i].length ; j++) {
                if(i == 0 || j == 0) {
                    resultMatrix[i][j] = Integer.parseInt(matrix[i][j]+"");
                    max = Math.max(resultMatrix[i][j] , max);
                    continue;
                }
                if(matrix[i][j] == '1') {
                    resultMatrix[i][j] = 1 + Math.min( resultMatrix[i -1][j] ,
                            Math.min(resultMatrix[i -1][j -1] , resultMatrix[i][j-1]));
                    max = Math.max(resultMatrix[i][j] , max);
                }
            }
        }
        return max;
    }
}
