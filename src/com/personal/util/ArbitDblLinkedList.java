package com.personal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 3/22/17.
 */
public class ArbitDblLinkedList implements Cloneable {
    public ArbitDblListNode head;
    int length=0;

    public ArbitDblLinkedList clone() {
        ArbitDblLinkedList returnlist = new ArbitDblLinkedList();

        //pass 1 insert nodes;
        ArbitDblListNode temp = head;

        while(temp!=null){
            ArbitDblListNode nodeToBeInserted = new ArbitDblListNode();
            nodeToBeInserted.value = temp.value;
            ArbitDblListNode newNextNode = temp.next;
            temp.next = nodeToBeInserted;
            nodeToBeInserted.next = newNextNode;
            temp = temp.next.next;
        }
        temp = head;
        //reset and set random pointers
        while(temp!=null){
            ArbitDblListNode cloneNode = temp.next;
            cloneNode.arbit = temp.arbit.next;
            //cloneNode.next = null;
            returnlist.add(cloneNode);

            temp = temp.next.next;
        }
        return returnlist;
    }

    private void add(ArbitDblListNode node) {
        int whereToPut = length;
        if(head==null){
            head = node;
            length++;
            return;
        }
        ArbitDblListNode target = head;
        while(whereToPut>0) {
            target = target.next;
            whereToPut--;
        }
        //at this moment traget is pointing at the last node
        target.next = node;
        length++;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        ArbitDblLinkedList originalList = new ArbitDblLinkedList();
        originalList.head = new ArbitDblListNode();
        originalList.head.value = 1;
        originalList.head.next = new ArbitDblListNode(2);
        originalList.head.next.next = new ArbitDblListNode(3);
        originalList.head.next.next.next = new ArbitDblListNode(4);
        originalList.head.next.next.next.next = new ArbitDblListNode(5);
        originalList.head.next.next.next.next.next = new ArbitDblListNode(6);
        originalList.head.next.next.next.next.next.next = new ArbitDblListNode(7);

        originalList.head.arbit =  originalList.head.next.next.next.next.next.next;
        originalList.head.next.arbit =  originalList.head.next.next.next.next.next;
        originalList.head.next.next.arbit =  originalList.head.next.next.next.next;
        originalList.head.next.next.next.arbit =  originalList.head.next.next.next;
        originalList.head.next.next.next.next.arbit =  originalList.head.next.next;
        originalList.head.next.next.next.next.next.arbit =  originalList.head.next;
        originalList.head.next.next.next.next.next.next.arbit =  originalList.head;

        ArbitDblLinkedList newList = originalList.clone();
        System.out.println("check");

    }
}
