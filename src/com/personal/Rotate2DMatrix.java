package com.personal;

import com.personal.util.MatrixUtil;

/**
 * Created by pr250155 on 4/10/17.
 */
public class Rotate2DMatrix {
    public void inPlaceRotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0 ; i < n/2  ; i++){
            for(int j = i; j< n-1-i ; j++){
                //store the top in a temp array
                int temp = matrix[i][j];

                //move the left to the top
                matrix[i][j] = matrix[n-1-j][i];

                //move the bottom to the left
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                //move the right to the bottom
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];

                //assign temp to right
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
