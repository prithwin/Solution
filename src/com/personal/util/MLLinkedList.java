package com.personal.util;

/**
 * Created by pr250155 on 5/13/17.
 */
public class MLLinkedList {
    MLListNode head;

    public LinkedList flatten() {
        LinkedList result = new LinkedList();
        flattenInternal(head,result);
        return result;
    }

    private void flattenInternal(MLListNode node,LinkedList result) {
        if(node == null) return;
        result.add(node.key);
        flattenInternal(node.next,result);
        flattenInternal(node.child,result);
    }
}
