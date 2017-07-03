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

    @Test public void checkRedBlackTreeCreateCreation() {
        assertTrue(getSampleRedBlackree().isTreeBST());
    }

    @Test public void testRedBlackTreeDeletion() {
        RedBlackTree tree = getSampleRedBlackree();
        tree.delete(new RedBlackTreeNode(36));
        System.out.println();
        tree.printRedBlackTree();
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

    private RedBlackTree getSampleRedBlackree(){
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.add(new RedBlackTreeNode(5));
        redBlackTree.add(new RedBlackTreeNode(6));
        redBlackTree.add(new RedBlackTreeNode(7));
        redBlackTree.add(new RedBlackTreeNode(8));
        redBlackTree.add(new RedBlackTreeNode(9));
        redBlackTree.add(new RedBlackTreeNode(10));
        redBlackTree.add(new RedBlackTreeNode(11));
        redBlackTree.add(new RedBlackTreeNode(12));
        redBlackTree.add(new RedBlackTreeNode(13));
        redBlackTree.add(new RedBlackTreeNode(34));
        redBlackTree.add(new RedBlackTreeNode(36));
        redBlackTree.add(new RedBlackTreeNode(37));
        redBlackTree.add(new RedBlackTreeNode(38));
        redBlackTree.add(new RedBlackTreeNode(39));
        redBlackTree.add(new RedBlackTreeNode(555));
        redBlackTree.add(new RedBlackTreeNode(1));
        redBlackTree.add(new RedBlackTreeNode(2));
        redBlackTree.add(new RedBlackTreeNode(3));
        redBlackTree.add(new RedBlackTreeNode(4));
        redBlackTree.printRedBlackTree();
        return redBlackTree;
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
    @Test(enabled = false) public void testSplay() {
        SplayTree st = getSplayBST();
        st.search(23);
        System.out.println();
    }

    private SplayTree getSplayBST() {
        SplayTree bst = new SplayTree();
        bst.add(45);
        bst.add(50);
        bst.add(443);
        bst.add(4);
        bst.add(1);
        bst.add(13);
        bst.add(23);
        bst.add(33);
        bst.add(67);
        bst.add(899);
        bst.add(999);
        bst.add(7);
        bst.add(677);
        bst.add(4534);
        return bst;
    }
}
