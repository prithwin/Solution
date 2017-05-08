package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/8/17.
 */
public class FindMissingNumberTest {
    @Test public void find5() {
        assertEquals(new FindMissingNumber().findMissingNumber(Arrays.asList(1, 2, 4, 6, 3, 7, 8)),5);
    }

    @Test public void find6() {
        assertEquals(new FindMissingNumber().findMissingNumber(Arrays.asList(1, 2, 4, 5, 3, 7, 8)),6);
    }
}
