package recursion.string_reductions

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\string_reductions\\data.txt")


//  def reduce(text:String): String = {
//    text.toList.distinct.mkString("")
//  }

  @scala.annotation.tailrec
  def recReduce(text: String, reduced: String): String = {
    text match {
      case "" => reduced
      case _ if reduced.contains(text.head) => recReduce(text.tail, reduced)
      case _ => recReduce(text.tail, reduced + text.head)
    }
  }

  def reduce(text:String): String = {
    recReduce(text, "")
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(reduce(linesItr.next().trim()))
  }

}


