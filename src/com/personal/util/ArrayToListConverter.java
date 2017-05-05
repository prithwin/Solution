package com.personal.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 5/5/17.
 */
public class ArrayToListConverter {
    public static<T> List<T> toArrayList(T[] array) {
        List<T> result = new ArrayList<>();
        for(T item : array) {
            result.add(item);
        }
        return result;
    }
}
