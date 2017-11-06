package com.personal.util;

/**
 * Created by pr250155 on 1/19/16.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object obj) {
        ListNode otherNode = (ListNode) obj;
        return this.val==((ListNode) obj).val;
    }

    @Override
    public String toString() {
        LinkedList toList = new LinkedList();
        toList.head = this;
        return toList.toString();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(Integer.MAX_VALUE);
        ListNode k = d;
        while(l1 != null && l2 !=null) {
            System.out.println(l1.val);
            System.out.println(l2.val);
            if(l1.val < l2.val) {
                k.next = l1;
                l1 = l1.next;
                k = k.next;
            } else if(l2.val < l1.val) {
                k.next = l2;
                l2 = l2.next;
                k = k.next;
            } else {
                k.next = new ListNode(l1.val);
                k.next.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
                k = k.next.next;

            }

        }

        if(l1 == null) {
            while(l2!=null) {
                k.next = l2;
                l2 = l2.next;
                k = k.next;
            }
        }

        if(l2 == null) {
            while(l1!=null) {
                k.next = l1;
                l1 = l1.next;
                k = k.next;
            }
        }

        return d.next;
    }
}
