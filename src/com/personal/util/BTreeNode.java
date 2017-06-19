package com.personal.util;

/**
 * Created by prith on 15-06-2017.
 */
public class BTreeNode {
    ComparableNumber[] keys;
    int n;
    int c = 0;
    BTreeNode[] children;
    int degree;

    /**
     * default acess construction for symettric B tree.
     * @param degree
     */
    public BTreeNode(int degree) {
        this.degree = degree;
        this.keys = new ComparableNumber[this.degree - 1];
        this.children = new BTreeNode[this.degree];
    }

    public BTreeNode(BTreeNode source, int start, int end) {
        this(source.degree);
        for(int i = start, j = 0; i <=  end ; i++,j++) {
            this.keys[j] = source.keys[i]; n++;
            this.children[j] = source.children[i];
            this.children[j + 1] = source.children[i + 1];
        }
    }

    public static boolean lessThan(BTreeNode source, ComparableNumber number) {
        if(number.compareTo(source.keys[source.n - 1]) == -1)
            return true;
        return false;
    }

    public static boolean greaterThan(BTreeNode source, ComparableNumber number) {
        if(number.compareTo(source.keys[0]) == 1)
            return true;
        return false;
    }

    public BTreeNode delete(int index) {
        BTreeNode detached = new BTreeNode(degree);
        detached.keys[0] = this.keys[index];
        detached.children[0] = this.children[index];
        detached.children[1] = this.children[index + 1];
        int i = index;
        for(;i < n-1 ; i++) {
            this.keys[i] = this.keys[i+1];
            this.children[i] = this.children[i+1];
            this.children[i+1] = this.children[i+2];
        }
        this.keys[i] = null;
        this.children[i+1] = null;
        n--;
        return detached;
    }
}
