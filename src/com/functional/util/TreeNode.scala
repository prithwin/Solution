package com.functional.util

/**
  * Created by prajeeva on 9/7/17.
  */
case class TreeNode(var data:Int , var left:TreeNode,var right:TreeNode) {
  def this() = {
    this(0,null,null)
  }

  def this(data:Int) = {
    this(data,null,null)
  }

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
