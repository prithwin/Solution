package com.random.test.old;

/**
 * Created by pr250155 on 5/20/17.
 */
public class ClonableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        AB ab = new AB();
        ab.clone();
    }
}

class AB implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}