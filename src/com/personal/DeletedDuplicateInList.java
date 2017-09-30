package com.personal;

import com.personal.util.ListNode;
/**
 * Created by prajeeva on 7/31/17.
 */
public class DeletedDuplicateInList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) return head.next;
        return head;
    }
}
