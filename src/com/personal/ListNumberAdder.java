package com.personal;

import com.personal.util.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/9/17.
 */
public class ListNumberAdder {
    public int add(List<Integer> daye, List<Integer> baye){
        int sum = 0;
        int radix = 1;
        int reminder = 0;
        for(int i = daye.size()-1 , j = baye.size()-1;;){
            int sumInPlace = reminder;
            if(i<0 && j<0 && reminder == 0){
                break;
            }

            if(i >= 0){
                sumInPlace += daye.get(i);
            }
            if(j >= 0){
                sumInPlace += baye.get(j);
            }

            if(sumInPlace > 9){
                reminder = 1;
                int radixSum = sumInPlace % 10;
                sum += radix * radixSum;

            } else {
                reminder = 0;
                sum += radix * sumInPlace;

            }

            radix *= 10;
            i--;
            j--;
        }
        return sum;
    }

    public int addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int radix = 1;
        int total = 0;
        int reminder = 0;
        while(l1 != null && l2!=null) {
            int sum = reminder;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum >= 10) {sum = sum % 10 ;reminder = 1;}
            else reminder = 0;
            sum *= radix;
            total+=sum;
            radix*=10;

        }
        return total;
    }

    public ListNode addTwoNumbersL(ListNode l1, ListNode l2) {
        ListNode response = null;
        ListNode returnHead = null;
        int reminder = 0;
        while(l1 != null || l2!=null || reminder == 1) {
            int sum = reminder;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum >= 10) {sum = sum % 10 ;reminder = 1;}
            else reminder = 0;
            if(returnHead == null) {
                returnHead = new ListNode(sum);
                response = returnHead;
            } else {
                response.next = new ListNode(sum);
                response = response.next;
            }
        }
        return returnHead;
    }

    private ListNode reverseList(ListNode list) {
        if(list == null) return list;
        ListNode prev = null;
        ListNode curr = list;
        ListNode next = curr.next;

        while(next != null) {
            ListNode future = next.next;
            curr.next = prev;
            next.next = curr;

            prev = curr;
            curr = next;
            next = future;
        }
        return curr;
    }

}
