package com.functional.util

import scala.collection.mutable

/**
  * Created by prajeeva on 9/11/17.
  */
class LRUCache(map:mutable.HashMap[Int , DlListNode],
               cap :Int ,
               head: DlListNode ,
               tail:DlListNode ,
               var count:Int
              ) {

  def put(key:Int , value:Int):Unit = {
    if(!map.contains(key)) {
      val node = DlListNode(key , value)
      map.put(key , node)
      if(count < cap) {
        count += 1
        addToHead(node)
      } else {
        map.remove(tail.prev.key)
        deleteNode(tail.prev)
        addToHead(node)
      }
    } else {
      val node = map(key)
      node.value = value
      deleteNode(node)
      addToHead(node)
    }
  }

  def get(key:Int):Int = {
    if(map contains key ) {
      val node =  map(key)
      deleteNode(node)
      addToHead(node)
      node.value
    } else {
      -1
    }
  }

  private def addToHead(node: DlListNode):Unit = {
    val fut = head.next
    head.next = node
    node.prev = head
    node.next = fut
    fut.prev = node
  }

  private def deleteNode(node:DlListNode):Unit = {
    val back = node.prev
    val fut = node.next
    back.next = fut
    fut.prev = back
    node.prev = null
    node.next = null
  }
}

object LRUCache {
  def apply(cap:Int): LRUCache = {
    val head = DlListNode(0,0)
    val tail = DlListNode(0,0)
    head.next = tail
    head.prev = null
    tail.prev = head
    tail.next = null
    new LRUCache(mutable.HashMap(), 5,head, tail,0)
  }
}