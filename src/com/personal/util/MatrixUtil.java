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
