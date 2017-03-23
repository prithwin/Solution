package com.personal.util;

/**
 * Created by pr250155 on 3/22/17.
 */
public class ArbitDblListNode implements Cloneable{
    int value;
    ArbitDblListNode next;
    ArbitDblListNode arbit;

    public ArbitDblListNode(int value) {
        this.value = value;
    }

    public ArbitDblListNode() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}