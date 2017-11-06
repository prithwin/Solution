import com.functional.util.{BinarySearchTree, BinaryTree, LinkedList, TreeNode}

/**
  * Created by prajeeva on 9/7/17.
  */

object TreeInitializer {
  def main(args: Array[String]): Unit = {
    var tree = BinaryTree()
    tree.root =  TreeNode(1)
    tree.root.data = 1
    tree.root.left =  TreeNode(2)
    tree.root.right =  TreeNode(3)
    tree.root.left.left =  TreeNode(4)
    tree.root.left.right =  TreeNode(5)
    tree.root.right.left =  TreeNode(6)
    tree.root.right.right =  TreeNode(7)
    tree.printLevelOrder
    println(tree.height)
    println(tree.size)


    var tree2 =  BinaryTree()
    tree2.root =  TreeNode(1)
    tree2.root.data = 1
    tree2.root.left =  TreeNode(2)
    tree2.root.right =  TreeNode(3)
    tree2.root.left.left =  TreeNode(4)
    tree2.root.left.right =  TreeNode(5)
    tree2.root.right.left =  TreeNode(6)
    tree2.root.right.right =  TreeNode(7)
    println(tree.equals(tree2))

    tree2.mirror
    println("=====================mirrored tree===================")
    tree2.printLevelOrder

    tree.printAllPaths
    println(tree.leafCount)
    println("=====================Spiral tree===================")
    tree.printSpiralOrder

    var tree3 =  BinaryTree()
    tree3.root =  TreeNode(1)
    tree3.root.data = 100
    tree3.root.left =  TreeNode(50)
    tree3.root.right =  TreeNode(120)
    tree3.root.left.left =  TreeNode(14)
    tree3.root.left.right =  TreeNode(51)
    tree3.root.right.left =  TreeNode(119)
    tree3.root.right.right =  TreeNode(121)
    println(tree.isBST)
    println("=====================left view =====================")
    tree.printLeftView()

    println("=====================right view =====================")
    tree.printRightView()
    println("=====================top view =====================")
    tree.printTopView()

    println("=====================bottom view =====================")
    tree.printBottomView()

    println("======================vertical view ===================")
    tree.printVertically

    println("======================outline view ===================")
    tree.printOutline

    println("=====================Binary Search Tree=================")
    var binarySearchTree = BinarySearchTree()

    binarySearchTree += 56
    binarySearchTree += 1
    binarySearchTree += 12
    binarySearchTree += 57
    binarySearchTree += 64
    binarySearchTree += 156
    binarySearchTree.printInOrder

    println()
    println(s"The Penultimate Elements is ${binarySearchTree.pen().data}")
    println()

    binarySearchTree -= 57
    println("=====================Binary Search Tree deleted 57=================")
    binarySearchTree.printInOrder

    binarySearchTree -= 1
    println("=====================Binary Search Tree deleted 1=================")
    binarySearchTree.printInOrder

    binarySearchTree -= 156
    println("=====================Binary Search Tree deleted 156=================")
    binarySearchTree.printInOrder

    println("=====================Adding the deleted elements back into the binary serach tree==========")
    binarySearchTree +=1
    binarySearchTree += 57
    binarySearchTree += 156
    binarySearchTree.printInOrder

    println(s"the LCA of 1 and 156 in the binary search tree is ${binarySearchTree.lca(1, 156)}")

    tree.flatten
    tree.printOnlyRight

    println("this the dreaded balance a binary tree probelm")

    val sortedList = LinkedList()
    sortedList += 1
    sortedList += 2
    sortedList += 3
    sortedList += 4
    sortedList += 5
    sortedList += 6
    sortedList += 7
    sortedList += 8
//    sortedList += 9

    //this is how you remind me of what i really am

    var bbinsertree = BinarySearchTree(sortedList.head)
    bbinsertree.printInOrder


  }
}