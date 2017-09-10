import com.functional.util.{BinarySearchTree, BinaryTree, TreeNode}

/**
  * Created by prajeeva on 9/7/17.
  */

object TreeInitializer {
  def main(args: Array[String]): Unit = {
    var tree = new BinaryTree()
    tree.root = new TreeNode(1)
    tree.root.data = 1
    tree.root.left = new TreeNode(2)
    tree.root.right = new TreeNode(3)
    tree.root.left.left = new TreeNode(4)
    tree.root.left.right = new TreeNode(5)
    tree.root.right.left = new TreeNode(6)
    tree.root.right.right = new TreeNode(7)
    tree.printLevelOrder
    println(tree.height)
    println(tree.size)


    var tree2 = new BinaryTree()
    tree2.root = new TreeNode(1)
    tree2.root.data = 1
    tree2.root.left = new TreeNode(2)
    tree2.root.right = new TreeNode(3)
    tree2.root.left.left = new TreeNode(4)
    tree2.root.left.right = new TreeNode(5)
    tree2.root.right.left = new TreeNode(6)
    tree2.root.right.right = new TreeNode(7)
    println(tree.equals(tree2))

    tree2.mirror
    println("=====================mirrored tree===================")
    tree2.printLevelOrder

    tree.printAllPaths
    println(tree.leafCount)
    println("=====================Spiral tree===================")
    tree.printSpiralOrder

    var tree3 = new BinaryTree()
    tree3.root = new TreeNode(1)
    tree3.root.data = 100
    tree3.root.left = new TreeNode(50)
    tree3.root.right = new TreeNode(120)
    tree3.root.left.left = new TreeNode(14)
    tree3.root.left.right = new TreeNode(51)
    tree3.root.right.left = new TreeNode(119)
    tree3.root.right.right = new TreeNode(121)
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


  }
}