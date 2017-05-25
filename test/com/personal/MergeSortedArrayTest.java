package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class MergeSortedArrayTest {
    @Test public void testMerge() {
        int[] thisz = {1,3,5,7,9};
        int[] that  = {2,4,6,8,10};
        for(int item : new MergeSortedArray().mergeSortedArray(thisz,that)){
            System.out.println(item);
        }
    }
}
