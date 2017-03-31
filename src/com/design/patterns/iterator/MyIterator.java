package com.design.patterns.iterator;

/**
 * Created by pr250155 on 3/31/17.
 */
public interface MyIterator<E> {
    boolean hasNext();
    E next();
}
