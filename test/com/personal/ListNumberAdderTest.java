package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/12/17.
 */
public class ListNumberAdderTest {
    @Test public void testNumberAdd1() {
       assertEquals(6912,new ListNumberAdder().add(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8)));
    }

    @Test public void testNumberAdd2() {
        assertEquals(2222,new ListNumberAdder().add(Arrays.asList(1,1,1,1),Arrays.asList(1,1,1,1)));
    }

    @Test public void testNumberAdd3() {
        assertEquals(1111+9999,new ListNumberAdder().add(Arrays.asList(1,1,1,1),Arrays.asList(9,9,9,9)));
    }
}
