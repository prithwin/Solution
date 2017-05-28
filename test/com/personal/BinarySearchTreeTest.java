package com.personal;

import com.personal.util.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/12/17.
 */
public class BinarySearchTreeTest {
    @Test public void testGetMaxValue() {
        assertEquals(getSampleBST().getMaxValue(),4534);
    }

    @Test public void testGetMinValue() {
        assertEquals(getSampleBST().getMinValue(), 1);
    }

    @Test public void testRemoveFromBST () {
        BinarySearchTree binaryTree = getSampleBST();
        System.out.println("\nORIGINAL TREE\n");
        binaryTree.printinOrder();
        System.out.println("\nRemoving-67\n");
       binaryTree.remove(new TreeNode(67));
        binaryTree.printinOrder();
        System.out.println("\nRemoving-45\n");
        binaryTree.remove(new TreeNode(45));
        binaryTree.printinOrder();
        System.out.println("\nRemoving-899\n");
        binaryTree.remove(new TreeNode(899));
        binaryTree.printinOrder();
        System.out.println("\nRemoving-7\n");
        binaryTree.remove(new TreeNode(7));
        binaryTree.printinOrder();
        System.out.println("\nadding-998\n");
        binaryTree.add(new TreeNode(998));
        binaryTree.printinOrder();
        System.out.println("\nRemoving-4534\n");
        binaryTree.remove(new TreeNode(4534));
        binaryTree.printinOrder();
        System.out.println("\nRemoving-1\n");
        binaryTree.remove(new TreeNode(1));
        binaryTree.printinOrder();

        System.out.println("\nadding-4545\n");
        binaryTree.add(new TreeNode(4545));
        binaryTree.printinOrder();


    }

    @Test public void checkAVLCreation() {
        assertTrue(getSampleAvlTree().isTreeBST());
    }

    @Test public void checkAVLDeletion() {
        AVLTree tree = getSampleAvlTree();
        tree.remove(new AVLTreeNode(36));
        assertTrue(tree.isTreeBST());
        System.out.println();
        tree.printAVLTree();
    }

    private AVLTree getSampleAvlTree(){
        AVLTree avlTree = new AVLTree();
        avlTree.add(new AVLTreeNode(5));
        avlTree.add(new AVLTreeNode(6));
        avlTree.add(new AVLTreeNode(7));
        avlTree.add(new AVLTreeNode(8));
        avlTree.add(new AVLTreeNode(9));
        avlTree.add(new AVLTreeNode(10));
        avlTree.add(new AVLTreeNode(11));
        avlTree.add(new AVLTreeNode(12));
        avlTree.add(new AVLTreeNode(13));
        avlTree.add(new AVLTreeNode(34));
        avlTree.add(new AVLTreeNode(36));
        avlTree.add(new AVLTreeNode(37));
        avlTree.add(new AVLTreeNode(38));
        avlTree.add(new AVLTreeNode(39));
        avlTree.add(new AVLTreeNode(555));
        avlTree.add(new AVLTreeNode(1));
        avlTree.add(new AVLTreeNode(2));
        avlTree.add(new AVLTreeNode(3));
        avlTree.add(new AVLTreeNode(4));
        avlTree.printAVLTree();
        return avlTree;
    }

    private BinarySearchTree getSampleBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TreeNode(45));
        bst.add(new TreeNode(50));
        bst.add(new TreeNode(443));
        bst.add(new TreeNode(4));
        bst.add(new TreeNode(1));
        bst.add(new TreeNode(13));
        bst.add(new TreeNode(23));
        bst.add(new TreeNode(33));
        bst.add(new TreeNode(67));
        bst.add(new TreeNode(899));
        bst.add(new TreeNode(999));
        bst.add(new TreeNode(7));
        bst.add(new TreeNode(677));
        bst.add(new TreeNode(4534));
        bst.balanceBST();
        return bst;
    }
}
