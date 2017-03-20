package com.personal.util;

import java.util.List;

/**
 * Created by prajeev on 9/8/16.
 */
public class LinkedList {
    public ListNode head;
    int length;

     public LinkedList(){
        super();
         length=0;
     }

    public LinkedList(int[] fromList){
        length=0;
       for(int item : fromList){
           add(item);
       }
    }

    public void add(int item) {
        length++;
        if(head==null){
            head = new ListNode(item);
            return;
        }
        ListNode target = head;
        while(target.next!=null)
            target = target.next;
        //at this moment traget is pointing at the last node
        target.next = new ListNode(item);
    }

    public ListNode getHead(){
        return  head;
    }

    public int size() {
        return length;

    }

    public void printList(){
        ListNode node = head;
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void printInReverese(ListNode node){
        if(node==null)
            return;
        printInReverese(node.next);
        System.out.println(node.val);
    }

    public void rotate() {
        ListNode preTail = this.getPreTail();
        ListNode tail = preTail.next;
        tail.next = head;
        preTail.next = null;
        this.head = tail;
    }

    private ListNode getPreTail() {
        ListNode tail = head;
        while(tail.next.next!=null){
            tail = tail.next;
        }
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode temp = this.getHead();
        while (temp!=null){
            stringBuilder.append(temp.val+",");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

}
