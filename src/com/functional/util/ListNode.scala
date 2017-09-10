package com.functional.util

/**
  * Created by prajeeva on 9/9/17.
  */
case class ListNode(var data:Int, var next:ListNode) {

  def equalsInternal(thiz: ListNode , that:ListNode): Boolean = {
    if(thiz == null && that == null) return true
    if(thiz == null || that == null) return false;
    thiz.data == that.data && equalsInternal(thiz.next , that.next)
  }

  def ==(x:Int):Boolean = this.data == x

  override def equals(obj: scala.Any): Boolean = canEqual(obj) && equalsInternal(obj.asInstanceOf[ListNode], this)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ListNode]

  override def toString: String = ""+data
}

object ListNode {
  //def apply(data: Int, next: ListNode): ListNode = new ListNode(data, next)
  def apply(data: Int): ListNode = new ListNode(data , null)
}
