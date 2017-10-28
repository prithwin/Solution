package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajeeva on 10/21/17.
 */
public class IslandPermeter {
    public int islandPerimeter(int[][] grid) {
        int sides = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {

                if(grid[i][j] == 1) {
                    if(i==0 || grid[i-1][j] == 0) sides++;
                    if(j==0 || grid[i][j-1] == 0) sides++;
                    if(i == grid.length-1 || grid[i+1][j] == 0) sides++;
                    if(j == grid[i].length-1 || grid[i][j+1] == 0) sides++;
                }

            }
        }
        return sides;
    }
}


