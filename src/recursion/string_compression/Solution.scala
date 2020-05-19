package recursion.string_compression

import scala.io.Source

object Solution {


  val source = Source.fromFile("D:\\src\\HackerRank_solutions_scala\\src\\recursion\\string_compression\\data.txt")


  def getPrefix(text: String, prefix: Char): Int = {
    if (text.isEmpty)
      return 0
    text.head match {
      case head if head == prefix => 1 + getPrefix(text.tail, prefix)
      case _ => 0
    }
  }

  @scala.annotation.tailrec
  def recCompress(text: String, compressed: String): String = {
    if (text.isEmpty)
      return compressed
    val prefixLen = getPrefix(text, text.head)
    prefixLen match {
      case 1 => recCompress(text.substring(prefixLen), compressed + text.head)
      case _ => recCompress(text.substring(prefixLen), compressed + text.head + prefixLen)
    }

  }

//  def compress(text: String): String = {
//    recCompress(text, "")
//  }

  def compress(text: String): String = {
    "(\\w)\\1+".r.replaceAllIn(text, matched => "$1" + matched.toString().length)
  }

  def main(args: Array[String]) {
    val linesItr = source.getLines()
    println(compress(linesItr.next().trim()))
  }

}


