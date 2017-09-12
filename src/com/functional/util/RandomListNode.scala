package com.functional.util

/**
  * Created by prajeeva on 9/11/17.
  */
case class RandomListNode(var label:Int ,var next:RandomListNode ,var random:RandomListNode) {
  override def toString: String = ""+label
}

object RandomListNode {
  def apply(_label:Int): RandomListNode = new RandomListNode(_label, null, null)
}
