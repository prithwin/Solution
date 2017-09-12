package com.functional.util

import scala.util.control.Breaks._

/**
  * Created by prajeeva on 9/11/17.
  */
case class RandomLinkedList(var head:RandomListNode) {
  override def toString: String = {
    var rep = "RandomLinkedList("
    var temp = head
    while(temp!=null) {
      rep += temp
      if(temp.next!=null)
        rep += ","
      temp = temp.next
    }
    rep += ")"
    rep
  }
}

object RandomLinkedList {
  def apply(): RandomLinkedList = new RandomLinkedList(null)
}
