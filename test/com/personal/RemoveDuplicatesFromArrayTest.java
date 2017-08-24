package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 8/4/17.
 */
public class RemoveDuplicatesFromArrayTest {
    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] array = {1,1,1,1,2,2,2,2,2,3,4,5,5};
        System.out.println(new RemoveDuplicatesFromArray().removeDuplicates(array));
        for(int i : array) {
            System.out.println(i);
        }
    }

}