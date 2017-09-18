package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/17/17.
 */
public class PalindromicPartitionTest {
    @Test
    public void testPartition() throws Exception {
        System.out.println(new PalindromicPartition().partition("aaaaaaaa"));
    }

}