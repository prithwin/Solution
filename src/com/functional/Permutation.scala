/**
  * Created by prajeeva on 8/21/17.
  */
object Permutation {
  def main(args: Array[String]): Unit = {
    val target = "ABCD"
    permute("",target)
  }

  def permute(lead: String, rem: String): Unit = rem.length match {
    case 0 => println(lead)
    case _ => for(i <- 0 until rem.length)
        permute(lead + rem.charAt(i),rem.substring(0,i)+rem.substring(i+1,rem.length))
    }
}
