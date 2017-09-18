package com.personal;

import com.personal.util.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/17/17.
 */
public class ReverseLinkedListInKGroupsTest {
    @Test
    public void testReverseKGroup() throws Exception {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        n = new ReverseLinkedListInKGroups().reverseKGroup(n,4);
        System.out.println(n);
    }

}