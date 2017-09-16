package com.personal;

import com.personal.util.MatrixUtil;

/**
 * Created by prajeeva on 9/13/17.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];

        for(int i = 0 ; i < M.length ; i++) {
            for(int j = 0 ; j < M[i].length ; j++) {
                int sum = 0 ;
                sum += value(i , j  ,M );
                sum += value(i-1 , j -1  ,M );
                sum += value(i , j - 1  ,M );
                sum += value(i + 1 , j -1  ,M );
                sum += value(i-1 , j  ,M );
                sum += value(i+1 , j  ,M );

                sum += value(i -1 , j + 1  ,M );
                sum += value(i , j + 1  ,M );
                sum += value(i + 1 , j +1  ,M );
                result[i][j] = sum / count(M , i , j );
            }
        }
        return result;
    }

    private int value(int i , int j , int[][] matrix) {
        if(i < 0 || j < 0 || i> matrix.length-1 ||j > matrix[i].length - 1) return 0;
        return matrix[i][j];
    }

    private int count(int[][] matrix , int i , int j) {
        if((i == 0 && j ==0) || (i == 0 && j== matrix[i].length - 1) || (i == matrix.length - 1 && j == 0) || (i == matrix.length - 1 && j == matrix[i]. length - 1)) {
            if(matrix.length == 1 || matrix[i].length == 1){return 2;
            }
            return 4;
        }
        if(i == 0 || j== 0 || i == matrix.length -1 || j == matrix[i].length - 1) return 6;
        return 9;
    }
}
