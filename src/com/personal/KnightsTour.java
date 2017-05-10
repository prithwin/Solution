package com.personal;

import com.personal.util.MatrixUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/18/17.
 * let B[][] be the chess board
 * let M[] be the number of moves
 * Function moveKnight(B,i,j,n) {
 *     if(n = T-1 && !noSafeMoves){
 *         M[i][j] = T; return;
 *     }
 *     if(n < T-1 %% noSafeMoves) {
 *         clearMoves(B,n-1);
 *         return;
 *     }
 *     for(move m in M) {
 *         if isSafe(m) {
 *             moveKnight(B,i+m,j+m,n+1)
 *         }
 *     }
 *     clearMoves(B,n-1);
 * }
 */
public class KnightsTour {


    private static int BOARD_SIZE ;
    private static int TOTAL_MOVES;
    private static int MAX_INDEX;

    public static void setBoardSize(int boardSize) {
        KnightsTour.BOARD_SIZE = boardSize;
        KnightsTour.TOTAL_MOVES = BOARD_SIZE * BOARD_SIZE;
        KnightsTour.MAX_INDEX = BOARD_SIZE - 1;
    }

    static class Move {
        int i;
        int j;

        public Move(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void beginTour() {
        int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int moveNum = 1;
        chessBoard[0][0] = moveNum;

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
            MatrixUtil.addKnightToFinalSpot(chessBoard, TOTAL_MOVES);
            MatrixUtil.print2dMatrix(chessBoard);
            return;
        }
        if(nextMove < TOTAL_MOVES && noSafeMoves(chessBoard,currI,currJ,moves)){
            //wipe all move numbers higher than this dead move
            MatrixUtil.clearNumbersHigherThan(nextMove - 1, chessBoard);
            return;
        }
            for (int i = 0 ; i < moves.size() ; i++) {
                Move currentMove = moves.get(i);
                if (isSafeMove(currentMove, chessBoard, currI, currJ)) {
                    chessBoard[currI+currentMove.i][currJ+currentMove.j] = nextMove;
                    moveKnight(chessBoard, moves, nextMove + 1, currI+currentMove.i, currJ+currentMove.j);
                }
            }
            MatrixUtil.clearNumbersHigherThan(nextMove - 1, chessBoard);

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
            return true;
        }
        return false;
    }

}