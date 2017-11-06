package com.random.test.old;

import com.personal.util.BinarySearchTree;
import com.personal.util.TreeNode;

import java.io.*;

/**
 * Created by pr250155 on 4/1/17.
 */
public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.add(new TreeNode(45));
//        bst.add(new TreeNode(443));
//        bst.add(new TreeNode(4));
//        bst.add(new TreeNode(1));
//        bst.add(new TreeNode(1));
//        bst.add(new TreeNode(3));
//        bst.add(new TreeNode(67));
//        bst.add(new TreeNode(999));
//        bst.add(new TreeNode(999));
//        bst.add(new TreeNode(7));
//        bst.add(new TreeNode(4534));
//
//        FileOutputStream fox= new FileOutputStream(new File("./premadebst"));
//        ObjectOutputStream serializer = new ObjectOutputStream(fox);
//        serializer.writeObject(bst);
//        serializer.close();


        FileInputStream buffer = new FileInputStream(new File("./premadebst"));
        ObjectInputStream inputStream = new ObjectInputStream(buffer);
        BinarySearchTree preMadeBst = (BinarySearchTree) inputStream.readObject();
        preMadeBst.printinOrder();

    }
}
