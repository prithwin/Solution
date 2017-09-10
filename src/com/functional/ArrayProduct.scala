import scala.collection.mutable

/**
  * Created by prajeeva on 9/7/17.
  */

object ArrayProduct {
  def arrayProduct(a:Array[Int]): Array[Int] = {
    var r = new Array[Int](a.length)
    var t = 1
    (0 until a.length).foreach(i => {
      r(i) = t
      t *= a(i)
    })
    t = 1
    (a.length -1  to 0 by -1).foreach(i => {
      r(i) *= t
      t *= a(i)
    })
    r
  }

  def fizzBuzz(n: Int): List[String] = {
    var response = mutable.ListBuffer[String]()
    (1 to n).foreach(i => {
      var addition = ""
      if(i % 3 == 0) {addition += "Fizz"}
      if(i % 5 == 0) {addition += "Buzz"}
      if(addition.equals("")) addition += i
      response += addition
    })
    response.toList
  }

  def main(args: Array[String]): Unit = {
    //arrayProduct(Array(1,2,3,4)).foreach(println)
    fizzBuzz(15).foreach(println)
  }
}