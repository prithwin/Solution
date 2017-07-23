package com.personal;

import com.personal.util.MatrixUtil;

/**
 * Created by prajeeva on 7/16/17.
 */
public class RobotMatrixPaths {
    public int uniquePaths(int m, int n) {
        return computeM(m -1, n -1 , 0 , 0);
    }
//193536720
    private int compute(int M ,int N , int x , int y) {
        if(x == M && y == N) return 1;
        int sum = 0;
        if(x < M) sum += compute(M,N , x+1, y);
        if(y < N) sum += compute(M,N , x , y +1);
        return sum;
    }
//193536718
    private int computeM(int M ,int N , int x , int y) {
        int[][] c = new int[M + 1][ N + 1];
        for(int i = 0 ; i < c.length ; i++) {
            for(int j = 0 ; j < c[i].length ; j++) {
                if(i == 0) c[i][j] += 1;
                else if(j == 0) c[i][j] += 1;
                else c[i][j] += c[i][j - 1] + c[i -1][j];
            }
        }
        MatrixUtil.print2dMatrix(c);
        return c[M][N];
    }
}
