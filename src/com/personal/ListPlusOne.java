package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeeva on 10/28/17.
 */
public class ListPlusOne {
    public ListNode plusOne(ListNode head) {
        if(head == null) new ListNode(1);
        if(head.next == null) {
            int sum = 1 + head.val;
            int carry = 0;
            if(sum > 10) {
                carry = 1;
                sum = sum % 10;
            }
            head.val = sum;
            return new ListNode(sum);
        } else{
            ListNode res = plusOne(head.next);
            if(res.val == 1) {
                res.next = head;
                return res;
            } else {
                return head;
            }

        }
    }

    public static void main(String[] args) {
        LinkedList lis = new LinkedList(0);
        ListNode res = new ListPlusOne().plusOne(lis.head);
        System.out.println();
    }
}
