import scala.util.control.Breaks._

/**
  * Created by prajeeva on 9/21/17.
  */

object PalindromeButOne {
  def main(args: Array[String]): Unit = {
    val s = "abbac"
    breakable {
      {
        (0 until s.length).foreach(i => {
          println(s.substring(0, i) + s.substring(i + 1, s.length))
          if (isPal(s.substring(0, i) + s.substring(i + 1, s.length))) {
            println("the string is palindrome")
            break
          }
        })
      }
    }
  }

  def isPal(s:String):Boolean = {
    if(s.length <= 1) true
    else {
      if(s.charAt(0) == s.charAt(s.length-1)
        && isPal(s.substring(1, s.length-1))) return true
      false
    }
  }
}
