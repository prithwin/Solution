/**
  * Created by prajeeva on 8/21/17.
  */

object InsertSpaces {
  def main(args: Array[String]): Unit = {
    val target = "ABCD"
    spacify(target,1,""+target.charAt(0))
  }

  def spacify(orig: String, pos: Int, lead: String):Unit ={
    if(pos == orig.length) {
      println(lead)
    } else {
      spacify(orig , pos + 1, lead + orig.charAt(pos))
      spacify(orig , pos + 1 ,lead + " " + orig.charAt(pos))
    }
  }
}
