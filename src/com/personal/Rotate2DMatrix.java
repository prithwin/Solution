package com.personal;

import com.personal.util.Print2DMatrix;

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


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},                             //1
                          {6, 7, 8, 9, 10},                            //2
                          {11,12,13,14,15},                            //3
                          {16,17,18,19,20},                            //4
                          {21,22,23,24,25}};                           //5
        Print2DMatrix.print2dMatrix(matrix);
        new Rotate2DMatrix().inPlaceRotate(matrix);
        System.out.println();
        Print2DMatrix.print2dMatrix(matrix);

    }
}
