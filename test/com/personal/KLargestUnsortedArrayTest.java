package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/10/17.
 */
public class KLargestUnsortedArrayTest {
    @Test public void find3rdLargest() {
        int[] target = {5,34,7,89,677,90,12,1,3};
        System.out.print(new KLargestUnsortedArray().findKthLargestInArray(target,3));
    }
}
