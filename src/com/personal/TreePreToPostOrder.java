package com.personal;

import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

/**
 * Created by pr250155 on 5/8/17.
 */
public class TreePreToPostOrder {

    public BinaryTree getPostOrder(int[] preOrder,int[] inOrder) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = getSubTree(preOrder, inOrder);
        return binaryTree;
    }

    private TreeNode getSubTree(int[] preOrder,int[] inOrder){
        if(preOrder.length == 3){
            TreeNode root = new TreeNode(preOrder[0]);
            root.left = new TreeNode(preOrder[1]);
            root.right = new TreeNode(preOrder[2]);
            return root;
        }
        if(preOrder.length==2){
            TreeNode root = new TreeNode(preOrder[0]);
            if(inOrder[0] == preOrder[0]){
                root.right = new TreeNode(preOrder[1]);
            }else {
                root.left = new TreeNode(preOrder[1]);
            }
            return root;
        }
        if(preOrder.length==1){
            TreeNode root = new TreeNode(preOrder[0]);
            return root;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        int rootLocationIo = 0;
        for(int i = 0 ; i < inOrder.length ; i++) {
            if(inOrder[i] == preOrder[0]){
                rootLocationIo = i;break;
            }
        }
        int[] leftInOrder = getSubArray(inOrder, 0, rootLocationIo - 1);
        int[] leftPreOrder = getSubArrayFromIo(0,leftInOrder.length,preOrder);
        root.left = getSubTree(leftPreOrder,leftInOrder);

        int[] rightInOrder = getSubArray(inOrder, rootLocationIo +1,inOrder.length-1);
        int[] rightPreOrder = getSubArrayFromIo(leftInOrder.length,rightInOrder.length,preOrder);
        root.right = getSubTree(rightPreOrder,rightInOrder);
        return root;
    }

    private int[] getSubArrayFromIo(int offset,int length, int[] preOrder) {
        int[] result = new int[length];
        for(int j=0, i = 1+offset ; i < 1+ offset+ length ; i++,j++) {
            result[j] = preOrder[i];
        }
        return result;
    }

    private int[] getSubArray(int[] inOrder, int start, int end) {
        int[] result = new int[end-start+1];
        for(int i = start,j=0 ; i <=end ;i++,j++ ) {
            result[j] = inOrder[i];
        }
        return result;
    }
}
