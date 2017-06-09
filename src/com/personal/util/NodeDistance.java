package com.personal.util;

/**
 * Created by prith on 09-06-2017.
 */
public class NodeDistance implements Comparable,Updatable{
    int node;
    int weight;

    public NodeDistance(Integer node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        NodeDistance that = (NodeDistance) o;
        if(this.weight < that.weight) return -1;
        if(this.weight > that.weight) return 1;
        return 0;
    }

    @Override
    public boolean update(int value) {
        if(this.weight > value) {
            this.weight = value;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDistance that = (NodeDistance) o;
        if (node != that.node) return false;
        return true;
    }
}
