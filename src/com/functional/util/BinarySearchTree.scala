package com.functional.util

/**
  * Created by prajeeva on 9/9/17.
  */
case class BinarySearchTree(var root : TNode) {

  def += (x:Int): Unit = {
    add(x)
  }

  def add(x: Int): Unit = {
    if(root == null) {
      root = TNode(x)
    } else {
      root = add(root , TNode(x))
    }
  }

  def -= (x:Int):Unit = {
    remove(x:Int)
  }

  def remove(x:Int): Unit = {
    root = remove(root, TNode(x))
  }

  private def remove(node:TNode , x:TNode):TNode = {
    if(x < node) {
      node.left = remove(node.left , x)
    } else if(x > node) {
      node.right = remove(node.right, x)
    } else {
      if(node.left == null) return node.right
      else if(node.right == null) return node.left
      else {
        var temp = node
        val min = findMin(node.right)
        temp.data = min
        temp = deleteMin(temp.right)

      }
    }
    node
  }

  def lca(a:Int , b:Int):Int = lca(a,b,root)

  private def lca(a: Int, b: Int, node: TNode):Int = {
    if(a < node.data && b < node.data) {
      lca(a,b,node.left)
    } else if(a > node.data && b > node.data) {
      lca(a,b,node.right)
    } else {
      node.data
    }
  }
  private def deleteMin(node: TNode) :TNode = {
    if(node.left == null) node.right
    else {
      node.left = deleteMin(node.left)
      node
    }
  }

  private def findMin(node:TNode):Int = {
    if(node.left == null) node.data
    else findMin(node.left)
  }

  def printInOrder : Unit = printInOrder(root)

  private def printInOrder(node: TNode):Unit = node match {
    case null =>
    case _ => printInOrder(node.left)
      println(node.data)
      printInOrder(node.right)
  }

  private def add(node: TNode , x: TNode):TNode = {
    if(node == null) return x
    if(x.data < node.data) node.left = add(node.left , x)
    else if(x.data > node.data) node.right = add(node.right , x)
    node
  }


}

object BinarySearchTree {
  def apply(): BinarySearchTree = new BinarySearchTree(null)
}
