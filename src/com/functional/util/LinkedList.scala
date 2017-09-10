package com.functional.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._


/**
  * Created by prajeeva on 9/9/17.
  */
case class LinkedList(var head:ListNode) {
  def >>(n: Int):Unit = rotateRight(n)

  private def rotateRight(n: Int):Unit = {

  }

  def foreach(method: Any => Unit): Unit = {
    var temp = head
    while(temp!=null) {
      method(temp.data)
      temp = temp.next
    }
  }

  def remove(x:Int): Unit = {
    if(head == null) return
    var dummy = ListNode(0)
    dummy.next = head
    var prev = dummy
    var curr = dummy.next
    while(curr != null) {
      if(curr == x) {
        prev.next = curr.next
        curr = curr.next
      } else {
        curr = curr.next
        prev = prev.next
      }
    }
  }

  def +=(num: Int): Unit = add(num)

  def -=(num: Int): Unit = remove(num)

  def add(x:Int):Unit = {
    if(head == null) head = ListNode(x)
    else {
      var temp = head
      while(temp.next != null) temp = temp.next
      temp.next = ListNode(x)
    }
  }

  def reverse:LinkedList = {
    if(this.head == null || head.next ==null) return this
    val dummy = ListNode(0)
    dummy.next = head
    val prev = dummy
    val start = prev.next
    var next = start.next
    while(start.next!=null) {
      start.next = next.next
      next.next = prev.next
      prev.next = next
      next = start.next
    }
    head = dummy.next
    this
  }

  def reverse(m:Int , n :Int): Unit ={
    var dummy = ListNode(0)
    dummy.next = head
    var prev = dummy
    for(i <- 0 until m - 1)
      prev = prev.next

    var start = prev.next
    var next = start.next

    for(i <- 0 until n-m)
    {
      start.next = next.next
      next.next = prev.next
      prev.next = next
      next = start.next
    }

    head = dummy.next
  }


  def bifurcate: Array[LinkedList] = {
    var prev: ListNode = null
    var slow = head
    var fast = head
    var response = ArrayBuffer[LinkedList]()
    breakable {
      while (true) {
        if (fast == null || fast.next == null) {
          break
        }
        prev = slow
        slow = slow.next
        fast = fast.next.next
      }
    }
    response += LinkedList(head)
    prev.next = null
    if (fast != null) {
      response += LinkedList(slow.next)
    } else {
      response += LinkedList(slow)
    }
    response.toArray
  }

  def isPalindrome:Boolean = {
    var stack = mutable.Stack[ListNode]()
    if(head.next == null) return true
    var slow = head
    var fast = head
    breakable {
      while(true) {
        stack.push(slow)
        println(stack)
        if(fast == null || fast.next == null) break
        slow = slow.next
        fast = fast.next.next
      }
    }

    if(fast == null) stack.pop

    while(slow!=null) {
      println(stack)
      var d = stack.pop
      if(slow.data != d.data) return false
      slow = slow.next
    }
    true
  }

  override def equals(obj: scala.Any): Boolean = {
    canEqual(obj) && obj.asInstanceOf[LinkedList].head.equals(head)
  }

  override def toString: String = {
    var rep = "LinkedList("
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
  override def canEqual(that: Any): Boolean = that.isInstanceOf[LinkedList]
}

object LinkedList {
  //def apply(head: ListNode): LinkedList = new LinkedList(head)
  def apply(): LinkedList = new LinkedList(null)
}
