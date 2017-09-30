/**
  * Created by prajeeva on 9/25/17.
  */

object BubbleSorter {
  def main(args: Array[String]): Unit = {
    var a = Array(5,4,8,19,1,56,5,9,1,9000,3,56)
    for(j <- 0 until a.length-1) {
      (1 until a.length-j).foreach(i => {
        if(a(i) < a(i-1)){
          val temp = a(i)
          a(i) = a(i-1)
          a(i-1) = temp
        }
      })
    }
    a.foreach(println)

    var b = Array(5,4,8,19,1,56,5,9,1,9000,3,56)
    selectionSort(0,b)
    println
    println
    println
    b.foreach(println)
  }

  def selectionSort(n: Int, a: Array[Int]):Unit = {
    if(n==a.length) return
    (n+1 until a.length).foreach(i=>{
      if(a(i) < a(n)) {
        val temp = a(i)
        a(i) = a(n)
        a(n) = temp
      }
    })
    selectionSort(n+1, a)
  }

  def insertionSort(n: Int, a: Array[Int]):Unit = {
    if(n==a.length) return
    (n+1 until a.length).foreach(i=>{
      if(a(i) < a(n)) {
        val temp = a(i)
        a(i) = a(n)
        a(n) = temp
      }
    })
    selectionSort(n+1, a)
  }

}

