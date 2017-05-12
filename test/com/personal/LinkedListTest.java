package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/10/17.
 */
public class LinkedListTest {
    @Test public void testNotPalindromeEven() {
        int[] array = {1,2,1,1};
        LinkedList target = new LinkedList(array);
        assertFalse(target.isPalindrome());
    }
    @Test public void testPalindromeEven() {
        int[] array = {1,2,2,1};
        LinkedList target = new LinkedList(array);
        assertTrue(target.isPalindrome());
    }
    @Test public void testPalindromeOdd() {
        int[] array = {1,2,3,2,1};
        LinkedList target = new LinkedList(array);
        assertTrue(target.isPalindrome());
    }
    @Test public void testNotPalindromeOdd() {
        int[] array = {1,2,7,3,7,8,1};
        LinkedList target = new LinkedList(array);
        assertFalse(target.isPalindrome());
    }

    @Test public void findIntersection() {
        LinkedList listA = new LinkedList();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        ListNode crossroads = new ListNode(3);
        headA.next.next = crossroads;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        listA.head = headA;

        LinkedList listB = new LinkedList();
        ListNode headB = new ListNode(11);
        headB.next = new ListNode(22);
        headB.next.next = crossroads;
        listB.head = headB;
        ListNode intersection = LinkedList.findIntersection(listA, listB);
        assertTrue(intersection.val == crossroads.val);
    }

}