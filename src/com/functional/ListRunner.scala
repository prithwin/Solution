/**
  * Created by prajeeva on 8/23/17.
  */

object ListRunner {
  class LinkedList(var head:ListNode) {
    def add(value:Int):Unit = {
      var n = new ListNode(3)
      Option(head) match {
        case None => head = n
        case _ => head.next = n;
      }
    }
  }

  class ListNode(var num: Int) {
    this.num = num
    this.next =
  }
  def main(args: Array[String]): Unit = {

  }
}

