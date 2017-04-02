package com.personal.util;

import java.io.Serializable;

/**
 * Created by pr250155 on 3/24/17.
 */
public class BinarySearchTree extends BinaryTree implements Serializable{

    public void add(TreeNode node){
        if(this.root == null){
            this.root = node;
            return;
        }
        addBSTInternal(root,node);
    }

    public TreeNode minValue(){
        TreeNode temp = root;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }

    public TreeNode maxValue(){
        TreeNode temp = root;
        while(temp.right!=null){
            temp = temp.right;
        }
        return temp;
    }

    private void addBSTInternal(TreeNode currentRoot,TreeNode node) {
       if(currentRoot==null){
          return;
       }
        if(currentRoot.left==null && node.number.compareTo(currentRoot.number)<=0){
            currentRoot.left = node;
            return;
        }
        if(currentRoot.right==null && node.number.compareTo(currentRoot.number)==1){
            currentRoot.right = node;
            return;
        }
        if(node.number.compareTo(currentRoot.number) == -1){
            addBSTInternal(currentRoot.left,node);
        } else {
            addBSTInternal(currentRoot.right,node);
        }
    }
}
