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
            this.root = null;
        } else if(this.root.left!=null && node.number.compareTo(this.root.left.number) <=0) {
            removeInternal(this.root,this.root.left, node);
        } else if(this.root.right!=null && node.number.compareTo(this.root.right.number) >= 0 ) {
            removeInternal(this.root,this.root.right,node);
        }
    }

    private void removeInternal(TreeNode penultimate , TreeNode ultimate , TreeNode node) {
        if(ultimate == null) return;
        if(ultimate.equals(node)) {
            if(ultimate.left == null && ultimate.right == null) {
                transplant(penultimate, null);
            }
            else if(ultimate.left == null || ultimate.right == null){
                if(ultimate.left != null) {
                    transplant(penultimate, ultimate.left);
                } else {
                    transplant(penultimate, ultimate.right);
                }
            } else {
                TreeNode rLargest = ultimate;
                TreeNode rLargetp = penultimate;
                while(rLargest.right!=null){
                    rLargest = rLargest.right;
                    rLargetp = rLargetp.right;
                }
                ultimate.number = rLargest.number;
                removeInternal(rLargetp,rLargest,node);
            }
        }
        if(root.left!=null && node.number.compareTo(ultimate.number) <= 0){
            removeInternal(penultimate.left,ultimate.left,node);
        }
        if(root.right!=null && node.number.compareTo(ultimate.number) == 1){
            removeInternal(penultimate.right,ultimate.right,node);
        }
    }

    private void transplant(TreeNode target, TreeNode node) {
        if(target.number.compareTo(node.number) == 1) {
            target.left = node;
        } else {
            target.right = node;
        }
    }
}
