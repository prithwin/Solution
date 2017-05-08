package com.personal;

import com.personal.util.BinaryTree;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/8/17.
 */
public class PreOrderToBSTTest {
    @Test public void testGetBST() throws IOException {
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(pos));
        BinaryTree btree = new PreOrderToBST().getBinaryTree(preOrder);
        btree.printPreOrder();
        System.out.println();
        Scanner scanner = new Scanner(pis);
        String[] preOrderArray = scanner.nextLine().trim().split("\\s+e");
        for (int i = 0 ; i < preOrder.length ; i++) {
            assertEquals(preOrder[i]+"" , preOrderArray[i]);
        }
    }

}
