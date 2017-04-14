package com.personal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static boolean checkPallindrome(ListNode  node){
        List<ListNode> reversedList = new ArrayList<>();
        getReversedList(node,reversedList);
        for(ListNode item : reversedList){
            if(!item.equals(node)){
                return false;
            }
            node = node.next;
        }
        return true;
    }

    private static void getReversedList(ListNode node, List<ListNode> resultList) {
        if(node == null){
            return;
        }
        getReversedList(node.next,resultList);
        resultList.add(node);
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

    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void reverse(){
        head = reverseInternal(head);
    }

    private ListNode reverseInternal(ListNode node) {
        if(node == null) {
            return node;
        }
        ListNode next = reverseInternal(node.next);
        node.next = next;
        return next;
    }

    public ListNode findNthFromLast(int n){
        return findNthFromLastInternal(head,n,0);
    }

    private ListNode findNthFromLastInternal(ListNode node, int n, Integer i) {
        if (node.next == null) {
            return node;
        }
        ListNode next = findNthFromLastInternal(node.next, n, i);
        if (++i == n) {
            return node;
        }
        return next;
    }
}


