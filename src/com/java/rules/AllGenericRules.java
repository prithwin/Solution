package com.java.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeeva on 11/2/17.
 */
public class AllGenericRules<A> {
    A a;

    static<T> List<T> doSomeMethodThing(T a) {
        return new ArrayList<>();
    }

    A somsdf(AllGenericRules<? extends Comparable> comparable) {
        return null;
    }
}
