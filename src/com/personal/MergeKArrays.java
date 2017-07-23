package com.personal;

import com.personal.util.ListNode;

import java.util.*;

/**
 * Created by prajeeva on 7/16/17.
 * TODO: come back to this later
 *
 */
public class MergeKArrays {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> g = new ArrayList<ListNode>();
        for(int i = 0 ; i < lists.length ; i++) {
            g.add(lists[i]);
        }
        //preparation done
        while(g.size() > 1) {
            for(int i = 0 ; i < g.size() ;) {
                if(i < g.size() - 1) {
                    ListNode merged = merge(g.get(i),g.get(i+1));
                    g.remove(i); g.remove(i + 1);
                    g.add(merged);
                    i+=2;
                }
            }
        }
        return g.get(0);
    }

    private ListNode merge(ListNode thiz , ListNode that) {
        ListNode response = new ListNode(Integer.MAX_VALUE);
        ListNode returnHead = response;
        while(thiz.next!=null && that.next!=null) {
            if(thiz.val < that.val) {
                response.next = thiz;
                response = response.next;
                thiz = thiz.next;
            } else if(that.val < thiz.val) {
                response.next = that.next;
                response = response.next;
                that = that.next;
            } else {
                response.next = thiz.next;
                response = response.next;
                response.next = that.next;
                response = response.next;
            }
        }
        if(thiz.next == null) {
            while(that.next != null) {
                response.next = that.next;
                response = response.next;
                that = that.next;
            }
        }

        if(that.next == null) {
            while(thiz.next != null) {
                response.next = thiz;
                response = response.next;
                thiz = thiz.next;
            }
        }
        return returnHead.next;
    }
}
