package com.personal.util;

/**
 * Created by pr250155 on 4/1/17.
 */
public class DoublyLinkedList {
    DoubleyLinkedListNode head;

    public void add(int item) {
        if(this.head == null){
            head = new DoubleyLinkedListNode(item);
            return;
        }
        DoubleyLinkedListNode temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }
        DoubleyLinkedListNode newNode = new DoubleyLinkedListNode(item);
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void add(int[] items){
        for(int item : items){
            this.add(item);
        }
    }

    public void reverse(){
        DoubleyLinkedListNode end = head;
        while(end.next!=null){
            end = end.next;
        }
        //we have reched the end;
        head = end;
        while(end!=null){
            DoubleyLinkedListNode realPrev = end.prev;
            DoubleyLinkedListNode temp = end.next;
            end.next = end.prev;
            end.prev = temp;
            end = realPrev;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DoubleyLinkedListNode temp = head;
        while(temp!=null){
            builder.append(temp+",");
            temp = temp.next;
        }
        return builder.toString();
    }
}
