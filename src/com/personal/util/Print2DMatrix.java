package com.personal.util;

/**
 * Created by pr250155 on 4/10/17.
 */
public class Print2DMatrix {
    public static void print2dMatrix(int[][] matrix){
        System.out.println();
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                System.out.printf("    %d    ",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
