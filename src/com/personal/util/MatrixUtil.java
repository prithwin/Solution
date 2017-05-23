package com.personal.util;

import com.personal.SudoKuSolver;

import java.util.List;

/**
 * Created by pr250155 on 4/10/17.
 */
public class MatrixUtil {
    public static void print2dMatrix(int[][] matrix){
        System.out.println();
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                System.out.printf(" %d  ",matrix[i][j]);
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    public static void print2dMatrix(int[][] matrix,List<FixedPoint> fixedPoints){
        System.out.println();
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                if(fixedPoints.contains(new FixedPoint(i,j))) {
                    System.out.printf(" %d*  ", matrix[i][j]);
                } else {
                    System.out.printf(" %d   ", matrix[i][j]);
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    public static void clearNumbersHigherThan(int moveNum, int[][] matrix) {
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] >= moveNum){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void addKnightToFinalSpot(int[][] matrix,int lastMove) {
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = lastMove;
                }
            }
        }
    }

    public static void clearMatrix(int[][] matrix) {
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                matrix[i][j] = 0;
            }
        }
    }
}
