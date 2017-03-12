package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeev on 10/3/17.
 */
public class ListIntersection {
    public ListNode findIntersection(LinkedList listA,LinkedList listB){
        return findIntersection(listA.getHead(),listB.getHead());
    }

    private ListNode findIntersection(ListNode headA, ListNode headB) {
        ListNode focus = headA;
        while(focus!=null){
            ListNode scanner = headB;
            while (scanner!=null){
                if(focus == scanner){
                    return focus;
                }
                scanner = scanner.next;
            }
            focus = focus.next;
        }
        return null;
    }

    public static void main(String[] args) {
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
        ListNode intersection = new ListIntersection().findIntersection(listA, listB);
        System.out.println("check");
    }
}
