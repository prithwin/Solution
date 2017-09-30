import scala.collection.mutable

/**
  * Created by prajeeva on 9/20/17.
  */

object BalanceParenteses {
  def main(args: Array[String]): Unit = {
    val exp = "((({})))"
    println(isBalancedParentheses(exp))
  }

  def isBalancedParentheses(exp: String):Boolean = {
    val stack = mutable.Stack[Char]()
    (0 until exp.length).foreach(i => {
      if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{') {
        stack.push(exp.charAt(i))
      } else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']' ) {
        if(exp.charAt(i) == ')' && stack.top != '(') return false
        if(exp.charAt(i) == ']' && stack.top != '[') return false
        if(exp.charAt(i) == '}' && stack.top != '{') return false
        stack.pop
      } else {
        //ignore
      }
    })
    true
  }
}
