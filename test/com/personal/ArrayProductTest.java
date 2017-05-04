package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by pr250155 on 5/4/17.
 */
public class ArrayProductTest {
    @Test
    public void testfunctionality() {
        int[] target = {1,2,3,4};
        int[] result = new ArrayProduct().computeProductArrayShort(target);
        for( int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    @Test
    public void testfunctionalitywithZero() {
        int[] target = {1,2,3,0};
        int[] result = new ArrayProduct().computeProductArrayShort(target);
        for( int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }
    @Test
    public void testfunctionalityWithLongListAndZeros() {
        int[] target = {1,2,3,5,7,-9};
        int[] result = new ArrayProduct().computeProductArrayShort(target);
        for( int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
