package com.personal;

/**
 * Created by pr250155 on 4/14/17.
 */
public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1},                            //1
                          {1, 1, 1, 1, 1},                            //2
                          {1, 1, 1, 1, 1},                            //3
                          {1, 1, 1, 1, 1},                            //4
                          {1, 1, 1, 1, 1}};

        System.out.println(getNumberofPaths(matrix, 0, 0));
    }

    private static int getNumberofPaths(int[][] matrix, int starti, int startj) {
        if(matrix[starti][startj] == 0){
            return 0;
        }
        if(starti == matrix.length-1 && startj == matrix[starti].length-1){
            return 1;
        } else {
            int sum = 0;
            if(starti + 1 <= matrix.length-1 ){
                sum += getNumberofPaths(matrix,starti+1,startj);
            }
            if(startj + 1 <= matrix[starti].length-1 ){
                sum += getNumberofPaths(matrix,starti,startj+1);
            }
            return sum % (1000000007);
        }
    }
}
