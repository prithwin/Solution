package com.personal;


import java.util.List;
import java.util.Stack;

/**
 * Created by prajeeva on 9/17/17.
 */
public class ReverseLinkedListInKGroups {
    public static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            ListNode<T> temp = this;
            while(temp!=null) {
                s.append(temp.value+" ");
                temp = temp.next;
            }
            return s.toString();
        }
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if(l == null) return l;
        if(l.next == null) return l;
        if(length(l) < k) return l;
        ListNode<Integer> dummy = new ListNode<>(Integer.MIN_VALUE);
        dummy.next = l;
        ListNode<Integer> p = dummy;
        ListNode<Integer> c = p.next;
        ListNode<Integer> n = c.next;
        int a = k;
        while(c.next!=null && a>1) {
            c.next = n.next;
            n.next = p.next;
            p.next = n;
            n = c.next;
            a--;
        }
        ListNode<Integer> start = dummy.next;
        int b = k;
        while(b>1) {
            if(start == null) break;
            start = start.next;
            b--;
        }
        ListNode<Integer> pre = start;
        start = start.next;
        if(start != null) {
            pre.next  = reverseNodesInKGroups(start,k);
        }
        return dummy.next;
    }

    private int length(ListNode<Integer> l) {
        int n = 0;
        while(l!=null) {n++;l = l.next;}
        return n;
    }

    public static void main(String[] args) {
        ListNode<Integer> lead = new ListNode<>(1);
        lead.next = new ListNode<>(2);
        lead.next.next = new ListNode<>(3);
        lead.next.next.next = new ListNode<>(4);
        lead.next.next.next.next = new ListNode<>(5);
        lead.next.next.next.next.next = new ListNode<>(6);
        lead.next.next.next.next.next.next = new ListNode<>(7);
        lead.next.next.next.next.next.next.next = new ListNode<>(8);
        lead.next.next.next.next.next.next.next.next = new ListNode<>(9);
        lead.next.next.next.next.next.next.next.next.next = new ListNode<>(10);
        lead.next.next.next.next.next.next.next.next.next.next = new ListNode<>(11);
        lead = new ReverseLinkedListInKGroups().reverseNodesInKGroups(lead, 3);
        System.out.println(lead);
        System.out.println("Something is going on way man");

    }

}
