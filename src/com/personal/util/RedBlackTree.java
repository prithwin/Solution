package com.personal.util;

/**
 * Created by prith on 12-06-2017.
 */
public class RedBlackTree extends BinarySearchTree {
    class SubTreeReference {
        boolean rotated;
        RedBlackTreeNode ref;

        SubTreeReference(RedBlackTreeNode ref , boolean rotated) {
            this.rotated = rotated;
            this.ref = ref;
        }
    }
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
            root = addInternal(root, node).ref;
            root.parent = null;
            root.isBlack = true;
        }
    }

    public SubTreeReference addInternal(RedBlackTreeNode where, RedBlackTreeNode what) {
        if(where.isSentinel) return new SubTreeReference(what,false);

        boolean left = true;
        if (what.number.compareTo(where.number) == -1) {
            SubTreeReference subTreeReference = addInternal(where.left, what);
            if(!subTreeReference.rotated) {
                where.left = subTreeReference.ref;
            } else {
                where = subTreeReference.ref;
            }
            where.left.parent = where;
        } else  {
            SubTreeReference subTreeReference = addInternal(where.right, what);
            if(!subTreeReference.rotated) {
                where.right = subTreeReference.ref;
            } else {
                where = subTreeReference.ref;
            }
            where.right.parent = where;
            left = false;
        }
        //Fix Up logic CLRS
        //        <C>
        //    {B}     {Dy}
        //  a   {zA}  d  e
        //       b g

        RedBlackTreeNode z = left? where.left : where.right;
        RedBlackTreeNode zP = z.parent;
        if(zP.parent != null && (!z.isBlack && !zP.isBlack)) {
            RedBlackTreeNode y = zP.getOtherSibling(zP);
            if(!zP.isBlack && !y.isBlack) {
                zP.isBlack = true;
                y.isBlack = true;
                zP.parent.isBlack = false;
            } else {
                if(y.isBlack) {
                    if(isBalanceType(zP.parent,BalanceType.LL)){
                        zP.parent = rotateLeft(zP.parent);
                    } else if(isBalanceType(zP.parent,BalanceType.RR)){
                        zP.parent = rotateLeft(zP.parent);
                    } else if(isBalanceType(zP.parent,BalanceType.LR)) {
                        zP = rotateLeft(zP);
                        zP.parent = rotateRight(zP.parent);
                    } else if(isBalanceType(zP.parent,BalanceType.RL)) {
                        zP = rotateRight(zP);
                        zP.parent = rotateLeft(zP.parent);
                    }
                    zP.isBlack = true;
                    zP.left.isBlack = false;
                    zP.right.isBlack = false;
                    return new SubTreeReference(zP, true);
                }
            }
        }
        return new SubTreeReference(where, false);
    }

    private boolean isBalanceType(RedBlackTreeNode node, BalanceType balanceType) {
        if(balanceType == BalanceType.LL) {
           if(!node.left.isBlack && !node.left.left.isBlack){
               return true;
           }
        }

        if(balanceType == BalanceType.RR) {
            if(!node.right.isBlack && !node.right.right.isBlack){
                return true;
            }
        }

        if(balanceType == BalanceType.LR) {
            if(!node.left.isBlack && !node.left.right.isBlack){
                return true;
            }
        }

        if(balanceType == BalanceType.RL) {
            if(!node.right.isBlack && !node.right.left.isBlack){
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
