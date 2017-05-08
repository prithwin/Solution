package com.personal;

import com.personal.util.BinaryTree;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/8/17.
 */
public class PreOrderToBSTTest {
    @Test public void testGetBST() {
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        BinaryTree btree = new PreOrderToBST().getBinaryTree(preOrder);
        System.out.println("");
    }

}
