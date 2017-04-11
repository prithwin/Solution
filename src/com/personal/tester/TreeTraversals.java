package com.personal.tester;

import com.personal.util.BinarySearchTree;
import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

/**
 * Created by prajeev on 19/3/17.
 */
public class TreeTraversals {
    BinaryTree tree;

    public static void main(String[] args) {
        TreeTraversals treeTraversals = new TreeTraversals();
        treeTraversals.tree = new BinaryTree(1);
        treeTraversals.tree.root.left = new TreeNode(2);
        treeTraversals.tree.root.right = new TreeNode(3);
        treeTraversals.tree.root.left.left = new TreeNode(4);
        treeTraversals.tree.root.left.right = new TreeNode(5);
        treeTraversals.tree.root.right.left = new TreeNode(6);
        treeTraversals.tree.root.right.left.left = new TreeNode(8);
        treeTraversals.tree.root.right.left.right = new TreeNode(9);
        treeTraversals.tree.root.right.right = new TreeNode(7);

        System.out.println("printing in order");
        treeTraversals.tree.printinOrder();
        System.out.println("printing pre order");
        treeTraversals.tree.printPreOrder();
        System.out.println("printing post order");
        treeTraversals.tree.printPostOrder();

        System.out.println("the height of this tree is:" + treeTraversals.tree.height());
        System.out.println("the size of this tree is:" + treeTraversals.tree.size());
        System.out.println("printing the Tree in level order");
        treeTraversals.tree.printLevelOrder();
        TreeTraversals treeTraversals2 = new TreeTraversals();
        treeTraversals2.tree = new BinaryTree(1);
        treeTraversals2.tree.root.left = new TreeNode(2);
        treeTraversals2.tree.root.right = new TreeNode(3);
        treeTraversals2.tree.root.left.left = new TreeNode(4);
        treeTraversals2.tree.root.left.right = new TreeNode(5);
        treeTraversals2.tree.root.right.left = new TreeNode(6);
//        treeTraversals2.tree.root.right.left.left = new TreeNode(8);
//        treeTraversals2.tree.root.right.left.right = new TreeNode(9);
        treeTraversals2.tree.root.right.right = new TreeNode(7);
        treeTraversals2.tree.summer();

        System.out.println("checking equality with a Copy: "+ treeTraversals.tree.equals(treeTraversals2.tree));

        System.out.println("mirroring second tree and printing the level order traversal:");
        //treeTraversals2.tree.mirror();
        treeTraversals2.tree.printLevelOrder();

        System.out.println("printing all the paths in this tree:");
        treeTraversals.tree.printAllPaths();

        System.out.println("printing the Tree in spiral order");
        treeTraversals2.tree.printSpiralOrder();

        System.out.println("This tree has "+treeTraversals2.tree.countLeaves()+ " leaves");

        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TreeNode(45));
        bst.add(new TreeNode(443));
        bst.add(new TreeNode(4));
        bst.add(new TreeNode(1));
        bst.add(new TreeNode(1));
        bst.add(new TreeNode(3));
        bst.add(new TreeNode(67));
        bst.add(new TreeNode(999));
        bst.add(new TreeNode(999));
        bst.add(new TreeNode(7));
        bst.add(new TreeNode(4534));

        System.out.println("Printing BST in order no matter what you do its always in order");
        bst.printinOrder();

        System.out.println("we can also find the min and max value of a tree");
        System.out.println("Minvalue:"+ bst.minValue());

        System.out.println("MaxValue:"+ bst.maxValue());
        System.out.println(bst.isTreeBST());
        System.out.println(treeTraversals.tree.isTreeBST());
        System.out.println("left view of the binary tree is: ");
        treeTraversals.tree.printLeftView();
        System.out.println("\nright view of the binary tree is: ");
        treeTraversals.tree.printRightView();

    }
}
