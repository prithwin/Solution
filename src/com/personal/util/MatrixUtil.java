package com.personal.util;

import com.personal.SudoKuSolver;

import java.util.List;
import java.util.ArrayList;

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

    public static void print2dMatrix(char[][] matrix){
        System.out.println();
        for(int i = 0; i< matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                System.out.printf(" %c  ",matrix[i][j]);
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    public static void spiralPrint(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[i].length ; j++) {
                if(i %2 == 0) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][matrix[i].length - j - 1]);
                }
            }
            System.out.println();
        }
    }

    /**
     *  [i][j]...........[j][i - N - 1]
     *    .                      .
     *    .                      .
     *    .                      .
     *  [j - M - 1][i]...[i - M - 1][j - N - 1]
     *
     * @param matrix
     * @return
     */
    public static List<Integer> conchPrint(int[][] matrix ) {
        List<Integer> response = new ArrayList<>();
        conchPrintInternal(matrix , response);
        return response;

    }

    private static void conchPrintInternal(int[][] matrix, List<Integer> response) {
        if(matrix == null) return;
        if(matrix.length == 0) return;
        if(matrix.length == 1) {
            if(matrix[0] == null || matrix[0].length == 0) return;
            for(int i = 0 ; i < matrix[0].length ; i++) {
                response.add(matrix[0][i]);
            }
            return;
        }

        if(matrix[0].length == 1) {
            for(int i = 0 ; i < matrix.length ; i++) {
                response.add(matrix[i][0]);
            }
            return;
        }
        for(int i =  0 ; i < matrix[0].length -1 ; i++) {
            response.add(matrix[0][i]);
        }

        for(int i = 0 ; i < matrix.length -1 ; i++) {
            response.add(matrix[i][matrix[0].length-1]);
        }

        for(int i = matrix[0].length - 1 ; i >0 ; i--) {
            response.add(matrix[matrix.length -1][i]);
        }

        for(int i = matrix.length - 1 ; i >0 ; i--) {
            response.add(matrix[i][0]);
        }

        if(matrix.length > 2 && matrix[0].length > 2) {
            int[][] future = new int[matrix.length -2][matrix[0].length - 2];
            for(int i = 1 ; i <= matrix.length - 2 ; i++) {
                for(int j = 1 ; j <= matrix[i].length - 2 ; j++) {
                    future[i - 1][j - 1] = matrix[i][j];
                }
            }
            conchPrintInternal(future , response);
        }
    }

    /**
     * 1
     * 23
     * 456
     * 78910
     */
    public static void printTreeNumber(boolean nSquare) {
        if(nSquare) {
            int s = 3;
            int n = 1;
            for (int number = 1; number <= 10; ) {
                for (int j = 0; j < n; j++) {
                    System.out.printf(" %d ", number++);
                }
                for (int k = 0; k < s; k++) {
                    System.out.print("   ");
                }
                s--;
                n++;
                System.out.println();
            }
        }
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

    public static boolean isEqual(int[][] thiz, int[][] that) {
        if(thiz.length != that.length) return false;
        for(int i = 0 ; i < thiz.length ; i++) {
            if(thiz[i].length != that[i].length) return false;
            for(int j = 0 ; j < thiz[i].length ;j++) {
                if(thiz[i][j] != that[i][j])
                    return false;
            }
        }
        return true;
    }
}
