package com.personal;

import com.personal.util.MatrixUtil;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/22/17.
 */
public class SudokuSolverTest {
    @Test public void testSudoKuSolver() {
        int[][] puzzle = {{1 , 5 , 0 ,   0, 7 , 0 ,   0 , 0 , 0},
                          {7 , 0 , 0 ,   4, 3 , 0 ,   5 , 6 , 0},
                          {0 , 0 , 4 ,   0, 5 , 6 ,   8 , 7 , 1},

                          {0 , 0 , 9 ,   7, 4 , 0 ,   0 , 0 , 6},
                          {6 , 0 , 0 ,   0, 2 , 0 ,   0 , 0 , 5},
                          {5 , 0 , 0 ,   0, 6 , 3 ,   9 , 0 , 0},

                          {8 , 1 , 5 ,   3, 9 , 0 ,   6 , 0 , 0},
                          {0 , 6 , 7 ,   0, 8 , 2 ,   0 , 0 , 3},
                          {0 , 0 , 0 ,   0, 1 , 0 ,   0 , 5,  8}};
        SudoKuSolver.solve(puzzle);
    }


    @Test public void testSudoKuSolver2() {
        int[][] puzzle =   {{3 , 0 , 6 ,   5, 0 , 8 ,   4 , 0 , 0},
                            {5 , 2 , 0 ,   0, 0 , 0 ,   0 , 0 , 0},
                            {0 , 8 , 7 ,   0, 0 , 0 ,   0 , 3 , 1},

                            {0 , 0 , 3 ,   0, 1 , 0 ,   0 , 8 , 0},
                            {9 , 0 , 0 ,   8, 6 , 3 ,   0 , 0 , 5},
                            {0 , 5 , 0 ,   0, 9 , 0 ,   6 , 0 , 0},

                            {1 , 3 , 0 ,   0, 0 , 0 ,   2 , 5 , 0},
                            {0 , 0 , 0 ,   0, 0 , 0 ,   0 , 7 , 4},
                            {0 , 0 , 5 ,   2, 0 , 6 ,   3 , 0 , 0}};
        SudoKuSolver.solve(puzzle);
    }


    @Test public void testSudoKuSolver3() {
        int[][] puzzle =   {{8 , 0 , 0 ,   0, 0 , 0 ,   0 , 0 , 0},
                            {0 , 0 , 3 ,   6, 0 , 0 ,   0 , 0 , 0},
                            {0 , 7 , 0 ,   0, 9 , 0 ,   2 , 0 , 0},

                            {0 , 5 , 0 ,   0, 0 , 7 ,   0 , 0 , 0},
                            {0 , 0 , 0 ,   0, 4 , 5 ,   7 , 0 , 0},
                            {0 , 0 , 0 ,   1, 0 , 0 ,   3 , 0 , 0},

                            {0 , 0 , 1 ,   0, 0 , 0 ,   0 , 6 , 8},
                            {0 , 0 , 8 ,   5, 0 , 0 ,   0 , 1 , 0},
                            {0 , 9 , 0 ,   0, 0 , 0 ,   4 , 0 , 0}};
        SudoKuSolver.solve(puzzle);
    }

    @Test public void testSudoKuSolver4() {
        int[][] puzzle = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},

                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},

                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        SudoKuSolver.solve(puzzle);
    }
}
