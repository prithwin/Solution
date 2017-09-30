/**
  * Created by prajeeva on 9/22/17.
  */

object Fibonacci {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 10) println(fib(i))

    var m = 0
    var n = 1

    for(i <- 0 to 10 ) {
      val sum = m+n
      println(sum)
      m = n
      n = sum
    }
  }

  def fib(n: Int):Int = {
    if(n <= 1) n
    else {
      fib(n-2) + fib(n-1)
    }
  }
}

