package com.personal;

import com.personal.util.ListNode;

import java.util.*;

/**
 * Created by prajeeva on 7/16/17.
 *
 */
public class MergeKArrays {
    public ListNode mergeKLists(ListNode[] lists) {
        return Arrays.stream(lists).parallel().filter(Objects::nonNull).
                reduce(this::merge).orElse(null);
    }

    private ListNode merge(ListNode l1 , ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = merge(l1.next , l2);
            return l1;
        } else {
            l2.next = merge(l1 , l2.next);
            return l2;
        }
    }
}
