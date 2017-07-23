package com.personal;

/**
 * Created by prajeeva on 7/16/17.
 */
public class MatrixMinPath {

    public int minPathSum(int[][] m) {
        for(int i = 0 ; i < m.length ; i++) {
            for(int j = 0 ; j < m[i].length ; j++) {
                if(i + j == 0) continue;
                if(i == 0) {m[i][j] += m[i][j-1];continue;}
                if(j == 0) {m[i][j] += m[i - 1][j];continue;}
                m[i][j] += Math.min(m[i - 1][j] , m[j][i-1]);
            }
        }
        return m[m.length - 1][m[m.length - 1].length - 1];
    }
}
