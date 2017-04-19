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
        int moveNum = 0;
        chessBoard[0][0] = moveNum;
        //creating a list of possible moves
        List<Move> moves = Arrays.asList(new Move(1, 2),
                new Move(2, 1),
                new Move(1, -2),
                new Move(-2, 1),
                new Move(-1, 2),
                new Move(2, -1),
                new Move(-1, -2),
                new Move(-2, -1));
        moveKnight(chessBoard, moves, 0, 0, 0);
        Print2DMatrix.print2dMatrix(chessBoard);
    }

    private static void moveKnight(int[][] chessBoard, List<Move> moves, int moveNum, int currI, int currJ) {
        if(moveNum < 63 && noSafeMoves(chessBoard,currI,currJ,moves,moveNum)){
            //backtrack
            return;
        }
        if(moveNum == 63 && noSafeMoves(chessBoard,currI,currJ,moves,moveNum)){
            Print2DMatrix.print2dMatrix(chessBoard);
            return;
        }
        chessBoard[currI][currJ] = moveNum;
            for (int i = 0; i < moves.size(); i++) {
                Move currentMove = moves.get(i);
                int nextMove=moveNum+1;
                if (isSafeMove(currentMove, chessBoard, currI, currJ, nextMove)) {
                    moveKnight(chessBoard, moves, nextMove, currI+currentMove.i, currJ+currentMove.j);
                }
            }

    }

    private static boolean noSafeMoves(int[][] chessBoard, int currI, int currJ, List<Move> moves,int moveNum) {
        for(Move move : moves){
            if(isSafeMove(move,chessBoard,currI,currJ,moveNum+1)){
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeMove(Move move, int[][] chessBoard, int currI, int currJ,int moveNum) {
        int newI = currI + move.i;
        int newJ = currJ + move.j;

        if(newI > 7 || newJ > 7){
            return false;
        }
        if(newI < 0 || newJ < 0){
            return false;
        }
        if(chessBoard[newI][newJ] == 0){
            return true;
        }
        if (chessBoard[newI][newJ]<moveNum) {
            return false;
        }
        return true;
    }

}