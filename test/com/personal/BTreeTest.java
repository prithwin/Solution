package com.personal;

import java.util.*;

import com.personal.util.BTreeNode;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.personal.util.BTree;

/**
 * Created by prith on 15-06-2017.
 */
public class BTreeTest {
    @Test public void testBtreeCreationWithJustRoot(){
        BTree bTree = new BTree(3);
        BTreeNode lefNode = new BTreeNode(3);
        System.out.println("");
    }
}
