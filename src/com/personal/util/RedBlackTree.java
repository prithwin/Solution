package com.personal.util;

/**
 * Created by prith on 12-06-2017.
 */
public class RedBlackTree extends BinarySearchTree {
    RedBlackTreeNode root = new RedBlackTreeNode(true);

    enum BalanceType{
        LL,RR,LR,RL
    }

    public void add(RedBlackTreeNode node) {
        node.left = new RedBlackTreeNode(true);
        node.right = new RedBlackTreeNode(true);
        if (root.isSentinel) {
            node.isBlack = true;
            node.isSentinel = false;
            this.root = node;
        } else {
            node.isBlack =false;
            RedBlackTreeNode temp = addInternal(root, node);
            while (temp.parent!=null) temp = temp.parent;
            root = temp;
            root.parent = null;
            root.isBlack = true;
            System.out.println("check");
        }
    }

    public RedBlackTreeNode addInternal(RedBlackTreeNode where, RedBlackTreeNode what) {
        if (where.left.isSentinel && what.number.compareTo(where.number) == -1) {
            what.parent = where;
            where.left = what;

        } else if (where.right.isSentinel && what.number.compareTo(where.number) >= 0) {
            what.parent = where;
            where.right = what;
        } else {
            if (!where.left.isSentinel && what.number.compareTo(where.number) == -1) {
                where = addInternal(where.left, what);
            } else if (!where.right.isSentinel && what.number.compareTo(where.number) >= 0) {
                where = addInternal(where.right, what);
            }
        }
        if(!where.isBlack && where.parent!=null) {
            RedBlackTreeNode whereParent = where.parent;
            RedBlackTreeNode whereSibling = new RedBlackTreeNode(true);
            if(!where.left.isBlack) {
                whereSibling = whereParent.right;
            } else {
                whereSibling = whereParent.left;
            }
            if(!whereSibling.isSentinel && whereParent.parent!=null) {
                whereParent.isBlack = false;
                where.isBlack = true;
                whereSibling.isBlack = true;
            } else {
                if (isBalanceType(whereParent, BalanceType.LL)) {
                    where.left = rotateRight(whereParent);
                }

                if (isBalanceType(whereParent, BalanceType.LR)) {
                    whereParent.left = rotateLeft(whereParent.left);
                    where.left = rotateRight(whereParent);
                }

                if (isBalanceType(whereParent,BalanceType.RR)) {
                    where.right = rotateLeft(whereParent);
                }

                if (isBalanceType(whereParent, BalanceType.RL)) {
                    whereParent.right = rotateRight(whereParent.right);
                    where.right  = rotateLeft(whereParent);
                }
            }
        }
        return where;
    }

    private boolean isBalanceType(RedBlackTreeNode node, BalanceType balanceType) {
        if(balanceType == BalanceType.LL) {
            if(node.left.isSentinel || node.left.left.isSentinel){
                return false;
            }
            if(node.left.number.compareTo(node.left.left.number) >= 0){
                return true;
            }
        }
        else if(balanceType == BalanceType.RR) {
            if(node.right.isSentinel|| node.right.right.isSentinel){
                return false;
            }
            if(node.right.number.compareTo(node.right.right.number) == -1){
                return true;
            }
        }

        else if(balanceType == BalanceType.LR) {
            if(node.left.isSentinel || node.left.right.isSentinel){
                return false;
            }
            if(node.left.number.compareTo(node.left.right.number) == -1){
                return true;
            }
        }
        else if(balanceType == BalanceType.RL) {
            if(node.right.isSentinel || node.right.left.isSentinel){
                return false;
            }
            if(node.right.number.compareTo(node.right.left.number) >= 0){
                return true;
            }
        }
        return false;
    }

    private RedBlackTreeNode rotateRight(RedBlackTreeNode root) {
        RedBlackTreeNode godFather = root.parent;
        RedBlackTreeNode pivot = root.left;
        RedBlackTreeNode alpha = pivot.left;
        RedBlackTreeNode beta = pivot.right;
        RedBlackTreeNode gamma = root.right;

        root.left = beta;
        root.right =  gamma;
        pivot.left = alpha;
        pivot.right = root;
        root.parent = pivot;
        pivot.parent = godFather;

        pivot.isBlack = false;
        alpha.isBlack = true;
        root.isBlack = true;

        return pivot;
    }

    private RedBlackTreeNode rotateLeft(RedBlackTreeNode root) {
        RedBlackTreeNode godFather = root.parent;
        RedBlackTreeNode pivot = root.right;
        RedBlackTreeNode alpha = pivot.left;
        RedBlackTreeNode beta = pivot.right;
        RedBlackTreeNode gamma = root.left;

        root.left = gamma;
        root.right =  alpha;
        pivot.left = root;
        pivot.right = beta;
        root.parent = pivot;
        pivot.parent = godFather;
        pivot.isBlack = false;
        root.isBlack = true;
        beta.isBlack = true;

        return pivot;
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
