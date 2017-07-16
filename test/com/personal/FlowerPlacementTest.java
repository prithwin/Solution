package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class FlowerPlacementTest {

    @Test
    public void testCanPlaceFlowers() throws Exception {
        int[] target = {1,0,0,0,1};
        System.out.println(new FlowerPlacement().canPlaceFlowers(target , 2));
    }

}