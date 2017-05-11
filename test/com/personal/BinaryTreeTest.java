package com.personal;

import com.personal.util.BinarySearchTree;
import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/11/17.
 */
public class BinaryTreeTest {
    @AfterMethod public void finish() {
        System.out.println();
    }

    @Test public void basicTraversalTest(){
        BinaryTree btree = getSampleBinaryTree();
        btree.printinOrder();
        System.out.println();
        btree.printPreOrder();
        System.out.println();
        btree.printPostOrder();
    }

    @Test public void testLevelOrderTraversals() {
        getSampleBinaryTree().printLevelOrder();
    }

    @Test public void testComputeHeight() {
        assertEquals(4, getSampleBinaryTree().height());
    }

    @Test public void testComputeSize() {
        assertEquals(9,getSampleBinaryTree().size());
    }

    @Test public void testBinaryTreeEquality() {
        BinaryTree lhs = getSampleBinaryTree();
        BinaryTree rhs = getSampleBinaryTree();
        assertNotSame(lhs,rhs);
        assertEquals(lhs,rhs);
    }

    @Test public void testMirrorBinaryTree() {
        BinaryTree target = getSampleBinaryTree();
        target.mirror();
        target.printLevelOrder();
    }

    @Test public void printAllRootToLeafPaths() {
        BinaryTree target = getSampleBinaryTree();
        target.printAllPaths();
    }

    @Test public void testCountLeaves() {
        BinaryTree btree = getSampleBinaryTree();
        assertEquals(4, btree.countLeaves());
    }

    @Test public void testPrintSpiralOrder() {
        getSampleBinaryTree().printSpiralOrder();
    }

    @Test public void testIfTreeBST() {
        assertFalse(getSampleBinaryTree().isTreeBST());
        assertTrue(getSampleBST().isTreeBST());
    }

    @Test public void testTreeSummer(){
        BinaryTree btree = getSampleBinaryTree();
        btree.summer();
        assertEquals(5 , btree.root.number.number);
    }

    @Test public void testAggregator(){
        BinaryTree btree = getSampleBinaryTree();
        btree.aggregate();
        assertEquals(36 , btree.root.number.number);
    }

    private BinaryTree getSampleBinaryTree() {
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.left.right = new TreeNode(8);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.right = new TreeNode(9);
        return tree;
    }

    private BinaryTree getSampleBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TreeNode(45));
        bst.add(new TreeNode(443));
        bst.add(new TreeNode(4));
        bst.add(new TreeNode(1));
        bst.add(new TreeNode(3));
        bst.add(new TreeNode(67));
        bst.add(new TreeNode(999));
        bst.add(new TreeNode(999));
        bst.add(new TreeNode(7));
        bst.add(new TreeNode(4534));
        return bst;
    }
}
