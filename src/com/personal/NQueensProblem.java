package com.personal;

import com.personal.util.Print2DMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 4/26/17.
 */
public class NQueensProblem {
    public static void main(String[] args) {
        int N = 8;
        int[][] chessBoard = new int[N][N];
        for(int i = 0 ; i < chessBoard.length ; i++ ) {
            for(int j = 0 ; j < chessBoard[i].length ; j++ ) {
                chessBoard[i][j] = 1;
                new NQueensProblem().placeNQueens(chessBoard, N-1);
                Print2DMatrix.clearMatrix(chessBoard);
            }
        }
    }

    class Spot {
        int i;
        int j;

        public Spot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void placeNQueens(int[][] chessBoard, int numberRemaining) {
        if(numberRemaining == 0){
            Print2DMatrix.print2dMatrix(chessBoard);
            return;
        }

        if (numberRemaining>0 && getFreeSpots(chessBoard).size() == 0) {
            return;
        }
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] != 1) {

                        if (clearLengthwise(i, j, chessBoard) &&
                                clearWidthWise(i, j, chessBoard) &&
                                clearOnCross(i, j, chessBoard)) {

                            chessBoard[i][j] = 1;
                            placeNQueens(chessBoard, numberRemaining - 1);
                        }
                    }

                }
            }

    }

    private List<Spot> getFreeSpots(int[][] chessBoard) {
        List<Spot> returnList = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if(chessBoard[i][j] != 1) {
                    if (clearLengthwise(i, j, chessBoard) &&
                            clearWidthWise(i, j, chessBoard) &&
                            clearOnCross(i, j, chessBoard)) {

                        Spot spot = new Spot(i, j);
                        returnList.add(spot);
                    }
                }
            }
        }
        return returnList;
    }

    private boolean clearOnCross(int currI, int currJ, int[][] chessBoard) {
        int tlI = currI - 1;
        int tlJ = currJ - 1;

        int trI = currI - 1;
        int trJ = currJ + 1;

        int blI = currI + 1;
        int blJ = currJ - 1;

        int brI = currI + 1;
        int brJ = currJ + 1;

        while(inBounds(tlI,tlJ,chessBoard) || inBounds(trI,trJ,chessBoard) || inBounds(brI,brJ,chessBoard) || inBounds(blI,blJ,chessBoard)){

            if(inBounds(tlI,tlJ,chessBoard) && chessBoard[tlI][tlJ] == 1){
                return false;
            }
            if(inBounds(trI,trJ,chessBoard) && chessBoard[trI][trJ] == 1){
                return false;
            }
            if(inBounds(blI,blJ,chessBoard) && chessBoard[blI][blJ] == 1){
                return false;
            }
            if(inBounds(brI,brJ,chessBoard) && chessBoard[brI][brJ] == 1){
                return false;
            }

            tlI--;tlJ--;
            trI--;trJ++;
            blI++;blJ--;
            brI++;brJ++;
        }

        return true;
    }

    private boolean inBounds(int i, int j,int[][] chessBoard) {
        if(i < 0 || i > chessBoard.length - 1 ){
            return  false;
        }
        if(j < 0 || j > chessBoard[i].length - 1) {
            return false;
        }
        return true;
    }

    private boolean clearWidthWise(int currI, int currJ, int[][] chessBoard) {
        for(int j=0; j<chessBoard[currI].length ;j++){
            if(j!=currJ && chessBoard[currI][j] == 1){
                return false;
            }
        }
        return true;
    }

    private boolean clearLengthwise(int currI, int currJ, int[][] chessBoard) {
        for(int i=0; i<chessBoard.length ;i++){
            if(i!=currI && chessBoard[i][currJ] == 1){
                return false;
            }
        }
        return true;
    }

}
