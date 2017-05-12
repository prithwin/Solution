package com.personal;

import com.personal.util.BinarySearchTree;
import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;
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
        assertEquals(getSampleBST().getMinValue(),1);
    }

    @Test public void testRemoveFromBST () {
        BinaryTree binaryTree = getSampleBST();
        binaryTree.remove(new TreeNode(67));
        binaryTree.printinOrder();
        binaryTree.remove(new TreeNode(45));
        binaryTree.printinOrder();
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
        bst.add(new TreeNode(7));
        bst.add(new TreeNode(4534));
        bst.balanceBST();
        return bst;
    }
}
