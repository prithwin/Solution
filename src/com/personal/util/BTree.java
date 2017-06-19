package com.personal.util;

import java.util.Arrays;

/**
 * Created by prith on 15-06-2017.
 */
public class BTree {
    BTreeNode root;
    int degree;

    /**
     * creates a Btree of a certain degree
     * @param degree
     */
    public BTree(int degree) {
        this.degree = degree;
        root = new BTreeNode(degree);
    }

    public void add(ComparableNumber what) {
        BTreeNode o = add(root,what);
        if(o != null) {
            root = o;
        }
        //o is the overflow node
    }

    private BTreeNode add(BTreeNode where, ComparableNumber what) {
        if(where.n <  degree - 1 && where.c < 1) {
            return include(where, what);
        } else if(where.c > 0) {
            BTreeNode o = null;
            if(what.compareTo(where.keys[0]) == -1) {
                where.children[0] = initialize(where.children[0]);
                o = add(where.children[0],what);
            } else if(what.compareTo(where.keys[where.n - 1]) == 1) {
                where.children[where.n] = initialize(where.children[where.n]);
                o = add(where.children[where.n],what);
            } else {
                //else find where do you need to put this value
                for (int i = 0; i < where.n - 1; i++) {
                    if (what.compareTo(where.keys[i]) == 1 && what.compareTo(where.keys[i + 1]) == -1) {
                        where.children[i + 1] = initialize(where.children[i + 1]);
                        o = add(where.children[i + 1], what);
                        break;
                    }
                }
            }
            if(o!=null && where.n == degree - 1) {
                addChildren(where,o);
                BTreeNode ro =  split(where,o.keys[0]);
                System.out.println();
            }
            if(o!=null) {
                merge(where,o);
                return where;
            }
            return o;
        }
        //overflow condition  the array in half
        return split(where, what);
    }

    public void merge(BTreeNode where, BTreeNode what) {
        addChildren(where,what);
        include(where,what.keys[0]);
    }

    private void addChildren(BTreeNode where, BTreeNode whose) {
        //the element whose definately has exactly two cheildren as it is the result of a recent split opertaion
        BTreeNode[] updatedChildren = new BTreeNode[degree];
        if(whose.keys[0].compareTo(where.keys[0]) == -1) {
            updatedChildren[0] = whose.children[0];
            updatedChildren[1] = whose.children[1];
            for (int i = 1,j = 2 ; i < where.c ; i++,j++){
                updatedChildren[j] = where.children[i];
            }
        } else if(whose.keys[0].compareTo(where.keys[where.n-1]) == 1) {
            int i = 0;
            for (; i < where.c ; i++){
                updatedChildren[i] = where.children[i];
            }
            updatedChildren[i-1] = whose.children[0];
            updatedChildren[i] = whose.children[1];
        } else {
            //find out the g and g+1 where the item would fit
            int g = 0;
            for(; g < where.n - 1 ; g++) {
                if(whose.keys[0].compareTo(where.keys[g]) == 1
                        && whose.keys[0].compareTo(where.keys[g+1]) == -1) {
                    break;
                }
            }
            //add keys from 0 to g-1 then add then add whose children and then add g+2 onwards;
            int j=0;
            for(int i = 0 ; i < g + 1 ; i++) {
                updatedChildren[j++] = where.children[i];
            }
            updatedChildren[j] = whose.children[0];
            updatedChildren[j+1] = whose.children[1];
            j+=2;
            for(int i = g+2 ; i < where.c ; i++) {
                updatedChildren[j++] = where.children[i];
            }
        }
        where.children = updatedChildren;
        where.c++;
    }

    private BTreeNode include(BTreeNode where, ComparableNumber what) {
        if(where.n == 0 ){
            where.keys[0] = what;
        } else if(what.compareTo(where.keys[where.n-1]) == 1) {
            where.keys[where.n] = what;
        }else {
            int i = 0;
            for(i = where.n - 1; i >= 0 ; i--) {
                if(what.compareTo(where.keys[i]) == -1) {
                    where.keys[i+1] = where.keys[i];
                } else {
                    break;
                }
            }
            where.keys[i+1] = what;
        }
        where.n++;
        return null;
    }

    private BTreeNode initialize(BTreeNode item) {
        if(item == null) return new BTreeNode(degree);
        else return item;
    }

    private BTreeNode split(BTreeNode where, ComparableNumber what) {
        int mid = ((degree - 1) / 2) - 1;
        BTreeNode o = new BTreeNode(degree);    //the overflow node
        BTreeNode left = new BTreeNode(where,0,mid);
        BTreeNode right = new BTreeNode(where,mid+1,where.n -1);
        ComparableNumber oN = null;
        if(BTreeNode.lessThan(left, what)) {
            o = left.delete(left.n - 1);
            add(left,what);
        } else if(BTreeNode.greaterThan(right,what)) {
            o = right.delete(0);
            add(right,what);
        } else {
            add(o,what);
        }
        o.n++;
        o.children[0] = left;
        o.children[1] = right;
        o.c+=2;
        return o;
    }
}
