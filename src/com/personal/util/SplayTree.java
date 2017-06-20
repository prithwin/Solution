package com.personal.util;

/**
 * Created by prith on 20-06-2017.
 */
public class SplayTree {
    TreeNode root;

    enum SplayType {
        LL,LR,RR,RL
    }

    public void add(int number) {
        root = add(root,number);
    }

    private TreeNode add(TreeNode where, int what) {
        if(where == null) {
            return new TreeNode(what);
        }
        if(what < where.number.number) {
            where.left = add(where.left,what);
        } else if(what < where.number.number) {
            where.right = add(where.right,what);
        } else {
            where.number.number = what;
        }
        return  where;
    }

    public void remove(int what) {
        root = remove(root,what);
    }

    private TreeNode remove(TreeNode where, int what) {
        if(where == null) return where;
        if(what < where.number.number) {
            where.left = remove(where.left,what);
        } else if(what > where.number.number) {
            where.right = remove(where.right,what);
        } else {
            //the number has been found;
            if(where.right == null) {
                return where.left;
            } else if(where.left == null) {
                return where.right;
            } else {
                TreeNode temp = where;
                where.number = min(temp.right).number;
                where.left = temp.left;
                where.right = deleteMin(temp.right);
            }
        }
        return where;
    }

    private TreeNode deleteMin(TreeNode where) {
        if(where.left == null) return where.right;
        where = deleteMin(where.left);
        return where;
    }

    private TreeNode min(TreeNode where) {
        if(where.left == null) return where;
        return min(where.left);
    }

    private TreeNode rotateLeft(TreeNode root) {
        TreeNode pivot  = root.right;
        TreeNode alpha = root.left;
        TreeNode beta = pivot.left;
        TreeNode gamma = pivot.right;

        root.left = alpha;
        root.right = beta;
        pivot.left = root;
        pivot.right = gamma;

        return pivot;
    }

    private TreeNode rotateRight(TreeNode root) {
        TreeNode pivot = root.left;
        TreeNode alpha = pivot.left;
        TreeNode beta = pivot.right;
        TreeNode gamma = root.right;

        root.left = beta;
        root.right = gamma;
        pivot.left = alpha;
        pivot.right = root;

        return pivot;

    }

    public TreeNode search(int what) {
        return search(root,what);
    }

    private TreeNode search(TreeNode where, int what) {
        if(where.number.number == what) return where;
        TreeNode splay;
        if(what < where.number.number) {
            splay = search(where.left,what);
        } else {
            splay = search(where.right,what);
        }
        splay = splay(splay , what);
        return splay;
    }

    private TreeNode splay(TreeNode splay, int what) {
        //splays a node based upon recent usage.
        SplayType type = getSplayType(splay, what);
        if(type == SplayType.LL || type == SplayType.LR){
            if(type == SplayType.LR){
                splay.left = rotateLeft(splay.left);
            }
            splay = rotateRight(splay);
        }
        if(type == SplayType.RL || type == SplayType.RR){
            if(type == SplayType.RL) {
                splay.right = rotateRight(splay.right);
            }
            splay = rotateLeft(splay);
        }

        return splay;
    }

    private SplayType getSplayType(TreeNode splay, int what) {
        if(splay.left.left.number.number == what) return SplayType.LL;
        if(splay.left.right.number.number == what) return SplayType.LR;
        if(splay.right.right.number.number == what ) return SplayType.RR;
        if(splay.right.left.number.number == what) return SplayType.RL;
        return null;
    }
}
