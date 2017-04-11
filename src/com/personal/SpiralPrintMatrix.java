package com.personal;

import com.personal.util.Print2DMatrix;

/**
 * Created by pr250155 on 4/10/17.
 */
public class SpiralPrintMatrix {
    public static void spiralPrintMatrix(int[][] matrix){
        boolean flip = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(!flip){
                    System.out.printf("  %d  ",matrix[i][j]);
                } else {
                    System.out.printf("  %d  ",matrix[i][matrix[i].length -1 - j]);
                }
            }
            flip = !flip;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},                             //1
                {6, 7, 8, 9, 10},                            //2
                {11,12,13,14,15},                            //3
                {16,17,18,19,20},                            //4
                {21,22,23,24,25}};                           //5
        Print2DMatrix.print2dMatrix(matrix);
        System.out.println();
        spiralPrintMatrix(matrix);
    }
}
