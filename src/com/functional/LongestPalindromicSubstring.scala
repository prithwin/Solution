package com.functional

import scala.collection.mutable

/**
  * Created by prajeeva on 9/15/17.
  */

object LongestPalindromicSubstring {

  def longestPalindrome(s: String): String = {
    var result = mutable.HashMap[Int,Int](1 -> Int.MinValue ,2 -> -1 ,3 -> -1)
    (0 until s.length).foreach(i => {
      process(s, i , i+ 1 , result)
      process(s, i , i , result)
    })
    s.substring(result(2), result(3)+1)
  }

  private def process(str: String, i: Int, j: Int,result:mutable.HashMap[Int,Int]):Unit ={
    var l = i
    var r = j
    while(l>=0 && r < str.length -1) {
      if(str.charAt(l) == str.charAt(r)) {
        if(r - l > result(1)) {
          result(1) = r - l
          result(2) = l
          result(3) = r
          l -= 1
          r -= 1
        } else return
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("abba"))
  }
}