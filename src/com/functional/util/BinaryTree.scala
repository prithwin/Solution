package com.functional.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by prajeeva on 9/7/17.
  */
case class BinaryTree(var root:TreeNode) {
  def printInOrder(): Unit = printInOrderInternal(root)
  def printPreOrder(): Unit  = printPreOrderInternal(root)
  def printPostOrder(): Unit  = printPostOrderInternal(root)
  def height:Int = height(root)
  def size:Int = size(root)
  def mirror():Unit = mirror(root)
  def leafCount():Int = leafCount(root)
  def isBST():Boolean = isBSTInternal(root, Int.MinValue , Int.MaxValue)
  def trim(low:Int , high:Int):Unit = {
    root = trim(low, high , root)
  }

  def hasPathSum(sum:Int):Boolean = hasPathSum(root , sum)

  private def hasPathSum(node: TreeNode, i: Int):Boolean = {
    true
  }

  private def trim(low:Int , high:Int , node:TreeNode):TreeNode = {
    if(node.data < low) {
      trim(low , high , node.right)
    } else if(node.data > high) {
      trim(low , high , node.left)
    } else {
      node.left = trim(low,high , node.left)
      node.right = trim(low , high , node.right)
      node
    }
  }

  def printOnlyRight:Unit = {
    var temp = root
    while(temp!=null) {
      println(temp.data)
      temp = temp.right
    }
  }

  def printOutline():Unit = {
    var map = mutable.TreeMap[Int , mutable.MutableList[Int]]()
    printOutlineInternal(root , map , 0)
    println(map(map.firstKey).head)
    map.filterKeys(k => k != map.firstKey && k != map.lastKey).values.foreach(v => println(v.head))
    println(map(map.lastKey).head)
    map.filterKeys(k => k != map.firstKey && k != map.lastKey).keys.toList.reverse.foreach(k => println(map(k)(map(k).length - 1)))
  }

  def flatten(): Unit = {
    root = flatten(root)
    while(root.left!=null) root = root.left
  }

  def flattenRight(): Unit = flattenRight(root)

  private def flattenRight(node:TreeNode):TreeNode = {
    if(node == null) return node
    var left = node.left
    var right = node.right

    left = flattenRight(left)
    right = flattenRight(right)
    node.left = null
    node.right = left
    var temp = node
    while(temp.right!=null) temp = temp.right
    temp.right = right
    node
  }

  private def flatten(node:TreeNode):TreeNode = {
    if(node == null) return node
    if(node.left != null) {
      var left = flatten(node.left)
      while(left.right != null) left = left.right
      left.right = node
      node.left = left
    }

    if(node.right != null) {
      var right = flatten(node.right)
      while(right.left!=null) right = right.left
      right.left = node
      node.right = right
    }
    node
  }



  private def printOutlineInternal(node: TreeNode,
                                   map: mutable.TreeMap[Int, mutable.MutableList[Int]],
                                   level: Int): Unit = node match {
    case null =>
    case _ =>
      if(!map.contains(level)) {map+=(level -> mutable.MutableList(node.data))} else {map(level)+=node.data}
      printOutlineInternal(node.left , map , level - 1)
      printOutlineInternal(node.right , map , level + 1)
  }
  def printBottomView() : Unit = {
    var map = mutable.TreeMap[Int,Int]()
    printBottomViewInternal(root, 0 , map)
    map.keys.foreach(k => println(map(k)))
  }
  def printVertically():Unit = {
    var map = mutable.TreeMap[Int,mutable.MutableList[Int]]()
    printVerticallyInternal(root ,map , 0)
    map.keys.foreach(k => map(k).foreach(v => print(v+",")))
  }

  def printVerticallyInternal(node:TreeNode , map:mutable.Map[Int , mutable.MutableList[Int]] , level:Int): Unit = node match {
    case null =>
    case _ => {
      if(!map.contains(level)) {
        map += (level -> mutable.MutableList(node.data))
      } else {
        map(level)+=node.data
      }
      printVerticallyInternal(node.left , map , level - 1)
      printVerticallyInternal(node.right , map , level + 1)
    }

  }

  def printSpiralOrder():Unit = {
    var depthStack = mutable.Stack[TreeNode]()
    depthStack.push(root)
    printSpiralOrderInternal(depthStack,dir = true)
  }
  def printTopView() : Unit = {
    var map = mutable.TreeMap[Int,Int]()
    printTopViewInternal(root, 0 , map)
    map.keys.foreach(k => println(map(k)))
  }

  private def printTopViewInternal(node:TreeNode, i:Int, map:mutable.Map[Int ,Int]):Unit = node match {
    case null =>
    case _ => {
      if(!map.contains(i)) map += (i -> node.data)
      printTopViewInternal(node.left , i - 1 ,map)
      printTopViewInternal(node.right , i + 1,map)
    }
  }

  private def printBottomViewInternal(node:TreeNode, i:Int, map:mutable.Map[Int ,Int]):Unit = node match {
    case null =>
    case _ => {
      map += (i -> node.data)
      printBottomViewInternal(node.left , i - 1 ,map)
      printBottomViewInternal(node.right , i + 1,map)
    }
  }

  var maxLevel:Int = 0

  def printLeftView():Unit = {
    maxLevel = 0
    printLefViewInternal(root,1)
  }
  var maxLevelR = 0
  def printRightView():Unit = printRightViewInternal(root, 1)

  private def printRightViewInternal(node: TreeNode, level: Int):Unit = {
    if(node==null) return
    if(level > maxLevelR) {
      println(node.data)
      maxLevelR = level
    }
    printRightViewInternal(node.right,level + 1)
    printRightViewInternal(node.left,level + 1)
  }

  def printLefViewInternal(node: TreeNode, level:Int) : Unit = {
    if(node == null) return
    if(level > maxLevel) {
      println(node.data)
      maxLevel = level
    }
    printLefViewInternal(node.left, level + 1)
    printLefViewInternal(node.right, level + 1)
  }

  private def isBSTInternal(node: TreeNode , min:Int , max:Int): Boolean = {
    if(node == null) return true
    if(node.left == null && node.right == null) return true
    if(node.left!=null && node.left.data > node.data) return false
    if(node.right!=null && node.right.data < node.data) return false
    if(node.data < min || node.data >max) return false
    isBSTInternal(node.left, min, root.data ) && isBSTInternal(node.right, root.data ,max )
  }

  private def printSpiralOrderInternal(s: mutable.Stack[TreeNode], dir: Boolean): Unit = {
    if (s.isEmpty) return
    var widthSack = mutable.Stack[TreeNode]()
    while (s.nonEmpty) {
      var ex = s.pop()
      println(ex.data)
      if (dir) {
        if (ex.left != null) {
          widthSack.push(ex.left)
        }
        if (ex.right != null) {
          widthSack.push(ex.right)
        }
      } else {
        if (ex.right != null) {
          widthSack.push(ex.right)
        }
        if (ex.left != null) {
          widthSack.push(ex.left)
        }
      }
    }
    printSpiralOrderInternal(widthSack, !dir)
  }

  def printAllPaths():Unit = {
    printAllPaths(mutable.Stack[TreeNode](),root)
  }

  private def leafCount(node: TreeNode): Int = {
    if(node.left == null && node.right ==null) return 1
    var sum = 0
    if(node.left!=null) sum+=leafCount(node.left)
    if(node.right!=null) sum+=leafCount(node.right)
    sum
  }

  private def printAllPaths(s: mutable.Stack[TreeNode], node: TreeNode):Unit = {
    if(node == null) return
    s.push(node)
    if(node.left == null && node.right == null) {
      //this is the dead and I must print the contents of the stack in reverse
      s.reverse.foreach(i => print(i.data+","))
      println
    } else {
      if(node.left != null) {
        printAllPaths(s,node.left)
        s.pop
      }
      if(node.right != null) {
        printAllPaths(s , node.right)
        s.pop
      }
    }

  }


  private def mirror(node: TreeNode): Unit = {
    if(node.left!=null) mirror(node.left)
    if(node.right!=null) mirror(node.right)
    var temp = node.left
    node.left = node.right
    node.right = temp
  }

  override def equals(o: scala.Any): Boolean = {
    var that = o.asInstanceOf[BinaryTree]
    if(this.root.equals(that.root)) {
      true
    } else {
      false
    }
  }

  private def size(node:TreeNode): Int = node match {
    case null => 0
    case _ => {
      1 + size(node.left) + size(node.right)
    }
  }

  private def height(node: TreeNode): Int = node match {
    case null => 0
    case _ => 1 + math.max(height(node.left) , height(node.right))
  }


  def printLevelOrder: Unit = {
    var q = mutable.Queue[TreeNode]()
    q.enqueue(root)
    printLevelOrderInternal(q)
  }


  private def printLevelOrderInternal(q: mutable.Queue[TreeNode]): Unit = {
    if(q.nonEmpty) {
      var node  = q.dequeue()
      println(node.data)
      if(node.left!=null) q.enqueue(node.left)
      if(node.right!=null) q.enqueue(node.right)
      printLevelOrderInternal(q)
    }
  }

  private def printInOrderInternal(node: TreeNode): Unit = node match {
    case null =>
    case _ =>
      printInOrderInternal(node.left)
      println(node.data)
      printInOrderInternal(node.right)
  }

  private def printPreOrderInternal(node:TreeNode):Unit = node match {
    case null =>
    case _ =>
      println(node.data)
      printPreOrderInternal(node.left)
      printPreOrderInternal(node.right)
  }

  private def printPostOrderInternal(node:TreeNode):Unit = node match {
    case null =>
    case _ =>
      printPostOrderInternal(node.left)
      printPostOrderInternal(node.right)
      println(node.data)
  }
}

object BinaryTree {
  def apply(): BinaryTree = new BinaryTree(null)
}


