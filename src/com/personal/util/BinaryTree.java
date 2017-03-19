package com.personal.util;

/**
 * Created by prajeev on 19/3/17.
 */
public class BinaryTree {
    public TreeNode root;

    public BinaryTree(int root) {
        TreeNode treeNode = new TreeNode(root);
        this.root = treeNode;
        this.root.left = null;
        this.root.right = null;
    }

    public int height(){
        return computeHeight(root);
    }

    public int computeHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int lHeight = computeHeight(node.left);
        int rHeight = computeHeight(node.right);
        if (lHeight > rHeight){
            return 1+lHeight;
        } else {
            return 1+rHeight;
        }
    }

    public int size(){
        return computeSize(this.root);
    }

    private int computeSize(TreeNode node) {
        if(node==null){
            return 0;
        }
        return 1+ computeSize(node.left)+ computeSize(node.right);

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BinaryTree){
            BinaryTree that = (BinaryTree) obj;
            if(btreeEquals(this.root,that.root)){
                return true;
            }
        }
        return  false;
    }

    private boolean btreeEquals(TreeNode lhs, TreeNode rhs) {
        if(lhs == null || rhs == null){
            return true;
        }
        return (lhs.number.equals(rhs.number)) && btreeEquals(lhs.left,rhs.left) && btreeEquals(lhs.right,rhs.right);
    }
}
