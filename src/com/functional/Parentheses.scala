package com.functional
/**
  * Created by prajeeva on 9/15/17.
  */

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Parentheses {
  def generate(n:Int):List[String] = {
    val lb = mutable.ListBuffer[String]()
    generate("", n,n,lb)
    lb.toList
  }

  private def generate(str: String, o: Int, c: Int,lb:ListBuffer[String]):Unit = {
    if(c < o) return
    if(o==0 && c ==0) {
      lb +=str
      return
    }
    if(o > 0) generate(str + "(" , o - 1, c , lb)
    if(c > 0) generate(str + ")" , o , c -1 , lb)
  }

  def main(args: Array[String]): Unit = {
    var response = generate(30)
    response.foreach(println)

  }
}