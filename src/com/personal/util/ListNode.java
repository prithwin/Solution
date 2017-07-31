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
}
