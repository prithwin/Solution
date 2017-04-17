package com.personal.util;

import java.util.Stack;

/**
 * Created by pr250155 on 4/16/17.
 */
public class LockedStack<E> extends Stack<E> implements Lockable {
    private boolean locked = false;
    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public E push(E item) {
        if(!isLocked()){
            return super.push(item);
        }
        return item;
    }

    @Override
    public synchronized E pop() {
        if(!isLocked()) {
            return super.pop();
        }
        return super.peek();
    }
}
