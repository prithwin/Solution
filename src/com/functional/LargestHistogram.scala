import scala.collection.mutable

/**
  * Created by prajeeva on 10/5/17.
  */

object LargestHistogram {
  def largestRectangleArea(heights: Array[Int]): Int = {
    val s = mutable.Stack[Int]()
    var max = heights(0)
    s.push(0)
    (1 until heights.length).foreach(i => {
        max = math.max(max , heights(i))
        if(s.isEmpty || heights(i) >= heights(s.top)) {
          s.push(i)
        } else {
          var fh = heights(i)
          var l = i - 1
          while(l >= 0 && heights(l) >= heights(i)) {
            fh += heights(i)
            l -= 1
          }
          var sh = 0
          var k = i+1
          while(k < heights.length && heights(k) >= heights(i)) {
            sh += heights(i)
            k += 1
          }
          max = math.max(max , fh+sh)
          var times = 1
          while(s.nonEmpty) {
            val j = s.pop()
            max = math.max(max , heights(j) * times )
            times += 1
          }
        }
    })
    if(s.nonEmpty) {
      var times = 1
      while(s.nonEmpty) {
        val j = s.pop()
        max = math.max(max , heights(j) * times )
        times += 1
      }
    }
    max
  }

  /**
    * the driver
    * @param args the args
    */
  def main(args: Array[String]): Unit = {
//    println(largestRectangleArea(Array(2,1,5,6,2,3)))
//    println(largestRectangleArea(Array(6, 2, 5, 4, 5, 1, 6)))
//    println(largestRectangleArea(Array(1,2,4)))
//    println(largestRectangleArea(Array(1,1,2,3)))
    println(largestRectangleArea(Array(2,1,2,0,3,2,2,3)))
  }
}

