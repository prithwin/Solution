/**
  * Created by prajeeva on 9/8/17.
  */

object RotateMatrix {
  def rotate(arr:Array[Array[Int]]):Unit = {
    var N = arr.length
    for(i <- 0 until N/2) {
      for(j <- i until N - i - 1 ) {
        var temp = arr(i)(j)
        arr(i)(j) = arr(N-j-1)(i)
        arr(N-j-1)(i) = arr(N-i-1)(N-j-1)
        arr(N-i-1)(N-j-1) = arr(j)(N-i-1)
        arr(j)(N-i-1) = temp
      }
    }
  }

  def main(args: Array[String]): Unit = {
    var matrix = Array(Array(1,2,3,4,5),
                  Array(6,7,8,9,10),
                  Array(11,12,13,14,15),
                  Array(16,17,18,19,20),
                  Array(21,22,23,24,25))
    for(i <- matrix.indices) {
      for(j <- matrix(i).indices) {
        print(s"     ${matrix(i)(j)}     ")
      }
      println
    }
    rotate(matrix)
    println
    for(i <- matrix.indices) {
      for(j <- matrix(i).indices) {
        print(s"     ${matrix(i)(j)}     ")
      }
      println
    }
  }
}
