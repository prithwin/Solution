package com.personal;

import com.personal.util.BinaryTree;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/8/17.
 */
public class TreePreToPostOrderTest {
    @Test public void testFunctionality() {
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 3, 6};
        BinaryTree binaryTree = new TreePreToPostOrder().getPostOrder(preOrder, inOrder);
        binaryTree.printinOrder();
        System.out.println();
        binaryTree.printPreOrder();
    }
}
