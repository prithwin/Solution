package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeev on 9/3/17.
 */
public class ReverseSinglyLinkedList {
    public void reverseList(LinkedList list){
        //reverses  the linked list passed to it
        list.head = realReverse(list.getHead());
    }

    private ListNode realReverse(ListNode current) {
        ListNode prevNode = null;
       while (current!=null){
           ListNode nextCurrent = current.next;
           current.next = prevNode;
           prevNode = current;
           current = nextCurrent;
       }
        return prevNode;
    }

    public static void main(String[] args) {
        int[] source = {1,2,3,4,5};
        LinkedList target = new LinkedList(source);
        ReverseSinglyLinkedList toool = new ReverseSinglyLinkedList();
        System.out.println("Original List!");
        target.printList();
        System.out.println("printing in reverse");
        LinkedList.printInReverese(target.head);
        toool.reverseList(target);
        System.out.println("Reversed List");
        target.printList();
        System.out.println("printing in reverse");
        LinkedList.printInReverese(target.head);


    }
}
