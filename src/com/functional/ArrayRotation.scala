/**
  * Created by prajeeva on 8/21/17.
  */

object ArrayRotation {
  def main(arr:Array[String]) : Unit = {
    var a = Array(1 ,2 ,3 ,4, 5)

    (1 to 4).foreach( _ => {
      var t = a(0)
      for(i <- 1 until a.length) {
      a(i-1) = a(i) }
      a(a.length-1) = t
    })
    a.map((x:Int) => print(x +" ,"))
  }
}

