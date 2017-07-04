package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/3/17.
 */
public class DividesByTreeTest {

    @Test
    public void testGetNumber() throws Exception {
        int[] target = {1, 5, 7, 2, 9, 14};
        System.out.println(new DividesByTree().getNumber(target));
    }
}