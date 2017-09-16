package com.functional.util

/**
  * Created by prajeeva on 9/11/17.
  */
case class RandomListNode(var label:Int ,var next:RandomListNode ,var random:RandomListNode) extends Ordered[RandomListNode] {
  override def toString: String = ""+label

  override def compare(that: RandomListNode): Int = {
    if(this.label > that.label) 1
    else if(this.label < that.label) -1
    else 0
  }
}

object RandomListNode {
  def apply(_label:Int): RandomListNode = new RandomListNode(_label, null, null)
}
