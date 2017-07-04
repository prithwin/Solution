package com.personal;

import com.personal.util.MatrixUtil;

/**
 * Created by prajeeva on 7/4/17.
 */
public class Crossword {

    private char[][] matrix;
    private boolean found;

    public boolean findWordInMatrix(String word){
        MatrixUtil.print2dMatrix(matrix);
        boolean found = false;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[i].length ; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    found = findWordInMatrixInternal(word, i, j);
                    if(found) return true;
                }
            }
        }
        return found;
    }

    private boolean findWordInMatrixInternal(String word , int startX , int startY) {
        if(startX <0 || startX > matrix.length - 1) return false;
        if(startY < 0 || startY > matrix[startX].length -1) return false;
        if(word.length() == 0) {
            //found the end of the matrix
            this.found = true;
            return true;
        }
        if(matrix[startX][startY] != word.charAt(0)) return false;
        boolean found  = false;
        if(!found && startX > 0 && word.charAt(0) == matrix[startX][startY]) {
            found = findWordInMatrixInternal(word.substring(1),startX - 1, startY);
        }
        if(!found && startY > 0 && word.charAt(0) == matrix[startX][startY] ) {
            found = findWordInMatrixInternal(word.substring(1), startX, startY - 1);
        }
        if(!found && startX < matrix.length - 1  && word.charAt(0) == matrix[startX][startY]) {
            found = findWordInMatrixInternal(word.substring(1), startX + 1, startY);
        }
        if(!found && startY < matrix[startX].length && word.charAt(0) == matrix[startX][startY]) {
            found = findWordInMatrixInternal(word.substring(1), startX, startY + 1);
        }
        if(found) return true;
        return false;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
