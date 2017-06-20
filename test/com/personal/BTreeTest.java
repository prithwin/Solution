package com.personal;

import java.util.*;

import com.personal.util.BTreeNode;
import com.personal.util.ComparableNumber;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.personal.util.BTree;

/**
 * Created by prith on 15-06-2017.
 */
public class BTreeTest {
    @Test public void testBtreeCreationWithJustRoot(){
        BTree bTree = new BTree(5);

        bTree.add(new ComparableNumber(10));
        bTree.add(new ComparableNumber(8));
        bTree.add(new ComparableNumber(6));
        bTree.add(new ComparableNumber(4));
        bTree.add(new ComparableNumber(5));
        System.out.println("");
        bTree.add(new ComparableNumber(15));
        bTree.add(new ComparableNumber(21));
        bTree.add(new ComparableNumber(19));
        bTree.add(new ComparableNumber(9));
        bTree.add(new ComparableNumber(11));
        bTree.add(new ComparableNumber(12));
        bTree.add(new ComparableNumber(13));
        bTree.add(new ComparableNumber(22));
        bTree.add(new ComparableNumber(23));
        bTree.add(new ComparableNumber(24));
        bTree.add(new ComparableNumber(3));
        bTree.add(new ComparableNumber(2));
        bTree.add(new ComparableNumber(1));
        bTree.add(new ComparableNumber(455));
        bTree.add(new ComparableNumber(456));
        bTree.add(new ComparableNumber(457));
        System.out.println("test");
    }
}
