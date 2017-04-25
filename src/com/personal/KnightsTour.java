package com.personal;

import com.personal.util.Print2DMatrix;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/18/17.
 * TODO: add greedyness by taking the path with the smallest number of possible Moves
 */
public class KnightsTour {

    public static final int BOARD_SIZE = 5;
    public static final int TOTAL_MOVES = BOARD_SIZE * BOARD_SIZE;
    public static final int MAX_INDEX = BOARD_SIZE - 1;

    static class Move {
        int i;
        int j;

        public Move(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int moveNum = 1;
        chessBoard[0][0] = moveNum;

        //creating a list of possible moves
        List<Move> moves = Arrays.asList (
                new Move(2, 1),
                new Move(1, 2),
                new Move(-2, 1),
                new Move(1, -2),
                new Move(-1, 2),
                new Move(-1, -2),
                new Move(2, -1),
                new Move(-2, -1)
        );
        moveKnight(chessBoard, moves, moveNum + 1, 0, 0);
    }

    private static void moveKnight(int[][] chessBoard, List<Move> moves, int nextMove, int currI, int currJ) {
        if(nextMove == TOTAL_MOVES && !noSafeMoves(chessBoard,currI,currJ,moves)){
            Print2DMatrix.addKnightToFinalSpot(chessBoard,TOTAL_MOVES);
            Print2DMatrix.print2dMatrix(chessBoard);
            return;
        }
        if(nextMove < TOTAL_MOVES && noSafeMoves(chessBoard,currI,currJ,moves)){
            //wipe all move numbers higher than this dead move
            Print2DMatrix.clearNumbersHigherThan(nextMove - 1, chessBoard);
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

        if(newI > MAX_INDEX || newJ > MAX_INDEX){
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