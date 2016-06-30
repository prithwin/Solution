package com.personal;


import com.personal.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pr250155 on 1/19/16.
 */
public class ListAddList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> s1 = new LinkedList<ListNode>();
        Queue<ListNode> s2 = new LinkedList<ListNode>();
        Queue<ListNode> sResult = new LinkedList<ListNode>();
        //Queue<ListNode> qResult = new LinkedList<ListNode>();
        ListNode result = null;
        ListNode curr = l1;
        int count = 0;
        while (curr != null) {
            s1.add(curr);
            count++;
            curr = curr.next;
        }
        int oldCount = count;
        curr = l2;
        while (curr != null) {
            s2.add(curr);
            count--;
            curr = curr.next;
        }
        if(count<=0){
            count = oldCount - (count);
        }else {
            count = oldCount;
        }
        int rem = 0;
        while (count>0) {
            int sum = extractVal(s1) + extractVal(s2) + rem;
            ListNode temp = null;
            if (sum < 10) {
                temp = new ListNode(sum);
                rem = 0;

            } else {
                temp = new ListNode(sum % 10);
                rem = 1;
            }
            sResult.add(temp);
//            qResult.add(temp);
            count--;
        }
        if(rem!=0){
            sResult.add(new ListNode(rem));
        }
        curr = null;
        while (!sResult.isEmpty()){
            ListNode temp = new ListNode(sResult.remove().val);
            if(result == null){
                curr = temp;
                result = curr;
            }else {
                curr.next = temp;
                curr =curr.next;
            }


        }

        return result;
    }

    private int extractVal(Queue<ListNode> s) {
        if(s.isEmpty()){
            return 0;
        }else {
            return s.remove().val;
        }

    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node12 = new ListNode(8);

        ListNode node2 = new ListNode(0);
        node1.next = node12;
        new ListAddList().addTwoNumbers(node1,node2);
    }
}
