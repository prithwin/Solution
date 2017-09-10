/**
  * Created by prajeeva on 9/9/17.
  */

object SpiralPrintMatrix {
  def main(args: Array[String]): Unit = {
    var array = Array(
                        Array(1, 2, 3, 4, 5),
                        Array(6, 7, 8, 9, 10),
                        Array(11,12,13,14,15),
                        Array(16,17,18,19,20),
                        Array(21,22,23,24,25)
                      )
    spiralPrint(array)
  }

  private def spiralPrint(arr:Array[Array[Int]]):Unit = {
    if(arr == null) return
    if(arr.length == 1) {
      if(arr(0) == null || arr(0).length == 0) return
      arr(0).indices.foreach(i => println(arr(0)(i)))
      return
    }
    if(arr(0).length == 1) {
      arr.foreach(a => println(a(0)))
      return
    }
    for(j <- arr(0).indices) {
      println(arr(0)(j))
    }

    for(i <- 1 until arr.length) {
      println(arr(i)(arr(0).length-1))
    }

    for(j <- arr(0).length -2 to 0 by -1) {
      println(arr(arr.length - 1)(j))
    }

    for(i <- arr.length -2 to 1 by  -1) {
      println(arr(i)(0))
    }
    if(arr.length > 2 && arr(0).length > 2) {
      var newArray = Array.ofDim[Int](arr.length -2 , arr(0).length -2)
      for(k <- 1 until arr.length - 1 by 1) {
        for(l <- 1 until arr(0).length -1 by 1) {
          newArray(k - 1)(l-1) = arr(k)(l)
        }
      }
      spiralPrint(newArray)
    }
  }
}