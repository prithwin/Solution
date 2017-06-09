package com.personal.util;

/**
 * Created by pr250155 on 5/17/17.
 */
public class ComparableEdge implements Comparable {
    int from;
    int to;
    int weight;

    public ComparableEdge(int start, int end, int weight) {
        this.from = start;
        this.to = end;
        this.weight = weight;
    }
    public ComparableEdge(){

    }

    @Override
    public int compareTo(Object object) {
        ComparableEdge that = (ComparableEdge) object;
        if(this.weight > that.weight) {
            return 1;
        } else if(this.weight<that.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
