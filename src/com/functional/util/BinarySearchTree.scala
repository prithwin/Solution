package com.functional.util

import java.util
import java.util.Stack

import com.personal.util.TreeNode

import scala.collection.mutable

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

  def pen():TNode = pen(root)

  private def pen(node:TNode):TNode = {
    val s = mutable.Stack[TNode]()
    var temp = node
    while(temp!=null) {
      s.push(temp)
      temp = temp.right
    }
    if(s.top.left != null) return s.top.left
    s.pop()
    s.top
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

  def inorderSuccessor(root: TreeNode, p: TreeNode): TreeNode = {
    val s: util.Stack[TreeNode] = new util.Stack[TreeNode]
    findNode(root, p, s)
    if (s.peek.right != null) {
      var can = s.peek.right
      while ( {
        can.left != null
      }) can = can.left
      return can
    }
    val ul: TreeNode = s.pop
    if (s.isEmpty) return null
    while ( {
      !s.isEmpty && s.peek.data < ul.data
    }) s.pop
    if (s.isEmpty) return null
    s.peek
  }

  private def findNode(node: TreeNode, what: TreeNode, s: util.Stack[TreeNode]): Unit = {
    if (node == null) return
    s.push(node)
    if (what.data == node.data) return
    if (what.data < node.data) findNode(node.left, what, s)
    if (what.data > node.data) findNode(node.right, what, s)
  }


}

object BinarySearchTree {
  def apply(): BinarySearchTree = new BinarySearchTree(null)

  private def sortedListToTreeNode(head: ListNode):TNode = head match {
    case null => null
    case _ =>
      if(head.next == null) TNode(head.data)
      else {
        if(head.next.next==null) {
          //this list has only two elements
          val response = TNode(head.data)
          response.right = TNode(head.next.data)
          return response
        }
        var s = head
        var f = head
        var prev:ListNode = null
        while(f != null && f.next != null) {
          prev = s
          s = s.next
          f = f.next.next
        }
        val tail = s
        prev.next = null
        val response = TNode(s.data)
        response.left = sortedListToTreeNode(head)
        response.right = sortedListToTreeNode(tail.next)
        response
      }
  }

  def apply(listNode:ListNode) : BinarySearchTree =
    new BinarySearchTree(sortedListToTreeNode(listNode))
}
