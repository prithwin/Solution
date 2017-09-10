import com.functional.util.LinkedList

/**
  * Created by prajeeva on 9/9/17.
  */


object ListInitializer {
  def main(args: Array[String]): Unit = {
    var linkedList = LinkedList()
    linkedList += 1
    linkedList += 2
    linkedList += 3
//    linkedList += 4
    linkedList += 4
    linkedList += 3
    linkedList += 2
    linkedList += 1
//    linkedList.foreach(println)
//    linkedList.reverse.foreach(println)
    //var comp = linkedList.biforcate
    //println(comp(0).equals(comp(1).reverse))

//    linkedList >> 1
//    println(linkedList.isPalindrome)
    var linkedList2 = LinkedList()
    linkedList2 += 1
    linkedList2 += 2
    linkedList2 += 3
    linkedList2 += 3
    linkedList2 += 3
    linkedList2 += 3
    linkedList2 += 4
    linkedList2 += 5
    linkedList2 += 5
    linkedList2 += 3
    linkedList2 += 5
    linkedList2 += 5
    println(linkedList2)
//    linkedList2.reverse(1,5)
    //println(linkedList2)
    println(linkedList2.reverse)
    linkedList2 -= 3
    println(linkedList2)

  }
}

