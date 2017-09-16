package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/14/17.
 */
public class ThirdLargestNumberTest {
    @Test
    public void testThirdMax() throws Exception {
        int[] target = {3,2,1};
        System.out.println(new ThirdLargestNumber().thirdMax(target));
    }

}