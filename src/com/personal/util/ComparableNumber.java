package com.personal.util;

import java.io.Serializable;

/**
 * Created by prajeev on 19/3/17.
 */
public class ComparableNumber implements Comparable, Serializable{
    public int number;

    public ComparableNumber(int i) {
        this.number = i;
    }

    @Override
    public boolean equals(Object obj) {
        ComparableNumber rhs = (ComparableNumber) obj;
        return number == rhs.number;
    }


    @Override
    public int compareTo(Object that) {
        ComparableNumber thats = (ComparableNumber) that;
        if (this.number == thats.number)
            return 0;
        return (this.number - thats.number) / ((this.number - thats.number) > 0 ?
                (this.number - thats.number) : -1 * (this.number - thats.number));
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
