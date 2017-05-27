package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/27/17.
 */
public class RotateArrayTest {
    @Test public void testRotation(){
        int[] target= {1,2,3,4,5};
        new ArrayRotate().rotateLeft(target,3);
        new ArrayRotate().rotateRight(target,3);
        for(int item : target) {
            System.out.println(item);
        }
    }
}
