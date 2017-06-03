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
            returnlist.add(cloneNode);
            ArbitDblListNode old = temp;
            temp = temp.next.next;
            old.next = temp;
        }
        returnlist.length = this.length;
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ArbitDblLinkedList) {
            ArbitDblLinkedList that  = (ArbitDblLinkedList) obj;
            if(this.length != that.length) {
                return false;
            }
            ArbitDblListNode thisStart = this.head;
            ArbitDblListNode thatStart = that.head;
            while(thisStart!=null) {
                if(!thisStart.equals(thatStart)) {
                    return false;
                }
                thatStart = thatStart.next;
                thisStart = thisStart.next;
            }
            return true;

        }
        return false;
    }
}
