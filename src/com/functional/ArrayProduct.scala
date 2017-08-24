/**
  * Created by prajeeva on 8/21/17.
  */

object ArrayProduct {
  def main(args:Array[String]):Unit = {
    var a = Array[Int](1,2,3,0)
    var r = new Array[Int](a.length)
    var t = 1
    for(i <- 0 until a.length) {
      r(i) = t
      t *= a(i)
    }
    t = 1
    for(i <- a.length - 1 to  0 by  -1) {
      r(i) *= t
      t *= a(i)
    }
    r.map(println)
  }
}