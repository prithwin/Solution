/**
  * Created by prajeeva on 8/20/17.
  */

object Factorial {
  def main(args:Array[String]):Unit = {
    println(factorial(5))
  }
  def factorial(n: Int):Int = n match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }
}