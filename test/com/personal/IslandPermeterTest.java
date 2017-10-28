package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 10/21/17.
 */
public class IslandPermeterTest {
    @Test
    public void testIslandPerimeter() throws Exception {
        int[][] input = {{0,1,0,0},
                         {1,1,1,0},
                         {0,1,0,0},
                         {1,1,0,0}};
        System.out.println(new IslandPermeter().islandPerimeter(input));
    }
    @Test
    public void testIslandPerimeter2() throws Exception {
        int[][] input = {{1}};
        System.out.println(new IslandPermeter().islandPerimeter(input));
    }
}