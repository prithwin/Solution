package com.personal;

import com.personal.util.Print2DMatrix;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/18/17.
 * TODO:
 */
public class KnightsTour {

    static class Move {
        int i;
        int j;

        public Move(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        int moveNum = 1;
        chessBoard[0][0] = moveNum;

        //creating a list of possible moves
        List<Move> moves = Arrays.asList (
                new Move(1, 2),
                new Move(2, 1),
                new Move(1, -2),
                new Move(-2, 1),
                new Move(2, -1),
                new Move(-1, 2),
                new Move(-1, -2),
                new Move(-2, -1)
        );
        moveKnight(chessBoard, moves, moveNum + 1, 0, 0);
        Print2DMatrix.print2dMatrix(chessBoard);
    }

    private static void moveKnight(int[][] chessBoard, List<Move> moves, int nextMove, int currI, int currJ) {

        if(nextMove <= 64 && noSafeMoves(chessBoard,currI,currJ,moves)){
            //wipe all move numbers higher than this dead move
            if(nextMove == 64) {
                System.out.printf("");
            }
            Print2DMatrix.print2dMatrix(chessBoard);
            System.out.println(nextMove + " cannot be done from  "+currI+","+currJ);
            System.out.println("backtracking and clearing "+ (nextMove -1) + "onwards");
            Print2DMatrix.clearNumbersHigherThan(nextMove - 1, chessBoard);
            Print2DMatrix.print2dMatrix(chessBoard);
            return;
        }
        if(nextMove == 65) {
            Print2DMatrix.print2dMatrix(chessBoard);
            return;
        }
            for (int i = 0 ; i < moves.size() ; i++) {
                Move currentMove = moves.get(i);
                if (isSafeMove(currentMove, chessBoard, currI, currJ)) {
                    chessBoard[currI+currentMove.i][currJ+currentMove.j] = nextMove;
                    moveKnight(chessBoard, moves, nextMove + 1, currI+currentMove.i, currJ+currentMove.j);
                }
            }
            Print2DMatrix.clearNumbersHigherThan(nextMove -1  ,chessBoard);

    }

    private static boolean noSafeMoves(int[][] chessBoard, int currI, int currJ, List<Move> moves) {
        for(Move move : moves){
            if( isSafeMove(move,chessBoard,currI,currJ)){
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeMove(Move move, int[][] chessBoard, int currI, int currJ) {

        int newI = currI + move.i;
        int newJ = currJ + move.j;

        if(newI > 7 || newJ > 7){
            return false;
        }
        if(newI < 0 || newJ < 0){
            return false;
        }
        if(chessBoard[newI][newJ] == 0){
            //has not been here
            return true;
        }
        return false;
    }

}