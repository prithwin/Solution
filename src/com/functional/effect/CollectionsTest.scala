import java.util.stream.Collectors

/**
  * Created by prajeeva on 11/3/17.
  */

object CollectionsTest {
  def main(args:Array[String]):Unit = {
    println("something is going on")
    val myList = List(1,2,3,4,5,6)
    val myList2 = List(List(1,2,3,4,5,6),List(0,0,0,0,0,0), List(0,0,0,0,0,0))
    val myList3 = List(List(List(1,2,3,4,5,6),List(1,2,3,4,5,6),List(1,2,3,4,5,6),List(1,2,3,4,5,6),List(1,2,3,4,5,6),List(1,2,3,4,5,6)),List(List(1,2,3,4,5,6)))
    println(myList.map(a => a+1)reduce(_+_))
    println(myList2.flatMap(_.map(_+1)))
    println(myList.map(_+""))
  }
}