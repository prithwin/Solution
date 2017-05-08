package com.personal;

import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

/**
 * Created by pr250155 on 5/8/17.
 */
public class PreOrderToBST {
    public BinaryTree getBinaryTree(int[] preOrder){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = constructBinaryTreeFromPreOrder(preOrder,0,preOrder.length-1);
        return binaryTree;
    }

    private TreeNode constructBinaryTreeFromPreOrder(int[] preOrder,int start,int end){
        if(end < start){
            return null;
        }
        if(end == start){
            return new TreeNode(preOrder[start]);
        }

        TreeNode root = new TreeNode(preOrder[start]);
        int rightTreeStart = 0;
        for(int j = end ; preOrder[j] > preOrder[start] ; j--) {
            rightTreeStart = j;
        }
        root.right = constructBinaryTreeFromPreOrder(preOrder,rightTreeStart, end);
        root.left = constructBinaryTreeFromPreOrder(preOrder,start+1,rightTreeStart-1);
        return root;
    }
}
