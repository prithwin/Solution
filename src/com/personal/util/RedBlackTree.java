package com.personal.util;

import com.random.test.RecursiveTester;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by prith on 12-06-2017.
 */
public class RedBlackTree extends BinarySearchTree {
    RedBlackTreeNode root = new RedBlackTreeNode(true);

    enum BalanceType {
        LL,LR,RR,RL
    }

    public void add(RedBlackTreeNode what){
        what.left = new RedBlackTreeNode(true);
        what.right = new RedBlackTreeNode(true);
        root = add(root,what);
        root.isBlack = true;
        root.parent = null;
    }

    private RedBlackTreeNode add(RedBlackTreeNode where ,  RedBlackTreeNode what) {
        if(where.isSentinel) return what;
        if(what.number.compareTo(where.number) == -1) {
            where.left = add(where.left,what);
            where.left.parent = where;
        } else if(what.number.compareTo(where.number) == 1) {
            where.right = add(where.right,what);
            where.right.parent = where;
        } else {
            where.number = what.number;
        }

        return balanceRB(where);
    }

    public void delete(RedBlackTreeNode what) {
        root = delete(root, what);
    }

    private RedBlackTreeNode delete(RedBlackTreeNode where,RedBlackTreeNode what) {
        if(what.number.compareTo(where.number) ==-1){
            where.left = delete(where.left,what);
        } else if(what.number.compareTo(where.number) == 1) {
            where.right = delete(where.right,what);
        } else {
            if(where.left.isSentinel) {
                return where.right;
            } else if(where.right.isSentinel) {
                return where.left;
            } else {
                RedBlackTreeNode temp = where;
                where.number = min(temp.right).number;
                where.left = temp.left;
                where.right = deleteMin(temp.right);
            }
        }
        return balanceRB(where);
    }

    private RedBlackTreeNode balanceRB(RedBlackTreeNode where) {
        if(where.parent != null){
            BalanceType balance = getBalanceType(where);
            if(balance == BalanceType.LL || balance == BalanceType.LR) {
                if(!where.right.isSentinel) {
                    return flipColorsDown(where);
                }
                if(balance == BalanceType.LR) {
                    where.left = rotateLeft(where.left);
                }
                where = rotateRight(where);
            }
            if(balance == BalanceType.RL || balance == BalanceType.RR) {
                if(!where.left.isSentinel) {
                    return flipColorsDown(where);
                }
                if(balance == BalanceType.RL) {
                    where.right = rotateRight(where.right);
                }
                where = rotateLeft(where);
            }
        }
        return where;
    }

    private RedBlackTreeNode min(RedBlackTreeNode where) {
        if(where.left.isSentinel) return where;
        return min(where.left);
    }

    private RedBlackTreeNode deleteMin(RedBlackTreeNode where) {
        if(where.left.isSentinel) return where.right;
        where.left = deleteMin(where.left);
        return balanceRB(where);
    }


    private RedBlackTreeNode rotateRight(RedBlackTreeNode root) {
        RedBlackTreeNode pivot = root.left;
        RedBlackTreeNode alpha = pivot.left;
        RedBlackTreeNode beta = pivot.right;
        RedBlackTreeNode gamma = root.right;
        root.left = beta;
        root.right = gamma;
        pivot.left = alpha;
        pivot.right = root;
        return pivot;
    }

    private RedBlackTreeNode rotateLeft(RedBlackTreeNode root) {
        RedBlackTreeNode pivot = root.right;
        RedBlackTreeNode alpha = root.left;
        RedBlackTreeNode beta = pivot.left;
        RedBlackTreeNode gamma = pivot.right;
        root.left = alpha;
        root.right = beta;
        pivot.left = root;
        pivot.right = gamma;
        return pivot;
    }

    private RedBlackTreeNode flipColorsDown(RedBlackTreeNode where) {
        where.isBlack = false;
        where.left.isBlack = true;
        where.right.isBlack = true;
        return where;
    }

    private BalanceType getBalanceType(RedBlackTreeNode where) {
        if(!where.left.isBlack && !where.left.left.isBlack) return BalanceType.LL;
        if(!where.left.isBlack && !where.left.right.isBlack) return BalanceType.LR;
        if(!where.right.isBlack && !where.right.right.isBlack) return BalanceType.RR;
        if(!where.right.isBlack && !where.right.left.isBlack) return BalanceType.RL;
        return null;
    }

    public void printRedBlackTree(){
        printRedBlackTreeInOrder(root);
    }

    private void printRedBlackTreeInOrder(RedBlackTreeNode node) {
        if(node.isSentinel)
            return;
        printRedBlackTreeInOrder(node.left);
        System.out.println(node.number+" -> "+((node.isBlack)?"Black":"Red"));
        printRedBlackTreeInOrder(node.right);
    }
}
