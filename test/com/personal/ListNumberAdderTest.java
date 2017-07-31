package com.personal;

import com.personal.util.*;
import com.personal.util.LinkedList;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/12/17.
 */
public class ListNumberAdderTest {
    @Test
    public void testAddTwoNumbers() throws Exception {
        int[] a1 = {1,2,3,4};
        com.personal.util.LinkedList list1 = new LinkedList(a1);

        int[] a2 = {1,1,1,1};
        com.personal.util.LinkedList list2 = new LinkedList(a2);
        System.out.println(new ListNumberAdder().addTwoNumbers(list1.head,list2.head));
    }

    @Test
    public void testAddTwoNumbersL() throws Exception {
        int[] a1 = {1,8};
        com.personal.util.LinkedList list1 = new LinkedList(a1);

        int[] a2 = {0};
        com.personal.util.LinkedList list2 = new LinkedList(a2);
        System.out.println(new ListNumberAdder().addTwoNumbersL(list1.head,list2.head));
    }

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
