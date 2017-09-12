package com.functional.util

/**
  * Created by prajeeva on 9/7/17.
  */
case class TreeNode(var data:Int , var left:TreeNode,var right:TreeNode) {
  override def canEqual(that: Any): Boolean = {
    if(that.isInstanceOf[TreeNode]) return true
    false
  }

  override def equals(o: scala.Any): Boolean = {
    if(this.canEqual(o)) {
      var that = o.asInstanceOf[TreeNode]
      if(this.data != that.data) {
        return false
      }
      if(this.left!=null && !this.left.equals(that.left)) {
        return false
      }
      if(this.right!=null && !this.right.equals(that.right)) {
        return false
      }
    }
    true
  }
}

object TreeNode {
  def apply: TreeNode = new TreeNode(0,null,null)
  def apply(data:Int):TreeNode = new TreeNode(data,null,null)

  def +(x:TreeNode , y:TreeNode):TreeNode = {
    if(x == null) return y
    if(y == null) return x
    this.apply
  }
}
