package com.personal;

import com.personal.util.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by prajeeva on 9/17/17.
 */
public class ReverseLinkedListInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        ListNode result = new ListNode(0);
        ListNode c = result;
        while(temp!=null) {
            int n = 0 ;
            boolean sh = false;
            while(n< k) {
                if(temp == null) {sh = true; break;}
                stack.push(temp);n++;
                temp = temp.next;
            }
            if(sh) {
                for(ListNode item : stack) {
                    c.next = item;
                    c = c.next;
                }
                c.next = null;
                break;

            } else {
                while(!stack.isEmpty()) {
                    c.next = stack.pop();
                    c = c.next;
                }
                c.next = null;
            }

        }
        return result.next;
    }
}
