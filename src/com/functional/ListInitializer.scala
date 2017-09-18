package com.functional

import com.functional.util.{LinkedList, ListNode, RandomLinkedList, RandomListNode}

/**
  * Created by prajeeva on 9/9/17.
  */


object ListInitializer {
  def main(args: Array[String]): Unit = {
    var linkedList = LinkedList()
    linkedList += 1
    linkedList += 2
    linkedList += 3
    linkedList += 4
    linkedList += 5
    linkedList += 6
    linkedList.reverse(3).foreach(println)

//    linkedList += 2
//    linkedList += 3
////    linkedList += 4
//    linkedList += 4
//    linkedList += 3
//    linkedList += 2
//    linkedList += 1
////    linkedList.foreach(println)
////    linkedList.reverse.foreach(println)
//    //var comp = linkedList.biforcate
//    //println(comp(0).equals(comp(1).reverse))
//
////    linkedList >> 1
////    println(linkedList.isPalindrome)
//    var linkedList2 = LinkedList()
//    linkedList2 += 1
//    linkedList2 += 2
//    linkedList2 += 3
//    linkedList2 += 3
//    linkedList2 += 3
//    linkedList2 += 3
//    linkedList2 += 4
//    linkedList2 += 5
//    linkedList2 += 5
//    linkedList2 += 3
//    linkedList2 += 5
//    linkedList2 += 5
//    println(linkedList2)
////    linkedList2.reverse(1,5)
//    //println(linkedList2)
//    println(linkedList2.reverse)
//    linkedList2 -= 3
//    println(linkedList2)
//
//    println("====================Doing operations on random linked list=============")
//    val randomlist = RandomLinkedList()
//    randomlist.head = RandomListNode(1)
//    randomlist.head.next = RandomListNode(2)
//    randomlist.head.next.next = RandomListNode(3)
//    randomlist.head.next.next.next = RandomListNode(4)
//    randomlist.head.next.next.next.next = RandomListNode(5)
//    randomlist.head.next.next.next.next.next = RandomListNode(6)
//    randomlist.head.next.next.next.next.next.next = RandomListNode(7)
//    randomlist.head.next.next.next.next.next.next.next = RandomListNode(8)
//
//    randomlist.head.random = randomlist.head.next.next.next.next.next.next.next
//    randomlist.head.next.random = randomlist.head.next.next.next.next.next.next
//    randomlist.head.next.next.random = randomlist.head.next.next.next.next.next
//    randomlist.head.next.next.next.random = randomlist.head.next.next.next.next
//    randomlist.head.next.next.next.next.random = randomlist.head.next.next.next
//    randomlist.head.next.next.next.next.next.random = randomlist.head.next.next
//    randomlist.head.next.next.next.next.next.next.random = randomlist.head.next
//    randomlist.head.next.next.next.next.next.next.next.random = randomlist.head
//    println(randomlist)
//    val res = randomlist.clone()
//    println(res)
  }
}

