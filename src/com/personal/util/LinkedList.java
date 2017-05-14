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

    /**
     * Function isPallindrome(L) {
     *  Node slow = L.head;
     *  Node fast = L.head;
     *  Stack S;
     *  while(slow!=null){
     *      if(fast!=null){
     *          fast = fast.next.next;
     *          S.push(slow);
     *      } else {
     *          if(S.POP != slow)
     *           return false;
     *      }
     *  }
     *  return true;
     * }
     */
    public boolean isPalindrome() {
        ListNode slow = this.head;
        ListNode fast = this.head;
        Stack<ListNode> comparisonStack  = new Stack();
        while(slow!=null) {
            if(fast != null) {
                comparisonStack.push(slow);
                if(fast.next==null){
                    fast = null;
                    comparisonStack.pop();
                } else {
                    fast = fast.next.next;
                }
                slow = slow.next;
            } else {
                if(!comparisonStack.pop().equals(slow)){
                    return false;
                }
                slow = slow.next;
            }
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

    public void deleteNode(ListNode node){
        if(head == null) return;
        ListNode trail = this.head;
        ListNode lead = trail.next;
        while(trail.next!=null){
            if(lead == node){
                break;
            }
            lead=lead.next;
            trail = trail.next;
        }
        trail.next = lead.next;
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

    public static ListNode findIntersection(LinkedList thiz, LinkedList that) {
        ListNode headA = thiz.head;
        ListNode headB = that.head;
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

    public boolean hasLoop(){
        return detectLoops(this.getHead());
    }

    private boolean detectLoops(ListNode head) {
        ListNode trailingPointer = head;
        ListNode leadPointer = head;
        boolean loopDetected = false;
        while (leadPointer.next!=null && trailingPointer.next!=null){
            trailingPointer = trailingPointer.next;
            leadPointer = leadPointer.next.next;
            if(trailingPointer == leadPointer){
                loopDetected = true;
                break;
            }
        }
        return loopDetected;
    }

    public void findAndRemoveLoopTermination(){
        if(!this.hasLoop()) return;
        ListNode pointInsideLoop = findPointWithinLoop();
        ListNode iori = head;
        while(iori!=pointInsideLoop) {
            ListNode kyo = pointInsideLoop.next;
            ListNode kDash = pointInsideLoop;
            while (kyo != pointInsideLoop) {
                if (kyo == iori) {
                    kDash.next = null;
                    return;
                }
                kyo=kyo.next;
                kDash = kDash.next;
            }
            iori=iori.next;
        }
        return;
    }

    private ListNode findPointWithinLoop() {
        if(!this.hasLoop()) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


