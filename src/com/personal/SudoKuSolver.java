package com.personal;

import com.personal.util.FixedPoint;
import com.personal.util.MatrixUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pr250155 on 5/22/17.
 */
public class SudoKuSolver {

    public static void solve(int[][] puzzle) {
        List<FixedPoint> fixedElements = scanForFixedElements(puzzle);
        FixedPoint startPoint = new FixedPoint(0,0);
        solveInternal(puzzle,startPoint,fixedElements);

    }

    private static boolean solveInternal(int[][] puzzle, FixedPoint startPoint, List<FixedPoint> fixedElements) {
        if(startPoint.x > 8) {MatrixUtil.print2dMatrix(puzzle,fixedElements); return true;}
        if(fixedElements.contains(startPoint)) {
            FixedPoint newStartPoint = new FixedPoint(startPoint.x , startPoint.y+1);
            return solveInternal(puzzle,newStartPoint,fixedElements);

        } else {

            for(int i = 1 ; i < 10 ; i++) {
                if (isSafeNumber(i, startPoint, puzzle)) {
                    puzzle[startPoint.x][startPoint.y] = i;
                    FixedPoint newStartPoint = new FixedPoint(startPoint.x, startPoint.y + 1);
                    boolean worked = solveInternal(puzzle, newStartPoint, fixedElements);
                    if(!worked) {
                        wipeMistakes(puzzle, startPoint, fixedElements);
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static void wipeMistakes(int[][] puzzle, FixedPoint startPoint, List<FixedPoint> fixedElements) {
        for(int i = startPoint.x ; i < puzzle.length ; i++) {
            for(int j = startPoint.y ; j < puzzle[i].length ; j++) {
                FixedPoint fp = new FixedPoint(i,j);
                if(!fixedElements.contains(fp)) {
                    puzzle[i][j] = 0;
                }
            }
        }
    }

    private static boolean isSafeNumber(int number, FixedPoint atPoint, int[][] puzzle) {
        //check in the same i
        for(int i = 0 ; i < puzzle.length ; i++) {
            if(puzzle[i][atPoint.y] == number){
                return false;
            }
        }
        for(int j = 0 ; j < puzzle[atPoint.x].length ; j++ ){
            if(puzzle[atPoint.x][j] == number){
                return false;
            }
        }
        FixedPoint subSquareStart = getSubsquareStart(atPoint);
        for(int i = subSquareStart.x ; i < subSquareStart.x + 3 ; i++ ) {
            for(int j = subSquareStart.y; j < subSquareStart.y + 3 ; j++) {
                if(puzzle[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static FixedPoint getSubsquareStart(FixedPoint atPoint) {
        FixedPoint point = new FixedPoint(0,0);
        if(atPoint.x>=0 && atPoint.x<=2){
            point.x = 0;
        } else if(atPoint.x>=3 && atPoint.x<=5){
            point.x = 3;
        } else {
            point.x = 6;
        }

        if(atPoint.y>=0 && atPoint.y<=2){
            point.y = 0;
        } else if(atPoint.y>=3 && atPoint.y<=5){
            point.y = 3;
        } else {
            point.y = 6;
        }
        return point;
    }

    private static List<FixedPoint> scanForFixedElements(int[][] puzzle) {
        List<FixedPoint> fixedElements = new ArrayList<>();

        for(int i = 0 ; i < puzzle.length ; i++) {
            for(int j = 0 ; j < puzzle[i].length ; j++) {
                if(puzzle[i][j] != 0) {
                    FixedPoint fp = new FixedPoint(i,j);
                    fixedElements.add(fp);
                }
            }
        }
        return fixedElements;
    }
}


