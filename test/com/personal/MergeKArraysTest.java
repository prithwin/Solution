package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 11/5/17.
 */
public class MergeKArraysTest {
    @Test
    public void testMergeKLists() throws Exception {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        ListNode var  = new MergeKArrays().mergeKLists(new ListNode[] {l1.head,l2.head});
        System.out.println(var);
    }

}