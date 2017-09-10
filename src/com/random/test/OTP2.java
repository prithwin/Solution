package com.random.test;


import com.personal.util.ListNode;

/**
 * Created by prajeeva on 8/25/17.
 */
public class OTP2 {
//    pblic Object hushlittlebaby () {
//        return new OTP().giveItBack();
//    }

    public ListNode reverseBetween(ListNode head, int start, int end) {
        if(head == null || head.next == null) return head;
        int s = start - 1;
        int e = end - start +1;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode ex = curr;
        while(s>0) {
            ex = curr;
            curr = curr.next;
            s -= 1;
        }

        while(curr!=null && e > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            e -= 1;
        }
        ex.next = prev;
        ListNode temp = prev;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = next;
        return head;
    }
}
