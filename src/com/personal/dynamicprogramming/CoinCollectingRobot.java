package com.personal.dynamicprogramming;

import com.personal.util.Mathematical;
import com.personal.util.MatrixUtil;

/**
 * Created by pr250155 on 5/3/17.
 *  1 2 3 4 5
 *  2 3 4 5 6
 *  3 4 5 6 7
 *  4 5 6 7 8
 */
public class CoinCollectingRobot {

    public int getHighestNumber(int[][] chessBoard) {
         for(int i = 0 ; i < chessBoard.length ;i++) {
             for(int j = 0 ; j < chessBoard[i].length ; j++) {
                 if(i == 0 && j == 0 )continue;
                 if(i == 0 ){
                     chessBoard[i][j] += chessBoard[i][j-1]; continue;
                 }
                 if(j == 0 ) {
                     chessBoard[i][j] += chessBoard[i-1][j]; continue;
                 }
                 chessBoard[i][j] += Mathematical.maximum(chessBoard[i-1][j],chessBoard[i][j-1]);
             }
         }
        MatrixUtil.print2dMatrix(chessBoard);
        return chessBoard[chessBoard.length-1][chessBoard[chessBoard.length-1].length-1];
     }
}
