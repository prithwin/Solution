package com.personal.util;

/**
 * Created by pr250155 on 3/22/17.
 */
public class ArbitDblListNode implements Cloneable{
    public int value;
    public ArbitDblListNode next;
    public ArbitDblListNode arbit;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ArbitDblListNode) {
            ArbitDblListNode that = (ArbitDblListNode) obj;
            if(this.value != that.value) {
                return false;
            }
            return true;
        }
        return false;
    }
}