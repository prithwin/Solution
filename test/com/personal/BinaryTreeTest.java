package com.personal;

import com.personal.util.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

    @Test public void testGetNodeDepth() {
        assertEquals(4, getSampleBinaryTree().getNodeDepth(new TreeNode(9)));
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
        assertEquals(26 , btree.root.number.number);
    }

    @Test public void testPrintLeft() {
        BinaryTree btree = getSampleBinaryTree();
        btree.printLeftView();
    }

    @Test public void testPrintRightView() {
        getSampleBinaryTree().printRightView();
    }

    @Test public void testPrintVertically() {
        getSampleBinaryTree().printTreeVertically();
    }

    @Test public void testPrintTopView() {
        getSampleBinaryTree().printTopView();
    }

    @Test public void testPrintBottomView() {
        getSampleBinaryTree().printBottomView();
    }

    @Test public void testIfTreeContainsRootToLeafSum() {
        assertTrue(getSampleBinaryTree().checkRootToLeafSum(7));
    }

    @Test public void testGetDistanceBetweenNodes() {
        BinaryTree binaryTree = getSampleBinaryTree();
        assertEquals(6,binaryTree.getDistance(new TreeNode(4), new TreeNode(9)));
        assertEquals(3,binaryTree.getDistance(new TreeNode(4), new TreeNode(5)));
    }

    @Test public void getLowestCommonAncestor() {
        BinaryTree binaryTree = getSampleBinaryTree();
        assertEquals(new TreeNode(1), binaryTree.getLowestCommonAncestor(new TreeNode(4), new TreeNode(9)));
    }

    @Test public void getMaxValue(){
        assertEquals(9,getSampleBinaryTree().getMaxValue());
    }

    @Test public void getMinValue() {
        assertEquals(1,getSampleBinaryTree().getMinValue());
    }

    @Test public void testGetBinaryTre() throws IOException {
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        BinaryTree btree = BinaryTree.newInstancefromPreOrder(preOrder);
        btree.printPreOrder();
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
        System.out.println(bst);
        return bst;
    }

    @Test public void testBSTDSRLZ() {
        BinaryTree b = new BinaryTree();
        b.root = new BinaryTree().deserialize("[2,1]");
        System.out.println(b);
    }
}
