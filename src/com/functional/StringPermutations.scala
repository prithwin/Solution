/**
  * Created by prajeeva on 9/7/17.
  */

import scala.collection.mutable._

object StringPermutations {

  def permuteInternal(lead: String, actual: String, response:MutableList[String]): Unit = {
    if(actual.length == 0) {
      response+=lead
    } else {
      for(i <- 0 until actual.length) {
        permuteInternal(lead + actual.charAt(i) ,
          actual.substring(0,i)+actual.substring(i+1, actual.length) ,
          response)
      }
    }
  }

  def permute(s : String):MutableList[String] = {
    var response = new MutableList[String]
    permuteInternal("" , s , response)
    response
  }

  def main(args: Array[String]): Unit = {
    permute("ABC").foreach(println)
  }
}