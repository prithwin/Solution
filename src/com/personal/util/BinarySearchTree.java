package com.personal.util;

import java.io.Serializable;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by pr250155 on 3/24/17.
 */
public class BinarySearchTree extends BinaryTree implements Serializable{

    public void add(TreeNode node) {
        if(this.root == null){
            this.root = node;
            return;
        }
        addBSTInternal(root,node);
    }

    @Override
    public int getMinValue(){
        TreeNode temp = root;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp.number.number;
    }

    @Override
    public int getMaxValue(){
        TreeNode temp = root;
        while(temp.right!=null){
            temp = temp.right;
        }
        return temp.number.number;
    }

    private TreeNode addBSTInternal(TreeNode currentRoot,TreeNode node) {
       if(currentRoot==null){
          return currentRoot;
       }
        if(currentRoot.left==null && node.number.compareTo(currentRoot.number)<=0){
            currentRoot.left = node;
            return currentRoot;
        }
        if(currentRoot.right==null && node.number.compareTo(currentRoot.number)==1){
            currentRoot.right = node;
            return currentRoot;
        }
        if(node.number.compareTo(currentRoot.number) == -1){
            return addBSTInternal(currentRoot.left,node);
        } else {
            return addBSTInternal(currentRoot.right,node);
        }
    }

    @Override
    public TreeNode getLowestCommonAncestor(TreeNode thiz, TreeNode dat) {
       return getLCABST(root,thiz,dat);

    }

    private TreeNode getLCABST(TreeNode currentRoot, TreeNode thiz, TreeNode dat) {
        if(thiz.number.compareTo(currentRoot.number) == -1 &&
                dat.number.compareTo(currentRoot.number) == 1){
            return currentRoot;
        }else if(thiz.number.compareTo(currentRoot.number) == -1 &&
                dat.number.compareTo(currentRoot.number) == -1 && thiz.left!=null){
                return getLCABST(currentRoot.left,thiz,dat);
        }
        else {
                return getLCABST(currentRoot.right,thiz,dat);
        }
    }

    public void balanceBST(){
        List<TreeNode> flattenedList = new LinkedList<>();
        inOrderAddToList(root,flattenedList);
        int mid = (flattenedList.size()-1)/2;
        int i = 0, j = 0 ;
        BinarySearchTree balancedBst = new BinarySearchTree();
        if(flattenedList.size() % 2 == 0){
            i = mid;
            j = i+1;
        } else {
            balancedBst.add(new TreeNode(flattenedList.get(mid).number.number));
            i = mid-1;
            j = mid+1;
        }
        BinarySearchTree BalancedBst = new BinarySearchTree();
        while(true) {
            if(i<0 && j>flattenedList.size()-1){
                break;
            }
            if(i>=0){
                balancedBst.add(new TreeNode(flattenedList.get(i--).number.number));
            }
            if(j<= flattenedList.size()-1){
                balancedBst.add(new TreeNode(flattenedList.get(j++).number.number));
            }
        }
        this.root = balancedBst.root;
    }

    private void inOrderAddToList(TreeNode node, List<TreeNode> flattenedList) {
        if(node == null){
            return;
        }
        inOrderAddToList(node.left,flattenedList);
        flattenedList.add(node);
        inOrderAddToList(node.right,flattenedList);
    }

    @Override
    public void remove(TreeNode node) {
        if(node.equals(this.root)){
            TreeNode phantom = new TreeNode(0);
            if(root.number.number > 0) {
                phantom.right = root;
                removeInternal(phantom, phantom.right,node);
                this.root = phantom.right;
            } else {
                phantom.left = root;
                removeInternal(phantom, phantom.left,node);
                this.root = phantom.left;
            }
        } else if(this.root.left!=null && node.number.compareTo(this.root.number) <=0) {
            removeInternal(this.root,this.root.left, node);
        } else if(this.root.right!=null && node.number.compareTo(this.root.number) >= 0 ) {
            removeInternal(this.root,this.root.right,node);
        }
    }

    private void removeInternal(TreeNode penultimate , TreeNode ultimate , TreeNode node) {
        if(ultimate == null) return;
        if(ultimate.equals(node)) {
            if(ultimate.left == null && ultimate.right == null) {
                transplant(penultimate,ultimate , null);
            }
            else if(ultimate.left == null || ultimate.right == null){
                if(ultimate.left != null) {
                    transplant(penultimate,ultimate,ultimate.left);
                } else {
                    transplant(penultimate,ultimate ,ultimate.right);
                }
            } else {
                TreeNode rLargest = ultimate.right;
                TreeNode rLargetp = penultimate.right;
                ultimate.number = rLargest.number;
                removeInternal(rLargetp,rLargest,new TreeNode(rLargest.number.number));
            }
            return;
        }
        if(ultimate.left!=null && node.number.compareTo(ultimate.number) <= 0){
            if(penultimate.left!=null && node.number.compareTo(penultimate.number) <= 0) {
                removeInternal(penultimate.left, ultimate.left, node);
            } else {
                removeInternal(penultimate.right, ultimate.left, node);
            }
        }
        if(ultimate.right!=null && node.number.compareTo(ultimate.number) == 1){
            if(penultimate.right!=null && node.number.compareTo(penultimate.number) == 1) {
                removeInternal(penultimate.right, ultimate.right, node);
            } else {
                removeInternal(penultimate.left, ultimate.right, node);
            }
        }
    }

    private void transplant(TreeNode penultimate, TreeNode ultimate, TreeNode replacement) {
        if(penultimate.left!=null) {
            if (penultimate.left.equals(ultimate)) {
                penultimate.left = replacement;
            }
        }
        if(penultimate.right!=null) {
            if (penultimate.right.equals(ultimate)) {
                penultimate.right = replacement;
            }
        }
    }
}
