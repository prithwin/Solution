package com.personal;

import com.personal.util.DisjointSet;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/16/17.
 */
public class DisjointSetTest {
    @Test public void testDisjointSetFunctionality() {
        DisjointSet set = new DisjointSet(5);
        set.union(0,1);
        assertEquals(set.find(0),set.find(1));
        assertNotEquals(set.find(0),set.find(2));
        set.union(1,2);
        assertEquals(set.find(0),set.find(2));
    }
}
