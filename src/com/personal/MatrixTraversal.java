package com.personal;

/**
 * Created by pr250155 on 4/14/17.
 */
public class MatrixTraversal {
    public int getNumberOfPaths(int[][] matrix, int starti, int startj) {
        if(matrix[starti][startj] == 0){
            return 0;
        }
        if(starti == matrix.length-1 && startj == matrix[starti].length-1){
            return 1;
        } else {
            int sum = 0;
            if(starti + 1 <= matrix.length-1 ){
                sum += getNumberOfPaths(matrix,starti+1,startj);
            }
            if(startj + 1 <= matrix[starti].length-1 ){
                sum += getNumberOfPaths(matrix,starti,startj+1);
            }
            return sum % (1000000007);
        }
    }
}
