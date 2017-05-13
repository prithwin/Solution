package com.personal;

/**
 * Created by pr250155 on 5/13/17.
 * find an element in a rowwise and column wise sorted matrix.
 */
public class MatrixSortedFind {
     public boolean findKeyInMatrix(int[][] matrix , int key) {
         for(int i = 0, j = 0 ; i < matrix.length && j< matrix.length  ; ) {
             if(matrix[i][j] == key) {
                 return true;
             }
             int rdiff = (j<matrix.length-1)?Math.abs(key-matrix[i][j+1]):Integer.MAX_VALUE;
             int ddiff = (i<matrix.length-1)?Math.abs(key-matrix[i+1][j]):Integer.MAX_VALUE;
             if(rdiff < ddiff) {
                 j++;
             } else {
                 i++;
             }
         }
         return false;
     }
}
