/**
  * Created by prajeeva on 9/8/17.
  */

import scala.collection._

object CheckBalancedParentheses {
  def isBalanced(exp:String):Boolean = {
    var s = mutable.Stack[Char]()
    var chars = exp.toCharArray
    chars.foreach(f = c => {
      if (c == '(' || c == '[' || c == '{') s.push(c)
      else if (c == ')' || c == ']' || c == '}') {
        var t = s.top
        if (c == ')' && t == '(' || c == '}' && t == '{' || c == '}' && t == '{') s.pop
        else return false
      }
    })
    s.isEmpty
  }

  def main(args: Array[String]): Unit = {
    println(isBalanced("(({}))"))
  }
}